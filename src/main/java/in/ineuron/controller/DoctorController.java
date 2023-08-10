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
import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("api/doctor")
public class DoctorController {
	
	@Autowired
	private IDoctorService doctorService;
	
	@Autowired
	HttpServletRequest req;
	
	@GetMapping("/doctor-login")
	@ApiOperation("doctor logon page display")
	public String doctorLoginPage() {
		return "doctorlogin";
	}
	
	@PostMapping("/doctorlogin")
	@ApiOperation("doctors login")
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
	@ApiOperation("list of appointments to perticular doctor")
	public String listOfPendingAppointments(@RequestParam String demail, Map<String, Object> model) {
			List<AppointmentData> appointmentData = (List<AppointmentData>) doctorService.listOfPendingAppointments(demail);
			model.put("appointmentData", appointmentData);
		    return "doctor-appointment-list";
	}
	
	
	@GetMapping("/approveAppointment")
	@ApiOperation("doctors will approve appointments from list of appointments page")
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
		return "failure";
	}
	
	@PostMapping("/complete-appointment")
	@ApiOperation("doctor will complete the appointment from their dashboard")
	public String completeAppointment(@RequestParam String appointid, Map<String, String>model) {
		String msg = doctorService.completeAppointment(appointid);
		if(msg.equalsIgnoreCase("completed")) {
			String demail = (String) req.getSession().getAttribute("demail");
			System.out.println(demail);
			String info = "Status updated for id "+appointid;
			model.put("info", info);
			model.put("demail", demail);
			return "doctor-dashboard";	
		}
		return "failure";
	}
	
	@GetMapping("/listOfAppointmentsToday")
	@ApiOperation("shows doctor list of approved appointments today")
	public String todayAppointmentList(@RequestParam String demail, Map<String, List<AppointmentData>>model) {
		List<AppointmentData> data = doctorService.todayAppointmentList(demail);
		model.put("data", data);
		return "doc-appointments";
	}
	
	@GetMapping("/Appointment-history")
	@ApiOperation("Shows a list of appointments to perticular doctor")
	public String appointmentHistory(@RequestParam String demail, Map<String, List<AppointmentData>>model ) {
		List<AppointmentData> appointmentHistory = doctorService.appointmentHistory(demail);
		model.put("appointments", appointmentHistory);
		return "dispay-appointments";
	}
	
	@GetMapping("/showforgotpasswordpage")
	@ApiOperation("to show forgot password page")
    public String showforgotpasswordpage() {
    	return "forgotpassword-doctor";
    }
    
    @PostMapping("/getPassword")
    @ApiOperation("doctor can enter their id and email to get password")
    public String getPassword(@RequestParam String did, String demail, Map<String, String>model) {
    	String password  = doctorService.getPassword(did, demail);
    	if(password!=null) {
    		model.put("password", password);
    		return "forgotpassword-doctor";
    	}else {
    		String error = "Invalid data";
    		model.put("error", error);
    		return "forgotpassword-doctor";
    	}
    }
    
    @GetMapping("/logout")
    @ApiOperation("doctor can logout here")
    public String logOut() {
    	return "index";
    }

}
