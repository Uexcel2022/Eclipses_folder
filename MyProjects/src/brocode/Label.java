package brocode;
import java.awt.Color;

import javax.swing.*;
public class Label {
	// JLabel = a GUI display area for string of text, an image.
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("My Frame");
		frame.setLayout(null);
		ImageIcon image = new ImageIcon("src/BroCode/R.jpg");
		frame.setIconImage(image.getImage());
		
		JLabel label = new JLabel("My label");
	
		label.setIcon(image);
		label.setHorizontalTextPosition(JLabel.CENTER);
//		label.setHorizontalTextPosition(JLabel.LEFT);
//		label.setHorizontalTextPosition(JLabel.RIGHT);
		label.setVerticalTextPosition(JLabel.TOP);
		label.setIconTextGap(0);
		label.setForeground(Color.WHITE);
		label.setBackground(Color.BLACK);
		label.setOpaque(true);
		label.setVerticalAlignment(JLabel.CENTER); //for Img&text
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setBounds(5, 0, 100, 100);
		frame.add(label);
//		frame.pack(); // this adjust the window to the size of the components in it.
		
		
		
		frame.setSize(500, 500);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
