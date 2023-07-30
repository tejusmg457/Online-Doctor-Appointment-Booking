package in.ineuron.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@PostMapping("/doctorlogin")
	public String loginDocter(@RequestParam String did, String dpassword) {
		System.out.println("DocterController.loginDocter()");
		System.out.println(did+dpassword);
		return "adsuccess";
	}
	
	

	@GetMapping("/listOfPendingAppointments/did")
	public String listOfPendingAppointments(@PathVariable String did, Map<String, Object> model) {
			List<AppointmentData> appointmentData = (List<AppointmentData>) doctorService.listOfPendingAppointments(did);
			model.put("appointmentData", appointmentData);
		    return null;
	}

}
