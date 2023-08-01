package in.ineuron.service;

import java.util.List;

import in.ineuron.model.AppointmentData;
import in.ineuron.model.Doctor;

public interface IDoctorService {
	
	public String loginDoctor(String docEmail);
    
    public String saveDocter(Doctor doctor);

    public List<AppointmentData> listOfPendingAppointments(String did);
    
    public List<Doctor> listOfDocters();
    
    public int noOfDocters();
    
    public String deleteDoctor(String did);
    

}
