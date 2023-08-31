package gui;
import javax.swing.JButton;
import javax.swing.JFrame;
//import java.awt.*;


import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Font;



import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.JTextField;
import javax.swing.ImageIcon;


@SuppressWarnings("serial")
public class Beginner extends JFrame {

	Font font = new Font("Ink Free", Font.BOLD, 25);

	public Beginner() {

		super("New Frame Title");
//		FlowLayout fl = new FlowLayout();
		BorderLayout bl = new BorderLayout();
		setLayout(bl);

		JButton btn1 = createButton("Button 1 text");

		JButton btn2 = createButton("Button 2 text");
		add(btn2);

		JPanel buttonPanel = new JPanel();
		buttonPanel.setBackground(Color.orange);
		add(buttonPanel, BorderLayout.SOUTH);
		buttonPanel.add(btn1);
		buttonPanel.add(btn2);

		JPanel formPanel = new JPanel();
		formPanel.setBorder(BorderFactory.createLineBorder(Color.black,  15, true));
//		formPanel.setBackground(Color.blue);
		GridLayout gl = new GridLayout();
		formPanel.setLayout(gl);
		gl.setColumns(2);
		gl.setRows(2);
		gl.setHgap(20);
		gl.setVgap(10);


		JPanel centerPanel = new JPanel();
		centerPanel.setBackground(Color.green);
		centerPanel.add(formPanel);
		add(centerPanel, BorderLayout.CENTER);
		
		JLabel fname = createLabel("First-Name");
		formPanel.add(fname);

		JTextField fNameField = createTextField("First-Name-Field");
		formPanel.add(fNameField);

		JLabel lname = createLabel("Last-Name");
		formPanel.add(lname);

		JTextField lNameField = createTextField("Last-Name-Field");
		lNameField.setText("New-Field");
		formPanel.add(lNameField);

		JButton btn3 = createButton("Button 3 text");
		buttonPanel.add(btn3);

		JLabel title = createLabel("Simple Java Swing");
		add(title, BorderLayout.NORTH);
		
		setVisible(true);
		getContentPane().setBackground(Color.pink);
		setResizable(true);
		setDefaultCloseOperation(Beginner.EXIT_ON_CLOSE);
//		setSize(450, 350);
		pack();
		setLocationRelativeTo(null);

	}

	public static void main(String[] args) {
		new Beginner();
//		new Image();
	}

	
	JLabel createLabel(String text) {
		JLabel label = new JLabel(text);
		label.setForeground(Color.red);
		label.setFont(font);
		label.setHorizontalAlignment(JLabel.CENTER);

		return label;
	}

	JTextField createTextField(String defaultText) {
		JTextField fNameField = new JTextField(defaultText, 15);
		fNameField.setFont(font);
		fNameField.setBackground(Color.black);
		fNameField.setForeground(Color.yellow);
		fNameField.setCaretColor(Color.green);

		return fNameField;
	}

	JButton createButton(String text) {

		JButton btn1 = new JButton(text);
//		btn1.setText(text);
		btn1.setToolTipText("Click here to login...");
		btn1.setFocusable(false);
		btn1.setBackground(Color.black);
		btn1.setForeground(Color.yellow);

		btn1.setFont(font);
		btn1.setFont(new Font("Comic Sans MS", Font.BOLD, 25));

		return btn1;

	}

}

@SuppressWarnings("serial")
class Image extends JFrame{
	
	public Image() {
		
		setLayout(new FlowLayout());
		
		ImageIcon im = new ImageIcon("src/GUI/R.jpg");
//		MenuBar bar = new MenuBar();
		setIconImage(im.getImage());
//		getContentPane().setBackground(Color.orange);
		setSize(260, 150);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}

	
	
	
}



