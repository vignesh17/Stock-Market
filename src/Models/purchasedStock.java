package Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.context.FacesContext;

import Servlets.purchasedStock1;

public class purchasedStock {

    public static ArrayList<purchasedStock1> userDetailsFetch()
            throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver").newInstance();
        Connection conn = DBConn.getConn();
        String user = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("username");
        String sql = "select * from purchase where username = ?";
        PreparedStatement statment = conn.prepareStatement(sql);
        statment.setString(1, user);
        ResultSet rs = statment.executeQuery();
        ArrayList<purchasedStock1> list = new ArrayList();
        while (rs.next()) {
            purchasedStock1 login = new purchasedStock1();
            login.setId(rs.getInt("id"));
            login.setUsername(rs.getString("username"));
            login.setStock_symbol(rs.getString("stock_symbol"));
            login.setQty(rs.getInt("qty"));
            login.setPrice(rs.getDouble("price"));
            login.setAmt(rs.getDouble("amt"));
            list.add(login);
        }
        return list;

    }
}
