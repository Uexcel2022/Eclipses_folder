package brocode;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class OptionPane {
	
	public static void main(String[] args) {
		
        // parent container, Message, title, maeeageType
		
//		JOptionPane.showMessageDialog(null, "Game Over", "Game", JOptionPane.INFORMATION_MESSAGE);
//		JOptionPane.showMessageDialog(null, "You're computer has a virius!!!"," Virious Infiection", JOptionPane.WARNING_MESSAGE);
//		JOptionPane.showMessageDialog(null, "Error Occured!!!","Error", JOptionPane.ERROR_MESSAGE);
//	    JOptionPane.showMessageDialog(null, "It's Awsome", "Wow!", JOptionPane.PLAIN_MESSAGE);
//		JOptionPane.showMessageDialog(null, "Reall?", "Question", JOptionPane.QUESTION_MESSAGE);
	
		
		// Confirmation: parent container, Message, title, options = buttonType	 
		
//		int option = JOptionPane.showConfirmDialog(null, "Press Yes to Continue", "Confirm", JOptionPane.YES_NO_CANCEL_OPTION);
//		 System.out.println(option);
		
		
		//Input Dialog
		
//	 String name = JOptionPane.showInputDialog("What's your name:");
//	 System.out.println(name);
		
		
		
//  parent container, Message, title, options = Buttons, messageType,
//		Icon, options = our custom Button, button to be selected
		
		String[] btn = {"Yes I am", "No I'm not", "Blushing"};

		ImageIcon icon = new ImageIcon("src/BroCode/R.jpg");
		
 int response = JOptionPane.showOptionDialog(null, "You're awsome!", "cool", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, icon, btn, 0);
 System.out.println(response);
	   	
		
	}

}
