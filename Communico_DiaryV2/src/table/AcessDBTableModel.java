package table;

import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.DAO;
import dto.DiaryDTO;


public class AcessDBTableModel {

	String tableName = "daodto" ; //  언젠가는 다양한 데이터베이스에 접근하는 테이블 모델의 기틀이 되도록 하렴 
	DefaultTableModel dtm;
	
	
	public AcessDBTableModel() {
	    
		
		Vector<Vector<Object>> data = new Vector<>();
		Vector<String> columnNames = new Vector<>();
		DAO dao = DAO.getinstance();
		
		ResultSet rs = dao.readAll(this.tableName);
		ResultSetMetaData rsmd ;
		try {
			rsmd = rs.getMetaData();
			for(int i = 1 ; i<= rsmd.getColumnCount(); i++) {
				 columnNames.add(rsmd.getColumnName(i));
			}
			while(rs.next()) {
				Vector<Object> row = new Vector<>(); 
				row.add(rs.getString("email"));
				row.add(rs.getString("spaceCode"));
				row.add(rs.getInt("taskIndex"));
				row.add(rs.getString("task"));
				row.add(rs.getString("manager"));
				row.add(rs.getDate("dDay"));
				
				data.add(row);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		//DefaultTableModel dtm2 = new DefaultTableModel(data, columnNames);
		
		DefaultTableModel dtm2 = new DefaultTableModel(data, columnNames) ;
		
		this.dtm = dtm2;

	}
	
	// Getter method to access the DefaultTableModel from other classes
    public DefaultTableModel getDefaultTableModel() {
        return dtm;
    }
	

	
}
