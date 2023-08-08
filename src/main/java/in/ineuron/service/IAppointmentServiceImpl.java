package in.ineuron.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.dao.ICustomerRepoForAppointment;
import in.ineuron.model.AppointmentData;

@Service(value="appointmentRepo")
public class IAppointmentServiceImpl implements IAppointmentService {
	 
	@Autowired
	private ICustomerRepoForAppointment customerRepoforAppointment;
	
	@Override
	public Optional<AppointmentData> getAppointmentStatusById(String appointid) {
		Optional<AppointmentData> appointmentData = customerRepoforAppointment.findById(appointid);
		return appointmentData;
	}

}
