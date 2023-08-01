package in.ineuron.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.dao.ICustomerRepo;
import in.ineuron.dao.ICustomerRepoForAppointment;
import in.ineuron.model.AppointmentData;
import in.ineuron.model.Customer;

@Service(value="customerService")
public class ICustomerServiceImpl implements ICustomerService{

    @Autowired
    private ICustomerRepo customerRepo;

    @Autowired
    private ICustomerRepoForAppointment customerRepoforAppointment;
    
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
       boolean flag = false;
       AppointmentData data = customerRepoforAppointment.save(appointmentData);
       flag=true;
       if(flag){
         return  data.getAppointId();
        }else
            return "Something went wrong try again! by entering appropriating details";
    }

	@Override
	public int noOfCustomers() {
		int num = customerRepo.noOfCustomers();
		return num;
	}
    
}
