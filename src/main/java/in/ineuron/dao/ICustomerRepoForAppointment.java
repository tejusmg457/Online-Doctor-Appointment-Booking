package in.ineuron.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.ineuron.model.AppointmentData;

@Repository(value="customerRepoforAppointment")
public interface ICustomerRepoForAppointment extends JpaRepository<AppointmentData, String>{

	public List<AppointmentData> findByDname(String dname);

}