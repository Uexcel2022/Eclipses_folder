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
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class AdminTable {

	public static void insert() {
		Font font = new Font("Dialog", Font.PLAIN, 16);
		JLabel loginTitle = new JLabel("Adminstrator Table");
		loginTitle.setForeground(Color.DARK_GRAY);
		loginTitle.setBounds(20, 20, 400, 25);
		loginTitle.setFont(new Font("", Font.BOLD, 25));

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setPreferredSize(new Dimension(285, 350));
		panel.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1, true));

		JLabel usernameberLabel = new JLabel("Username: ");
		JTextField usernameField = new JTextField();
		JLabel passwordLabel1 = new JLabel("Password");
		JPasswordField passwordField1 = new JPasswordField();

		JLabel comfirmPassordLabel2 = new JLabel(" Confirm Password");
		JPasswordField passwordField2 = new JPasswordField();

		JButton backButton = new JButton("Back");
		backButton.setFocusPainted(false);
		backButton.setBackground(Color.white);
		backButton.setBounds(50, 280, 70, 25);
		backButton.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1, true));

		usernameberLabel.setFont(font);
		usernameField.setFont(font);
		passwordLabel1.setFont(font);
		passwordField1.setFont(font);
		comfirmPassordLabel2.setFont(font);
		passwordField2.setFont(font);

		usernameberLabel.setBounds(20, 60, 250, 30);
		usernameField.setBounds(20, 90, 250, 30);
		passwordLabel1.setBounds(20, 125, 250, 30);
		passwordField1.setBounds(20, 160, 250, 30);

		comfirmPassordLabel2.setBounds(20, 200, 250, 30);
		passwordField2.setBounds(20, 235, 250, 30);

		JButton insetButton = new JButton("Insert");
		insetButton.setFocusPainted(false);
		insetButton.setBounds(170, 280, 70, 25);
		insetButton.setBackground(Color.white);
		insetButton.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1, true));

		panel.add(loginTitle);
		panel.add(usernameberLabel);
		panel.add(usernameField);
		panel.add(passwordLabel1);
		panel.add(passwordField1);
		panel.add(comfirmPassordLabel2);
		panel.add(passwordField2);
		panel.add(insetButton);
		panel.add(backButton);

		JFrame frame = new JFrame("Inert Statement");
		frame.add(panel);
		frame.setLayout(new FlowLayout());
		frame.setSize(500, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		insetButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String stringPassword1 = "";
				String stringPassword2 = "";
				String saltvalue = null;

				try {
					

					char[] passwordDb1 = passwordField1.getPassword();
					char[] passwordDb2 = passwordField2.getPassword();
					if (passwordDb1.length != passwordDb2.length) {
						JOptionPane.showMessageDialog(frame, "Password mismatched!", "Validation", JOptionPane.ERROR_MESSAGE);
						return;
					}
					for (int i = 0; i < passwordDb1.length; i++) {
						stringPassword1 += passwordDb1[i];
						stringPassword2 += passwordDb1[i];
					}

					if (stringPassword1.equals(stringPassword2)) {

						saltvalue = PassBasedEnc.getSaltvalue(30);

						String encryptPassword = PassBasedEnc.generateSecurePassword(stringPassword1, saltvalue);
						
						System.out.println(saltvalue);

						String query = String.format("INSERT INTO admin(username,password,saltvalue) VALUES('%s','%s','%s')",usernameField.getText(), encryptPassword, saltvalue);
						
						Statement statement = Connector.createStatement();
						statement.executeQuery(query);

						JOptionPane.showMessageDialog(frame, "Success!", "Confirmation",JOptionPane.INFORMATION_MESSAGE);
						
						passwordField1.setText("");
						stringPassword1 = null;
						stringPassword2 = null;
						return;
					} else

						JOptionPane.showMessageDialog(frame, "Password mismatched!", "Validation", JOptionPane.ERROR_MESSAGE);

				} catch (SQLException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(frame, "We ecountered error!", "Error", JOptionPane.ERROR_MESSAGE);
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
//		AdminTable.insert();
	}

}
