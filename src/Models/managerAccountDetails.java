package Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.context.FacesContext;

import Servlets.managerAccountDetails1;

public class managerAccountDetails {

    public static ArrayList<managerAccountDetails1> userDetailsFetch()
            throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver").newInstance();
        Connection conn = DBConn.getConn();
        String user = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("username");
        String sql = "select * from manager where username = ?";
        PreparedStatement statment = conn.prepareStatement(sql);
        statment.setString(1, user);
        ResultSet rs = statment.executeQuery();
        ArrayList<managerAccountDetails1> list = new ArrayList();
        while (rs.next()) {
            managerAccountDetails1 login = new managerAccountDetails1();
            login.setUid(rs.getInt("mid"));
            login.setFirstname(rs.getString("firstname"));
            login.setLastname(rs.getString("lastname"));
            login.setAddress(rs.getString("address"));
            login.setPhonenumber(rs.getInt("phonenumber"));
            login.setEmail(rs.getString("email"));
            login.setUsername(rs.getString("username"));
//            login.setPassword(rs.getString("password"));
            login.setPassword(rs.getString("commission"));
            list.add(login);
        }
        return list;

    }
}
