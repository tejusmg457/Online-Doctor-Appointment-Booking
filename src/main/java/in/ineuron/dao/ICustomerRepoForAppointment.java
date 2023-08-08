package in.ineuron.dao;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import in.ineuron.model.AppointmentData;

@Repository(value="customerRepoforAppointment")
public interface ICustomerRepoForAppointment extends JpaRepository<AppointmentData, String>{

	@Query(value = "SELECT appointid, pname, page, adate, psymptoms, dname, dspecialist FROM Appointmentdata a join appointment_status s where a.appointid = s.appointmentid and a.dname= :d and s.status= :s", nativeQuery = true)
	public List<AppointmentData> findPendingAppointments(@Param ("d") String dname,@Param ("s") String Status);

	@Query("SELECT COUNT(adate) from AppointmentData where adate = :n")
	public int noOfAppointmentsForToday(@Param ("n") Date tdate);
	
	@Query(value="SELECT * from Appointmentdata where adate between :f and :t", nativeQuery = true)
	public List<AppointmentData> findAppointments(@Param ("f") Date fdate, @Param ("t") Date tdate);
	
	@Query(value = "SELECT * FROM Appointmentdata a join appointment_status s where a.appointid = s.appointmentid AND a.appointid= :n", nativeQuery = true)
	public AppointmentData getAppointmentStatusById(@Param ("n")String appointid);
	
	@Query(value = "SELECT * FROM Appointmentdata a join appointment_status s where a.appointid = s.appointmentid AND a.dname= :n AND a.adate=:d AND s.status=:s", nativeQuery = true)
	public List<AppointmentData> todayAppointmentListToDoc(@Param ("n")String dname,@Param ("d") Date todayDate, @Param ("s") String status);
}