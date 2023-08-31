package brocode;

import java.awt.*;
import javax.swing.*;

// you can set border layout many manager to null then Set bounds for the COMPOMENT.
// Set BorderLayout and  set BoderLayout.SOUTH,EAST WEST, NORTH OR CENTER
// WHEN ADDING COPONENT.

@SuppressWarnings("serial")
public class Layout extends JFrame {

	public Layout() {

//		borderLayout();
//		flowLayout();
		 gridLayout();

	}

	public static void main(String[] args) {
		new Layout();
	}

	public void borderLayout() {
		ImageIcon image = new ImageIcon("src/BroCode/R.jpg");
		this.setIconImage(image.getImage());
		this.setSize(500, 500);
		this.setVisible(true);
		this.setTitle("Panel");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout(10, 10)); // value for the y,x axis margin
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		JPanel panel4 = new JPanel();
		JPanel panel5 = new JPanel();
		panel1.setPreferredSize(new Dimension(100, 50)); // setting panel size/
		panel2.setPreferredSize(new Dimension(100, 50));
		panel3.setPreferredSize(new Dimension(50, 100));
		panel4.setPreferredSize(new Dimension(50, 100));
		panel5.setPreferredSize(new Dimension(100, 50));
		panel1.setBackground(Color.ORANGE);
		panel2.setBackground(Color.green);
		panel3.setBackground(Color.yellow);
		panel4.setBackground(Color.magenta);
		panel5.setBackground(Color.gray);
		this.add(panel1, BorderLayout.NORTH);
		this.add(panel2, BorderLayout.SOUTH);
		this.add(panel3, BorderLayout.EAST);
		this.add(panel4, BorderLayout.WEST);
		this.add(panel5, BorderLayout.CENTER);

//		 ADDING INNER PANEL TO THE CNTER PANEL

		panel5.setLayout(new BorderLayout());

		JPanel panel6 = new JPanel();
		JPanel panel7 = new JPanel();
		JPanel panel8 = new JPanel();
		JPanel panel9 = new JPanel();
		JPanel panel10 = new JPanel();
		panel6.setPreferredSize(new Dimension(100, 50));
		panel7.setPreferredSize(new Dimension(100, 50));
		panel8.setPreferredSize(new Dimension(50, 100));
		panel9.setPreferredSize(new Dimension(50, 100));
		panel10.setPreferredSize(new Dimension(100, 50));
		panel6.setBackground(Color.pink);
		panel7.setBackground(Color.blue);
		panel8.setBackground(Color.black);
		panel9.setBackground(Color.magenta);
		panel10.setBackground(Color.WHITE);
		panel5.add(panel6, BorderLayout.NORTH);
		panel5.add(panel7, BorderLayout.SOUTH);
		panel5.add(panel8, BorderLayout.EAST);
		panel5.add(panel9, BorderLayout.WEST);
		panel5.add(panel10, BorderLayout.CENTER);

	}
	
	public void flowLayout() {
		
		// Layout manager = Defines the natural layout for component within a container
		// FlowLayout = places components in a row, sized at their preferred size.
		//                       If the horizontal space in the container is too small,
		//                      the FlowLayout class uses the next available row
		
		
		ImageIcon image = new ImageIcon("src/BroCode/R.jpg");
		this.setIconImage(image.getImage());
		
		
        JPanel panel =new JPanel();
        panel.setPreferredSize(new Dimension(250,250));
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        
		panel.add(new JButton("1"));
		panel.add(new JButton("2"));
		panel.add(new JButton("3"));
		panel.add(new JButton("4"));
		panel.add(new JButton("5"));
		panel.add(new JButton("6"));
		panel.add(new JButton("7"));
		panel.add(new JButton("8"));
		panel.add(new JButton("9"));
		panel.setBackground(Color.gray);
		this.add(panel);
		
		this.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));// Margin
//		this.setLayout(new FlowLayout(FlowLayout.LEADING));
//		this.setLayout(new FlowLayout(FlowLayout.TRAILING));
//		this.setLayout(new FlowLayout(FlowLayout.LEFT));
//		this.setLayout(new FlowLayout(FlowLayout.RIGHT));
		this.setSize(500, 500);
		this.setVisible(true);
		this.setTitle("Panel");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public void gridLayout() {
		// Layout Manager = Defines the natural layout for component within the container
		
		// GridLayout = places components in a grid of cells.
		//                      Each component takes all the available space within its cell,
		//                      and each cells is the same size.
		
		
		JButton btn1 = new JButton();
		btn1.setPreferredSize(new Dimension(200,200));
		btn1.setBackground(Color.orange);

		JButton btn2 = new JButton();
		btn2.setPreferredSize(new Dimension(200,200));
		btn2.setBackground(Color.orange);

		JButton btn3 = new JButton();
		btn3.setPreferredSize(new Dimension(200,200));
		btn3.setBackground(Color.orange);

		JButton btn4 = new JButton();
		btn4.setPreferredSize(new Dimension(200,200));
		btn4.setBackground(Color.orange);

		JButton btn5 = new JButton();
		btn5.setPreferredSize(new Dimension(200,200));
		btn5.setBackground(Color.orange);

		JButton btn6 = new JButton();
		btn6.setPreferredSize(new Dimension(200,200));
		btn6.setBackground(Color.orange);

		JButton btn7 = new JButton();
		btn7.setPreferredSize(new Dimension(200,200));
		btn7.setBackground(Color.orange);

		JButton btn8 = new JButton();
		btn8.setPreferredSize(new Dimension(200,200));
		btn8.setBackground(Color.orange);

		JButton btn9 = new JButton();
		btn9.setPreferredSize(new Dimension(200,200));
		btn9.setBackground(Color.orange);
		
		this.add(btn1);
		this.add(btn2);
		this.add(btn3);
		this.add(btn4);
		this.add(btn5);
		this.add(btn6);
		this.add(btn7);
		this.add(btn8);
		this.add(btn9);
		
		this.setLayout(new GridLayout(3,3,10,10)); //the 3rd and 4th value is margin
		this.setSize(500, 500);
		this.setVisible(true);
		this.setTitle("Panel");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageIcon image = new ImageIcon("src/BroCode/R.jpg");
		this.setIconImage(image.getImage());
	}
}






























