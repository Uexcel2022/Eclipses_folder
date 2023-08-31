package brocode;


	import java.awt.FlowLayout;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;

	import javax.swing.JButton;
	import javax.swing.JCheckBox;
	import javax.swing.JFrame;

	@SuppressWarnings("serial")
	public class CheckBox extends JFrame implements ActionListener {
		JCheckBox notRobot;
		JCheckBox age;
		JCheckBox agreed;
		JButton btn;
		
		//For Image
		// ImageIcon  name;

		CheckBox() {

			notRobot = new JCheckBox("I'm not a Robot");
			age = new JCheckBox("I'm 18+");
			agreed = new JCheckBox("I agreed");
			btn = new JButton("Summit");
			notRobot.setFocusPainted(false);
			age.setFocusPainted(false);
			btn.setFocusPainted(false);
			
			// YOU CAN CHNAGE CHECKBOX TO IMAGE
			// name = new ImgeIcon(eg src/BroCode/R.jpg)
			// add Icon eg age.setIcon(name)
			//  age.setSelectedIcon(name)
			
			
	        btn.addActionListener(this);
			this.add(notRobot);
			this.add(age);
			this.add(agreed);
			this.add(btn);
			this.setLayout(new FlowLayout());
			this.setVisible(true);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.pack();

		}

		public static void main(String[] args) {
			new CheckBox();

		}

		@Override
		public void actionPerformed(ActionEvent e) {
	         if(e.getSource()==btn) {
	        	 if(notRobot.isSelected()&&  age.isSelected() && agreed.isSelected()) {
	        		 System.out.println("You have been registed!");
	        	 } else {
	        		 System.out.println("You are not qualified!");
	        	 }
	         }
		}

	}

	
	
	

