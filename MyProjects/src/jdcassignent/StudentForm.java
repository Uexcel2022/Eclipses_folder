package jdcassignent;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class StudentForm {

	private JTextField surnameField;
	private JTextField otherNameField;
	private JTextField DOBField;
	JTextField YOAField;
	JTextField mariticNumber;
	private JRadioButton male;
	private JRadioButton female;
	private JPasswordField passwordField1;
	private JPasswordField passwordField2;

	ArrayList<CreateDepartment> department;
	JComboBox<String> box;
	String selectedDptCode = null;
	String[] depCodetList;
	String genderSelected = null;

	public StudentForm() {
		JFrame frame = new JFrame();
		Font font = new Font("", Font.PLAIN, 16);
		

		JPanel panel = new JPanel();
		panel.setLayout(null);

		panel.setPreferredSize(new Dimension(600, 330));
		panel.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1, true));

		JLabel passwordLabel = new JLabel("Password:");
		passwordField1 = new JPasswordField();
		passwordLabel.setLabelFor(passwordField1);
		passwordField1.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1, true));
		passwordLabel.setFont(font);
		passwordField1.setFont(font);
		passwordLabel.setBounds(20, 200, 150, 30);
		passwordField1.setBounds(110, 200, 150, 30);

		JLabel passwordLabel2 = new JLabel("Confirm password:");
		passwordField2 = new JPasswordField();
		passwordLabel2.setLabelFor(passwordField2);
		passwordField2.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1, true));
		passwordLabel2.setFont(font);
		passwordField2.setFont(font);
		passwordLabel2.setBounds(290, 200, 150, 30);
		passwordField2.setBounds(430, 200, 150, 30);

		surnameField = new JTextField();
		DOBField = new JTextField();
		JLabel surnameLabel = new JLabel("Surname:");
		JLabel DOBLabel = new JLabel("Date of birth:");
		JLabel deptCodeLabel = new JLabel("Select department:");
		male = new JRadioButton("Male");
		female = new JRadioButton("Female");
		ButtonGroup buttonGroup = new ButtonGroup();
		JLabel genderLabel = new JLabel("Gender:");
		male.setFont(font);
		female.setFont(font);
		buttonGroup.add(male);
		buttonGroup.add(female);
		male.setBounds(400, 125, 80, 20);
		female.setBounds(480, 125, 100, 20);
		genderLabel.setBounds(445, 90, 100, 30);
		genderLabel.setFont(font);

		JButton insertButton = new JButton("Submit");
		JButton resetButton = new JButton("Reset");
		JButton homeButton = new JButton("Home");
		homeButton.setFocusPainted(false);
		homeButton.setBackground(Color.white);
		homeButton.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1, true));
		homeButton.setFont(font);
		homeButton.setBounds(60, 290, 100, 30);

		surnameLabel.setLabelFor(surnameField);
		DOBLabel.setLabelFor(DOBField);
		surnameLabel.setBounds(20, 5, 100, 30);
		DOBLabel.setBounds(230, 5, 150, 30);
		deptCodeLabel.setBounds(410, 5, 150, 30);
		surnameLabel.setFont(font);
		DOBLabel.setFont(font);
		deptCodeLabel.setFont(font);

		surnameField.setBounds(20, 40, 150, 30);
		surnameField.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1, true));
		DOBField.setBounds(200, 40, 150, 30);
		DOBField.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1, true));
		surnameField.setFont(font);
		DOBField.setFont(font);
		DOBField.setText("dd-mm-yyyy");

		otherNameField = new JTextField();
	    YOAField = new JTextField();
		JLabel otherNameLabel = new JLabel("Other Names:");
		JLabel YOALabel = new JLabel("Addmission Year:");

		otherNameLabel.setLabelFor(otherNameField);
		YOALabel.setLabelFor(YOAField);

		otherNameLabel.setBounds(20, 90, 100, 30);
		YOALabel.setBounds(252, 90, 150, 30);
		otherNameLabel.setFont(font);
		YOALabel.setFont(font);
		deptCodeLabel.setFont(font);

		otherNameField.setBounds(20, 125, 200, 30);
		otherNameField.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1, true));
		YOAField.setBounds(250, 125, 130, 30);
		YOAField.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1, true));
		otherNameField.setFont(font);
		YOAField.setFont(font);

		insertButton.setBounds(250, 290, 100, 30);
		insertButton.setFocusPainted(false);
		insertButton.setBackground(Color.white);
		insertButton.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1, true));
		insertButton.setFont(font);

		resetButton.setBounds(430, 290, 100, 30);
		resetButton.setFocusPainted(false);
		resetButton.setBackground(Color.white);
		resetButton.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1, true));
		resetButton.setFont(font);

		frame.setTitle("Department");
		frame.setSize(680, 800);
		frame.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel.add(surnameLabel);
		panel.add(DOBLabel);
		panel.add(surnameField);
		panel.add(DOBField);
		panel.add(deptCodeLabel);
		panel.add(otherNameLabel);
		panel.add(YOALabel);
		panel.add(otherNameField);
		panel.add(YOAField);
		panel.add(genderLabel);
		panel.add(male);
		panel.add(female);
		panel.add(insertButton);
		panel.add(resetButton);
		panel.add(passwordLabel);
		panel.add(passwordField1);
		panel.add(passwordLabel2);
		panel.add(passwordField2);
		panel.add(homeButton);

		Statement statement = Connector.createStatement();

		String select = "SELECT * FROM department";
		department = new ArrayList<>();

		try {
			ResultSet values = statement.executeQuery(select);

			while (values.next()) {

				CreateDepartment createDept = new CreateDepartment(values.getString("DepartmentName"),
						values.getString("DepartmentCode"));

				department.add(createDept);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		String[] deptList = new String[department.size()];
		depCodetList = new String[department.size()];

		Collections.sort(department, nameComparator);

		int i = 0;
		for (CreateDepartment n : department) {
			depCodetList[i] = n.dptCode;
			deptList[i] = n.dptName;
			i++;

		}

		box = new JComboBox<>(deptList);

		box.setBounds(380, 40, 200, 30);

		panel.add(box);

		frame.add(panel);
		frame.setVisible(true);

		box.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				selectedDptCode = depCodetList[box.getSelectedIndex()];

			}

		});

		resetButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				selectedDptCode = null;
				surnameField.setText("");
				otherNameField.setText("");
				YOAField.setText("");
				DOBField.setText("dd-mm-yyyy");
				genderSelected = null;
				buttonGroup.clearSelection();

			}

		});

		DOBField.addFocusListener(new FocusAdapter() {

			@Override
			public void focusGained(FocusEvent e) {
				if (DOBField.getText().contains("dd-mm-yyyy")) {
					DOBField.setText("");
				}

			}

		});

		insertButton.addActionListener(new ActionListener() {
			@Override

			public void actionPerformed(ActionEvent e) {
				boolean isValided = validation(frame);
				if (isValided) {
					String password1 = "";
					String password2 = "";

					char[] passworChar1 = passwordField1.getPassword();
					char[] passworChar2 = passwordField2.getPassword();

					if (passworChar1.length != passworChar2.length) {
						JOptionPane.showMessageDialog(null, "Password does not match!", "Validation",
								JOptionPane.INFORMATION_MESSAGE);
						return;
					}

					for (int i = 0; i < passworChar1.length; i++) {
						password1 += passworChar1[i];
						password2 += passworChar2[i];

					}

					if (!password1.equals(password2)) {
						JOptionPane.showMessageDialog(null, "Password does not match!", "Validation",
								JOptionPane.INFORMATION_MESSAGE);
						return;
					}

					if (surnameField.getText().isEmpty() || DOBField.getText().isEmpty() || selectedDptCode == null
							|| password1.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Null value is not allowed!", "Error",
								JOptionPane.ERROR_MESSAGE);
						return;
					}

					try {
						String createTable = "CREATE TABLE IF NOT EXISTS `student` (\r\n"
								+ "  `MatricNumber` int(11) NOT NULL AUTO_INCREMENT,\r\n"
								+ "  `Surname` varchar(50) NOT NULL,\r\n" + "  `OtherNames` varchar(100) NOT NULL,\r\n"
								+ "  `DOB` varchar(30) NOT NULL,\r\n" + "  `Gender` varchar(20) NOT NULL,\r\n"
								+ "  `AdmissionYear` varchar(30) NOT NULL,\r\n"
								+ "  `DepartmentCode` varchar(30) NOT NULL,\r\n"
								+ "  `Password` varchar(30) NOT NULL,\r\n" + "  PRIMARY KEY (`MatricNumber`),\r\n"
								+ "  KEY `dpt_fk` (`DepartmentCode`),\r\n"
								+ "  CONSTRAINT `dpt_fk` FOREIGN KEY (`DepartmentCode`) REFERENCES `department` (`DepartmentCode`)\r\n"
								+ ") ENGINE=InnoDB AUTO_INCREMENT=202300 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;";
						statement.execute(createTable);
						String insert = String.format(
								"INSERT INTO student(Surname,OtherNames,DOB,Gender, AdmissionYear, DepartmentCode,Password) VALUES('%s','%s','%s','%s','%s','%s','%s')",
								surnameField.getText(), otherNameField.getText(), DOBField.getText(), genderSelected,
								YOAField.getText(), selectedDptCode, password1);
						statement.execute(insert);

						String selectQuery = "Select max(MatricNumber) AS MatricNumber from mydatabase.student";
						ResultSet resultSet = statement.executeQuery(selectQuery);
						String matricNumber = null;
						while (resultSet.next()) {
							matricNumber = resultSet.getString("MatricNumber");
						}
						JOptionPane.showMessageDialog(null,
								"Successful! \nYour Matric number: " + matricNumber
										+ "\nPLEASE SAVE IT. \n It will be required to access\nyour profile.",
								"Done", JOptionPane.INFORMATION_MESSAGE);
						surnameField.setText("");
						DOBField.setText("");
						selectedDptCode = null;
						password1 = "";
						password1 = "";
						passwordField1.setText("");
						passwordField2.setText("");
						otherNameField.setText("");
						YOAField.setText("");
						buttonGroup.clearSelection();
						

						return;

					} catch (SQLException e1) {
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "We encountered error!", "Error",
								JOptionPane.ERROR_MESSAGE);
					}

				}
			}
		});

		male.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (male.isSelected()) {
					genderSelected = "Male";
				}

			}

		});

		female.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (female.isSelected()) {
					genderSelected = "Female";
				}

			}

		});

		homeButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new Login();

			}

		});

	}

	public static void main(String[] args) {
//		new StudentForm();
	}

	public static Comparator<CreateDepartment> nameComparator = new Comparator<>() {

		@Override
		public int compare(CreateDepartment obj1, CreateDepartment obj2) {
			String name1 = obj1.dptName;
			String name2 = obj2.dptName;
			return name1.compareTo(name2);
		}

	};

	public Boolean validation(JFrame frame) {

		String[] dOB = DOBField.getText().split("-");

		try {
			Double.parseDouble(dOB[0]);
			Double.parseDouble(dOB[1]);
			Double.parseDouble(dOB[2]);

			if (Double.parseDouble(dOB[0]) > 29 && Double.parseDouble(dOB[1]) == 02) {
				DOBField.setText("");
				JOptionPane.showMessageDialog(frame, "Invalid date!\n Febuary has 28 or 29 days!", "Date validation",
						JOptionPane.INFORMATION_MESSAGE);
				return false;

			}

			if (dOB.length != 3) {
				DOBField.setText("");
				JOptionPane.showMessageDialog(frame, "Invalid date!\n Expected date format: dd-mm-yyyy",
						"Date validation", JOptionPane.INFORMATION_MESSAGE);
				return false;

			}

			if (Double.parseDouble(dOB[0]) > 31 || Double.parseDouble(dOB[1]) > 12) {
				DOBField.setText("");
				JOptionPane.showMessageDialog(frame, "Invalid date!\nMonth > 12 or days in month > 31",
						"Date validation", JOptionPane.INFORMATION_MESSAGE);
				return false;

			}

			if (dOB[0].length() != 2 || dOB[1].length() != 2 || dOB[2].length() != 4) {
				DOBField.setText("");
				JOptionPane.showMessageDialog(frame, "Invalid date!\n Expected date format: dd-mm-yyyy",
						"Date validation", JOptionPane.INFORMATION_MESSAGE);
				return false;

			}

			Boolean isValid = Pattern.matches("[1-2][0-9][0-9][0-9]", YOAField.getText());
			if (!isValid) {
				YOAField.setText("");
				JOptionPane.showMessageDialog(frame, "Invalid date!\n Expected date format: yyyy", "Date validation",
						JOptionPane.INFORMATION_MESSAGE);
				return false;
			}

			return true;

		} catch (NumberFormatException er) {
			DOBField.setText("");
			JOptionPane.showMessageDialog(frame, "Invalid date!\n Expected date format: dd-mm-yyyy", "Date validation",
					JOptionPane.INFORMATION_MESSAGE);
			return false;

		}
	}

}

class CreateDepartment {
	String dptName;
	String dptCode;

	public CreateDepartment(String name, String code) {
		dptName = name;
		dptCode = code;
	}
}
