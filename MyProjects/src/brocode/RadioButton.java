package brocode;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

@SuppressWarnings("serial")
public class RadioButton extends JFrame implements ActionListener {

	// JRadio Button = one or more button in grouping in which only may be selected
	// per go
	
	// YOU CAN ADD IMAGE AS THE BUTTON
	//  create the ImageIcon obj;
	// use buttonName.setIcon(obj)
	
	JRadioButton meatPie;
	JRadioButton friedChicken;
	JRadioButton shawama;

	public RadioButton() {

		meatPie = new JRadioButton("Meat Pie");
		friedChicken = new JRadioButton("Fried Chicken");
		shawama = new JRadioButton("Shawama");

		ButtonGroup btnGroup = new ButtonGroup();

		btnGroup.add(meatPie);
		btnGroup.add(friedChicken);
		btnGroup.add(shawama);
		
		meatPie.setFocusPainted(false);
		friedChicken.setFocusPainted(false);
		friedChicken.setFocusPainted(false);

		this.add(meatPie);
		this.add(friedChicken);
		this.add(shawama);

		meatPie.addActionListener(this);
		friedChicken.addActionListener(this);
		shawama.addActionListener(this);

		this.setLayout(new FlowLayout());
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
	}

	public static void main(String[] args) {
		new RadioButton();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == meatPie) {
			System.out.println("You've ordered meat pie!");
		} else if (e.getSource() == friedChicken) {
			System.out.println("You've ordered fried chicken!");
		} else if (e.getSource() == shawama) {
			System.out.println("You've ordered shawama!");
		}

	}
}
