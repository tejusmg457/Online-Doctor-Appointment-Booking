package in.ineuron.idgenerator;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class AppointmentIdGenerator implements IdentifierGenerator {
	
	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		String id = null;
		int records = 0;
		Connection connection1 = null; 
		Statement statement1 = null;
		ResultSet rs1 = null;
		try {
			connection1 = session.connection();
			statement1 = connection1.createStatement();
			rs1 = statement1.executeQuery("SELECT COUNT(appointid) FROM Appointmentdata");
			while(rs1.next()) {
				records = rs1.getInt(1);
				records++;
				LocalDate date = LocalDate.now();
				int day = date.getDayOfMonth();
				int month = date.getMonthValue();
				id = "APP"+day+month+records;
				return id;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
