package regex;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class CredentialsValidation extends JFrame implements ActionListener {
	ImageIcon icon;
	JTextField emailField;
	JPasswordField passwordField;
	JLabel label;
	char[] password;
	private String validPassword;

	CredentialsValidation() {
		Font font = new Font(null, Font.PLAIN, 15);
		Font font2 = new Font(null, Font.TRUETYPE_FONT, 16);
//		Font font3 = new Font(null, Font.TRUETYPE_FONT, 13);
		
		icon = new ImageIcon("R.jpg");
		this.setIconImage(icon.getImage());
		this.setLayout(new FlowLayout());
		this.setTitle("Sign up");
		this.setSize(450, 150);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(380, 150));
		JButton submitButton = new JButton("Validate");
		JButton resetButton = new JButton("Reset");
		submitButton.setFocusPainted(false);
		resetButton.setFocusPainted(false);

		label = new JLabel();

		JLabel emailLabel = new JLabel("Email ID:");
		JLabel passwordLabel = new JLabel("Password:");
		emailField = new JTextField(20);
		passwordField = new JPasswordField(19);
		emailLabel.setLabelFor(emailField);
		passwordLabel.setLabelFor(passwordLabel);
		emailField.setFont(font);
		passwordField.setFont(font);
		emailLabel.setFont(font2);
		passwordLabel.setFont(font2);
		
		
		

		panel.add(emailLabel);
		panel.add(emailField);
		panel.add(passwordLabel);
		panel.add(passwordField);
		panel.add(resetButton);
		panel.add(submitButton);

		submitButton.addActionListener(this);
		resetButton.addActionListener(this);

		this.add(panel);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent event) {

		if (event.getActionCommand().equals("Validate")) {

			Boolean isValidPassord = validatePassword();
			Boolean isValidEmail = validateEmail();

			if (isValidPassord && isValidEmail) {
				JOptionPane.showMessageDialog(null,
						"Email: " + emailField.getText() + "\nPassword: " + validPassword + "\nStatus: Valid",
						"Validation", JOptionPane.INFORMATION_MESSAGE);

			} else if (emailField.getText().isEmpty() && passwordField.getPassword().length == 0) {
				JOptionPane.showMessageDialog(null, "The form is empty!", "Validation",
						JOptionPane.INFORMATION_MESSAGE);

			} else if (emailField.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "The email address field is empty!", "Validation",
						JOptionPane.INFORMATION_MESSAGE);

			} else if (passwordField.getPassword().length == 0) {
				JOptionPane.showMessageDialog(null, "The password field is empty!", "Validation",
						JOptionPane.INFORMATION_MESSAGE);
			}

			else if (!isValidEmail) {
				JOptionPane.showMessageDialog(null, "Invalid email address!", "Validation",
						JOptionPane.INFORMATION_MESSAGE);

			} else if (!isValidPassord) {
				JOptionPane.showMessageDialog(null, "Invalid password! \nPassword example: T23!u345", "Validation",
						JOptionPane.INFORMATION_MESSAGE);
			}

		}

		if (event.getActionCommand() == "Reset") {
			emailField.setText("");
			passwordField.setText("");
			validPassword = "";
		}

	}

	public Boolean validatePassword() {

		String[][] arrays = {

				{ "[A-Z]+[a-z]\\W[A-Z]*" }, { "[A-Z]+[a-z]\\W" }, { "[A-Z]+\\W[a-z]" },

				{ "[A-Z][a-z]+\\W" }, { "[a-z][A-Z]+\\W" },

				{ "[A-Z][a-z]+\\W[a-z]*" }, { "[a-z][A-Z]+\\W[A-Z]*" },

				{ "[A-Z]+\\W[A-Z]*[a-z][A-Z]*" }, { "[a-z]+\\W[a-z]*[A-Z][a-z]*" },

				{ "[\\W][a-z][A-Z]+" }, { "[\\W][A-Z][a-z]+" },

				{ "[A-Z][0-9]+[a-z]\\W[0-9]*" }, { "[a-z][0-9]+[A-Z]\\W[0-9]*" }, { "[A-Z][0-9]+[a-z]\\W" },

				{ "[a-z][0-9]+[A-Z]\\W" },

				{ "[0-9]*\\W[0-9]*[A-Z][a-z][0-9]*" }, { "[0-9]*\\W[0-9]*[a-z][A-Z][0-9]*" },

				{ "[0-9]*[A-Z][0-9]*\\W[a-z][0-9]*" }, { "[0-9]*[A-Z][0-9]*[a-z]\\W[0-9]*" },

				{ "[0-9]*[a-z][0-9]*\\W[A-Z][0-9]*" }, { "[0-9]*[a-z][0-9]*[A-Z]\\W[0-9]*" },

				{ "[0-9]*[A-Z][0-9]*\\W[0-9]*[a-z][0-9]*" }, { "[0-9]*[A-Z][0-9]*[a-z][0-9]*\\W[0-9]*" },

				{ "[0-9]*[a-z][0-9]*\\W[0-9]*[A-Z][0-9]*" }, { "[0-9]*[a-z]*[0-9]*[A-Z][0-9]*\\W[0-9]*" },

				{ "[0-9]*\\W[0-9]*[A-Z][0-9]*[a-z][0-9]*" }, { "[0-9]*\\W[0-9]*[a-z][0-9]*[A-Z][0-9]*" },

				{ "[a-z]*[0-9]*[a-z]*[a-z]*\\W[a-z0-9]*[A-Z]" },

				{ "[a-z]*[0-9]*[a-z0-9]*\\W[a-z]*[a-z0-9]*[A-Z][0-9a-z]*" },

				{ "[a-z]*\\W[a-z]*[A-Z][a-z]*[0-9]?[a-z]*" }, { "[a-z]*\\W[a-z]*[0-9]?[a-z]*[A-Z][a-z]*" },

				{ "[a-z]*[0-9]*[a-z]*[A-Z][a-z]*\\W[a-z0-9]*" }, { "[a-z]*[0-9]*[a-z]*[A-Z][a-z]*\\W[a-z]*[0-9a-z]*" },

				{ "[a-z]*[A-Z][a-z]*\\W[a-z]*[0-9][a-z]*" }, { "[a-z]*[A-Z][a-z]*[0-9]*[a-z]*\\W[a-z0-9]*" },

				{ "[0-9]*[A-Z][0-9]*[a-z0-9]*\\W[0-9]*[a-z]?[0-9]*" },

		};

		for (String[] n : arrays) {

			char[] password = passwordField.getPassword();

			String passwordInput = convertPassword(password);

			Boolean isFound = Pattern.matches(n[0], passwordInput);

			if (isFound && passwordInput.length() == 8) {
				validPassword = passwordInput;
				return true;
			}
		}
		return false;

	}

	public Boolean validateEmail() {
		Pattern pattern = Pattern.compile("[a-z]+\\.?[a-z0-9_]*@[a-z0-9]+\\.?[a-z]+\\.[a-z]{2,3}+");
		Matcher match = pattern.matcher(emailField.getText());
		Boolean isFound = match.matches();
		return isFound;

	}

	public String convertPassword(char[] charPassword) {
		String password = "";

		for (int i = 0; i < charPassword.length; i++) {
			password += charPassword[i];
		}

		return password;
	}

}
