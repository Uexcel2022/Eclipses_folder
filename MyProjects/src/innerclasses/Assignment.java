package innerclasses;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Assignment extends JFrame implements ActionListener {

	private String name;
	private String qualification;
	private int age;
	private String status;

	JTextField nameField;
	JTextField qfField;
	JTextField ageField;

	JLabel display;

	Assignment() {
		this.setTitle("IQTest");
		this.setLayout(new FlowLayout());
		this.setSize(300, 320);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		ImageIcon icon = new ImageIcon("R.jpg");
		this.setIconImage(icon.getImage());
//		JLabel label = new JLabel();
//		label.setIcon(icon);
//		this.add(label);
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setPreferredSize(new Dimension(280, 270));
		panel.setBorder(BorderFactory.createLineBorder(Color.gray, 1, true));
		JButton submitButton = new JButton("Submit");
		JButton resetButton = new JButton("Reset");
		JLabel nameLabel = new JLabel("Name:");
		JLabel qfLabel = new JLabel("Qalification:");
		JLabel ageLabel = new JLabel("Age:");
		display = new JLabel();
		nameField = new JTextField();
		qfField = new JTextField();
		ageField = new JTextField();
		nameLabel.setLabelFor(nameField);
		qfLabel.setLabelFor(qfField);
		ageLabel.setLabelFor(ageField);

		display.setBounds(20, 5, 300, 25);
		nameLabel.setBounds(20, 35, 100, 20);
		nameField.setBounds(20, 60, 250, 25);
		qfLabel.setBounds(20, 95, 150, 20);
		qfField.setBounds(20, 120, 250, 25);
		ageLabel.setBounds(20, 155, 100, 20);
		ageField.setBounds(20, 180, 250, 25);
		submitButton.setBounds(50, 230, 80, 25);
		resetButton.setBounds(150, 230, 80, 25);

		panel.add(display);
		panel.add(nameLabel);
		panel.add(nameField);
		panel.add(qfLabel);
		panel.add(qfField);
		panel.add(ageLabel);
		panel.add(ageField);
		panel.add(submitButton);
		panel.add(resetButton);
		this.add(panel);
		this.setVisible(true);

		submitButton.addActionListener(this);
		resetButton.addActionListener(this);

	}

	class Validator {
		public String validate() {
			if (nameField.getText() == null || !(nameField.getText().length() > 2)) {

				return "Invalid name!";
			}

			if (qfField.getText() == null || !(qfField.getText().length() > 2)) {
				return "Invalid qualification!";
			}
			try {
				int validAge = Integer.parseInt(ageField.getText());
				String confirm = (validAge >= 21 && validAge <= 25) ? "Accepted" : "Rejected";
				return confirm;
			} catch (NumberFormatException e) {
				return "Invalid age! Numbers Only!";
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getActionCommand().equals("Submit")) {
			Validator obj = new Validator();
			String checkStatus = obj.validate();
			if (checkStatus.equals("Accepted") || checkStatus.equals("Rejected")) {
				name = "";
				String[] splitedName = nameField.getText().split(" ");
				for (String n : splitedName) {
					n = String.valueOf(n.charAt(0)).toUpperCase() + n.substring(1);
					name += n + " ";
				}
				qualification = qfField.getText();
				age = Integer.parseInt(ageField.getText());
				status = checkStatus;
				display();
			} else
				display.setText(checkStatus);
		}

		if (event.getActionCommand().equals("Reset")) {
			name = "";
			qualification = "";
			age = 0;
			nameField.setText("");
			qfField.setText("");
			ageField.setText("");
			display.setText("");

		}

	}

	public void display() {
		this.dispose();
		ImageIcon icon = new ImageIcon("R.jpg");
		JFrame frame = new JFrame();
		frame.setTitle("IQTest");
		frame.setIconImage(icon.getImage());
		frame.setLayout(new FlowLayout());
		frame.setSize(300, 320);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(280, 270));
		panel.setBorder(BorderFactory.createLineBorder(Color.gray, 1, true));

		JButton okButton = new JButton("Ok");
		okButton.setFocusPainted(false);

		panel.setLayout(null);
		JLabel display1 = new JLabel();
		display1.setText("Name: " + name);
		JLabel display2 = new JLabel();
		display2.setText("Qualification: " + qualification);
		JLabel display3 = new JLabel();
		display3.setText(String.valueOf("Age: " + age));
		JLabel display4 = new JLabel();
		display4.setText("Status: " + status);

		display1.setBounds(20, 5, 200, 25);
		display2.setBounds(20, 35, 200, 25);
		display3.setBounds(20, 65, 200, 25);
		display4.setBounds(20, 95, 200, 25);
		okButton.setBounds(110, 140, 50, 25);

		panel.add(display1);
		panel.add(display2);
		panel.add(display3);
		panel.add(display4);
		panel.add(okButton);

		frame.add(panel);
		frame.setVisible(true);

		okButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				if (event.getActionCommand().equals("Ok")) {
					frame.dispose();
					new Assignment();
				}

			}

		});

	}

}
