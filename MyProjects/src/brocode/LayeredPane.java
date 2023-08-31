package brocode;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

public class LayeredPane {

	public static void main(String[] args) {
		JFrame frame = new JFrame("JLayeredPane");

		JLayeredPane pane = new JLayeredPane();
		pane.setBounds(0, 0, 500, 500);

		JLabel label1 = new JLabel();
		JLabel label2 = new JLabel();
		JLabel label3 = new JLabel();

		label1.setOpaque(true);
		label2.setOpaque(true);
		label3.setOpaque(true);

		label1.setBackground(Color.green);
		label2.setBackground(Color.blue);
		label3.setBackground(Color.red);

		label1.setBounds(50, 50, 150, 150);
		label2.setBounds(100, 150, 150, 150);
		label3.setBounds(150, 250, 150, 150);

		pane.add(label1, Integer.valueOf(0));
		pane.add(label2, Integer.valueOf(1));
		pane.add(label3, Integer.valueOf(2));

		frame.add(pane);
		frame.setSize(500, 500);
		frame.setVisible(true);
//		frame.setLayout(new Layout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
