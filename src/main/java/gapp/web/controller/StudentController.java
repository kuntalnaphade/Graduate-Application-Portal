package gapp.web.controller;

import gapp.model.AdditionalField;
import gapp.model.ApplicantAdditionalFieldValue;
import gapp.model.Applications;
import gapp.model.Department;
import gapp.model.EducationalBackground;
import gapp.model.Program;
import gapp.model.Status;
import gapp.model.StatusAudit;
import gapp.model.User;
import gapp.model.dao.AdditionalFiledDao;
import gapp.model.dao.ApplicationsDao;
import gapp.model.dao.DepartmentDao;
import gapp.model.dao.EduBackgroundDao;
import gapp.model.dao.StatusDao;
import gapp.model.dao.TermDao;
import gapp.model.dao.UserDao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.filefilter.FalseFileFilter;
import org.hibernate.ejb.criteria.predicate.IsEmptyPredicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@SessionAttributes({ "application" })
public class StudentController {
	@Autowired
	ApplicationsDao applicationDao;
	@Autowired
	DepartmentDao departmentDao;
	@Autowired
	TermDao termdao;

	@Autowired
	StatusDao statusdao;

	@Autowired
	UserDao userdao;

	@Autowired
	EduBackgroundDao eduBackgrounddao;

	@Autowired
	ServletContext context;

	@Autowired
	AdditionalFiledDao additionalfielddao;

	private File getFileDirectory() {
		String path = context.getRealPath("/WEB-INF/files/");
		return new File(path);
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		sdf.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}

	@RequestMapping("/student.html")
	public String student(ModelMap models, HttpSession session) {
		User objUser = (User) session.getAttribute("user");
		if (objUser == null) {
			return "redirect:/login.html";
		}

		objUser = applicationDao.getApplicationsByEmail(objUser.getEmail_id());

		List<Applications> lstapplication = objUser.getLstappliApplications();

		models.put("lstapplications", lstapplication);
		return "student";
	}

	@RequestMapping(value = "/newapplication.html", method = RequestMethod.GET)
	public String newapplication(ModelMap models) {
		List<Department> lstdepartments = departmentDao.getallDepartments();
		models.put("application", new Applications());
		models.put("lstdepartment", lstdepartments);
		models.put("lstterms", termdao.getallTerms());

		return "newapplication";
	}

	java.util.Date date = new java.util.Date();

	@RequestMapping(value = "/newapplication.html", method = RequestMethod.POST)
	public String newapplication(@ModelAttribute Applications application,
			ModelMap models, HttpSession session) {
		User objUser = (User) session.getAttribute("user");

		if((application.getDept().getDeptId()==null)||(application.getProgram().getProgramId()==null)||(termdao.getTermbyid(application.getTerm().getTermId())==null))
		{
			return "redirect:/newapplication.html";
		}
			
			
			
		Department department = departmentDao.getDepartmentById(application
				.getDept().getDeptId());
		objUser = applicationDao.getApplicationsByEmail(objUser.getEmail_id());
		application.setDept(department);
		session.setAttribute("sessionDep", department);

		application.setProgram(departmentDao.getProgrambyId(application
				.getProgram().getProgramId()));
		application.setTerm(termdao.getTermbyid(application.getTerm()
				.getTermId()));
		application.setUser(objUser);
		application.setFirstname(objUser.getFirst_name());
		application.setLastname(objUser.getLast_name());
		application.setEmailid(objUser.getEmail_id());
		application.setModifiedtime(new Timestamp(date.getTime()));
		application.setStatus(statusdao.getStatusbyname("Not Submitted"));
		application = applicationDao.saveApplication(application);
		models.put("application", application);

		if (application.getDept().getLstAdditionalFields().size() > 0) {
			return "redirect:/newAdditionalFields.html";
		}

		return "redirect:/newPersonalDeatails.html";
	}

	@RequestMapping(value = "/newAdditionalFields.html", method = RequestMethod.GET)
	public String newAdditionalFields(
			@ModelAttribute("application") Applications application,
			ModelMap models) {
		models.put("application", application);
		models.put("lstaddfields", application.getDept()
				.getLstAdditionalFields());
		return "newAdditionalFields";
	}

	@RequestMapping(value = "/newAdditionalFields.html", method = RequestMethod.POST)
	public String newAdditionalFields(
			HttpServletRequest request,
			@ModelAttribute("application") Applications application,
			@RequestParam(value = "file", required = false) MultipartFile[] transcript,
			ModelMap models) throws Exception {
		int i = 0;
		for (AdditionalField a : application.getDept().getLstAdditionalFields()) {
			ApplicantAdditionalFieldValue obj = new ApplicantAdditionalFieldValue();
			obj.setApplicant(application);
			if (a.getFieldtype().equalsIgnoreCase("File")) {

				if (transcript != null && transcript.length > 0) {
					if(!transcript[i].isEmpty())
					{
					transcript[i].transferTo(new File(getFileDirectory(),
							application.getApplicationId()
									+ transcript[i].getOriginalFilename()));
					obj.setValue((application.getApplicationId() + transcript[i]
							.getOriginalFilename()));
					}
					obj.setField(a);
					additionalfielddao.saveVAlue(obj);
					i++;

				}
			} else {
				String value = request.getParameter(a.getName());
				obj.setValue(value);
				obj.setField(a);
				additionalfielddao.saveVAlue(obj);
			}

			models.put("application", application);
		}
		return "redirect:/newPersonalDeatails.html";
	}

	@RequestMapping(value = "/newPersonalDeatails.html", method = RequestMethod.GET)
	public String newpersonaldetails(
			@ModelAttribute("application") Applications application,
			ModelMap models, HttpSession session) {
		models.put("application", application);
		return "newPersonalDeatails";
	}

	@RequestMapping(value = "/newPersonalDeatails.html", method = RequestMethod.POST)
	public String newpersonaldetails(
			@ModelAttribute("application") Applications application,
			ModelMap models) {

		// System.out.println(key);
		applicationDao.saveApplication(application);
		models.put("application", application);
		return "redirect:/newEdubackgroundDetails.html";
	}

	@RequestMapping(value = "/newEdubackgroundDetails.html", method = RequestMethod.GET)
	public String newEdubackgroundDetails(ModelMap models,
			@ModelAttribute("application") Applications application) {
		models.put("edu", new EducationalBackground());
		application = applicationDao.getApplicationbyid(application
				.getApplicationId());
		models.put("lstedu", application.getLsteEducationalBackgrounds());
		models.put("application", application);
		return "newEdubackgroundDetails";
	}

	@RequestMapping(value = "/newEdubackgroundDetails.html", method = RequestMethod.POST)
	public String newEdubackgroundDetails(
			@ModelAttribute("application") Applications application,
			@ModelAttribute EducationalBackground edu, ModelMap models,
			HttpSession session) {
		edu.setApplicant(application);
		eduBackgrounddao.saveEduDetails(edu);
		return "redirect:/newEdubackgroundDetails.html";
	}

	@RequestMapping(value = "/newEducationalDetails.html", method = RequestMethod.GET)
	public String newEDucationalDetails(
			@ModelAttribute("application") Applications application,
			ModelMap models, HttpSession session) {
		models.put("application", application);
		return "newEducationalDetails";
	}

	@RequestMapping(value = "/newEducationalDetails.html", method = RequestMethod.POST)
	public String newEDucationalDetails(
			@ModelAttribute("application") Applications application,
			@RequestParam("file") MultipartFile transcript, ModelMap models,
			@RequestParam("action") String action)
			throws IllegalStateException, IOException {

		models.put("application", application);
		if (!transcript.isEmpty()) {
			transcript.transferTo(new File(getFileDirectory(), application
					.getApplicationId() + transcript.getOriginalFilename()));
			application.setTranscript(application.getApplicationId()
					+ transcript.getOriginalFilename());
		}
		if (action.equalsIgnoreCase("Submit"))
			application.setStatus(statusdao.getStatusbyname("Submitted"));
		else
			application.setStatus(statusdao.getStatusbyname("Not Submitted"));
		application.setModifiedtime(new Timestamp(date.getTime()));
		applicationDao.saveApplication(application);
		return "redirect:/student.html";
	}

	@RequestMapping("/getprograms.html")
	public void getprograms(@RequestParam int deptid,
			HttpServletResponse response) throws IOException {
		response.setContentType("application/json");
		// List<Program> programs= //ObjectMapper mapper = new ObjectMapper();
		PrintWriter out = response.getWriter();
		ObjectMapper mapper = new ObjectMapper();

		Department dep = departmentDao.getDepartmentById(deptid);
		List<Program> lstprograms = dep.getLstPrograms();
		String json = "";
		try {
			json = mapper.writeValueAsString(lstprograms);
		} catch (Exception e) {
			e.printStackTrace();
		}

		out.println(json);
	}

	@RequestMapping(value = { "EditApplication/download.html", "/download.html" }, method = RequestMethod.GET)
	public String upload(HttpServletResponse response,
			@ModelAttribute("application") Applications application,
			@RequestParam(value = "name", required = false) String filename)
			throws IOException {
		if (filename == null) {
			filename = application.getTranscript();
		}
		response.setContentType("text/plain");
		response.setHeader("Content-Disposition", "attachment; filename="
				+ filename);
		FileInputStream in = new FileInputStream(new File(getFileDirectory(),
				filename));
		OutputStream out = response.getOutputStream();

		byte buffer[] = new byte[2048];
		int bytesread;

		while ((bytesread = in.read(buffer)) > 0)
			out.write(buffer, 0, bytesread);
		in.close();
		return null;
	}

	@RequestMapping(value = "/viewApplicationDetails.html", method = RequestMethod.GET)
	public String viewApplicationDetails(@RequestParam Integer id,
			ModelMap models) {
		models.put("application", applicationDao.getApplicationbyid(id));
		return "viewApplicationDetails";
	}

	// Edit application controllers

	@RequestMapping(value = "EditApplication/editapplication.html", method = RequestMethod.GET)
	public String editapplication(@RequestParam Integer id, ModelMap models) {
		Applications application = applicationDao.getApplicationbyid(id);
		models.put("application", application);
		models.put("lstprgms", application.getDept().getLstPrograms());
		models.put("lstterms", termdao.getallTerms());
		return "EditApplication/editapplication";
	}

	@RequestMapping(value = "EditApplication/editapplication.html", method = RequestMethod.POST)
	public String editapplication(@ModelAttribute Applications application,
			ModelMap models, @RequestParam int id) {
		application.setProgram(departmentDao.getProgrambyId(application
				.getProgram().getProgramId()));

		application.setTerm(termdao.getTermbyid(application.getTerm()
				.getTermId()));
		Applications objapplication = applicationDao.getApplicationbyid(id);
		objapplication.setProgram(application.getProgram());
		objapplication.setTerm(application.getTerm());
		objapplication.setModifiedtime(new Timestamp(date.getTime()));
		application = applicationDao.saveApplication(objapplication);
		models.put("application", objapplication);
		if (objapplication.getDept().getLstAdditionalFields().size() > 0)
			return "redirect:/EditApplication/editAdditionalFields.html?id="
					+ application.getApplicationId();
		else
			return "redirect:/EditApplication/editPersonalDeatails.html";
	}

	@RequestMapping(value = "EditApplication/editPersonalDeatails.html", method = RequestMethod.GET)
	public String editpersonaldetails(
			@ModelAttribute("application") Applications application,
			ModelMap models, HttpSession session) {
		models.put("application", application);
		return "EditApplication/editPersonalDeatails";
	}

	@RequestMapping(value = "EditApplication/editPersonalDeatails.html", method = RequestMethod.POST)
	public String editpersonaldetails(
			@ModelAttribute("application") Applications application,
			ModelMap models) {
		application.setModifiedtime(new Timestamp(date.getTime()));
		applicationDao.saveApplication(application);
		models.put("application", application);
		return "redirect:/EditApplication/editEdubackgroundDetails.html";
	}

	@RequestMapping(value = "EditApplication/editEdubackgroundDetails.html", method = RequestMethod.GET)
	public String editEdubackgroundDetails(ModelMap models,
			@ModelAttribute("application") Applications application) {
		models.put("editedubflag", 0);
		models.put("edu", new EducationalBackground());
		application = applicationDao.getApplicationbyid(application
				.getApplicationId());
		List<EducationalBackground> lstedu = application
				.getLsteEducationalBackgrounds();
		models.put("lstedu", lstedu);
		return "EditApplication/editEdubackgroundDetails";
	}

	@RequestMapping(value = "EditApplication/editEdubackgroundDetails.html", method = RequestMethod.POST)
	public String editEdubackgroundDetails(
			@ModelAttribute("application") Applications application,
			@ModelAttribute EducationalBackground edu, ModelMap models,
			@RequestParam(value = "id", required = false) Integer id) {
		models.put("editedubflag", 0);
		if (id != null) {
			EducationalBackground objedu = eduBackgrounddao
					.getEdubckgroundid(id);
			edu.setEduId(objedu.getEduId());
		}
		edu.setApplicant(application);
		application.setModifiedtime(new Timestamp(date.getTime()));
		eduBackgrounddao.saveEduDetails(edu);
		return "redirect:/EditApplication/editEdubackgroundDetails.html";
	}

	@RequestMapping(value = "EditApplication/editEduBg.html", method = RequestMethod.GET)
	public String editEduBg(ModelMap models, @RequestParam int id,
			@ModelAttribute("application") Applications application) {
		models.put("editedubflag", 1);

		application = applicationDao.getApplicationbyid(application
				.getApplicationId());
		models.put("lstedu", application.getLsteEducationalBackgrounds());
		models.put("edu", eduBackgrounddao.getEdubckgroundid(id));
		return "EditApplication/editEdubackgroundDetails";
	}

	@RequestMapping("EditApplication/deleteEduBg.html")
	public String deleteprogram(@RequestParam int id,
			@ModelAttribute("application") Applications application,
			ModelMap models) {
		models.put("editedubflag", 0);
		application.setModifiedtime(new Timestamp(date.getTime()));
		eduBackgrounddao.removeeduBachgroundbyId(eduBackgrounddao
				.getEdubckgroundid(id));
		models.put("application", applicationDao.getApplicationbyid(application
				.getApplicationId()));
		return "redirect:/EditApplication/editEdubackgroundDetails.html";
	}

	@RequestMapping(value = "EditApplication/editEducationalDetails.html", method = RequestMethod.GET)
	public String editEDucationalDetails(
			@ModelAttribute("application") Applications application,
			ModelMap models) {
		models.put("application", application);
		return "EditApplication/editEducationalDetails";
	}

	@RequestMapping(value = "EditApplication/editEducationalDetails.html", method = RequestMethod.POST)
	public String editEDucationalDetails(
			@ModelAttribute("application") Applications application,
			ModelMap models,
			@RequestParam(value = "file", required = false) MultipartFile file,
			@RequestParam("action") String action)
			throws IllegalStateException, IOException {
		models.put("application", application);
		String fname = file.getOriginalFilename();
		if (StringUtils.hasText(fname)) {
			file.transferTo(new File(getFileDirectory(), fname));
			application.setTranscript(application.getApplicationId()
					+ file.getOriginalFilename());
		}
		java.util.Date date = new java.util.Date();
		Status status = application.getStatus();
		if (action.equalsIgnoreCase("Submit")) {
			application.setStatus(statusdao.getStatusbyname("Submitted"));
			application.setModifiedtime(new Timestamp(date.getTime()));
		} else {
			application.setStatus(statusdao.getStatusbyname("Not Submitted"));
			application.setModifiedtime(new Timestamp(date.getTime()));
		}

		if (status.getStatusId() != application.getStatus().getStatusId()) {
			StatusAudit audit = new StatusAudit();
			audit.setOldstatus(status);
			audit.setNewstatus(application.getStatus());
			audit.setModifiedBy(application.getUser());
			audit.setApplicant(application);
			audit.setModifiedtime(new Timestamp(date.getTime()));
		}
		application.setModifiedtime(new Timestamp(date.getTime()));
		applicationDao.saveApplication(application);
		return "redirect:/student.html";
	}

	@RequestMapping(value = "EditApplication/editAdditionalFields.html", method = RequestMethod.GET)
	public String editAdditionalFields(@RequestParam int id,
			@ModelAttribute("application") Applications application,
			ModelMap models) {
		models.put("application", application);
		List<ApplicantAdditionalFieldValue> lstaddfieldvalues = applicationDao
				.getApplicationbyid(id).getLstfieldvalues();
		// System.out.println(lstaddfieldvalues.size());
		// System.out.println(lstaddfieldvalues.get(0).getValue());
		models.put("lstaddfieldvalues", lstaddfieldvalues);
		return "EditApplication/editAdditionalFields";
	}

	@RequestMapping(value = "EditApplication/editAdditionalFields.html", method = RequestMethod.POST)
	public String editAdditionalFields(
			@RequestParam int id,
			HttpServletRequest request,
			@ModelAttribute("application") Applications application,
			@RequestParam(value = "file", required = false) MultipartFile[] transcript,
			ModelMap models) throws Exception {
		try {
			int i = 0;
			List<ApplicantAdditionalFieldValue> lstaddfieldvalues = applicationDao
					.getApplicationbyid(id).getLstfieldvalues();
			for (ApplicantAdditionalFieldValue a : lstaddfieldvalues) {

				if (a.getField().getFieldtype().equalsIgnoreCase("File")) {
					if (transcript != null && transcript.length > 0) {
						if (!transcript[i].isEmpty()) {
							String filename = application.getApplicationId()
									+ transcript[i].getOriginalFilename();
							if (!a.getValue().equalsIgnoreCase(filename)) {
								transcript[i].transferTo(new File(
										getFileDirectory(), filename));
								a.setValue(filename);
							}
							i++;
							//additionalfielddao.saveVAlue(a);
						}

					}
				} else {
					String value = request.getParameter(a.getField().getName());
						a.setValue(value);
						//additionalfielddao.saveVAlue(a);
				}
			}
			
			application.setLstfieldvalues(lstaddfieldvalues);
			applicationDao.saveApplication(application);
			models.put("application", application);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return "redirect:/EditApplication/editPersonalDeatails.html";
	}

}
