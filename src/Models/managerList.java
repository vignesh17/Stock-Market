package Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Servlets.managerList1;

public class managerList {
    
    public static ArrayList<managerList1> managerDetailsFetch() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {

            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn = DBConn.getConn();
            String sql = "select * from manager ";
            PreparedStatement statment = conn.prepareStatement(sql);
    //      statment.setString(1, username);
    //      login login1 = new login();
            ResultSet  rs =  statment.executeQuery();
            ArrayList<managerList1> list=new ArrayList();
            while (rs.next()) {
                managerList1 login = new managerList1();
                login.setFirstname(rs.getString("firstname"));
                login.setLastname(rs.getString("lastname"));
                login.setAddress(rs.getString("address"));
                login.setEmail(rs.getString("email"));
                list.add(login);
            }
            return list;

    }
}
