package in.ineuron.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="AppointmentStatus")
public class AppointmentStatus {
	
	@Id
	private String status;
	
	@Column(length=1000)
	private String message;
	
	@OneToOne
	private AppointmentData appointmentData;

}
