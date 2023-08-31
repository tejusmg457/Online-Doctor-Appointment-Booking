package in.ineuron.model;

import java.sql.Date;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.SqlResultSetMapping;

import org.hibernate.annotations.NamedNativeQuery;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@NamedNativeQuery(name="myMap" ,query="SELECT t1.appoint_id, t1.pname, t1.page, t1.dname, t1.dspecialist, t1.adate, t2.status from (select appointid as appoint_id, pname as pname, page as page, dname as dname, adate as adate, dspecialist as dspecialist from customer c join appointmentdata d where c.cid=:i AND d.cid=:i) as t1, (SELECT status as status FROM appointment_status where customer_id=:i) as t2")
@SqlResultSetMapping(name ="myMap" , classes = @ConstructorResult(targetClass = AppointmentHistory.class,
	columns = {
		@ColumnResult(name="appoint_id"),
		@ColumnResult(name="pname"),
		@ColumnResult(name="page"),
		@ColumnResult(name="dname"),
		@ColumnResult(name="dspecialist"),
		@ColumnResult(name="adate"),
		@ColumnResult(name="status"),		
}))

public class AppointmentHistory {

	String appoint_id;
	String pname;
	int page;
	String dname;
	String dspecialist;
	Date adate;
	String status;

}
