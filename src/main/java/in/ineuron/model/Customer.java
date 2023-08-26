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
@Table(name="Customer")
public class Customer {
	
	@Id
    @GenericGenerator(name="mygen", strategy = "in.ineuron.idgenerator.CustomerIdGenerator")
    @GeneratedValue(generator = "mygen")
    @Column(name="cid")
    private String cid;
    
    @Column(name="cname")
    private String cname;
    
    @Column(name="cage")
    private int cage;
    
    @Column(name="cgender")
    private String cgender;
    
    @Column(name="cphoneNo", unique=true)
    private long cphoneNo;
    
    @Column(name="cemail", unique = true)
    private String cemail;
    
    @Column(name="cpassword")
    private String cpassword;
    
}
