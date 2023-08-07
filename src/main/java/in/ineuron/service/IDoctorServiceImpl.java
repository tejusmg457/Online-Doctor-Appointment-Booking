package in.ineuron.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.dao.IAppointmentRepo;
import in.ineuron.dao.ICustomerRepoForAppointment;
import in.ineuron.dao.IDoctorRepo;
import in.ineuron.model.AppointmentData;
import in.ineuron.model.AppointmentStatus;
import in.ineuron.model.Doctor;

@Service(value="docterService")
public class IDoctorServiceImpl implements IDoctorService {

    @Autowired
    private IDoctorRepo doctorRepo;
    
    @Autowired
    private ICustomerRepoForAppointment customerRepoforAppointment;
    
    @Autowired
    private IAppointmentRepo appointmentStatusRepo;

    @Override
    public String saveDocter(Doctor doctor) {
        String id = doctorRepo.save(doctor).getDid();
        return id;
    }

    @Override
    public List<AppointmentData> listOfPendingAppointments(String demail) {
    	String dname = doctorRepo.findDocName(demail);
		List<AppointmentData> data = customerRepoforAppointment.findByDname(dname);
		return data;
    }

	@Override
	public List<Doctor> listOfDocters() {
		List<Doctor> doctors = doctorRepo.findAll();
		return doctors;
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

	@Override
	public String approveAppointment(String appointmentId) {
		System.out.println("IDoctorServiceImpl.approveAppointment()");
		
		int recordNo = appointmentStatusRepo.findRecordNo(appointmentId);
		appointmentStatusRepo.updateAppointment(recordNo, "Visit clinic on date", "Approved");
		return "approved";
		
	
	}
}
