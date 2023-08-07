package in.ineuron.model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
@Table(name="Appointmentdata")
public class AppointmentData {

    @Id
    @GenericGenerator(name="appgen", strategy = "in.ineuron.idgenerator.AppointmentIdGenerator")
    @GeneratedValue(generator = "appgen")
    @Column(name="appointid")
    private String appointid;
    
    @Column(name="pname")
    private String pname;
    
    @Column(name="page")
    private int page;
    
    @Column(name="adate")
	private Date adate;
    
    @Column(name="psymptoms")
    private String psymptoms;
    
    @Column(name="dname")
    private String dname;
    
    @Column(name="dspecialist")
    private String dspecialist;
    
    @OneToOne(mappedBy = "appointmentData", cascade = CascadeType.ALL)
    private AppointmentStatus appointmentStatus;
    
}
