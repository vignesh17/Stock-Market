package Models;
//https://docs.oracle.com/javase/tutorial/jdbc/basics/retrieving.html
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.faces.context.FacesContext;

import Servlets.login;

public class Update {
	
	public static login userDetailsFetch(String username) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		int i = 0;
			System.out.println("Update");
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection conn = DBConn.getConn();
			String sql = "select * from user where username='" +username +"'";
			PreparedStatement statment = conn.prepareStatement(sql);
			login login1 = new login();
			ResultSet  rs =  statment.executeQuery(sql);
			while (rs.next()) {
				login1.setUid(rs.getString("uid"));
				System.out.println(login1.getUid()+"UID");
				login1.setFirstname(rs.getString("firstname"));
				login1.setLastname(rs.getString("lastname"));
				login1.setAddress(rs.getString("address"));
				login1.setPhonenumber(rs.getInt("phonenumber"));
				login1.setEmail(rs.getString("email"));
				login1.setPassword(rs.getString("password"));
				
			}
			return login1;
	}
	
	public static int updateUser(String firstName, String lastName, String address, int phoneNumber, String emailid,String password) {
		int i = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection conn = DBConn.getConn();
			@SuppressWarnings("unused")
			String user = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
					.get("username");
			String sql = "update user set FirstName = ? ,LastName = ? ,Address = ? ,PhoneNumber = ? ,email = ? ,Password = ?  where username = ? ";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, firstName);
			statement.setString(2, lastName);
			statement.setString(3, address);
			statement.setLong(4, phoneNumber);
			statement.setString(5, emailid);
//			statement.setString(6, userName);
			statement.setString(6, password);
			statement.setString(7, user);

			boolean result = statement.execute();

			while (result || statement.getUpdateCount() != -1) {
				if (result) {
					ResultSet result_statement = statement.getResultSet();
					while (result_statement.next()) {
						i = result_statement.getInt(1);
					}
				} else {
					if (statement.getUpdateCount() == -1)
						break;

				}
				result = statement.getMoreResults();
			}
			conn.close();
		} catch (Exception exp) {
			System.out.println(exp.getMessage());
		}
		return i;
	}
	
	
	public static int updateManager(String firstName, String lastName, String address, int phoneNumber, String emailid,
			String password) {
		int i = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection conn = DBConn.getConn();
			@SuppressWarnings("unused")
			String user = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("username");
			System.out.println(user);
			String sql = "update manager set FirstName = ? ,LastName = ? ,Address = ? ,PhoneNumber = ? ,email = ? ,Password = ?  where username = ? ";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, firstName);
			statement.setString(2, lastName);
			statement.setString(3, address);
			statement.setInt(4, phoneNumber);
			statement.setString(5, emailid);
//			statement.setString(6, userName);
			statement.setString(6, password);
			statement.setString(7, user);

			boolean result = statement.execute();
			statement.executeUpdate();

			while (result || statement.getUpdateCount() != -1) {
				if (result) {
					ResultSet result_statement = statement.getResultSet();
					while (result_statement.next()) {
						i = result_statement.getInt(1);
					}
				} else {
					if (statement.getUpdateCount() == -1)
						break;

				}
				result = statement.getMoreResults();
			}
			conn.close();
		} catch (Exception exp) {
			System.out.println(exp.getMessage());
		}
		
//		System.out.println("I am here");
		return i;
	}

}
