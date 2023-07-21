package mouseEvent;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dummy.TransferVal;
import managerListPanel.ManagerListPane;
import propertiesPanel.PropertiesPane;
import taskpanel.TaskDetailPane;

public class MyTableMouseListener extends MouseAdapter {
	JLayeredPane layeredPane;
    private JTable table;
    private DefaultTableModel tableModel;
    private TaskDetailPane taskDetailPane;
    private PropertiesPane pp;
    private ManagerListPane mlp;
    private JLabel taskNameLabel;
    private JLabel taskManagerLabel;
    private JLabel taskDDayLabel;
    

    public MyTableMouseListener(JLayeredPane layeredPane,JTable table, 
    				TaskDetailPane taskDetailPane, PropertiesPane pp, ManagerListPane mlp) {
        this.layeredPane = layeredPane;
    	this.table = table;
        this.tableModel = (DefaultTableModel) table.getModel();
        this.taskDetailPane = taskDetailPane;
        this.pp = pp;
        this.mlp = mlp;
        
        this.taskNameLabel = taskDetailPane.getTaskNameLabel();
        this.taskManagerLabel = taskDetailPane.getTaskMangerLabel();
        this.taskDDayLabel = taskDetailPane.getTaskDDayLabel();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    	int sensitive = 20;
        int row = table.getSelectedRow();
        int column = table.getSelectedColumn();
        
        int task = tableModel.findColumn("task");
        int managerIdx = tableModel.findColumn("manager");
        int dDayIdx = tableModel.findColumn("dDay");
        
        
        if(e.getButton() == MouseEvent.BUTTON1) { //왼쪽 클릭
        	if(column == task) {
        		taskNameLabel.setText((String)tableModel.getValueAt(row, tableModel.findColumn("task")));
        		taskManagerLabel.setText((String)tableModel.getValueAt(row, tableModel.findColumn("manager")));
        		java.sql.Date dDay = (java.sql.Date) tableModel.getValueAt(row, tableModel.findColumn("dDay"));
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                taskDDayLabel.setText(dateFormat.format(dDay));
        		taskDetailPane.setVisible(true);
        	}else {
        		taskDetailPane.setVisible(false);
        	}
        	if(column == tableModel.findColumn("manager")) {
        		TransferVal.pk = (int)tableModel.getValueAt(row, tableModel.findColumn("taskIndex"));
        		TransferVal.selectedRow = row;
        		mlp.setLocation(e.getX(), e.getY() + sensitive);
                layeredPane.setLayer(mlp, JLayeredPane.POPUP_LAYER);
                mlp.setVisible(true); // 마우스 우클릭 이벤트일 때 pp 보이도록 설정
        	}else {
                layeredPane.setLayer(mlp, JLayeredPane.DEFAULT_LAYER);
            }

        }
      
        if (e.getButton() == MouseEvent.BUTTON3) { // 마우스 우클릭 이벤트
            pp.setLocation(e.getX(), e.getY() + sensitive);
            layeredPane.setLayer(pp, JLayeredPane.POPUP_LAYER);
            pp.setVisible(true); // 마우스 우클릭 이벤트일 때 pp 보이도록 설정
        } else {
            layeredPane.setLayer(pp, JLayeredPane.DEFAULT_LAYER);
        }
        
        
        
    }
}
