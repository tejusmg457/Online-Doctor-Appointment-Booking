package in.ineuron.controller;

import java.sql.Date;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.ineuron.model.AppointmentData;
import in.ineuron.model.Customer;
import in.ineuron.service.IAppointmentService;
import in.ineuron.service.ICustomerService;
import in.ineuron.service.IDoctorService;
import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
    @Autowired
    private ICustomerService customerService;
    
    @Autowired
    private IAppointmentService appointmentService;
    
    @Autowired
    private IDoctorService doctorService;
    
    @Autowired
    HttpSession session;
    
    @PostMapping("/logincustomer")
    @ApiOperation("customer login")
    public String loginCustomer(@RequestParam String cemail, String cpassword, Map<String, Object>model) {
    	String cdpassword = customerService.loginCustomer(cemail);	
    	if(cpassword.equalsIgnoreCase(cdpassword)) {
			String[] docNames = customerService.docNames();
    		String[] docSpecialists = customerService.docSpecilist();
    		String cname = customerService.getCustomerName(cemail);
    		
    		session.setAttribute("docNames", docNames);
    		session.setAttribute("docSpecialists", docSpecialists);
    		session.setAttribute("cname", cname);
    		
    		return "customer-dashboard";
    	}
    	else { 
    		String msg = "Invalid email and password";
    		model.put("msg", msg);
    		return "customerlogin";
    	}
    }
    
    @GetMapping("/signup")
    @ApiOperation("display signup page to customer")
    public String signup() {
    	return "customer-registration";
    }

    @PostMapping("/save-customer")
    @ApiOperation("customer can register here")
    public String saveCustomer(@ModelAttribute("customer") Customer customer, Map<String, String> model){
    	 	String msg = customerService.saveCustomer(customer);
			model.put("msg", msg);
			return "customer-registration";
    }

    
    @GetMapping("/book-appointment")
    @ApiOperation("displaying appointment booking page to customer ")
    public String bookAppointment(Map<String, Object> common) {
    	return "appointment-booking";
    }
    
    @SuppressWarnings("unused")
	@PostMapping("/BookAppointment")
    @ApiOperation("patient can book appointment here")
    public String getAppointment(@ModelAttribute AppointmentData appointmentData,Model model){
    	String[] dspecialist = doctorService.verifyDocSpecialist(appointmentData.getDname());
    	boolean flag= false;
    	for(int i=0; i<dspecialist.length; i++) {
    		String udSpecialist = appointmentData.getDspecialist();
    		if(udSpecialist.equalsIgnoreCase(dspecialist[i]))
    			flag=true;
    		else {
    			String msg = "Invalid doctor name or specialist";
    	        session.setAttribute("msg", msg);
    	        return "redirect:/customer/book-appointment";
    		}
    	}if(flag=true) {
    		String result = customerService.getAppointment(appointmentData);
    		String msg = "Appointment booked successfully and id "+ result +" for your reference";
            model.addAttribute("msg", msg);
            System.out.println(msg);
            return "appointment-booking";
    	}
    	return "failure";	
    }
    
    @GetMapping("/getAppointmentStatus")
    @ApiOperation("patient can track appointment here")
    public String trackAppointment(@RequestParam String appointid, Map<String, Optional<AppointmentData>>model) {
    	Optional<AppointmentData> data = appointmentService.getAppointmentStatusById(appointid);
    	model.put("data", data);
    	return "customer-dashboard";
    }
    
    @GetMapping("/showforgotpasswordpage")
    @ApiOperation("get forgot password page incase forgotted password")
    public String showforgotpasswordpage() {
    	return "forgotpassword-customer";
    }
    
    @PostMapping("/getPassword")
    @ApiOperation("customer will get password if and only provide correct id and email")
    public String getPassword(@RequestParam String cid, String cemail, Map<String, String>model) {
    	String password  = customerService.getPassword(cid, cemail);
    	if(password!=null) {
    		model.put("msg", "password is "+password );
    		return "forgotpassword-customer";
    	}else {
    		String error = "Id or mailId Invalid!";
    		model.put("msg", error);
    		return "forgotpassword-customer";
    	}
    }

	@GetMapping("checkslot")
	public String checkSlot(String dname, String dspecialist, Date adate, Map<String, String>model){
		int bookedSlots = customerService.checkSlot(dname, dspecialist, adate);
		int remainingSlots = 30-bookedSlots;
		String msg = remainingSlots + " slots available";
		model.put("msg", msg);
		return "customer-dashboard";
	}
    
    @GetMapping("/logout")
    @ApiOperation("customer logout")
    public String logOut() {
    	return "customerlogin";
    }
    
    
    
}
