package in.ineuron.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    public String loginCustomer(@RequestParam String cid, String cpassword) {
    		
    	return "customer-dashboard";
    }

    @PostMapping("/save-customer")
    public String saveCustomer(@RequestBody Customer customer){
    	String msg = customerService.saveCustomer(customer);
    	return msg;
    }

    @DeleteMapping("delete-customer/{id}")
    public String deleteCustomer(@PathVariable String id){
        String msg = customerService.deleteCustomer(id);
        return msg;
    }

    @PostMapping("/BookAppointment")
    public String getAppointment(@RequestBody AppointmentData appointmentData){
        String msg = customerService.getAppointment(appointmentData);
        return msg;
    }

    @GetMapping("/AppoitmentStatus/{id}")
    public String getStatusOfAppointment(@PathVariable String id){
        return null;
    }
    
}
