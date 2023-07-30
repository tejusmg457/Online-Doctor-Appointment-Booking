package in.ineuron.service;

import in.ineuron.model.AppointmentData;
import in.ineuron.model.Customer;

public interface ICustomerService {

    public String saveCustomer(Customer customer);

    public String deleteCustomer(String id);

    public String getAppointment(AppointmentData appointmentData);
    
    public int noOfCustomers();

    
}
