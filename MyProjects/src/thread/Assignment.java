package thread;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Assignment extends Thread {
	JFrame frame;
	JPanel mainPanel;
	JPanel redLight, greenLight, yellowLight;
	Color defaultColor = Color.lightGray;


	public Assignment() {
		frame();

	}

	public void run() {
		red();

//		if (Thread.currentThread().getName() == "red") {
//			red();
//		}
//
//		if (Thread.currentThread().getName() == "green") {
//			green();
//		}
//
//		if (Thread.currentThread().getName() == "yellow") {
//			yellow();
//		}

	}

	public void red() {

		redLight.setBackground(Color.red);
		try {
			Thread.sleep(3000);
			redLight.setBackground(defaultColor);
//			Thread.sleep(7000);
			green();
			yellow();
			red();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void green() {
		try {
//			Thread.sleep(3000);
			greenLight.setBackground(Color.decode("#00FF00"));
			Thread.sleep(5000);
			greenLight.setBackground(defaultColor);
//			Thread.sleep(2000);
//			green();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void yellow() {
		try {
//			Thread.sleep(8000);
			yellowLight.setBackground(Color.yellow);
			Thread.sleep(2000);
			yellowLight.setBackground(defaultColor);
//			yellow();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void frame() {
		frame = new JFrame("Traffic Light");
		ImageIcon icon = new ImageIcon("R.jpg");
		frame.setIconImage(icon.getImage());
		frame.setSize(250, 250);
		frame.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	

		mainPanel = new JPanel();
		mainPanel.setBackground(Color.BLACK);
		mainPanel.setPreferredSize(new Dimension(70, 190));
		mainPanel.setLayout(null);

		redLight = new JPanel();
		redLight.setBounds(10, 10, 50, 50);
		redLight.setBackground(defaultColor);

		greenLight = new JPanel();
		greenLight.setBounds(10, 70, 50, 50);
		greenLight.setBackground(defaultColor);

		yellowLight = new JPanel();
		yellowLight.setBounds(10, 130, 50, 50);
		yellowLight.setBackground(defaultColor);

		mainPanel.add(redLight);
		mainPanel.add(greenLight);
		mainPanel.add(yellowLight);

		frame.add(mainPanel);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		Assignment obj = new Assignment();
		obj.start();
//		Thread redThread = new Thread(obj);
//		Thread greenThread = new Thread(obj);
//		Thread yellowThread = new Thread(obj);
//		redThread.setName("red");
//		greenThread.setName("green");
//		yellowThread.setName("yellow");
//		redThread.start();
//		greenThread.start();
//		yellowThread.start();
	}
}
