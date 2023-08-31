package brocode;
import javax.swing.*;
import java.awt.*;

public class ProgressBar {
 // Progress bar = visual aid to let the user know that an operation is in progress
	
	JFrame frame;
	JProgressBar bar;
	JPanel panel;
	JLabel label; 
	
	public static void main(String[] args) {
		new ProgressBar();
	}
	
	public ProgressBar() {
		frame = new JFrame("Progress Bar");
		bar = new JProgressBar(0,100); //Min/Max value;
//		bar.setValue(0);
		bar.setBounds(50,160,300,30 );
		bar.setStringPainted(true);
		bar.setFont(new Font("MV Boli",Font.BOLD, 20));
		bar.setBackground(Color.black);
		bar.setForeground(Color.RED);
		
		
		
		frame.add(bar);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420, 420);
		frame.setLayout(null);
     	frame.setVisible(true);
     	
     	fill();
	}
	
	public void fill() {
		int counter = 0;
		while(counter <= 100) {
			bar.setValue(counter);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			counter += 10;
		}
		bar.setString("Done! :)");
	}
}






















