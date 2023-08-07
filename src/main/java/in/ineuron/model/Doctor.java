package in.ineuron.model;

import javax.persistence.Column;
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
@Table(name="Doctor")
public class Doctor {

    @Id
    @GenericGenerator(name="docgen", strategy = "in.ineuron.idgenerator.DoctorIdGenerator")
    @GeneratedValue(generator = "docgen")
    @Column(name="did")
    private String did;
    
    @Column(name="dname")
    private String dname;
    
    @Column(name="dgender")
    private String dgender;
    
    @Column(name="dspecialist")
    private String dspecialist;
    
    @Column(name="dphoneNo")
    private long dphoneNo;
    
    @Column(name="demail")
    private String demail;
    
    @Column(name="dpassword")
    private String dpassword;
    
}
