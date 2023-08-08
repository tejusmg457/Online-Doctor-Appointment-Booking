package in.ineuron.service;

import java.util.Optional;

import in.ineuron.model.AppointmentData;

public interface IAppointmentService {
	
	public Optional<AppointmentData> getAppointmentStatusById(String appointid);
	

}
