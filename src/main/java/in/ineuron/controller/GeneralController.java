package in.ineuron.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class GeneralController {
	
	@GetMapping("")
	public String welcome() {
		return "index";
	}
	
	@PostMapping("/adminlogin")
	public String adminlogin() {
		return "adminlogin";
	}
	
	@PostMapping("/doctorlogin")
	public String docterlogin() {
		return "docterlogin";
	}
	
	@PostMapping("/customerlogin")
	public String customerlogin() {
		return "customerlogin";
	}

}
