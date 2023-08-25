package in.ineuron.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/")
public class GeneralController {
	
	@GetMapping("")
	@ApiOperation("To show index page")
	public String welcome() {
		return "index";
	}
	
	@GetMapping("/adminlogin")
	@ApiOperation("To get admin login page")
	public String adminlogin() {
		return "adminlogin";
	}
	
	@GetMapping("/doctorlogin")
	@ApiOperation("To get doctor login page")
	public String docterlogin() {
		return "doctorlogin";
	}
	
	
	@GetMapping("/customerlogin")
	@ApiOperation("To get customer login page")
	public String customerlogin() {
		return "customerlogin";
	}
	
	@GetMapping("/header")
	public String headerPage() {
		return "header";
	}

}
