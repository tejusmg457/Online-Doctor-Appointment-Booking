package in.ineuron.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.ineuron.model.AppointmentData;

@Repository(value="customerRepoforAppointment")
public interface ICustomerRepoForAppointment extends JpaRepository<AppointmentData, String>{
    
}
