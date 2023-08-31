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

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class QueryStudent {
	private String matricNumber = null;

	private Font font = new Font("Dialog", Font.PLAIN, 16);
	private Font headingfont = new Font("", Font.PLAIN, 30);
	private JLabel heading;
	private JLabel surname;
	private JLabel otherNames;
	private JLabel DOB;
	private JLabel gender;
	private JLabel departmentCode;
	private JLabel departmentName;
	private JLabel facultyCode;
	private JLabel facultyName;
	private JLabel YOA;
	private JLabel matriculationNo;
	private JLabel loginTitle;

	JTextField matricNumberField;
	JPasswordField passwordField;

	QueryStudent() {

		heading = new JLabel("Student Details");
		heading.setForeground(Color.blue);
		heading.setFont(headingfont);
		heading.setBounds(20, 2, 300, 50);
		
		loginTitle = new JLabel("Login");
		loginTitle.setFont(new Font("Dialog",Font.TRUETYPE_FONT, 26));
		loginTitle.setBounds(20, 20, 250, 30);
		
		surname = new JLabel();
		otherNames = new JLabel();
		DOB = new JLabel();
		gender = new JLabel();
		departmentCode = new JLabel();
		departmentName = new JLabel();
		facultyCode = new JLabel();
		facultyName = new JLabel();
		YOA = new JLabel();
		surname.setFont(font);
		otherNames.setFont(font);
		DOB.setFont(font);
		gender.setFont(font);
		departmentCode.setFont(font);
		departmentName.setFont(font);
		facultyCode.setFont(font);
		facultyName.setFont(font);
		YOA.setFont(font);
		matriculationNo = new JLabel();
		matriculationNo.setFont(font);
		login();

	}

	public void login() {
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setPreferredSize(new Dimension(290, 275));
		panel.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1, true));

		JLabel matricNumberLabel = new JLabel("Matric Number: ");
		matricNumberField = new JTextField();
		JLabel passwordLabel = new JLabel("Password");
		passwordField = new JPasswordField();
		
		JButton homeButton = new JButton("Home");
		homeButton.setFocusPainted(false);
		homeButton.setBackground(Color.white);
		homeButton.setBounds(50, 220, 70, 25);
		homeButton.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1, true));

		matricNumberLabel.setFont(font);
		matricNumberField.setFont(font);
		passwordLabel.setFont(font);
		passwordField.setFont(font);

		matricNumberLabel.setBounds(20, 60, 250, 30);
		matricNumberField.setBounds(20, 90, 250, 30);
		passwordLabel.setBounds(20, 125, 250, 30);
		passwordField.setBounds(20, 160, 250, 30);

		JButton loginButton = new JButton("Login");
		loginButton.setFocusPainted(false);
		loginButton.setBounds(170, 220, 70, 25);
		loginButton.setBackground(Color.white);
		loginButton.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1, true));

		panel.add(matricNumberLabel);
		panel.add(matricNumberField);
		panel.add(passwordLabel);
		panel.add(passwordField);
		panel.add(loginButton);
		panel.add(homeButton);
		panel.add(loginTitle);

		JFrame frame = new JFrame("Student Detail");
		frame.setLayout(new FlowLayout());
		frame.setSize(500, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		frame.setVisible(true);

		loginButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				matricNumber = matricNumberField.getText();
				String password = null;
				String stringPassword = "";
				Statement statement = Connector.createStatement();
				String query = String.format("SELECT MatricNumber, password FROM student WHERE MatricNumber='%s' ",
						matricNumber);
				try {
					ResultSet tableData = statement.executeQuery(query);

					while (tableData.next()) {
						password = tableData.getString("Password");
					}

					if (password == null) {
						JOptionPane.showMessageDialog(frame, "Invalid matriculation number!", "Error",
								JOptionPane.INFORMATION_MESSAGE);
					} else {

						char[] passwordDb = passwordField.getPassword();
						for (char n : passwordDb) {
							stringPassword += n;
						}
					}

					if (stringPassword.equals(password)) {
						passwordField.setText("");
						password = null;
						stringPassword = null;
						frame.dispose();
						studentView(matricNumber);
					} else {
						JOptionPane.showMessageDialog(frame, "Invalid password!", "Error",
								JOptionPane.INFORMATION_MESSAGE);
					}

				} catch (SQLException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(frame, "We ecountered error!", "Error", JOptionPane.ERROR_MESSAGE);
				}

			}

		});
		
		homeButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new Login();
			}

		});

	}

	private void studentView(String matiricNumber) {

		try {

			Statement statement = Connector.createStatement();
			String query = String.format("SELECT MatricNumber, Surname, OtherNames, DOB, Gender, d.DepartmentCode,"
					+ "DepartmentName, f.FacultyCode, facultyName, AdmissionYear FROM "
					+ "student s JOIN department d ON s.DepartmentCode = d.DepartmentCode JOIN "
					+ "faculty f ON d.FacultyCode = f.FacultyCode WHERE MatricNumber='%s'", matricNumber);

			ResultSet tableData = statement.executeQuery(query);
			while (tableData.next()) {
				matriculationNo.setText("Matric Number: " + tableData.getString("MatricNumber"));
				surname.setText("Surname: " + tableData.getString("Surname"));
				otherNames.setText("Other Name: " + tableData.getString("OtherNames"));
				DOB.setText("Date of birth: " + tableData.getString("DOB"));
				gender.setText("Gender: " + tableData.getString("Gender"));
				departmentCode.setText("Department code: " + tableData.getString("DepartmentCode"));
				departmentName.setText("Department name: " + tableData.getString("DepartmentName"));
				facultyCode.setText("Faculty code: " + tableData.getString("FacultyCode"));
				facultyName.setText("Faculty name: " + tableData.getString("FacultyName"));
				YOA.setText("Year of admission: " + tableData.getString("AdmissionYear"));
			}

			JPanel panel = new JPanel();
			panel.setLayout(null);
			panel.setPreferredSize(new Dimension(450, 740));
			surname.setBounds(20, 50, 300, 30);
			otherNames.setBounds(20, 80, 400, 30);
			DOB.setBounds(20, 110, 300, 30);
			gender.setBounds(20, 140, 300, 30);
			matriculationNo.setBounds(20, 170, 300, 30);
			departmentName.setBounds(20, 200, 400, 30);
			departmentCode.setBounds(20, 230, 300, 30);
			facultyName.setBounds(20, 260, 400, 30);
			facultyCode.setBounds(20, 290, 300, 30);
			YOA.setBounds(20, 320, 300, 30);
			panel.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1, true));

			JButton homeButton = new JButton("Home");
			homeButton.setFocusPainted(false);
			homeButton.setBackground(Color.white);
			homeButton.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1, true));
			homeButton.setFont(font);
			homeButton.setBounds(170, 700, 100, 30);

			panel.add(heading);
			panel.add(surname);
			panel.add(otherNames);
			panel.add(DOB);
			panel.add(gender);
			panel.add(departmentCode);
			panel.add(departmentName);
			panel.add(facultyCode);
			panel.add(facultyName);
			panel.add(matriculationNo);
			panel.add(YOA);
			panel.add(homeButton);
			

			JFrame frame = new JFrame("Student Detail");
			frame.setLayout(new FlowLayout());
			frame.setSize(500, 800);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.add(panel);
			frame.setVisible(true);

			homeButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					frame.dispose();
					new Login();

				}

			});

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "We ecountered error!", "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		new QueryStudent();

	}
}

class CreateStudent {
	String surname;
	String otherNames;
	String DOB;
	String gender;
	String departmentCode;
	String departmentName;
	String falcutyCode;
	String facultyName;
	String YOA;

	public CreateStudent(String surname, String otherNames, String DOB, String gender, String departmentCode,
			String departmentName, String falcutyCode, String facultyName, String YOA) {

		this.surname = surname;
		this.otherNames = otherNames;
		this.DOB = DOB;
		this.gender = gender;
		this.departmentCode = departmentCode;
		this.departmentName = departmentName;
		this.falcutyCode = falcutyCode;
		this.facultyName = facultyName;
		this.YOA = YOA;

	}
}