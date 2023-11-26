package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MyConnectDB {
	public static String sqlDB;
		
		public MyConnectDB() {
			super();
			
			
		}
		
		public static  Connection connect() throws Exception{
			
			Connection connection = null;
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				connection=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;encrypt=true;trustServerCertificate=true;databaseName=TestDB;user=sa;password=27092003");
				System.out.println("Connect success");
			} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}
			return connection;
			
		}
		public  void thucThiSQL(String sql) throws Exception{
			Connection connect =connect();
			Statement stmt = connect.createStatement();
			stmt.executeUpdate(sql);
		}
		public ResultSet chonDuLieu(String sql) throws Exception{
			Connection connect =connect();
			Statement stmt = connect.createStatement();
			ResultSet rs=	stmt.executeQuery(sql);
			return rs;
		}
		
	
		public PreparedStatement dungStament(String sql) throws SQLException, Exception{
			return connect().prepareStatement(sql);
		}
		
	public static void main(String[] args) throws Exception {
		System.out.println(new MyConnectDB().connect());
	}
}
