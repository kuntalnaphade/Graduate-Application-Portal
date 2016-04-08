package gapp.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StaffController {
	@RequestMapping("/staff.html")
	public String staff() {
		return "staff";
	}
}
