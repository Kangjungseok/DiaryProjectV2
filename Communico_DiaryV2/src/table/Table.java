package table;

import java.awt.EventQueue;
import java.sql.Date;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import dao.DAO;
import dto.DiaryDTO;
import dummy.TransferVal;


public class Table  implements TableModelListener{
	
	JTable table ;
	String tableName = "daodto";
	String spaceCode ;
	String pk;
	
	
	public Table(String spaceCode, String pk) {
		this.spaceCode = spaceCode;
		this.pk = pk;
		AcessDBTableModel adtm = new AcessDBTableModel();
		JTable table2 = new JTable(adtm.getDefaultTableModel()); 
		
		// 테이블에 TableModelListener를 추가합니다.
        table2.getModel().addTableModelListener(this);
		this.table = table2;
		
		
		
	}
	
	public JTable getJTable() {
       return this.table;
    }
	
	@Override
	public void tableChanged(TableModelEvent e) {
		DAO dao = DAO.getinstance();
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		if(e.getType() == TableModelEvent.INSERT) {
			int row = e.getFirstRow();
			int column = e.getColumn();
			
			
			
			//DiaryDTO dto = new DiaryDTO(SPACECODE, TASKINDEX);
			
			//dao.insert(null, TOOL_TIP_TEXT_KEY);
			
		}
		if(e.getType() == TableModelEvent.UPDATE) {
			int row = e.getFirstRow();
			int column = model.findColumn(pk);
			int taskIndex = (int)table.getModel().getValueAt(row, column);

			DiaryDTO dto = new DiaryDTO(spaceCode, taskIndex);
			dto.setEmail((String) model.getValueAt(row, model.findColumn("email")));
			dto.setTask((String) model.getValueAt(row, model.findColumn("task")));
			dto.setManager((String) model.getValueAt(row, model.findColumn("manager")));
			dto.setDDay((Date)model.getValueAt(row, model.findColumn("dDay")));
			dao.update(dto, tableName, dto.searchByPk());
			
		}
		
		if(e.getType() == TableModelEvent.DELETE) {
			
            DiaryDTO dto = new DiaryDTO(spaceCode, TransferVal.pk);
            dao.delete(dto, tableName, dto.searchByPk());
            
		}
		
	}
	

	public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    JFrame frame = new JFrame();
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    JScrollPane sp = new JScrollPane();
                    JTable table = new Table("jsTest","taskIndex").getJTable();
                    sp.setViewportView(table);
                    frame.setBounds(500,300, 700, 500);
                    frame.add(sp);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

	
	
	
	
}
