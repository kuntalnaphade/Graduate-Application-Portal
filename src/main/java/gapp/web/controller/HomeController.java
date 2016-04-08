package gapp.web.controller;

import java.util.ArrayList;
import java.util.List;




import javax.servlet.http.HttpSession;

import gapp.model.AdditionalField;
import gapp.model.Department;
import gapp.model.Program;
import gapp.model.User;
import gapp.model.UserType;
import gapp.model.dao.AdditionalFiledDao;
import gapp.model.dao.ApplicationsDao;
import gapp.model.dao.DepartmentDao;
import gapp.model.dao.UserDao;
import gapp.web.validator.RegistrationValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({"user","newuser"})
public class HomeController {

	@Autowired
	private RegistrationValidator registrationvalidator;
	@Autowired
	ApplicationsDao applicationDao;

	@Autowired
	DepartmentDao departmentDao;

	@Autowired
	UserDao userDao;

	@Autowired
	AdditionalFiledDao additionalFieldDao;

	
	 
	@RequestMapping("/home.html")
	public String index() {
		return "home";
	}

	@RequestMapping(value = "/login.html", method = RequestMethod.GET)
	public String login(ModelMap models) {
		models.put("user", new User());
		models.put("loginV", 0);
		return "login";
	}

	@RequestMapping(value = "/login.html", method = RequestMethod.POST)
	public String login(@ModelAttribute User user, ModelMap models,HttpSession session) {

		User objUser = applicationDao
				.getApplicationsByEmail(user.getEmail_id());
		session.setAttribute("user", objUser);

		if (objUser == null) {
			models.put("loginV", 1);
			return "login";
		} else if (!objUser.getPassword().equalsIgnoreCase(user.getPassword())) {
			models.put("loginV", 1);
			return "login";
		}

		if (objUser.getEmail_id().equalsIgnoreCase(user.getEmail_id())
				&& objUser.getPassword().equalsIgnoreCase(user.getPassword())) {
			if (objUser.getLstusertype().get(0).getType()
					.equalsIgnoreCase("Administrators")) {

				return "redirect:/admin.html";
			} else if (objUser.getLstusertype().get(0).getType()
					.equalsIgnoreCase("Students")) {

				return "redirect:/student.html";
			} else if (objUser.getLstusertype().get(0).getType()
					.equalsIgnoreCase("Staff")) {

				return "redirect:/staff.html";
			} else
				return "redirect:/login.html";

		} else {

			return "redirect:/login.html";
		}
	}

	@RequestMapping("/admin.html")
	public String admin(ModelMap models) {
		models.put("lstdepartment", departmentDao.getallDepartments());
		return "admin";
	}

	
	@RequestMapping(value = "/registration.html", method = RequestMethod.GET)
	public String register(ModelMap models) {
		models.put("newuser", new User());
		models.put("ErrorduplicateEmail", -1);
		models.put("fnameerror", 0);
		models.put("lnameerror", 0);
		models.put("emailerror", 0);
		models.put("pwderror", 0);
		return "registration";
	}

	@RequestMapping(value = "/registration.html", method = RequestMethod.POST)
	public String register(@ModelAttribute User newuser, ModelMap models,
			BindingResult bindingResult) {
		registrationvalidator.validate(newuser, bindingResult);
		if (bindingResult.hasErrors()) {
			models.put("newuser", newuser);
			if (!StringUtils.hasText(newuser.getFirst_name())) {
				models.put("fnameerror", 1);
			}
			if (!StringUtils.hasText(newuser.getLast_name())) {
				models.put("lnameerror", 1);
			}
			if (!StringUtils.hasText(newuser.getEmail_id())) {
				models.put("emailerror", 1);
			}
			if (!StringUtils.hasText(newuser.getPassword())) {
				models.put("pwderror", 1);
			}
			return "registration";
		}
		newuser.setEmail_id(newuser.getEmail_id().toLowerCase());
		if (userDao.getUserByEmail(newuser.getEmail_id()).size() > 0) {
			models.put("ErrorduplicateEmail", 1);
			return "registration";
		}
		models.put("ErrorduplicateEmail", -1);
		List<UserType> lst = new ArrayList<UserType>();
		UserType type = userDao.getUserTpe("Students");
		lst.add(type);

		newuser.setLstusertype(lst);

		userDao.saveUser(newuser);
		// sessionStatus.setComplete();
		return "redirect:/login.html";
	}

	@RequestMapping("/viewdepartment.html")
	public String viewdepartment(@RequestParam Integer id, ModelMap models) {
		models.put("dept", departmentDao.getDepartmentById(id));
		return "viewdepartment";
	}

	@RequestMapping(value = "/adddepartment.html", method = RequestMethod.GET)
	public String adddepartment(ModelMap models) {
		models.put("dept", new Department());
		models.put("addflag", 1);

		admin(models);
		return "admin";
	}

	@RequestMapping(value = "/adddepartment.html", method = RequestMethod.POST)
	public String adddepartment(@ModelAttribute Department dept, ModelMap models) {
		models.put("addflag", -1);
		if (StringUtils.hasText(dept.getDepartment()))
			departmentDao.saveDepartment(dept);
		return "redirect:/admin.html";
	}

	@RequestMapping(value = "/addprogram.html", method = RequestMethod.GET)
	public String addprogram(@RequestParam Integer id, ModelMap models) {
		models.put("prog", new Program());
		models.put("prgflag", 1);
		viewdepartment(id, models);
		return "viewdepartment";

	}

	@RequestMapping(value = "/addprogram.html", method = RequestMethod.POST)
	public String addprogram(@ModelAttribute Program prog, ModelMap models,
			@RequestParam Integer id) {

		if (StringUtils.hasText(prog.getProgram())) {
			models.put("prgflag", -1);
			Program newprog = departmentDao.saveProgram(prog);
			newprog.setDept(departmentDao.getDepartmentById(id));
			departmentDao.saveProgram(newprog);
		}
		return "redirect:/viewdepartment.html?id=" + id;
	}

	@RequestMapping(value = "/addfields.html", method = RequestMethod.GET)
	public String addfields(@RequestParam Integer id, ModelMap models) {
		models.put("field", new AdditionalField());
		models.put("fldflag", 1);
		viewdepartment(id, models);
		return "viewdepartment";
	}

	@RequestMapping(value = "/addfields.html", method = RequestMethod.POST)
	public String addfields(@ModelAttribute AdditionalField field,
			ModelMap models, @RequestParam Integer id) {
		if (StringUtils.hasText(field.getName())) {
			models.put("fldflag", -1);
			field.setDept(departmentDao.getDepartmentById(id));
			additionalFieldDao.savefield(field);
		}
		return "redirect:/viewdepartment.html?id=" + id;
	}

	@RequestMapping(value = "/editdepartment.html", method = RequestMethod.GET)
	public String editdepartment(@RequestParam Integer id, ModelMap models) {
		models.put("editdept", departmentDao.getDepartmentById(id));
		models.put("depteditflag", 1);
		viewdepartment(id, models);
		return "viewdepartment";
	}

	@RequestMapping(value = "/editdepartment.html", method = RequestMethod.POST)
	public String editdepartment(@ModelAttribute Department editdept,
			ModelMap models, @RequestParam Integer id) {
		if (StringUtils.hasText(editdept.getDepartment())) {
			models.put("depteditflag", -1);
			editdept.setDeptId(id);
			departmentDao.saveDepartment(editdept);
		}
		return "redirect:/viewdepartment.html?id=" + id;
	}

	@RequestMapping(value = "/editprogram.html", method = RequestMethod.GET)
	public String editprogram(@RequestParam Integer id, ModelMap models,
			@RequestParam Integer deptid) {
		models.put("editprg", departmentDao.getProgrambyId(id));
		models.put("prgeditflag", 1);
		viewdepartment(deptid, models);
		return "viewdepartment";
	}

	@RequestMapping(value = "/editprogram.html", method = RequestMethod.POST)
	public String editprogram(@ModelAttribute Program editprg, ModelMap models,
			@RequestParam Integer deptid, @RequestParam Integer id) {
		if (StringUtils.hasText(editprg.getProgram())) {
			models.put("prgeditflag", -1);
			editprg.setProgramId(id);
			editprg.setDept(departmentDao.getDepartmentById(deptid));
			departmentDao.saveProgram(editprg);
		}
		return "redirect:/viewdepartment.html?id=" + deptid;
	}

	@RequestMapping(value = "/editfield.html", method = RequestMethod.GET)
	public String editfield(@RequestParam Integer id, ModelMap models,
			@RequestParam Integer deptid) {
		models.put("editfld", additionalFieldDao.getfieldbyId(id));
		models.put("fldeditflag", 1);
		viewdepartment(deptid, models);
		return "viewdepartment";
	}

	@RequestMapping(value = "/editfield.html", method = RequestMethod.POST)
	public String editfield(@ModelAttribute AdditionalField editfld,
			ModelMap models, @RequestParam Integer deptid,
			@RequestParam Integer id) {
		if (StringUtils.hasText(editfld.getName())) {
			models.put("fldeditflag", -1);
			editfld.setFieldId(id);
			editfld.setDept(departmentDao.getDepartmentById(deptid));
			additionalFieldDao.savefield(editfld);
		}
		return "redirect:/viewdepartment.html?id=" + deptid;
	}

	@RequestMapping("/deleteprogram.html")
	public String deleteprogram(@RequestParam Integer id,
			@RequestParam Integer deptid, ModelMap models) {

		departmentDao.removeProgrambtId(departmentDao.getProgrambyId(id));
		return "redirect:/viewdepartment.html?id=" + deptid;

	}

	@RequestMapping("/deletefield.html")
	public String deletefield(@RequestParam Integer id,
			@RequestParam Integer deptid, ModelMap models) {

		additionalFieldDao.removeAdditionalField(additionalFieldDao
				.getfieldbyId(id));
		return "redirect:/viewdepartment.html?id=" + deptid;

	}

}