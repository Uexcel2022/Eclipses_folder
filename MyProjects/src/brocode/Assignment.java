package brocode;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Assignment implements ActionListener {
	JButton smsMenuBtton;
	JButton emailMenuBtton;
	JFrame menuFrame;
	JPanel menuPanel;
	JLabel menuLabel;

	JFrame smsFrame;
	JTextArea smsMessage;
	JTextField phoneNumberField;

	JFrame emailFrame;
	JTextArea emailMessage;
	JTextField emailTextField;

	JButton smsSendButton;
	JButton smsResetButton;
	JButton smsBackToMenuButton;

	JButton emailSendButton;
	JButton emailResetButton;
	JButton emailBackToMenuButton;

	Font labelFont = new Font("null", Font.PLAIN, 30);
	Font menuButtonFont = new Font("null", Font.PLAIN, 20);

	public Assignment() {
		menuFrame = frame();
		menuPanel = panel();
		menuLabel = new JLabel("MENU");
		menuFrame.add(menuPanel);

		smsMenuBtton = button("SMS");
		emailMenuBtton = button("Email");

		menuLabel.setBounds(160, 5, 300, 50);
		smsMenuBtton.setBounds(50, 70, 300, 35);
		emailMenuBtton.setBounds(50, 130, 300, 35);

		smsMenuBtton.setBackground(Color.white);
		emailMenuBtton.setBackground(Color.white);

		menuLabel.setFont(labelFont);
		smsMenuBtton.setFont(menuButtonFont);
		emailMenuBtton.setFont(menuButtonFont);

		menuPanel.add(menuLabel);
		menuPanel.add(smsMenuBtton);
		menuPanel.add(emailMenuBtton);

		smsMenuBtton.addActionListener(this);
		emailMenuBtton.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getActionCommand().equals("SMS")) {
			sms();
		}

		if (event.getActionCommand().equals("Email")) {
			email();
		}

	}

	public JFrame frame() {
		JFrame frame = new JFrame("Iz Messaging");
		ImageIcon icon = new ImageIcon("R.jpg");
		frame.setIconImage(icon.getImage());
		frame.setSize(400, 400);
		frame.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		return frame;
	}

	public JPanel panel() {
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(400, 400));
		panel.setLayout(null);
		return panel;

	}

	public JButton button(String tag) {
		JButton button = new JButton(tag);
		button.setFocusPainted(false);
		return button;

	}

	public void sms() {
		menuFrame.dispose();
		Font labelFont = new Font("null", Font.PLAIN, 20);
//		Font fieldFont = new Font("null", Font.PLAIN, 20);
		JFrame smsFrame = frame();
		JPanel smsPanel = panel();
		smsPanel.setLayout(null);

		JLabel phneLabel = new JLabel("Phone number:");
		JLabel smsLabel = new JLabel("Message:");
		smsMessage = new JTextArea();
		phoneNumberField = new JTextField();

		smsSendButton = button("Send");
		smsResetButton = button("Rest");
		smsBackToMenuButton = button("Menu");

		smsFrame.add(smsPanel);

		phneLabel.setFont(labelFont);
		smsLabel.setFont(labelFont);

		phneLabel.setBounds(50, 3, 300, 50);
		phoneNumberField.setBounds(50, 50, 300, 35);
		smsLabel.setBounds(50, 95, 300, 35);
		smsMessage.setBounds(50, 140, 300, 70);
		smsResetButton.setBounds(50, 230, 80, 30);
		smsSendButton.setBounds(162, 230, 80, 30);
		smsBackToMenuButton.setBounds(270, 230, 80, 30);

		phoneNumberField.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1, true));
		smsMessage.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1, true));

		smsPanel.add(phneLabel);
		smsPanel.add(phoneNumberField);
		smsPanel.add(smsLabel);
		smsPanel.add(smsMessage);

		smsPanel.add(smsSendButton);
		smsPanel.add(smsResetButton);
		smsPanel.add(smsBackToMenuButton);

		smsResetButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				phoneNumberField.setText("");
				smsMessage.setText("");

			}

		});

		smsSendButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				DateFormat dFDate = DateFormat.getDateInstance(DateFormat.LONG, Locale.getDefault());
				String date = dFDate.format(new Date());

				DateFormat dFTime = DateFormat.getTimeInstance(DateFormat.LONG, Locale.getDefault());
				String time = dFTime.format(new Date());
//				System.out.println("Cell Number: " +phoneNumberField.getText());
//				System.out.println("Massage: " +smsMessage.getText());
//				System.out.println(date + " " + time);

				JOptionPane
						.showMessageDialog(null,
								"Cell Number: " + phoneNumberField.getText() + "\nMassage: " + smsMessage.getText()
										+ "\nReceived " + date + " " + time,
								"Message", JOptionPane.INFORMATION_MESSAGE);

			}

		});

		smsBackToMenuButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				smsFrame.dispose();
				new Assignment();

			}

		});

	}

	public void email() {
		menuFrame.dispose();
		Font labelFont = new Font("null", Font.PLAIN, 20);
//		Font fieldFont = new Font("null", Font.PLAIN, 20);

		emailFrame = frame();
		JPanel emailPanel = panel();
		emailPanel.setLayout(null);
		emailFrame.add(emailPanel);

		JLabel emailLabel = new JLabel("Email ID:");
		JLabel messageLabel = new JLabel("Message:");
		emailMessage = new JTextArea();
		emailTextField = new JTextField();

		emailLabel.setFont(labelFont);
		messageLabel.setFont(labelFont);

		emailSendButton = button("Send");
		emailResetButton = button("Rest");
		emailBackToMenuButton = button("Menu");

		emailLabel.setBounds(50, 3, 300, 50);
		emailTextField.setBounds(50, 50, 300, 35);
		messageLabel.setBounds(50, 95, 300, 35);
		emailMessage.setBounds(50, 140, 300, 70);
		emailResetButton.setBounds(50, 230, 80, 30);
		emailSendButton.setBounds(162, 230, 80, 30);
		emailBackToMenuButton.setBounds(270, 230, 80, 30);

		emailMessage.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1, true));
		emailTextField.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1, true));

		emailPanel.add(emailLabel);
		emailPanel.add(emailTextField);
		emailPanel.add(messageLabel);
		emailPanel.add(emailMessage);
		emailPanel.add(emailResetButton);
		emailPanel.add(emailSendButton);
		emailPanel.add(emailBackToMenuButton);

		emailResetButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				emailTextField.setText("");
				emailMessage.setText("");

			}

		});

		emailSendButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String[] splittedEmail = emailTextField.getText().split("@");
			

				if (splittedEmail[0].equals("udokaexcellence")) {
					DateFormat dFDate = DateFormat.getDateInstance(DateFormat.LONG, Locale.getDefault());
					String date = dFDate.format(new Date());

					DateFormat dFTime = DateFormat.getTimeInstance(DateFormat.LONG, Locale.getDefault());
					String time = dFTime.format(new Date());

//				System.out.println(date + " " + time);

					JOptionPane
							.showMessageDialog(null,
									"Email ID: " + emailTextField.getText() + "\nMassage: " + emailMessage.getText()
											+ "\nReceived " + date + " " + time,
									"Message", JOptionPane.INFORMATION_MESSAGE);
				}

			}

		});

		emailBackToMenuButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				emailFrame.dispose();
				new Assignment();

			}

		});

	}
}
