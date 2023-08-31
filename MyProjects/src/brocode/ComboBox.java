package brocode;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class ComboBox extends JFrame implements ActionListener {
	// JComboBox = A component that combines a button or editable editable field and drop-down list
	// works with Array of reference(of raper class) data type  that will passed into the constructor;
	@SuppressWarnings("rawtypes")
	JComboBox comboBox;
	
	public static void main(String[] args) {
		new ComboBox();
	}

	public ComboBox() {
		String[] animal = {"goat", "dog", "cat", "bird"};
		
		comboBox = new JComboBox<String>(animal);
		
//		comboBox.setEditable(true);
//		System.out.println(comboBox.getItemCount());
//		comboBox.addItem("rat");
//		comboBox.insertItemAt("dove",0);
//		comboBox.setSelectedIndex(0);
//		comboBox.removeItemAt(2);
//		comboBox.removeItem("bird");
//		comboBox.removeAllItems();
		
		comboBox.addActionListener(this);
		this.add(comboBox);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500, 500);
		this.setTitle("Combo Box");
		this.setLayout(new FlowLayout());
		this.pack();
		this.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==comboBox) {
			System.out.println(comboBox.getSelectedItem());
//			System.out.println(comboBox.getSelectedIndex());
		}
		
	}
	
}
