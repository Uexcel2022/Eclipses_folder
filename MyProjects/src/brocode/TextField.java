package brocode;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class TextField extends JFrame implements ActionListener{
       JButton btn;
       JTextField textField;
       
	TextField(){
		
		textField = new JTextField();
		btn = new JButton("Sumit");
		btn.addActionListener(this);
		
		
		btn.setFocusPainted(false);
		textField.setBackground(Color.black);
		textField.setForeground(Color.green);
		textField.setCaretColor(Color.white);
		this.add(btn);
		this.add(textField);
		
		
		textField.setPreferredSize(new Dimension(150,25));
		this.setLayout(new FlowLayout());
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		
	}
	
	public static void main(String[] args) {
		new TextField();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btn) {
			System.out.println(textField.getText());
		}
		
	}

}
