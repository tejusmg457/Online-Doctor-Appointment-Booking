package in.ineuron.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.dao.IAppointmentRepo;
import in.ineuron.dao.ICustomerRepoForAppointment;
import in.ineuron.dao.IDoctorRepo;
import in.ineuron.model.AppointmentData;
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
    	List<AppointmentData> data =  customerRepoforAppointment.findPendingAppointments(dname, "Pending");
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
		
		int recordNo = appointmentStatusRepo.findRecordNo(appointmentId);
		appointmentStatusRepo.updateAppointment(recordNo, "Visit clinic on date", "Approved");
		return "approved";
	}

	@Override
	public int noOfAppointmentsForToday() {
		Date Todaydate = Date.valueOf(LocalDate.now());
		int noOfAppointmentsToday = customerRepoforAppointment.noOfAppointmentsForToday(Todaydate, "Approved");
		return noOfAppointmentsToday;
	}

	@Override
	public int noOfDoctors() {
		int noOfDoctors = doctorRepo.noOfDocters();
		return noOfDoctors;
	}

	@Override
	public List<AppointmentData> findAppointments(Date fdate, Date tdate) {
		System.out.println("IDoctorServiceImpl.findAppointments()");
		List<AppointmentData> appointments = customerRepoforAppointment.findAppointments(fdate, tdate);
		return appointments;
	}

	@Override
	public String completeAppointment(String appointid) {
		int recordNo = appointmentStatusRepo.findRecordNo(appointid);
		appointmentStatusRepo.completeAppointment(recordNo, "Staysafe-Stayhealthy", "Completed");
		return "completed";
	}

	@Override
	public List<AppointmentData> todayAppointmentList(String demail) {
		Date Todaydate = Date.valueOf(LocalDate.now());
		String dname = doctorRepo.findDocName(demail);
		List<AppointmentData> data = customerRepoforAppointment.todayAppointmentListToDoc(dname, Todaydate, "Approved");
		return data;
	}

	@Override
	public List<AppointmentData> appointmentHistory(String demail) {
		String dname = doctorRepo.findDocName(demail);
		List<AppointmentData> appointmentHistory = customerRepoforAppointment.appointmentHistory(dname);
		return appointmentHistory;
	}

	@Override
	public String[] verifyDocSpecialist(String dname) {
		String[] dspecialist = doctorRepo.findDocSpecialist(dname); 
		return dspecialist;
	}

	@Override
	public String getPassword(String did, String demail) {
		return doctorRepo.getPassword(did, demail);
	}
}
