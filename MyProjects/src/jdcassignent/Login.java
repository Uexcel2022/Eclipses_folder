package jdcassignent;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



@SuppressWarnings("serial")
public class Login extends JFrame implements ActionListener {
	Font titleFont = new Font("Dialog", Font.CENTER_BASELINE,30);
	JButton loginStudentButton;
	JButton registerButton;
	JButton loginAdminButton;
	JPanel sidePanel;
	JLabel stitleLabel;
	
	
	Login(){
		
		homeFrame();
	}
	
	
	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getActionCommand().equals("Register")) {
			 this.dispose();
			new StudentForm();
		}
		
		if(event.getActionCommand().equals("Login")) {
			 this.dispose();
			new QueryStudent();
		}
		
		if(event.getActionCommand().equals("Administrator")) {
			 this.dispose();
			new AdminLogin();
		}
		
		
		
	}
	
	public void homeFrame() {
		
		registerButton = new JButton("Register");
		registerButton.setFocusPainted(false);
		registerButton.setBounds(10,30,80, 25);
		registerButton.setBackground(Color.decode("#757C88"));
		registerButton.setForeground(Color.white);
		registerButton.setBorder(null);
		
		loginStudentButton = new JButton("Login");
		loginStudentButton.setFocusPainted(false);
		loginStudentButton.setBounds(10,50,80, 25);
		loginStudentButton.setBackground(Color.decode("#757C88"));
		loginStudentButton.setForeground(Color.white);
		loginStudentButton.setBorder(null);
		
		loginAdminButton = new JButton("Administrator");
		loginAdminButton.setFocusPainted(false);
		loginAdminButton.setBounds(10,80,80, 25);
		loginAdminButton.setBackground(Color.decode("#757C88"));
		loginAdminButton.setForeground(Color.white);
		loginAdminButton.setBorder(null);
		
		loginStudentButton.addActionListener(this);
		registerButton.addActionListener(this);
		loginAdminButton.addActionListener(this);
		
		JLabel stitleLabel = new JLabel("DIAMOND UNIVERSITY");
		stitleLabel.setForeground(Color.decode("#051094"));
		stitleLabel.setFont(titleFont);
		stitleLabel.setBounds(250, 5, 400, 30);
		
		JLabel studentInf = new JLabel("Students corner");
		studentInf.setForeground(Color.white);
		studentInf.setBounds(10,5,150, 30);
		
		JPanel sidePanel = new JPanel();
		sidePanel.setLayout(null);
		sidePanel.setPreferredSize(new Dimension(100, 800));
		sidePanel.setBounds(1,0, 120,800);
		sidePanel.setBackground(Color.decode("#757C88"));
		sidePanel.add(studentInf);
		sidePanel.add(registerButton);
		sidePanel.add(loginStudentButton);
		sidePanel.add(loginAdminButton);
		
		JPanel loginPanel = new JPanel();
		loginPanel.setPreferredSize(new Dimension(200, 200));
		loginPanel.setBounds(250,100, 300,200);
		loginPanel.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1,true));
		
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(null);
		mainPanel.setBackground(Color.decode("#ECF3F9"));
		mainPanel.setPreferredSize(new Dimension(800,800));
		mainPanel.add(stitleLabel);
		mainPanel.add(sidePanel);
		mainPanel.add(loginPanel);
		
		
		this.setTitle("Home");
		this.setSize(800, 800);
		this.setLayout(new FlowLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(mainPanel);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Login();
	}

}
