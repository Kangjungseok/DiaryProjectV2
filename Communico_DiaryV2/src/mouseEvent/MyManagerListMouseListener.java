package mouseEvent;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dummy.TransferVal;

public class MyManagerListMouseListener extends MouseAdapter{
	
	private JTable table;
	private JLabel ml;
	public MyManagerListMouseListener(JTable table, JLabel managerLabel) {
		this.table = table;
		this.ml = managerLabel;
	}
	
	@Override
     public void mouseEntered(MouseEvent e) {
         ml.setBackground(Color.lightGray);
     }
     @Override
     public void mouseExited(MouseEvent e) {
         ml.setBackground(null);
     }
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON1) {
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.setValueAt(ml.getText(), TransferVal.selectedRow, model.findColumn("manager"));
			
		}
	}
	
	
}
