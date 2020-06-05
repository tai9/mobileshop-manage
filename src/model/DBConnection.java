package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnection {
		public static final String url = "jdbc:sqlserver://localhost;databaseName=MobileShopManagementttt;user=sa;password=123";
		Connection con = null;

		public Connection getConnection() throws ClassNotFoundException {
			if (con == null) {
				try {
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					con = DriverManager.getConnection(url);
					System.out.println("Successful.");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return con;
		}
		
		public void closeConnection() {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		public static void main(String[] args) throws SQLException, ClassNotFoundException {
			DBConnection db = new DBConnection();
			
			db.getConnection();
		}
}
