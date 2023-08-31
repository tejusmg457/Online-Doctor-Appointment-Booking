package in.ineuron.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import in.ineuron.model.Customer;

@Repository(value = "customerRepo")
public interface ICustomerRepo extends JpaRepository<Customer, String> {

	@Query("SELECT COUNT(cid) FROM Customer")
	public int noOfCustomers();

	@Query("SELECT cpassword FROM Customer where cemail=:n")
	public String loginCustomer(@Param("n") String cemail);

	@Query(value = "SELECT distinct dname from Doctor", nativeQuery = true)
	public String[] docNames();

	@Query(value = "SELECT distinct dspecialist from Doctor", nativeQuery = true)
	public String[] docSpecilist();

	@Query(value = "SELECT cpassword FROM Customer where cid=:i AND cemail=:e", nativeQuery = true)
	public String getPassword(@Param("i") String cid, @Param("e") String cemail);

	@Query(value = "SELECT cname FROM Customer where cemail=:e", nativeQuery = true)
	public String getCustomerName(@Param("e") String cemail);

	@Query(value = "SELECT cid FROM Customer where cemail=:e", nativeQuery = true)
	public String getCustomerId(@Param("e") String cemail);
	  
	@Query(value = "SELECT appointid from customer c join appointmentdata d where c.cid=:i AND d.customer_id=:i", nativeQuery = true)
	public List<String> getAppointmentHistory(@Param("i") String customerId);
}
