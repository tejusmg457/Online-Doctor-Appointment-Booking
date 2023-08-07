package in.ineuron.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

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
	@GenericGenerator(name = "gen1", strategy = "identity")
	@GeneratedValue(generator = "gen1")
	@Column(name="totalrecords")
	private int recordNo;
	
	@Column(name="status")
	private String status;
	
	@Column(name="message",length=1000)
	private String message;
	
	@OneToOne
	@JoinColumn(name="appointmentid")
	private AppointmentData appointmentData;

}
