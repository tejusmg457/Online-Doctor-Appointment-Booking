package in.ineuron.service;

import java.util.List;
import java.util.Optional;

import in.ineuron.model.AppointmentData;
import in.ineuron.model.Docter;

public interface IDoctorService {
    
    public String saveDocter(Docter docter);

    public Optional<Docter> getDocter(String docId);

    public List<AppointmentData> listOfPendingAppointments(String did);
    
    public List<Docter> listOfDocters();
    
    public int noOfDocters();
    

}
