package Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.faces.context.FacesContext;

import Servlets.selectManager1;

public class selectManager {
    
    public static ArrayList<selectManager1> managerDetailsFetch() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {

            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn = DBConn.getConn();
            String sql = "select * from manager where status = 'yes' ";
            PreparedStatement statment = conn.prepareStatement(sql);
    //      statment.setString(1, username);
    //      login login1 = new login();
            ResultSet  rs =  statment.executeQuery(sql);
            ArrayList<selectManager1> list=new ArrayList();
            while (rs.next()) {
                selectManager1 login = new selectManager1();
                login.setFirstname(rs.getString("firstname"));
                login.setLastname(rs.getString("lastname"));
                login.setAddress(rs.getString("address"));
                login.setEmail(rs.getString("email"));
                login.setUsername(rs.getString("username"));
                
                list.add(login);
            }
            return list;

    }
    
    public static String select(String username) throws SQLException {
    	Connection conn = DBConn.getConn();
//		Statement statement = conn.createStatement();
		System.out.println("I am here");
    	String user = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("username");
    	System.out.println(user);
    	System.out.println(username);
    	PreparedStatement statement1 = conn.prepareStatement("select mid from manager where username = ?");
    	statement1.setString(1, username);
    	ResultSet rs = statement1.executeQuery(); 
    	int mid = 0;
    	while(rs.next()) {
        	mid = rs.getInt("mid");
        }
    	System.out.println("yoo");
    	PreparedStatement statment2 = conn.prepareStatement("update user set mid = ? where username = ?");
    	statment2.setInt(1, mid);
    	statment2.setString(2, user);
    	statment2.executeUpdate();
		return null;
    	
    }
    
    
}
