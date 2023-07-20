package dao;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Vector;

import dto.DTO;
import dto.DiaryDTO;

public class DAO {

	private String url = "jdbc:mariadb://localhost:3306/diaryEx2";
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
	
	public ResultSetMetaData getResultSetMetaData(String tableName) {
		Connection conn = getConnection();
		String sql = "SELECT * FROM "+ tableName ;
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
		closeConnection(conn);
		return rsmd;
	}
	
	

	// Create Read Update Delete

	public int insert(DTO dto, String tableName) throws SQLException {
		int result = 0;

		Connection conn = getConnection();
		String sql = "INSERT INTO " + tableName+" VALUES ("+ dto.getAllValues() +")" ;
		Statement stmt = conn.createStatement();

		result = stmt.executeUpdate(sql);
		stmt.close();
		conn.close();

		return result;
	}
	
	/*
	public DTO read(DTO dto, String dataToRead, String tableName) {
		Connection conn = getConnection();
		String sql = "Select "+ dataToRead +" from "+ tableName;
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

	public void read(DTO dto, String dataToRead, String tableName, String condition) {

		Connection conn = getConnection();
		String sql = "Select ? from ? where ?";
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dataToRead);
			pstmt.setString(2, tableName);
			pstmt.setString(3, condition);
			rs = pstmt.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	*/
	public ResultSet readAll(String tableName) {
		Connection conn = getConnection();
		String sql = "Select * from "+ tableName;
		ResultSet rs = null;
		try {
			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeConnection(conn);
		return rs;
	}
	
	public int update(DTO dto, String tableName,String condition) {
		int result = 0 ;
		Connection conn = getConnection();
		String updateSql = dto.updateSql();
		//condition = dto.searchByPk();
		String sql = "UPDATE " + tableName + " SET " + updateSql + " WHERE " + condition ;
		try {
			Statement stmt = conn.createStatement();
			result = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeConnection(conn);
		return result;
	}
	
	public int delete(DTO dto, String tableName, String condition) {
		int result = 0;
		Connection conn = getConnection();
		String sql = "DELETE FROM " + tableName + " WHERE " + condition;
		try {
			Statement stmt = conn.createStatement();
			result = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeConnection(conn);
		return result;
	}
	
	public static void main(String[] args) {
		
		DAO dao = DAO.getinstance();
		String tableName = "daodto";
		String spaceCode = "jsTest";
		int taskIndex = 41;
		
		DiaryDTO dto = new DiaryDTO(spaceCode, taskIndex);
		//dto.setDDay(Date.valueOf(LocalDate.now()));
		//dto.setTask("두 번째 insert");
		//dto.setEmail("wjwj@nav.com");
		//dto.setManager("정석");
		
		
		/*
		for(int i = 21 ; i<40 ; i++ ) {
			taskIndex = i;
			DiaryDTO dto2 = new DiaryDTO(spaceCode, taskIndex);
			dto2.setDDay(Date.valueOf(LocalDate.now().plusDays(i)));
			dto2.setTask( i+"번째 insert");
			dto2.setEmail("wjwj" + i + "@nav.com");
			dto2.setManager("정석"+i);
			try {
				dao.insert(dto2, tableName);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		*/
		
		
		
		
		
		
		//UPDATE ㄱㄱ
		//System.out.println(dao.update(dto, tableName, dto.searchByPk()));
		
		//DELETE ㄱㄱ
		//dao.delete(dto, tableName, dto.searchByPk());
		
		//SELECT ㄱㄱ
		
		
		ResultSet rs = dao.readAll(tableName);
		Vector<DiaryDTO> datas = new Vector<>();
		try {
			ResultSetMetaData rsmd = rs.getMetaData();
			System.out.println(rsmd.getColumnCount());
			for(int i = 1 ; i<=rsmd.getColumnCount(); i++) {
				System.out.print(rsmd.getColumnName(i));
				System.out.println(" " + rsmd.getColumnTypeName(i));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		/*
		try {
			
			while(rs.next()) {
				spaceCode = rs.getString("spaceCode");
				taskIndex = rs.getInt("taskIndex");
				dto = new DiaryDTO(spaceCode, taskIndex);
				dto.setEmail(rs.getString("email"));
				dto.setSpaceCode(rs.getString("spaceCode"));
				dto.setTaskIndex(rs.getInt("taskIndex"));
				dto.setTask(rs.getString("task"));
				dto.setManager(rs.getString("manager"));
				dto.setDDay(rs.getDate("dDay"));
				
				datas.add(dto);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		*/
	}
	
	

}
