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
		String records = null;
		String temp = null;
		int num = 0;
		
		Connection connection = null; 
		Statement statement = null;
		ResultSet rs = null;
		try {
			connection = session.connection();
			statement = connection.createStatement();
			rs = statement.executeQuery("select max(cid) from customer");
			while(rs.next()) {
				records = rs.getString(1);
				for(int i=3; i<records.length(); i++) {
					  char a = records.charAt(i);
					  if(temp==null)
						  temp =  "0"+a;
					  else
						  temp = temp+a;
				}
				num = Integer.parseInt(temp);
				num++;
				id = "CUS"+num;
				System.out.println("id is "+ id);
				return id;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(NullPointerException e) {
			return "CUS1";
		}
		return null;
	}
}
