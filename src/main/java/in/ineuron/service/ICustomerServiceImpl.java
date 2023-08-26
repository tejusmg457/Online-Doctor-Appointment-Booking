package in.ineuron.service;

import java.sql.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.dao.IAppointmentRepo;
import in.ineuron.dao.ICustomerRepo;
import in.ineuron.dao.ICustomerRepoForAppointment;
import in.ineuron.model.AppointmentData;
import in.ineuron.model.AppointmentStatus;
import in.ineuron.model.Customer;

@Service(value="customerService")
public class ICustomerServiceImpl implements ICustomerService{

    @Autowired
    private ICustomerRepo customerRepo;
    

    @Autowired
    private ICustomerRepoForAppointment customerRepoforAppointment;
    
    @Autowired
    private IAppointmentRepo appointmentStatusRepo;
    
	@Override
	public String loginCustomer(String cemail) {
		String cdpassword = customerRepo.loginCustomer(cemail);
		return cdpassword;
	}

    @Override
    public String saveCustomer(Customer customer) {
        
    	String id = null;
    	
    	try{        
    		id = customerRepo.save(customer).getCid();
    	}catch(Exception e) {
    		return "Patient already registered you can login!";
    	}
    	if(id!=null)
    		return "Patient registration successfull and id "+ id +" for your reference";
    	else
    		return "Patient registration failed";
    }

    @Override
    public String deleteCustomer(String id) {
        Optional<Customer> customer = customerRepo.findById(id);
        if(customer.isPresent()){
            customerRepo.deleteById(id);
            return "yes";
        }else
            return "Deletion failed try again!";
    }

    @Override
    public String getAppointment(AppointmentData appointmentData) {
       
       AppointmentStatus appointmentStatus = new AppointmentStatus();
       
       appointmentStatus.setStatus("Pending");
       appointmentStatus.setMessage("Need to be approval from doctor end");
       appointmentStatus.setAppointmentData(appointmentData);

       String id = customerRepoforAppointment.save(appointmentData).getAppointid();
       appointmentStatusRepo.save(appointmentStatus);
       return  id;

    }

	@Override
	public int noOfCustomers() {
		int num = customerRepo.noOfCustomers();
		return num;
	}

	@Override
	public String[] docNames() {
		return customerRepo.docNames();
	}

	@Override
	public String[] docSpecilist() {
		return customerRepo.docSpecilist();
	}

	@Override
	public String getPassword(String cid, String cemail) {
		return customerRepo.getPassword(cid, cemail);
	}

	@Override
	public String getCustomerName(String cemail) {
		return customerRepo.getCustomerName(cemail);
	}

    @Override
    public int checkSlot(String dname, String dspecialist, Date sdate) {
        return customerRepoforAppointment.checkSlot(dname, dspecialist, sdate);
    }
}
