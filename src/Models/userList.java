package Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.context.FacesContext;

import Servlets.userList1;

public class userList {
	
	public static ArrayList<userList1> userDetailsFetch() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {

			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection conn = DBConn.getConn();
			String user = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("username");
			PreparedStatement statement1 = conn.prepareStatement("select mid from manager where username = ?");
	    	statement1.setString(1, user);
	    	ResultSet rs = statement1.executeQuery(); 
	    	int mid = 0;
	    	while(rs.next()) {
	        	mid = rs.getInt("mid");
	        }
	    	PreparedStatement statement2 = conn.prepareStatement("select * from user where mid = ?");
	    	statement2.setInt(1, mid);
	//		statment.setString(1, username);
	//		login login1 = new login();
			ResultSet  rs1 =  statement2.executeQuery();
			ArrayList<userList1> list=new ArrayList();
			while (rs1.next()) {
				userList1 login = new userList1();
				login.setFirstname(rs1.getString("firstname"));
				login.setLastname(rs1.getString("lastname"));
				login.setAddress(rs1.getString("address"));
				login.setEmail(rs1.getString("email"));
				list.add(login);
			}
			return list;

	}
}
