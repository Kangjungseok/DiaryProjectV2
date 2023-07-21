package listMainPanel;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import managerListPanel.ManagerListPane;
import mouseEvent.MyDeleteLabelMouseListener;
import mouseEvent.MyManagerListMouseListener;
import mouseEvent.MyTableMouseListener;
import propertiesPanel.PropertiesPane;
import table.Table;
import taskpanel.TaskDetailPane;

public class ListMainPane extends JPanel{
	
	String spaceCode = "jsTest";
	String pk = "taskIndex";
	
	public ListMainPane() {
		setLayout(new BorderLayout(0, 0));
		
		JLayeredPane layeredPane = new JLayeredPane();
		add(layeredPane, BorderLayout.CENTER);
		
		JScrollPane sp = new JScrollPane();
		JTable jtable = new Table(spaceCode,pk).getJTable();
		sp.setViewportView(jtable);
		layeredPane.addComponentListener(new ComponentAdapter() {//table size설정해서 보이게 하기
			    @Override
			    public void componentResized(ComponentEvent e) {
			        sp.setBounds(0, 0, layeredPane.getWidth(), layeredPane.getHeight());
			    }
			});
		layeredPane.add(sp, JLayeredPane.PALETTE_LAYER);
		
		PropertiesPane pp = new PropertiesPane();
		layeredPane.add(pp, JLayeredPane.DEFAULT_LAYER);
		
		ManagerListPane msp = new ManagerListPane();
		layeredPane.add(msp, JLayeredPane.DEFAULT_LAYER);

		TaskDetailPane tdp = new TaskDetailPane();
		tdp.setVisible(false);
		add(tdp, BorderLayout.EAST);
		
		//JTable에 마우스리스너 추가
		MyTableMouseListener tml = new MyTableMouseListener(layeredPane, jtable, tdp, pp,msp);
		jtable.addMouseListener(tml);
		
		
		//deleteLabel에 마우스리스너 추가
		pp.getDeleteLabel().addMouseListener(new MyDeleteLabelMouseListener(jtable));
		
		for (Component comp : msp.getComponents()) {
		    if (comp instanceof JLabel) {
		        JLabel labelComp = (JLabel) comp;
		        labelComp.addMouseListener(new MyManagerListMouseListener(jtable, labelComp));
		    }
		}

		
		
		
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ListMainPane lmp = new ListMainPane();
        frame.getContentPane().add(lmp);
        frame.setBounds(500, 300, 700, 500);
        frame.setVisible(true);
		
	}
     

}
