package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import dto.DTO;

public class DAO {

	private String url = "jdbc:mariadb://localhost:3306/diaryEx";
	private String user = "jskang";
	private String pass = "rkdwjdtjr1";

	private static DAO instance;

	private DAO() {
	}

	public static DAO getinstance() {
		if (instance == null) {
			instance = new DAO();
		}

		return instance;
	}

	private Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, pass);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}

	private void closeConnection(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public ResultSetMetaData getResultSetMetaData(String DB) {
		Connection conn = getConnection();
		String sql = "SELECT * FROM "+ DB ;
		Statement stmt = null;
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			rsmd = rs.getMetaData();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rsmd;
	}
	
	

	// Create Read Update Delete

	public int create(DTO dto, String DB) throws SQLException {
		int result = 0;

		Connection conn = getConnection();
		//String sql = "INSERT INTO ? VALUES (?)";
		//PreparedStatement pstmt = conn.prepareStatement(sql);

		//pstmt.setString(1, DB);
		//pstmt.setString(2, dto.getAllValues());
		//result = pstmt.executeUpdate();
		//pstmt.close();
		conn.close();

		return result;
	}
	

	public DTO read(DTO dto, String dataToRead, String DB) {
		Connection conn = getConnection();
		String sql = "Select "+ dataToRead +" from "+ DB;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dto;
	}

	public void read(DTO dto, String dataToRead, String DB, String condition) {

		Connection conn = getConnection();
		String sql = "Select ? from ? where ?";
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dataToRead);
			pstmt.setString(2, DB);
			pstmt.setString(3, condition);
			rs = pstmt.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void readAll(DTO dto, String DB) {
		Connection conn = getConnection();
		String sql = "Select * from "+ DB;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void update() {
		
	}
	

}
