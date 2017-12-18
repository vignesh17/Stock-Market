package Models;

import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Servlets.pendingList1;

public class pendingList {
	
	public static ArrayList<pendingList1> pendingDetailsFetch() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {

			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection conn = DBConn.getConn();
			String sql = "select * from manager where status = 'NA' ";
			PreparedStatement statment = conn.prepareStatement(sql);
	//		statment.setString(1, username);
	//		login login1 = new login();
			ResultSet  rs =  statment.executeQuery(sql);
			ArrayList<pendingList1> list=new ArrayList();
			while (rs.next()) {
				pendingList1 login = new pendingList1();
				login.setFirstname(rs.getString("firstname"));
				login.setLastname(rs.getString("lastname"));
				login.setAddress(rs.getString("address"));
				login.setEmail(rs.getString("email"));
				login.setUsername(rs.getString("username"));
				list.add(login);
			}
			return list;

	}
	
	public static String result(String username, String option) throws SQLException {
		Connection conn = DBConn.getConn();
		PreparedStatement statement1 = conn.prepareStatement("update manager set status = ? where username = ?");
		statement1.setString(1, option);
		statement1.setString(2, username);
		statement1.executeUpdate();
		return null;
	}
	
	public static String result1(String username) throws SQLException{
		Connection conn = DBConn.getConn();
		PreparedStatement statement1 = conn.prepareStatement("update manager set status = 'no' where username = ?");
		statement1.setString(1, username);
		statement1.executeUpdate();
		return null;		
	}
}
