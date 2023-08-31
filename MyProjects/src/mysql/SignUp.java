package mysql;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import java.util.regex.*;

public class SignUp {
	JTextField firstNameField, lastNameField, usernameField, phoneField, emailField;
	JPasswordField passwordField, passwordConfirmation;
	JRadioButton male, female;

	JLabel errorFname;
	JLabel errorLname;
	JLabel errorPhone;
	JLabel errorEmail;
	JLabel errorPassword;
	Font errorFont = new Font("", Font.BOLD, 20);

	Statement sqlStatement;

	JFrame homeFrame;
	JFrame signUpFrame;
	JFrame logInFrame;
	JPanel homePanel, signUpPanel, logInPanel;
	ImageIcon icon;

	String selectedGender = null;
	String fName = "";
	String lName = "";
	String phone = "";
	String email = "";
	String username = "";
	String password = "";
	int deactivateWindowClosingNotification;

	public SignUp() {
		icon = new ImageIcon("R.jpg");
		homeFrame = new JFrame("Home");
		signUpFrame = new JFrame("SignUp");
		logInFrame = new JFrame("LogIn");
		homePanel = new JPanel();
		signUpPanel = new JPanel();
		logInPanel = new JPanel();
		errorFname = new JLabel();
		errorLname = new JLabel();
		errorPhone = new JLabel();
		errorEmail = new JLabel();
		errorPassword = new JLabel();
		errorFname.setForeground(Color.red);
		errorLname.setForeground(Color.red);
		errorPhone.setForeground(Color.red);
		errorEmail.setForeground(Color.red);
		errorPassword.setForeground(Color.red);
		windowListener();
		homePage();

	}

	public void homePage() {
		Font buttFont = new Font("", Font.PLAIN, 20);
		homePanel = new JPanel();
		homePanel.setLayout(null);
		homePanel.setBounds(22, 5, 440, 435);
		homePanel.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1, true));

		JButton signUp = new JButton("SignUp");
		JButton logIn = new JButton("Login");

		signUp.setBounds(90, 130, 250, 35);
		signUp.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1, true));
		signUp.setFocusPainted(false);
		signUp.setFont(buttFont);
		signUp.setBackground(Color.WHITE);

		logIn.setBounds(90, 210, 250, 35);
		logIn.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1, true));
		logIn.setFocusPainted(false);
		logIn.setFont(buttFont);
		logIn.setBackground(Color.WHITE);

		homeFrame.setIconImage(icon.getImage());
		homeFrame.setSize(500, 500);
		homeFrame.setLayout(null);
//		homeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		homePanel.add(signUp);
		homePanel.add(logIn);

		homeFrame.add(homePanel);

		homeFrame.setVisible(true);

		signUp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				homeFrame.dispose();
				signUp();
			}

		});

		logIn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				homeFrame.dispose();
				login();

			}

		});

	}

	public static void main(String[] args) {
		new SignUp();
	}

	public void signUp() {
		Font labelFont = new Font("SanSerif", Font.TRUETYPE_FONT, 15);
		Font buttFont = new Font("", Font.PLAIN, 16);
		errorFname.setFont(errorFont);
		errorLname.setFont(errorFont);
		errorPhone.setFont(errorFont);
		errorEmail.setFont(errorFont);
		errorPassword.setFont(errorFont);

		JLabel fNameLabel = new JLabel("First Name:");
		JLabel lNameLabel = new JLabel("Last Name:");
		JLabel passwordLabel = new JLabel("Password:");
		JLabel pCLabel = new JLabel("Confirm Password:");
		JLabel phoneLabel = new JLabel("Phone:");
		JLabel emailLabel = new JLabel("Email:");
		JLabel userNameLabel = new JLabel("Username:");

		firstNameField = new JTextField();
		lastNameField = new JTextField();
		usernameField = new JTextField();
		phoneField = new JTextField();
		emailField = new JTextField();

		passwordField = new JPasswordField();
		passwordConfirmation = new JPasswordField();

		fNameLabel.setLabelFor(firstNameField);
		lNameLabel.setLabelFor(lastNameField);
		passwordLabel.setLabelFor(passwordField);
		pCLabel.setLabelFor(passwordConfirmation);
		phoneLabel.setLabelFor(phoneField);
		emailLabel.setLabelFor(emailField);
		userNameLabel.setLabelFor(usernameField);

		fNameLabel.setBounds(5, 10, 100, 25);
		fNameLabel.setFont(labelFont);
		firstNameField.setBounds(150, 10, 270, 25);
		firstNameField.setFont(labelFont);
		firstNameField.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1, true));
		errorFname.setBounds(fNameLabel.getWidth() + 2, fNameLabel.getY() + 3, 20, 20);

		lNameLabel.setBounds(5, 60, 100, 25);
		lNameLabel.setFont(labelFont);
		lastNameField.setBounds(150, 60, 270, 25);
		lastNameField.setFont(labelFont);
		lastNameField.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1, true));
		errorLname.setBounds(lNameLabel.getWidth() + 2, lNameLabel.getY() + 3, 20, 20);

		phoneLabel.setBounds(5, 110, 100, 25);
		phoneField.setBounds(150, 110, 270, 25);
		errorPhone.setBounds(phoneLabel.getWidth() + 2, phoneLabel.getY() + 3, 20, 20);

		emailLabel.setBounds(5, 160, 100, 25);
		emailField.setBounds(150, 160, 270, 25);
		errorEmail.setBounds(emailLabel.getWidth() + 2, emailLabel.getY() + 3, 20, 20);

		phoneLabel.setFont(labelFont);
		phoneField.setFont(labelFont);
		emailLabel.setFont(labelFont);
		emailField.setFont(labelFont);
		phoneField.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1, true));
		emailField.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1, true));

		userNameLabel.setBounds(5, 210, 180, 25);
		usernameField.setBounds(150, 210, 270, 25);
		userNameLabel.setFont(labelFont);
		usernameField.setFont(labelFont);
		usernameField.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1, true));

		passwordLabel.setBounds(5, 260, 100, 25);
		passwordField.setBounds(150, 260, 270, 25);
		passwordLabel.setFont(labelFont);
		passwordField.setFont(labelFont);
		errorPassword.setBounds(passwordLabel.getWidth() + 2, passwordLabel.getY() + 3, 20, 20);
		passwordField.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1, true));

		pCLabel.setBounds(5, 310, 180, 25);
		passwordConfirmation.setBounds(150, 310, 270, 25);
		pCLabel.setFont(labelFont);
		passwordConfirmation.setFont(labelFont);
		passwordConfirmation.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1, true));

		ButtonGroup gender = new ButtonGroup();
		male = new JRadioButton("Male");
		female = new JRadioButton("Female");
		JButton submitButton = new JButton("Submit");
		JButton resetButton = new JButton("Reset");
		JButton homeButton = new JButton("Home");
		gender.add(male);
		gender.add(female);
		female.setFont(labelFont);
		male.setFont(labelFont);

		submitButton.setBounds(80, 395, 80, 30);
		submitButton.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1, true));
		submitButton.setFocusPainted(false);
		submitButton.setFont(buttFont);
		submitButton.setBackground(Color.WHITE);

		resetButton.setBounds(280, 395, 80, 30);
		resetButton.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1, true));
		resetButton.setFocusPainted(false);
		resetButton.setFont(buttFont);
		resetButton.setBackground(Color.WHITE);

		homeButton.setBounds(180, 395, 80, 30);
		homeButton.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1, true));
		homeButton.setFocusPainted(false);
		homeButton.setFont(buttFont);
		homeButton.setBackground(Color.WHITE);

		male.setBounds(35, 345, 100, 30);
		female.setBounds(330, 345, 100, 30);

		signUpPanel = new JPanel();
		signUpPanel.setLayout(null);
		signUpPanel.setBounds(22, 5, 440, 435);
		signUpPanel.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1, true));

		signUpFrame.setIconImage(icon.getImage());
		signUpFrame.setSize(500, 500);
		signUpFrame.setLayout(null);
//		signUpFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		signUpPanel.add(fNameLabel);
		signUpPanel.add(firstNameField);

		signUpPanel.add(lNameLabel);
		signUpPanel.add(lastNameField);

		signUpPanel.add(passwordLabel);
		signUpPanel.add(passwordField);

		signUpPanel.add(pCLabel);
		signUpPanel.add(passwordConfirmation);

		signUpPanel.add(phoneLabel);
		signUpPanel.add(phoneField);

		signUpPanel.add(userNameLabel);
		signUpPanel.add(usernameField);

		signUpPanel.add(emailLabel);
		signUpPanel.add(emailField);

		signUpPanel.add(submitButton);
		signUpPanel.add(resetButton);
		signUpPanel.add(homeButton);

		signUpPanel.add(male);
		signUpPanel.add(female);

		signUpPanel.add(errorFname);
		signUpPanel.add(errorLname);
		signUpPanel.add(errorPhone);
		signUpPanel.add(errorEmail);
		signUpPanel.add(errorPassword);

		signUpFrame.add(signUpPanel);

		signUpFrame.setVisible(true);

		homeButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				signUpFrame.dispose();
				homePage();

			}

		});

		resetButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				firstNameField.setText("");
				lastNameField.setText("");
				phoneField.setText("");
				emailField.setText("");
				usernameField.setText("");
				passwordField.setText("");
				passwordConfirmation.setText("");
				firstNameField.setForeground(Color.black);
				lastNameField.setForeground(Color.black);
				phoneField.setForeground(Color.black);
				emailField.setForeground(Color.black);
				gender.clearSelection();
				selectedGender = null;
				fName = "";
				lName = "";
				phone = "";
				email = "";
				username = "";
				password = "";

			}

		});

		submitButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				submit();

			}

		});

		passwordField.addFocusListener(new FocusAdapter() {

			@Override
			public void focusGained(FocusEvent e) {
				if (!errorPassword.getText().isEmpty()) {
					passwordField.setText("");
					passwordConfirmation.setText("");
				}

			}

		});

		firstNameField.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				if (!firstNameField.getText().isEmpty() && !errorFname.getText().isEmpty()) {
					firstNameField.setText("");
					errorFname.setText("");
				}

			}

			@Override
			public void focusLost(FocusEvent e) {
				if (!firstNameField.getText().isEmpty()) {
					Boolean valid = Pattern.matches("[A-Za-z]{3,}+", firstNameField.getText());
					if (valid) {
						fName = firstNameField.getText();
					} else {
						errorFname.setText("*");
					}
				}

			}

		});

		lastNameField.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				if (!lastNameField.getText().isEmpty() && !errorLname.getText().isEmpty()) {
					lastNameField.setText("");
					errorLname.setText("");
				}

			}

			@Override
			public void focusLost(FocusEvent e) {
				if (!lastNameField.getText().isEmpty()) {
					Boolean valid = Pattern.matches("[A-Za-z]{3,}+", lastNameField.getText());
					if (valid) {
						lName = lastNameField.getText();
					} else {
						errorLname.setText("*");
					}
				}

			}

		});

		phoneField.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				if (!phoneField.getText().isEmpty() && !errorPhone.getText().isEmpty()) {
					phoneField.setText("");
					errorPhone.setText("");
				}

			}

			@Override
			public void focusLost(FocusEvent e) {
				if (!phoneField.getText().isEmpty()) {
					Boolean valid = Pattern.matches("(\\+234||0)[7-9][01][0-9]{8}", phoneField.getText());
					if (valid) {
						phone = phoneField.getText();
					} else {
						errorPhone.setText("*");
					}
				}

			}

		});

		emailField.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				if (!emailField.getText().isEmpty() && !errorEmail.getText().isEmpty()) {
					emailField.setText("");
					errorEmail.setText("");
				}

			}

			@Override
			public void focusLost(FocusEvent e) {
				if (!emailField.getText().isEmpty()) {
					Boolean valid = Pattern.matches("[a-z]+\\.?[a-z0-9_]*@[a-z0-9]+\\.?[a-z]+\\.[a-z]{2,3}+",
							emailField.getText());
					if (valid) {
						email = emailField.getText();
					} else {
						errorEmail.setText("*");
					}
				}

			}

		});

		male.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (male.isSelected()) {
					selectedGender = "male";
				}

			}

		});

		female.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (female.isSelected()) {
					selectedGender = "female";
				}

			}

		});

	}

	public void windowListener() {

		homeFrame.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				windClosing(homeFrame);
			}

		});

		signUpFrame.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				windClosing(signUpFrame);
			}

		});

		logInFrame.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				windClosing(logInFrame);
			}

		});

	}

	public void windClosing(JFrame frame) {
		if (deactivateWindowClosingNotification != 2) {
			
			String[] btn = { "Ok", "Cancel", "Deativate" };

			ImageIcon icon = new ImageIcon("src/BroCode/R.jpg");

			int response = JOptionPane.showOptionDialog(frame, "Window Closing...\nDon't want notification? Deativate!",
					"Notification", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, icon, btn, 0);
			if (response == 2) {
				deactivateWindowClosingNotification = 2;
				frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			} else {

				if (response == 0) {
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					System.exit(0);
				} else {
					frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				}
			}
		} else
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void submit() {

		String passwordString1 = "";
		String passwordString2 = "";
		char[] password1 = passwordField.getPassword();
		char[] password2 = passwordConfirmation.getPassword();

		if (password1.length != password2.length) {
			errorPassword.setText("*");
			JOptionPane.showMessageDialog(signUpFrame, "Password not matched!", "Password validation",
					JOptionPane.ERROR_MESSAGE);
			return;
		} else
			errorPassword.setText("");

		for (int i = 0; i < password1.length; i++) {
			passwordString1 += String.valueOf(password1[i]);
			passwordString2 += String.valueOf(password2[i]);
		}

		if (!passwordString1.equals(passwordString2)) {
			errorPassword.setText("*");
			JOptionPane.showMessageDialog(signUpFrame, "Password not matched!", "Password validation",
					JOptionPane.ERROR_MESSAGE);
			return;

		} else {
			password = passwordString1;
			errorPassword.setText("");
		}

		username = usernameField.getText();

		if (fName.isEmpty() || lName.isEmpty() || email.isEmpty() || phone.isEmpty() || username.isEmpty()
				|| password.isEmpty() || selectedGender == null) {

			JOptionPane.showMessageDialog(signUpFrame, "Please fill the form properly!", "Form Verification",
					JOptionPane.ERROR_MESSAGE);
			return;

		} else {

			try {
				sqlStatement = Connector.creatStatment();
				
				fName = fName.toLowerCase();
				lName = lName.toLowerCase();
				
				fName = String.valueOf(fName.charAt(0)).toUpperCase() + fName.substring(1);
				lName = String.valueOf(lName.charAt(0)).toUpperCase() + lName.substring(1);
				
				String insert = String.format("INSERT INTO login VALUES('%s','%s','%s','%s','%s','%s', '%s')", fName,
						lName, selectedGender, phone, email, username, password);
				sqlStatement.execute(insert);

				JOptionPane.showMessageDialog(signUpFrame, "You are signed up", "Sign UP",
						JOptionPane.INFORMATION_MESSAGE);
				sqlStatement.close();

				login();

			} catch (SQLSyntaxErrorException err) {
				JOptionPane.showMessageDialog(signUpFrame, "Error Occurred!", "Sign Up", JOptionPane.ERROR_MESSAGE);

			} catch (SQLException e) {
				JOptionPane.showMessageDialog(signUpFrame, "Error Occurred!", "Sign Up", JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();

			}
		}

	}

	public void login() {
		Font labelFont = new Font("SanSerif", Font.TRUETYPE_FONT, 15);
		Font buttFont = new Font("", Font.PLAIN, 15);
		logInPanel = new JPanel();
		logInPanel.setLayout(null);
		logInPanel.setBounds(22, 5, 440, 435);
		logInPanel.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1, true));

		JButton loginHomeButton = new JButton("Home");
		JButton loginButton = new JButton("Login");

		JLabel loginUsernameLabel = new JLabel("Username:");
		JTextField loginUsernameField = new JTextField();

		JLabel loginPasswordLabel = new JLabel("Password:");
		JPasswordField loginPasswordField = new JPasswordField();

		loginUsernameLabel.setBounds(50, 50, 100, 25);
		loginUsernameField.setBounds(150, 50, 230, 25);
		loginUsernameLabel.setFont(labelFont);
		loginUsernameField.setFont(labelFont);
		loginUsernameField.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1, true));

		loginPasswordLabel.setBounds(50, 100, 100, 25);
		loginPasswordField.setBounds(150, 100, 230, 25);
		loginPasswordLabel.setFont(labelFont);
		loginPasswordField.setFont(labelFont);
		loginPasswordField.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1, true));

		loginButton.setBounds(100, 180, 80, 30);
		loginButton.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1, true));
		loginButton.setFocusPainted(false);
		loginButton.setFont(buttFont);
		loginButton.setBackground(Color.WHITE);

		loginHomeButton.setBounds(250, 180, 80, 30);
		loginHomeButton.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1, true));
		loginHomeButton.setFocusPainted(false);
		loginHomeButton.setFont(buttFont);
		loginHomeButton.setBackground(Color.WHITE);

		logInFrame.setIconImage(icon.getImage());
		logInFrame.setSize(500, 500);
		logInFrame.setLayout(null);
		logInPanel.add(loginHomeButton);
		logInPanel.add(loginButton);

		logInPanel.add(loginUsernameLabel);
		logInPanel.add(loginUsernameField);
		logInPanel.add(loginPasswordLabel);
		logInPanel.add(loginPasswordField);
		logInFrame.add(logInPanel);

		logInFrame.setVisible(true);

		loginHomeButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				logInFrame.dispose();
				homePage();

			}

		});

		loginButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String username = loginUsernameField.getText();
				String password = "";
				char[] charPassword = loginPasswordField.getPassword();
				for (char n : charPassword) {
					password += String.valueOf(n);

				}

				String query = String.format(
						"SELECT FirstName, Username, Password From login WHERE username='%s' and password='%s'",
						username, password);

				try {
					sqlStatement = Connector.creatStatment();
					ResultSet rs = sqlStatement.executeQuery(query);

					while (rs.next()) {
						if (!String.valueOf(rs.getString("password")).isEmpty()) {
							loginUsernameField.setText("");
							loginPasswordField.setText("");
							String name = String.valueOf(rs.getString("firstname")).toLowerCase();

							name = String.valueOf(name.charAt(0)).toUpperCase() + String.valueOf(name).substring(1);

							JOptionPane.showMessageDialog(logInFrame, "Welcome, " + name, "Login",
									JOptionPane.INFORMATION_MESSAGE);
							sqlStatement.close();
							return;
						}

					}

					JOptionPane.showMessageDialog(logInFrame, "Your login credentials are invalid!", "Login",
							JOptionPane.INFORMATION_MESSAGE);

					sqlStatement.close();

				} catch (SQLException ex) {
					ex.printStackTrace();
				}

			}

		});

	}

}
