package in.ineuron.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.dao.IDoctorRepo;
import in.ineuron.model.AppointmentData;
import in.ineuron.model.Docter;

@Service(value="docterService")
public class IDoctorServiceImpl implements IDoctorService {

    @Autowired
    private IDoctorRepo doctorRepo;

    @Override
    public String saveDocter(Docter docter) {
        String id = doctorRepo.save(docter).getDid();
        return id;
    }

    @Override
    public Optional<Docter> getDocter(String docId) {
        Optional<Docter> docter = doctorRepo.findById(docId);
        if(docter.isPresent()){
           return docter;
        }else
            return null;
    }

    @Override
    public List<AppointmentData> listOfPendingAppointments(String did) {
    	List<AppointmentData> appointmentData = (List<AppointmentData>) doctorRepo.listOfPendingAppointments(did);
    	System.out.println(appointmentData);
		return appointmentData;
    }

	@Override
	public List<Docter> listOfDocters() {
		List<Docter> docters = doctorRepo.findAll();
		return docters;
	}

	@Override
	public int noOfDocters() {
		return doctorRepo.noOfDocters();
	}

	
	
    
    

}
