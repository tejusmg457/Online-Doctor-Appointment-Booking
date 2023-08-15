package in.ineuron.controller;

import java.sql.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.ineuron.model.AppointmentData;
import in.ineuron.model.Doctor;
import in.ineuron.service.IAppointmentService;
import in.ineuron.service.ICustomerServiceImpl;
import in.ineuron.service.IDoctorServiceImpl;
import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("api/admin")
public class AdminController {

    @Autowired 
    private IDoctorServiceImpl docterService;

    @Autowired
    private ICustomerServiceImpl customerService;
    
    @Autowired
    private IAppointmentService appointmentService;
    
    @PostMapping("/adminlogin")
    @ApiOperation("admin login")
    public String verifyAdmin(@RequestParam String aname, String apassword, Map<String, Integer>model) {
    	if(aname.equalsIgnoreCase("admin") && apassword.equalsIgnoreCase("9844")) {
    		
    		int noOfAppointmentsForToday = docterService.noOfAppointmentsForToday();
    		int noOfCustomers = customerService.noOfCustomers();
    		int noOfDoctors = docterService.noOfDoctors();
    		
        	model.put("noOfAppointmentsForToday", noOfAppointmentsForToday);
        	model.put("noOfCustomers", noOfCustomers);
        	model.put("noOfDoctors", noOfDoctors);
        	
    		return "admin-dashboard";
    	}else 
    		return "failure";
    }
    
    @GetMapping("/doctor-registration")
    @ApiOperation("show doctor registration form")
    public String docRegistration() {
    	return "doctor-registration";
    }

    @PostMapping("/save-doctor")
    @ApiOperation("doctor registration")
    public String addDoctor(Map<String, String> model, @ModelAttribute("doctor") Doctor doctor){
    	System.out.println("AdminController.addDoctor()");
    	String msg = docterService.saveDocter(doctor); 
        model.put("msg", msg);
        return "doctor-registration";
    }
    
    @GetMapping("/listofdoctors")
    @ApiOperation("list of doctors")
    public String listOfDoctors(@SuppressWarnings("rawtypes") Map<String, List>model){
    	List<Doctor> doctors = docterService.listOfDocters();
    	model.put("doctors", doctors);
    	return "display-doctors";
    }
    
    @GetMapping("/delete-customer")
    @ApiOperation("customer deletion")
    public String deleteCustomer(@RequestParam String cid, Map<String, String> model) {
    	String status = customerService.deleteCustomer(cid);
    	if(status.equalsIgnoreCase("yes")) {
    		String msg = "Customer "+ cid + " data deleted successfully ";
    		model.put("msg", msg);
    		return "redirect:/admin/adminlogin";
    	}
    	else {
    		String msg = "Customer "+ cid + " data can't be deleted ";
    		model.put("msg", msg);
    		return "redirect:/admin/adminlogin";
    	}
    }
    
    @GetMapping("/delete-doctor")
    @ApiOperation("doctor deletion it internally calls from list of doctors")
    public String deleteDoctor(@RequestParam String did, Map<String, String> model) {
    	String msg = docterService.deleteDoctor(did);
    	model.put("msg", msg);
    	return "redirect:/admin/listofdoctors";
    }
    
    @GetMapping("/track-appointment")
    @ApiOperation("track appointment here")
    public String trackAppointment(@RequestParam String apointid, Map<String,Optional<AppointmentData>>model) {
    	Optional<AppointmentData> data = appointmentService.getAppointmentStatusById(apointid);
    	model.put("data", data);
    	return "display-appointment-status";
    }
    
    @GetMapping("/listofappointments")
    @ApiOperation("list of appointments by selecting between two dates")
    public String getAppointments(@RequestParam Date fdate, Date tdate, Map<String, List<AppointmentData>> model){
    	System.out.println("AdminController.getAppointments()");
    	List<AppointmentData> appointments = docterService.findAppointments(fdate, tdate);
    	model.put("appointments", appointments);
    	return "dispay-appointments";
    }
    
    @GetMapping("/logout")
    @ApiOperation("lagout here")
    public String logOut() {
    	return "index";
    }
   
}
