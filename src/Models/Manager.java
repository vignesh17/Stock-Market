package Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.context.FacesContext;

import DAO.ManagerDAO;

public class Manager {

	public static int registerUser(String firstname, String lastname, String address, int phonenumber, String email,
			String username, String password, Double availableBalance) {
		int i = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection conn = DBConn.getConn();
			String sql = "insert into user(FirstName,LastName,Address,PhoneNumber,Email,UserName,Password, availableBalance) values (?,?,?,?,?,?,?,?); SELECT LAST_INSERT_ID();";
			PreparedStatement statment = conn.prepareStatement(sql);
			statment.setString(1, firstname);
			statment.setString(2, lastname);
			statment.setString(3, address);
			statment.setLong(4, phonenumber);
			statment.setString(5, email);
			statment.setString(6, username);
			statment.setString(7, password);
			statment.setString(8, "1000000");

			boolean result = statment.execute();

			while (result || statment.getUpdateCount() != -1) {
				if (result) {
					ResultSet result_statement = statment.getResultSet();
					while (result_statement.next()) {
						i = result_statement.getInt(1);
					}
				} else {
					if (statment.getUpdateCount() == -1)
						break;

				}
				result = statment.getMoreResults();
			}
			conn.close();
		} catch (Exception exp) {
			System.out.println(exp.getMessage());
		}
		return i;
	}

	public static int registerManager(String firstname, String lastname, String address, int phonenumber, String email,
			String username, String password, String status) {
		int i = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection conn = DBConn.getConn();
			String sql = "insert into manager(FirstName,LastName,Address,PhoneNumber,email,UserName,Password,status) values (?,?,?,?,?,?,?,?); SELECT LAST_INSERT_ID();";
			PreparedStatement statment = conn.prepareStatement(sql);
			statment.setString(1, firstname);
			statment.setString(2, lastname);
			statment.setString(3, address);
			statment.setLong(4, phonenumber);
			statment.setString(5, email);
			statment.setString(6, username);
			statment.setString(7, password);
			statment.setString(8, "NA");

			boolean result = statment.execute();

			while (result || statment.getUpdateCount() != -1) {
				if (result) {
					ResultSet result_statement = statment.getResultSet();
					while (result_statement.next()) {
						i = result_statement.getInt(1);
					}
				} else {
					if (statment.getUpdateCount() == -1)
						break;

				}
				result = statment.getMoreResults();
			}
			conn.close();
		} catch (Exception exp) {
			System.out.println(exp.getMessage());
		}
		return i;
	}

	public static boolean loginUser(String userName, String password) throws SQLException {
		boolean valid = false;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection conn = DBConn.getConn();
			System.out.println("userName " + userName);
			System.out.println("password " + password);
			String sql = "select case when exists (select * from user where username = ? and password = ?) then true else false end as valid";
			PreparedStatement statment = conn.prepareStatement(sql);
			statment.setString(1, userName);
			statment.setString(2, password);

			boolean result = statment.execute();

			

			while (result || statment.getUpdateCount() != -1) {
				if (result) {
					ResultSet result_statement = statment.getResultSet();
					while (result_statement.next()) {
						valid = result_statement.getBoolean(1);
					}
				} else {
					if (statment.getUpdateCount() == -1)
						break;

				}
				result = statment.getMoreResults();
			}
			conn.close();
		} catch (Exception exp) {
			System.out.println(exp.getMessage());
		}

		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("username", userName);
//		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("uid", uid);
	//	System.out.println();FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("username");
		// System.out.println((String)
		// FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("username"));
		System.out.println(valid);
		return valid;
	}

	public static boolean loginManager(String userName, String password) throws SQLException {
		boolean valid = false;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection conn = DBConn.getConn();
			System.out.println("userName " + userName);
			System.out.println("password " + password);
			String sql = "select case when exists (select * from manager where username = ? and password = ? and status = 'yes') then true else false end as valid";
			PreparedStatement statment = conn.prepareStatement(sql);
			statment.setString(1, userName);
			statment.setString(2, password);

			boolean result = statment.execute();

			System.out.println(valid);

			while (result || statment.getUpdateCount() != -1) {
				if (result) {
					ResultSet result_statement = statment.getResultSet();
					while (result_statement.next()) {
						valid = result_statement.getBoolean(1);
					}
				} else {
					if (statment.getUpdateCount() == -1)
						break;

				}
				result = statment.getMoreResults();
			}
			conn.close();
		} catch (Exception exp) {
			System.out.println(exp.getMessage());
		}
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("username", userName);
		return valid;
	}

	

	public static ArrayList<ManagerDAO> getManagerList() {
		ArrayList<ManagerDAO> manager_list = new ArrayList<ManagerDAO>();
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection conn = DBConn.getConn();
			String sql = "select * from manager;";
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet rs = statement.getResultSet();

			while (rs.next()) {
				ManagerDAO mgr = new ManagerDAO();
				mgr.setID(rs.getInt(0));
				mgr.setFirstName(rs.getString(1));
				mgr.setLastName(rs.getString(2));
				mgr.setAddress(rs.getString(3));
				mgr.setPhoneNumber(rs.getInt(4));
				mgr.setEmailid(rs.getString(5));
				mgr.setUserName(rs.getString(6));
				mgr.setPassword(rs.getString(7));
				mgr.setStatus(rs.getString(8));

				manager_list.add(mgr);
			}

			conn.close();
		} catch (Exception exp) {
			System.out.println(exp.getMessage());
		}
		return manager_list;
	}
}
