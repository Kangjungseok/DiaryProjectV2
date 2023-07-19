package sqlTest;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

public class DatabaseMetaDataEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ConnectionEx cex = new ConnectionEx();
		Connection conn =  cex.getConnection();
		
		try {
			DatabaseMetaData dbmd =  conn.getMetaData();
			
			System.out.println(dbmd.getMaxColumnsInIndex());
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		cex.closeConnection(conn);
		
	}

}
