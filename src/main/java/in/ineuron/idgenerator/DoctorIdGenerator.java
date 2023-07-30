package in.ineuron.idgenerator;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class DoctorIdGenerator implements IdentifierGenerator {
	
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		String id = null;
		int records = 0;
		Connection connection2 = null; 
		Statement statement2 = null;
		ResultSet rs2 = null;
		try {
			connection2 = session.connection();
			statement2 = connection2.createStatement();
			rs2 = statement2.executeQuery("SELECT COUNT(did) FROM Docter");
			while(rs2.next()) {
				records = rs2.getInt(1);
				records++;
				id = "DOC"+records;
				System.out.println("id is "+ id);
				return id;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
