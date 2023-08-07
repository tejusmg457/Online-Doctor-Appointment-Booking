package in.ineuron.service;

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
		System.out.println(cdpassword);
		return cdpassword;
	}

    @Override
    public String saveCustomer(Customer customer) {
        boolean flag = false;
        String id = customerRepo.save(customer).getCid();
        System.out.println("customer id is :: "+ id);
        flag=true;
        if(flag){
            return id;
        }else
            return "Customer registration failed";
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
       
       
   
       AppointmentData data = customerRepoforAppointment.save(appointmentData);
       appointmentStatusRepo.save(appointmentStatus);
       System.out.println("saved data "+data);
       return  data.getAppointid();

    }

	@Override
	public int noOfCustomers() {
		int num = customerRepo.noOfCustomers();
		return num;
	}
    //SELECT * FROM appointmentdata a inner join appointment_status s where a.appointid = s.appointmentid;
}
