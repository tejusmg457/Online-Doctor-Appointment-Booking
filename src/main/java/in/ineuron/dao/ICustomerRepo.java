package in.ineuron.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import in.ineuron.model.Customer;

@Repository(value="customerRepo")
public interface ICustomerRepo extends JpaRepository<Customer, String>{
	
	@Query("SELECT COUNT(cid) FROM Customer")
	public int noOfCustomers();
	
	@Query("SELECT cpassword FROM Customer where cemail=:n")
	public String loginCustomer(@Param("n") String cemail);

}
