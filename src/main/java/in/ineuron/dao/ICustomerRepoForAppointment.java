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

	@Query(value="SELECT count(*) FROM Appointmentdata a join appointment_status s where a.appointid = s.appointmentid  AND a.adate=:d AND s.status=:s", nativeQuery = true)
	public int noOfAppointmentsForToday(@Param ("d") Date tdate, @Param ("s") String status);
	
	@Query(value="SELECT * from Appointmentdata where adate between :f and :t", nativeQuery = true)
	public List<AppointmentData> findAppointments(@Param ("f") Date fdate, @Param ("t") Date tdate);
	
	@Query(value = "SELECT * FROM Appointmentdata a join appointment_status s where a.appointid = s.appointmentid AND a.appointid= :n", nativeQuery = true)
	public AppointmentData getAppointmentStatusById(@Param ("n")String appointid);
	
	@Query(value = "SELECT * FROM Appointmentdata a join appointment_status s where a.appointid = s.appointmentid AND a.dname= :n AND a.adate=:d AND s.status=:s", nativeQuery = true)
	public List<AppointmentData> todayAppointmentListToDoc(@Param ("n")String dname,@Param ("d") Date todayDate, @Param ("s") String status);

	@Query(value = "SELECT * FROM Appointmentdata a join appointment_status s where a.appointid = s.appointmentid AND a.dname= :d", nativeQuery = true)
	public List<AppointmentData> appointmentHistory(@Param ("d") String dname);

	@Query(value="SELECT COUNT(*) FROM Appointmentdata where dname=:n AND dspecialist=:s AND adate=:d", nativeQuery=true)
	public int checkSlot(@Param ("n") String dname,@Param ("s") String dspecialist,@Param ("d") Date sdate);


}