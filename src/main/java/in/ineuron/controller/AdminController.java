package in.ineuron.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.ineuron.model.Docter;
import in.ineuron.service.ICustomerServiceImpl;
import in.ineuron.service.IDoctorServiceImpl;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired 
    private IDoctorServiceImpl docterService;

    @Autowired
    private ICustomerServiceImpl customerService;
    
    @PostMapping("/adminlogin")
    public String verifyAdmin(@RequestParam String aname, String apassword) {
    	if(aname.equalsIgnoreCase("admin") && apassword.equalsIgnoreCase("9844"))
    		return "success";
    	else 
    		return "failure";
    }

    @PostMapping("/save-docter")
    public String addDoctor(@RequestBody Docter docter, Map<String, String> model){
        String msg = docterService.saveDocter(docter);
        System.out.println(msg);
        model.put("msg", msg);
        return msg;
    }

    @GetMapping("/get-docter/{id}")
    public String getDocter(@PathVariable String id, Map<String, Object> model){
        Optional<Docter> docter = docterService.getDocter(id);
        model.put("docter", docter);
		return "index";
    }

    @GetMapping("/noofcustomer")
    public String noOfCustomers(Map<String, String> model){
    	int records = customerService.noOfCustomers();
    	String totalRecords = Integer.toString(records);
     	model.put("totalRecords", totalRecords);
     	System.out.println(records);
     	return "";
    }
    
    @GetMapping("/listofdocters")
    public List<Docter> listOfDocters(){
    	List<Docter> docters = docterService.listOfDocters();
    	return docters;
    }
    
    @GetMapping("/noofdocters")
    public int noOfDocters() {
    	int noOfDoc = docterService.noOfDocters();
    	return noOfDoc;
    	
    }
    
    @GetMapping("/noofcustomers")
    public int noOfCustomers() {
    	int noOfCustomers = customerService.noOfCustomers();
    	return noOfCustomers;
    }
    

    
}
