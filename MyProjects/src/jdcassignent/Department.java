package jdcassignent;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Department {
	ArrayList<CreateFaculty> faculty;
	JComboBox<String> box;
	String selectedFacultyCode = null;
	String[] facultyCodetList;

	public Department() {
		JFrame frame = new JFrame("Department");
		Font font = new Font("", Font.PLAIN, 16);
		

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setPreferredSize(new Dimension(730, 130));
		panel.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1, true));

		JTextField nameTextField = new JTextField();
		JTextField deptCodeTextField = new JTextField();
		JLabel nameLabel = new JLabel("Depart Name");
		JLabel deptCodeLabel = new JLabel("Dept. Code");
		JLabel facultyCodeLabel = new JLabel("Select Faculty");

		nameLabel.setLabelFor(nameTextField);
		deptCodeLabel.setLabelFor(deptCodeTextField);

		nameLabel.setBounds(20, 5, 150, 30);
		deptCodeLabel.setBounds(397, 5, 150, 30);
		facultyCodeLabel.setBounds(550, 5, 150, 30);
		nameLabel.setFont(font);
		deptCodeLabel.setFont(font);
		facultyCodeLabel.setFont(font);

		nameTextField.setBounds(20, 40, 350, 30);
		nameTextField.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1, true));
		deptCodeTextField.setBounds(390, 40, 100, 30);
		deptCodeTextField.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1, true));
		nameTextField.setFont(font);
		deptCodeTextField.setFont(font);

		JButton insertButton = new JButton("Submit");
		insertButton.setBounds(150, 90, 100, 30);
		insertButton.setFocusPainted(false);
		insertButton.setBackground(Color.white);
		insertButton.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1, true));
		insertButton.setFont(font);

		JButton backButton = new JButton("Back");
		backButton.setBounds(480, 90, 100, 30);
		backButton.setFocusPainted(false);
		backButton.setBackground(Color.white);
		backButton.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1, true));
		backButton.setFont(font);

		frame.setSize(800, 200);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.add(nameLabel);
		panel.add(deptCodeLabel);
		panel.add(nameTextField);
		panel.add(deptCodeTextField);
		panel.add(facultyCodeLabel);
		panel.add(insertButton);
		panel.add(backButton);

		Statement statement = Connector.createStatement();

		String select = "SELECT * FROM Faculty";
		faculty = new ArrayList<>();

		try {
			ResultSet values = statement.executeQuery(select);

			while (values.next()) {

				CreateFaculty createFaculty = new CreateFaculty(values.getString("FacultyName"),
						values.getString("FacultyCode"));

				faculty.add(createFaculty);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		String[] facultytList = new String[faculty.size()];
		facultyCodetList = new String[faculty.size()];

		Collections.sort(faculty, nameComperator);

		int i = 0;
		for (CreateFaculty n : faculty) {
			facultyCodetList[i] = n.facultyCode;
			facultytList[i] = n.falcutyName;
			i++;

		}

		box = new JComboBox<>(facultytList);

		box.setBounds(510, 40, 200, 30);

		panel.add(box);

		frame.add(panel);
		frame.setVisible(true);

		box.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				selectedFacultyCode = facultyCodetList[box.getSelectedIndex()];
			}

		});

		insertButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (nameTextField.getText().isEmpty() || deptCodeTextField.getText().isEmpty()
						|| selectedFacultyCode == null) {
					JOptionPane.showMessageDialog(null, "Null value is not allowed!", "Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				try {
					String createTable = "CREATE TABLE IF NOT EXISTS `department` (\r\n"
							+ "  `DepartmentCode` varchar(30) NOT NULL,\r\n"
							+ "  `DepartmentName` varchar(100) NOT NULL,\r\n"
							+ "  `FacultyCode` varchar(30) NOT NULL,\r\n"
							+ "  PRIMARY KEY (`DepartmentCode`) USING BTREE,\r\n"
							+ "  UNIQUE KEY `DepartmantName` (`DepartmentName`),\r\n"
							+ "  KEY `faculty_fk` (`FacultyCode`),\r\n"
							+ "  CONSTRAINT `faculty_fk` FOREIGN KEY (`FacultyCode`) REFERENCES `faculty` (`FacultyCode`)\r\n"
							+ ")ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;";

					statement.execute(createTable);
					String insert = String.format("INSERT INTO Department VALUES('%s','%s','%s')",
							deptCodeTextField.getText(), nameTextField.getText(), selectedFacultyCode);
					statement.execute(insert);
					JOptionPane.showMessageDialog(null, "Successful!", "Done", JOptionPane.INFORMATION_MESSAGE);
					nameTextField.setText("");
					deptCodeTextField.setText("");
					selectedFacultyCode = null;
					return;

				} catch (SQLException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "We encountered error!", "Error", JOptionPane.ERROR_MESSAGE);
				}

			}

		});
		
		backButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				AdminLogin.queryInterface();
				
			}
			
		});

	}

	public static void main(String[] args) {
//		new Department();
	}

	public static Comparator<CreateFaculty> nameComperator = new Comparator<>() {

		@Override
		public int compare(CreateFaculty obj1, CreateFaculty obj2) {
			String name1 = obj1.falcutyName;
			String name2 = obj2.falcutyName;

			return name1.compareTo(name2);
		}

	};

}

class CreateFaculty {
	String falcutyName;
	String facultyCode;

	public CreateFaculty(String name, String code) {
		falcutyName = name;
		facultyCode = code;
	}
}
