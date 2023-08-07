package in.ineuron.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.ineuron.model.AppointmentData;
import in.ineuron.service.IDoctorService;

@Controller
@RequestMapping("/doctor")
public class DoctorController {
	
	@Autowired
	private IDoctorService doctorService;
	
	@Autowired
	HttpServletRequest req;
	
	@GetMapping("/doctor-login")
	public String doctorLoginPage() {
		return "doctorlogin";
	}
	
	@PostMapping("/doctorlogin")
	public String loginDocter(@RequestParam String demail, String dpassword, Map<String, String>model) {
		String dbpassword = doctorService.loginDoctor(demail);
		if(dpassword.equalsIgnoreCase(dbpassword)) {
			model.put("demail", demail);
			return "doctor-dashboard";
		}else {
			String msg = "Login failed";
			model.put("msg",msg);
			return "redirect:/doctor/doctor-login";
		}		
	}
	
	@GetMapping("/listOfPendingAppointments")
	public String listOfPendingAppointments(@RequestParam String demail, Map<String, Object> model) {
			List<AppointmentData> appointmentData = (List<AppointmentData>) doctorService.listOfPendingAppointments(demail);
			model.put("appointmentData", appointmentData);
		    return "doctor-appointment-list";
	}
	
	
	@GetMapping("/approveAppointment")
	public String approveAppointment(@RequestParam String appointmentId,  Map<String, String>model) {
		
		HttpSession session = req.getSession();
		String demail = (String)session.getAttribute("demail");
	
		String msg = doctorService.approveAppointment(appointmentId);
		if(msg.equalsIgnoreCase("approved")) {
			String result = "Appointment approved for the ID :: "+appointmentId;
			model.put("result", result);
			String path = "redirect:/doctor/listOfPendingAppointments/?demail="+demail;
			return path;
		}
		return null;
	}

}
