package in.ineuron.dao;

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
	
	String query = "UPDATE appointment_status SET message = visit hospital on date, status = approved WHERE (totalrecords = :n)";
	
	@Query("SELECT recordNo from AppointmentStatus where appointmentid = :n")
	public int findRecordNo(@Param ("n") String appointid);
	
	@Modifying
	@Query("UPDATE AppointmentStatus a SET a.message = :m, status = :s WHERE (totalrecords = :n)")
	public void updateAppointment(@Param("n") int recordNo, @Param("m") String message, @Param("s") String status);
}
