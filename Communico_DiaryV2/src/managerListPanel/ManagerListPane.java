package managerListPanel;

import javax.swing.JPanel;

import mouseEvent.MyManagerListMouseListener;

import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class ManagerListPane extends JPanel{
	public ManagerListPane() {
		setBounds(new Rectangle(0, 0, 100, 100));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel manager1 = new JLabel("\uAC15\uC815\uC11D1");
		manager1.setOpaque(true);
		GridBagConstraints gbc_manager1 = new GridBagConstraints();
		gbc_manager1.insets = new Insets(0, 0, 5, 0);
		gbc_manager1.gridx = 0;
		gbc_manager1.gridy = 0;
		add(manager1, gbc_manager1);
		
		JLabel manager2 = new JLabel("\uAC15\uC815\uC11D2");
		manager2.setOpaque(true);
		GridBagConstraints gbc_manager2 = new GridBagConstraints();
		gbc_manager2.insets = new Insets(0, 0, 5, 0);
		gbc_manager2.gridx = 0;
		gbc_manager2.gridy = 1;
		add(manager2, gbc_manager2);
		
		JLabel manager3 = new JLabel("\uAC15\uC815\uC11D3");
		manager3.setOpaque(true);
		GridBagConstraints gbc_manager3 = new GridBagConstraints();
		gbc_manager3.insets = new Insets(0, 0, 5, 0);
		gbc_manager3.gridx = 0;
		gbc_manager3.gridy = 2;
		add(manager3, gbc_manager3);
		
		JLabel manager4 = new JLabel("\uAC15\uC815\uC11D4");
		manager4.setOpaque(true);
		GridBagConstraints gbc_manager4 = new GridBagConstraints();
		gbc_manager4.gridx = 0;
		gbc_manager4.gridy = 3;
		add(manager4, gbc_manager4);
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
