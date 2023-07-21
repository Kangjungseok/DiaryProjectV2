package propertiesPanel;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Rectangle;

public class PropertiesPane extends JPanel{
	
	private JLabel deleteLabel;
	
	public PropertiesPane() {
		setBounds(new Rectangle(0, 0, 100, 200));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel deleteLabel = new JLabel("\uC0AD\uC81C");
		GridBagConstraints gbc_deleteLabel = new GridBagConstraints();
		gbc_deleteLabel.gridx = 0;
		gbc_deleteLabel.gridy = 0;
		add(deleteLabel, gbc_deleteLabel);
		
		
		this.deleteLabel = deleteLabel;
		
	}
	
	public JLabel getDeleteLabel() {
		return this.deleteLabel;
	}

}
