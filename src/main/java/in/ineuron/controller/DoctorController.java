package in.ineuron.controller;

import java.sql.Date;
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
@RequestMapping("/doctor")
public class DoctorController {
	
	@Autowired
	private IDoctorService doctorService;
	
	@Autowired
	HttpServletRequest req;
	
	@Autowired
	HttpSession session;
	
	@GetMapping("/doctor-login")
	@ApiOperation("doctor login page display")
	public String doctorLoginPage(Map<String, String> model) {
		model.put("msg", "Invalid");
		return "doctorlogin";
	}
	
	@PostMapping("/doctorlogin")
	@ApiOperation("doctors login")
	public String loginDocter(@RequestParam String demail, String dpassword, Map<String, String>model) {
		String dbpassword = doctorService.loginDoctor(demail);
		if(dpassword.equalsIgnoreCase(dbpassword)) {
			String dname = doctorService.getDoctorName(demail);
			session.setAttribute("demail", demail);
			session.setAttribute("dname", dname);
			System.out.println(session.getAttribute("dname"));
			System.out.println(session.getAttribute("demail"));
			return "doctor-dashboard";
		}else {
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
	public String approveAppointment(@RequestParam String appointmentId,  Map<String, Object>model) {
		HttpSession session = req.getSession();
		String demail = (String)session.getAttribute("demail");
		
		String dname = doctorService.getDoctorName(demail);
		Date date = doctorService.getAppointmentDate(appointmentId);
		int count = doctorService.getAppointmentApprovedCount(dname, date, "Approved");
		
		if(count<30) {
		String msg = doctorService.approveAppointment(appointmentId);
			if(msg.equalsIgnoreCase("approved")) {
				System.out.println("enter after condition block");
				List<AppointmentData> appointmentData = (List<AppointmentData>) doctorService.listOfPendingAppointments(demail);
				model.put("appointmentData", appointmentData);
				model.put("msg", "appointment approved for the id "+appointmentId);
				return "doctor-appointment-list";
			}
		}else {
			model.put("msg", "limit over you're approved 30 appointments for the day "+date);
		}
		return "failure";
	}
	
	@PostMapping("/complete-appointment")
	@ApiOperation("doctor will complete the appointment from their dashboard")
	public String completeAppointment(@RequestParam String appointid, Map<String, String>model) {
		String msg = doctorService.completeAppointment(appointid);
		if(msg.equalsIgnoreCase("completed")) {
			String info = "Status updated for id "+appointid;
			model.put("info", info);
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
	public String appointmentHistory(@RequestParam String demail, Date fdate, Date tdate, Map<String, Object>model ) {
		List<AppointmentData> appointmentHistory = doctorService.appointmentHistory(demail);
		model.put("appointments", appointmentHistory);
		model.put("fdate", fdate);
		model.put("tdate", tdate);
		model.put("doctor", "doctor");
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
    		model.put("msg", "password is "+password );
    		return "forgotpassword-doctor";
    	}else {
    		String error = "Id or mailId Invalid!";
    		model.put("msg", error);
    		return "forgotpassword-doctor";
    	}
    }
    
    @GetMapping("/logout")
    @ApiOperation("doctor can logout here")
    public String logOut() {
    	return "doctorlogin";
    }

}
