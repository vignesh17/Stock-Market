package Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class sellStock {
	
	
	public void updateStock(String username, String stock_symbol, Double price, int quantity) throws SQLException {

	Connection conn = DBConn.getConn();
	PreparedStatement ps;
	
	
	String sql="uupdate purchase set qty=qty-?,amt=amt-? where username=? and stock_symbol ";
	 ps = conn.prepareStatement(sql);
	ps.setInt(1, quantity);
	ps.setDouble(2, price);
	ps.setString(3, username);
	ps.setString(4, stock_symbol);
	
	}
}