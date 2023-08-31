package jdcassignent;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Faculty {
	private JFrame facultyTableFrame;
	
	public Faculty() {
		Font font = new Font("",Font.PLAIN, 16);
		facultyTableFrame = new JFrame("Faculty");
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setPreferredSize(new Dimension(630,130));
		panel.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1,true));
		
		JTextField nameTextField = new JTextField();
		JTextField codeTextField = new JTextField();
		JLabel nameLabel = new JLabel("Faculty Name");
		JLabel codeLabel = new JLabel("Code");
		JButton insertButton = new JButton("Submit");
		nameLabel.setLabelFor(nameTextField);
		codeLabel.setLabelFor(codeTextField);
		
		nameLabel.setBounds(20,5,150,30);
		codeLabel.setBounds(500,5,150,30);
		nameLabel.setFont(font);
		codeLabel.setFont(font);
		
		nameTextField.setBounds(20,40, 400,30);
		nameTextField.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1,true));
		codeTextField.setBounds(450,40, 150,30);
		codeTextField.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1,true));
		nameTextField.setFont(font);
		codeTextField.setFont(font);
		
		insertButton.setBounds(150, 90, 100,30);
		insertButton.setFocusPainted(false);
		insertButton.setBackground(Color.white);
		insertButton.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1,true));
		insertButton.setFont(font);
		
		JButton backButton = new JButton("Back");
		backButton.setBounds(380, 90, 100, 30);
		backButton.setFocusPainted(false);
		backButton.setBackground(Color.white);
		backButton.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1, true));
		backButton.setFont(font);
		
		facultyTableFrame.setSize(700, 200);
		facultyTableFrame.setLocationRelativeTo(null);
		facultyTableFrame.setLayout(new FlowLayout());
		facultyTableFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.add(nameLabel);
		panel.add(codeLabel);
		panel.add(nameTextField);
		panel.add(codeTextField);
		panel.add(insertButton);
		panel.add(backButton);
	
		facultyTableFrame.add(panel);
		facultyTableFrame.setVisible(true);
		
		insertButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(nameTextField.getText().isEmpty()|| codeTextField.getText().isEmpty()){
					JOptionPane.showMessageDialog(facultyTableFrame, "Null value is not allowed!", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
			
				try {
					Statement statement = Connector.createStatement();
					String createTable= "CREATE TABLE IF NOT EXISTS `faculty` (\r\n"
							+ "  `FacultyCode` varchar(30) NOT NULL,\r\n"
							+ "  `FacultyName` varchar(20) NOT NULL,\r\n"
							+ "  PRIMARY KEY (`FacultyCode`),\r\n"
							+ "  UNIQUE KEY `FacultyName` (`FacultyName`)\r\n"
							+ ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;";
					statement.execute(createTable);
					String insert =  String.format("INSERT INTO Faculty VALUES('%s','%s')", codeTextField.getText(),nameTextField.getText());
					statement.execute(insert);
					JOptionPane.showMessageDialog(facultyTableFrame, "Successful!", "Done", JOptionPane.INFORMATION_MESSAGE);
					nameTextField.setText("");
					codeTextField.setText("");	
				} catch (SQLException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(facultyTableFrame, "We encountered error!", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
			
		});
		
		backButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				facultyTableFrame.dispose();
				AdminLogin.queryInterface();
				
			}
			
		});
		
	}

	
   public static void main(String[] args) {
//	   new Faculty();
	   
}
}
