package in.ineuron.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import in.ineuron.model.AppointmentData;
import in.ineuron.model.Docter;

@Repository(value="doctorRepo")
public interface IDoctorRepo extends JpaRepository<Docter, String> {
    
	@Query("select count(*) from AppointmentData where dname =:n")
	public List<AppointmentData> listOfPendingAppointments(@Param ("n") String did);
	
	@Query("SELECT COUNT(did) FROM Docter")
	public int noOfDocters();
}
