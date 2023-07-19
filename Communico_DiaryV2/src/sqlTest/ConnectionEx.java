package sqlTest;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionEx {

	private String url = "jdbc:mariadb://localhost:3306/diaryEx";
	private String user = "jskang";
	private String pass = "rkdwjdtjr1";
	
	Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, pass);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}
	public void closeConnection(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConnectionEx cex = new ConnectionEx();
		Connection conn =  cex.getConnection();

		try {
			System.out.println(conn.getCatalog());
			 //System.out.println(DatabaseMetaData.getClientInfoProperties); 
			System.out.println(conn.getSchema());
			System.out.println(conn.getClass());
			System.out.println(conn.getHoldability());
			System.out.println(conn.getClientInfo());
			System.out.println(conn.getTypeMap());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cex.closeConnection(conn);

	}

}
