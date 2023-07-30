package in.ineuron.idgenerator;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class CustomerIdGenerator implements IdentifierGenerator {
	
	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		String id = null;
		int records = 0;
		Connection connection = null; 
		Statement statement = null;
		ResultSet rs = null;
		try {
			connection = session.connection();
			statement = connection.createStatement();
			rs = statement.executeQuery("SELECT COUNT(cid) FROM Customer");
			while(rs.next()) {
				records = rs.getInt(1);
				records++;
				id = "CUS"+records;
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
