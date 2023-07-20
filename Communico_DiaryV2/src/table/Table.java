package table;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import dao.DAO;
import dto.DTO;
import dto.DiaryDTO;


public class Table extends JTable implements TableModelListener{
	
	JTable table ;
	
	public Table() {
		// TODO Auto-generated constructor stub
		AcessDBTableModel adtm = new AcessDBTableModel();
		JTable table2 = new JTable(adtm.getDefaultTableModel()); 
		
		// 테이블에 TableModelListener를 추가합니다.
        table2.getModel().addTableModelListener(this);
		
		this.table = table2;
	}
	
	public JTable getJTable() {
        return table;
    }
	
	@Override
	public void tableChanged(TableModelEvent e) {
		if(e.getType() == TableModelEvent.INSERT) {
			int row = e.getFirstRow();
			int column = e.getColumn();
			
			DAO dao = DAO.getinstance();
			
			
			//DiaryDTO dto = new DiaryDTO(SPACECODE, TASKINDEX);
			
			//dao.insert(null, TOOL_TIP_TEXT_KEY);
			
		}
		if(e.getType() == TableModelEvent.UPDATE) {
			
		}
		if(e.getType() == TableModelEvent.DELETE) {
			
		}
	}
	
	public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    JFrame frame = new JFrame();
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    JScrollPane sp = new JScrollPane();
                    JTable table = new Table().getJTable();
                    sp.setViewportView(table);
                    frame.setBounds(AUTO_RESIZE_NEXT_COLUMN, ABORT, 700, 500);
                    frame.add(sp);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
	
	
}
