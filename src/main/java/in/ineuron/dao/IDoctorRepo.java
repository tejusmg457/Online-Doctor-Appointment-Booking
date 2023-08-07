package in.ineuron.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import in.ineuron.model.Doctor;

@Repository(value="doctorRepo")
public interface IDoctorRepo extends JpaRepository<Doctor, String> {
    
	
	@Query("SELECT COUNT(did) FROM Doctor")
	public int noOfDocters();
	
	@Query("SELECT dpassword FROM Doctor where demail=:n")
	public String loginDoctor(@Param("n") String demail);
	
	@Query("SELECT dname FROM Doctor where demail=:n")
	public String findDocName(@Param("n") String demail);
}
