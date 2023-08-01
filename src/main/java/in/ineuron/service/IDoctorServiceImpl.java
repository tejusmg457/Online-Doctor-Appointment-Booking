package in.ineuron.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.dao.IDoctorRepo;
import in.ineuron.model.AppointmentData;
import in.ineuron.model.Doctor;

@Service(value="docterService")
public class IDoctorServiceImpl implements IDoctorService {

    @Autowired
    private IDoctorRepo doctorRepo;

    @Override
    public String saveDocter(Doctor doctor) {
        String id = doctorRepo.save(doctor).getDid();
        return id;
    }

    @Override
    public List<AppointmentData> listOfPendingAppointments(String did) {
    	List<AppointmentData> appointmentData = (List<AppointmentData>) doctorRepo.listOfPendingAppointments(did);
    	System.out.println(appointmentData);
		return appointmentData;
    }

	@Override
	public List<Doctor> listOfDocters() {
		List<Doctor> doctors = doctorRepo.findAll();
		return doctors;
	}

	@Override
	public int noOfDocters() {
		return doctorRepo.noOfDocters();
	}

	@Override
	public String loginDoctor(String docEmail) {
		String dbpassword = doctorRepo.loginDoctor(docEmail);
		return dbpassword;
	}

	@Override
	public String deleteDoctor(String did) {
		doctorRepo.deleteById(did);
		return "Data deleted successfully for the id "+did;
	}

	
	
    
    

}
