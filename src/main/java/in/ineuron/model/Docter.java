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
@Table(name="Docter")
public class Docter {

    @Id
    @GenericGenerator(name="docgen", strategy = "in.ineuron.idgenerator.DocterIdGenerator")
    @GeneratedValue(generator = "docgen")
    private String did;
    private String dname;
    private String dgender;
    private String dspecialist;
    private String demail;
    private String dpassword;
    
}
