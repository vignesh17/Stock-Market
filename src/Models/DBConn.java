package Models;

import java.sql.Connection;

public class DBConn {
	public static Connection getConn() {
		try {
			com.mysql.jdbc.jdbc2.optional.MysqlDataSource ds = new com.mysql.jdbc.jdbc2.optional.MysqlDataSource();
			ds.setServerName(System.getenv("ICSI518_SERVER"));
			ds.setPortNumber(Integer.parseInt(System.getenv("ICSI518_PORT")));
			ds.setDatabaseName(System.getenv("ICSI518_DB"));
			ds.setUser(System.getenv("ICSI518_USER"));
			ds.setPassword(System.getenv("ICSI518_PASSWORD"));
			ds.setAllowMultiQueries(true);
			Connection conn = ds.getConnection();
			return conn;
		} catch (Exception exp) {
			System.out.println(exp.getMessage());
			return null;

		}
	}
	
	public static void close(Connection con) {
        try {
            con.close();
        } catch (Exception ex) {
        }
    }
}
