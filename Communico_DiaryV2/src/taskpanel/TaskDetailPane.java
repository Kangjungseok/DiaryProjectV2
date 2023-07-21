package taskpanel;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextField;

public class TaskDetailPane extends JPanel{
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel taskNameLabel;
	private JLabel taskManagerLabel;
	private JLabel taskDDayLabel;
	
	public TaskDetailPane() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel exitLabel = new JLabel("\u2192|");
		GridBagConstraints gbc_exitLabel = new GridBagConstraints();
		gbc_exitLabel.insets = new Insets(0, 0, 5, 0);
		gbc_exitLabel.gridx = 0;
		gbc_exitLabel.gridy = 0;
		add(exitLabel, gbc_exitLabel);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		textField = new JTextField();
		textField.setText("\uC791\uC5C5 \uC774\uB984");
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 0;
		panel.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel taskNameLabel = new JLabel("\uC791\uC5C5 \uC774\uB984 \uAC12 \uB123\uC5B4\uC8FC\uAE30");
		GridBagConstraints gbc_taskNameLabel = new GridBagConstraints();
		gbc_taskNameLabel.insets = new Insets(0, 0, 5, 0);
		gbc_taskNameLabel.gridx = 1;
		gbc_taskNameLabel.gridy = 0;
		panel.add(taskNameLabel, gbc_taskNameLabel);
		
		textField_1 = new JTextField();
		textField_1.setText("\uB2F4\uB2F9\uC790");
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 0;
		gbc_textField_1.gridy = 1;
		panel.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		JLabel taskManagerLabel = new JLabel("\uB2F4\uB2F9\uC790 \uC774\uB984 \uB123\uC5B4\uC8FC\uAE30");
		GridBagConstraints gbc_taskManagerLabel = new GridBagConstraints();
		gbc_taskManagerLabel.insets = new Insets(0, 0, 5, 0);
		gbc_taskManagerLabel.gridx = 1;
		gbc_taskManagerLabel.gridy = 1;
		panel.add(taskManagerLabel, gbc_taskManagerLabel);
		
		textField_2 = new JTextField();
		textField_2.setText("\uB9C8\uAC10\uC77C");
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 0, 5);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 0;
		gbc_textField_2.gridy = 2;
		panel.add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		
		JLabel taskDDayLabel = new JLabel("\uB9C8\uAC10\uC77C \uAC12 \uB123\uC5B4\uC8FC\uAE30");
		taskDDayLabel.setText("값은 이렇게 바꾸는 건가?");
		GridBagConstraints gbc_taskDDayLabel = new GridBagConstraints();
		gbc_taskDDayLabel.gridx = 1;
		gbc_taskDDayLabel.gridy = 2;
		panel.add(taskDDayLabel, gbc_taskDDayLabel);
		
		JLabel taskDescriptionLabel = new JLabel("\uC791\uC5C5 \uC124\uBA85 \uCC3D");
		GridBagConstraints gbc_taskDescriptionLabel = new GridBagConstraints();
		gbc_taskDescriptionLabel.gridx = 0;
		gbc_taskDescriptionLabel.gridy = 2;
		add(taskDescriptionLabel, gbc_taskDescriptionLabel);
		
		
		
		
		this.taskNameLabel = taskNameLabel;
		this.taskManagerLabel = taskManagerLabel;
		this.taskDDayLabel = taskDDayLabel;
		
		
		exitLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getButton() == MouseEvent.BUTTON1) {
					TaskDetailPane.this.setVisible(false);
				}
			}
		});
	}
	
	public JLabel getTaskNameLabel() {
		return this.taskNameLabel;
	}
	
	public JLabel getTaskMangerLabel() {
		return this.taskManagerLabel;
	}
	
	public JLabel getTaskDDayLabel() {
		return this.taskDDayLabel;
	}
	
	
	
}
