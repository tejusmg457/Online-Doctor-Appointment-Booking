package in.ineuron.service;


import in.ineuron.model.AppointmentData;
import in.ineuron.model.Customer;

public interface ICustomerService {
	
	public String loginCustomer(String cemail);

    public String saveCustomer(Customer customer);

    public String deleteCustomer(String id);

    public String getAppointment(AppointmentData appointmentData);
    
    public int noOfCustomers();
    
    public String[] docNames();
    
    public String[] docSpecilist();
    
    public String getPassword(String cid, String cemail);

    
}
