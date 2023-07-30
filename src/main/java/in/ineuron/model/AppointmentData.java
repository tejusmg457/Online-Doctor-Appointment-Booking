package in.ineuron.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="AppointmentData")
public class AppointmentData {

    @Id
    @GenericGenerator(name="appgen", strategy = "in.ineuron.idgenerator.AppointmentIdGenerator")
    @GeneratedValue(generator = "appgen")
    private String appointId;
    private String pname;
    private int page;
    private Date adate;
    private String symptoms;
    private String dname;
    private String dspecialist;
    
}
