package in.ineuron.service;

import java.sql.Date;
import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

import in.ineuron.model.AppointmentData;
import in.ineuron.model.Doctor;

public interface IDoctorService {
	
	public String loginDoctor(String docEmail);
    
    public String saveDocter(Doctor doctor);

    public List<AppointmentData> listOfPendingAppointments(String did);
    
    public List<Doctor> listOfDocters();
    
    public String deleteDoctor(String did);
    
    public String approveAppointment(String appointmentId);
    
    public int noOfAppointmentsForToday();
    
    public int noOfDoctors();
    
    public List<AppointmentData> findAppointments(Date fdate, Date tdate);
   
    public String completeAppointment(@RequestParam String appointid);
    
    public List<AppointmentData> todayAppointmentList(String demail);
    
    public Date getAppointmentDate(String aId);
    
    public List<AppointmentData> appointmentHistory(String demail);
    
    public String[] verifyDocSpecialist(String dname);
    
    public String getPassword(String did, String demail);
    
    public String getDoctorName(String demail);
    
    public int getAppointmentApprovedCount(String dname, Date date, String status);

}
