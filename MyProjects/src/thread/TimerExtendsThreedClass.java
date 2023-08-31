package thread;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class TimerExtendsThreedClass extends Thread {
	JFrame frame;
	JLabel timeoutLabel;
	int mins = 3;
	int secs = 59;

	public void run() {
		displayFrame();
	}

	public void display() throws InterruptedException {

		for (int i = 177; i >= 0; i--) {
			Thread.sleep(1000);
			if (secs == 0) {
				mins--;
				secs = 59;
			}
			if (mins >= 0) {
				if(i!=0) {
				String n = (secs > 9)? Integer.toString(secs) : "0"+Integer.toString(secs);
				timeoutLabel.setText("0"+Integer.toString(mins) + " : " + n);
				secs--;
				} else timeoutLabel.setText( "00 : 00");
			}
		}
	
		JOptionPane.showMessageDialog(frame, "Game Over", "Notification", JOptionPane.INFORMATION_MESSAGE);
		System.exit(0);
	}

	public void displayFrame() {
		Font font = new Font(null, Font.PLAIN, 40);
		frame = new JFrame("Countdown Timer");
		frame.setSize(400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createLineBorder(Color.lightGray, 3, true));
		timeoutLabel = new JLabel();
		timeoutLabel.setFont(font);
		timeoutLabel.setText("0"+Integer.toString(mins) + " : 00");
		panel.add(timeoutLabel);
		frame.add(panel);
		frame.setVisible(true);
		try {
			display();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		TimerExtendsThreedClass timer = new TimerExtendsThreedClass();
		timer.start();

	}

}
