package in.ineuron.dao;

import java.sql.Date;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import in.ineuron.model.AppointmentStatus;

@Repository(value="appointmentStatus")
@Transactional 
public interface IAppointmentRepo extends JpaRepository<AppointmentStatus, String>{
	
	@Query("SELECT recordNo from AppointmentStatus where appointmentid = :n")
	public int findRecordNo(@Param ("n") String appointid);
	
	@Modifying
	@Query("UPDATE AppointmentStatus a SET a.message = :m, status = :s WHERE (totalrecords = :n)")
	public void updateAppointment(@Param("n") int recordNo, @Param("m") String message, @Param("s") String status);


	@Modifying
	@Query("UPDATE AppointmentStatus a SET a.message = :m, status = :s WHERE (totalrecords = :n)")
	public void completeAppointment(@Param("n") int recordNo, @Param("m") String message, @Param("s") String status);
	
	@Query(value="SELECT COUNT(*) FROM Appointmentdata a join Appointment_status s WHERE a.appointid = s.appointmentid AND status=:s AND dname=:e AND adate=:d", nativeQuery = true)
	public int getAppointmentApprovedCount(@Param("e")String demail, @Param ("d") Date date, @Param ("s") String status);
	
	@Query(value = "SELECT adate FROM Appointmentdata WHERE appointid=:a", nativeQuery = true)
	public Date getAppointmentDate(@Param ("a") String aId);
}
