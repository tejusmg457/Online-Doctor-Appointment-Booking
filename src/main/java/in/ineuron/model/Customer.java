package in.ineuron.model;

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
    private String cid;
    private String cname;
    private int cage;
    private String cgender;
    private long cphoneNo;
    private String cemail;
    private String cpassword;
    
}
