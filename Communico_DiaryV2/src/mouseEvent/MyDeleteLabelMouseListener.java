package mouseEvent;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dto.DiaryDTO;
import dummy.TransferVal;
import myEventListener.TableEventListener;

public class MyDeleteLabelMouseListener extends MouseAdapter {
	
	private String pk = "taskIndex";
	private JTable table;
    private DefaultTableModel tableModel;
    
    
    public MyDeleteLabelMouseListener(JTable table) {
    	this.table = table;
    	this.tableModel = (DefaultTableModel) table.getModel();
	}
    
    
    @Override
    public void mouseClicked(MouseEvent e) {
    	int row = table.getSelectedRow();
    	if(e.getButton() == MouseEvent.BUTTON1) {
    		if (row >= 0) {
    		    int primaryKeyValue = (int)tableModel.getValueAt(row, tableModel.findColumn(pk));	
    		    TransferVal.pk = primaryKeyValue; //중계 클래스에 값 설정
    			tableModel.removeRow(row);
    			tableModel.fireTableRowsDeleted(row, row);
    		}    		
    	}
    	
    }
    
    
}
