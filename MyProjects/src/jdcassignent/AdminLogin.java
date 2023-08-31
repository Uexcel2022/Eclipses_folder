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

public class AdminLogin {
	private Font font = new Font("Dialog", Font.PLAIN, 16);
	private Font headingfont = new Font("", Font.PLAIN, 30);
	private JLabel heading;
	private JLabel loginTitle;

	JPasswordField passwordField;

	AdminLogin() {

		heading = new JLabel("Student Details");
		heading.setForeground(Color.blue);
		heading.setFont(headingfont);
		heading.setBounds(20, 2, 300, 50);

		loginTitle = new JLabel("Login");
		loginTitle.setFont(new Font("Dialog", Font.TRUETYPE_FONT, 26));
		loginTitle.setBounds(20, 20, 250, 30);

		login();


	}

	public void login() {
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setPreferredSize(new Dimension(290, 275));
		panel.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1, true));

		JLabel usernameberLabel = new JLabel("Username: ");
		JTextField usernameField = new JTextField();
		JLabel passwordLabel = new JLabel("Password");
		passwordField = new JPasswordField();

		JButton homeButton = new JButton("Home");
		homeButton.setFocusPainted(false);
		homeButton.setBackground(Color.white);
		homeButton.setBounds(50, 220, 70, 25);
		homeButton.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1, true));

		usernameberLabel.setFont(font);
		usernameField.setFont(font);
		passwordLabel.setFont(font);
		passwordField.setFont(font);

		usernameberLabel.setBounds(20, 60, 250, 30);
		usernameField.setBounds(20, 90, 250, 30);
		passwordLabel.setBounds(20, 125, 250, 30);
		passwordField.setBounds(20, 160, 250, 30);

		JButton loginButton = new JButton("Login");
		loginButton.setFocusPainted(false);
		loginButton.setBounds(170, 220, 70, 25);
		loginButton.setBackground(Color.white);
		loginButton.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1, true));

		panel.add(usernameberLabel);
		panel.add(usernameField);
		panel.add(passwordLabel);
		panel.add(passwordField);
		panel.add(loginButton);
		panel.add(homeButton);
		panel.add(loginTitle);

		JFrame frame = new JFrame("Student Detail");
		frame.setLocationByPlatform(false);
		frame.setLayout(new FlowLayout());
		frame.setSize(500, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		frame.setVisible(true);

		loginButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String password = null;
				String stringPassword = "";
				String saltvalue = null;
				
				Statement statement = Connector.createStatement();
				String query = String.format("SELECT password, saltvalue FROM admin WHERE username= '%s' ",usernameField.getText());
				try {
					ResultSet tableData = statement.executeQuery(query);

					while (tableData.next()) {
						password = tableData.getString("password");
						saltvalue = tableData.getString("saltvalue");
					}

					if (password == null) {
						JOptionPane.showMessageDialog(frame, "Invalid username!", "Error",
								JOptionPane.INFORMATION_MESSAGE);
						return;
					} else {

						char[] passwordDb = passwordField.getPassword();
						for (char n : passwordDb) {
							stringPassword += n;
						}
					}


				
					Boolean status = PassBasedEnc.verifyUserPassword(stringPassword, password, saltvalue);
					if (status == true) {
						passwordField.setText("");
						password = null;
						stringPassword = null;
						frame.dispose();
						queryInterface();

					} else {
						JOptionPane.showMessageDialog(frame, "Invalid password!", "Error",
								JOptionPane.INFORMATION_MESSAGE);
					}

				} catch (SQLException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(frame, "We ecountered error!", "Error", JOptionPane.ERROR_MESSAGE);
				} catch(IllegalArgumentException er) {
					
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

	public static void queryInterface() {

		JFrame frame = new JFrame("Database Query interface");
		JPanel panel = new JPanel();

		frame.setSize(700, 500);
		frame.setLayout(new FlowLayout());
		frame.setLocationRelativeTo(frame);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel.setLayout(null);
		panel.setPreferredSize(new Dimension(700, 500));
		panel.setBackground(Color.white);
		panel.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1, true));

		JLabel titleLabel = new JLabel("Databaese Query Interface");
		titleLabel.setFont(new Font("", Font.BOLD, 20));
		titleLabel.setBounds(370, 5, 400, 40);
		titleLabel.setForeground(Color.decode("#3A3B3C"));

		JPanel sidePanel = new JPanel();
		sidePanel.setLayout(null);
		sidePanel.setBounds(0, 0, 300, 500);
		sidePanel.setBackground(Color.decode("#B8BABBC"));

		JButton homeButton = new JButton("Home");
		homeButton.setFocusPainted(false);
		homeButton.setBackground(Color.WHITE);
		homeButton.setBounds(470, 420, 70, 25);
		homeButton.setBorder(BorderFactory.createLineBorder(Color.decode("#B8BABBC"), 1, true));

		JLabel Query = new JLabel("Query by: ");
		Query.setBounds(10, 8, 100, 30);
		Query.setForeground(Color.white);
		Query.setFont(new Font("Dialog", Font.PLAIN, 18));

		JButton getAllMatricButton = new JButton("All Matriculation number");
		getAllMatricButton.setFocusPainted(false);
		getAllMatricButton.setBounds(11, 40, 150, 25);
		getAllMatricButton.setBackground(Color.decode("#B8BABBC"));
		getAllMatricButton.setForeground(Color.white);
		getAllMatricButton.setBorder(null);
		getAllMatricButton.setFocusPainted(false);

		JButton getByDeptButton = new JButton("Get Matriculation number by Department");
		getByDeptButton.setFocusPainted(false);
		getByDeptButton.setBounds(9, 70, 248, 25);
		getByDeptButton.setBackground(Color.decode("#B8BABBC"));
		getByDeptButton.setForeground(Color.white);
		getByDeptButton.setBorder(null);
		getByDeptButton.setFocusPainted(false);

		JButton getByFacultytButton = new JButton("Get Matriculation number by Faculty");
		getByFacultytButton.setFocusPainted(false);
		getByFacultytButton.setBounds(9, 100, 220, 25);
		getByFacultytButton.setBackground(Color.decode("#B8BABBC"));
		getByFacultytButton.setForeground(Color.white);
		getByFacultytButton.setBorder(null);
		getByFacultytButton.setFocusPainted(false);

		JButton getByYOAtButton = new JButton("Get Matriculation number by Admission year");
		getByYOAtButton.setFocusPainted(false);
		getByYOAtButton.setBounds(6, 130, 275, 25);
		getByYOAtButton.setBackground(Color.decode("#B8BABBC"));
		getByYOAtButton.setForeground(Color.white);
		getByYOAtButton.setBorder(null);
		getByYOAtButton.setFocusPainted(false);

		JButton getStudentDetalsButton = new JButton("Get student details");
		getStudentDetalsButton.setFocusPainted(false);
		getStudentDetalsButton.setBounds(6, 160, 135, 25);
		getStudentDetalsButton.setBackground(Color.decode("#B8BABBC"));
		getStudentDetalsButton.setForeground(Color.white);
		getStudentDetalsButton.setBorder(null);
		getStudentDetalsButton.setFocusPainted(false);

		JButton addFacultyButton = new JButton("Add data to faculty table");
		addFacultyButton.setFocusPainted(false);
		addFacultyButton.setBounds(6, 190, 160, 25);
		addFacultyButton.setBackground(Color.decode("#B8BABBC"));
		addFacultyButton.setForeground(Color.white);
		addFacultyButton.setBorder(null);
		addFacultyButton.setFocusPainted(false);

		JButton addDeptButton = new JButton("Add data to department  table");
		addDeptButton.setFocusPainted(false);
		addDeptButton.setBounds(6, 220, 190, 25);
		addDeptButton.setBackground(Color.decode("#B8BABBC"));
		addDeptButton.setForeground(Color.white);
		addDeptButton.setBorder(null);
		addDeptButton.setFocusPainted(false);
		
		JButton addAdminButton = new JButton("Add data to admin table");
		addAdminButton.setFocusPainted(false);
		addAdminButton.setBounds(6, 250, 155, 25);
		addAdminButton.setBackground(Color.decode("#B8BABBC"));
		addAdminButton.setForeground(Color.white);
		addAdminButton.setBorder(null);
		addAdminButton.setFocusPainted(false);
		
		

		sidePanel.add(Query);
		sidePanel.add(getAllMatricButton);
		sidePanel.add(getByDeptButton);
		sidePanel.add(getByFacultytButton);
		sidePanel.add(getByYOAtButton);
		sidePanel.add(getStudentDetalsButton);
		sidePanel.add(addFacultyButton);
		sidePanel.add(addDeptButton);
		sidePanel.add(addAdminButton);
		panel.add(homeButton);
		panel.add(titleLabel);
		panel.add(sidePanel);
		frame.add(panel);
		frame.setVisible(true);

		homeButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new Login();

			}

		});

		getAllMatricButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				QueryAdmin.tableQueries(null, null);
			}

		});

		getByDeptButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				call("DepartmentName");
			}

		});

		getByFacultytButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				call("FacultyName");
			}

		});

		getByYOAtButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				call("AdmissionYear");
			}

		});

		addDeptButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new Department();
			}

		});

		addFacultyButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new Faculty();
			}

		});
		
		
		addAdminButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				AdminTable.insert();
			}

		});
		
		getStudentDetalsButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				QueryAdmin.studentDetails();
			}

		});

	}
	
	
	
	

	public static void main(String[] args) {
//		new AdminLogin();
	}

	public static void call(String objName) {
		String labelName = "";

		switch (objName) {
		case "DepartmentName":
			labelName = "Department Name";
			break;

		case "FacultyName":
			labelName = "Faculty Name";
			break;
		case "AdmissionYear":
			labelName = "Year Of Addmission";
			break;

		default:
			return;
		}

		Font font = new Font("Dialog", Font.PLAIN, 16);
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setPreferredSize(new Dimension(290, 275));
		panel.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1, true));

		JLabel objNameLabel = new JLabel(labelName + ":");
		JTextField objNameField = new JTextField();

		JButton backButton = new JButton("Back");
		backButton.setFocusPainted(false);
		backButton.setBackground(Color.white);
		backButton.setBounds(50, 150, 70, 25);
		backButton.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1, true));

		objNameLabel.setFont(font);
		objNameField.setFont(font);

		objNameLabel.setBounds(20, 60, 250, 30);
		objNameField.setBounds(20, 90, 250, 30);

		JButton queryButton = new JButton("Query");
		queryButton.setFocusPainted(false);
		queryButton.setBounds(170, 150, 70, 25);
		queryButton.setBackground(Color.white);
		queryButton.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1, true));

		panel.add(objNameLabel);
		panel.add(objNameField);
		panel.add(queryButton);
		panel.add(backButton);

		JFrame frame = new JFrame("Student Detail");
		frame.setLayout(new FlowLayout());
		frame.setSize(400, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		frame.setVisible(true);

		queryButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				QueryAdmin.tableQueries(objName, objNameField.getText());

			}

		});

		backButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				queryInterface();

			}

		});

	}

}
