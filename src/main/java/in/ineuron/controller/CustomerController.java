package in.ineuron.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.ineuron.model.AppointmentData;
import in.ineuron.model.Customer;
import in.ineuron.service.ICustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
    @Autowired
    private ICustomerService customerService;
    
    @PostMapping("/logincustomer")
    public String loginCustomer(@RequestParam String cemail, String cpassword) {
    	String cdpassword = customerService.loginCustomer(cemail);	
    	if(cpassword.equalsIgnoreCase(cdpassword))
    		return "customer-dashboard";
    	else 
    		return "failure";
    }
    
    @GetMapping("/signup")
    public String signup() {
    	return "customer-registration";
    }

    @PostMapping("/save-customer")
    public String saveCustomer(@ModelAttribute("customer") Customer customer, Map<String, String> model){
    	String msg = customerService.saveCustomer(customer);
    	model.put("msg", msg);
    	return "customer-registration";
    }

    @DeleteMapping("delete-customer/{id}")
    public String deleteCustomer(@PathVariable String id){
        String msg = customerService.deleteCustomer(id);
        return msg;
    }
    
    @GetMapping("/book-appointmentment")
    public String bookAppointment() {
    	return "appointment-booking";
    }
    
    @PostMapping("/BookAppointment")
    public String getAppointment(@ModelAttribute AppointmentData appointmentData, Map<String, String> model){
        String msg = customerService.getAppointment(appointmentData);
        model.put("msg", msg);
        return "appointment-booking";
    }

    @GetMapping("/AppoitmentStatus/{id}")
    public String getStatusOfAppointment(@PathVariable String id){
        return null;
    }
    
    @GetMapping("/track-appointment")
    public String trackAppointment() {
    	return "track-appointment-status";
    }
    
}
