package connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Connector {
	private static String dbdriver = "com.mysql.jdbc.Driver";
	private static String dburl = "jdbc:mysql://127.0.0.1:3306/Pharmacy?useUnicode=true&characterEncoding=gbk&useSSL=false";
	private static String username = "root";
	private static String userpassword = "123456";
	public static Connection conn = null;
	
	public static Connection getConnection() {
		try {
			Class.forName(dbdriver);
			conn = DriverManager.getConnection(dburl, username, userpassword);
			
			System.out.println("Successfully get the connection!");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) {
		if(rs != null) {
			try {
				rs.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		if(ps != null) {
			try {
				ps.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		if(conn == null)
			return;
		try {
			conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
