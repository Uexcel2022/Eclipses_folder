package brocode;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class Slider implements ChangeListener {

	// JSlider = GUI Component that lets user enter a value
	// using a adjustable sliding knob on track
	// 

	JFrame frame;
	JPanel panel;
	JLabel label;
	JSlider slider;

	public static void main(String[] args) {
		new Slider();
	}

	public Slider() {
		frame = new JFrame("Slider Demo");
		panel = new JPanel();
		label = new JLabel();
		slider = new JSlider(0,100,50);
		
		slider.setPreferredSize(new Dimension(400,200));	
		panel.setPreferredSize(new Dimension(400, 420));
		
		
		slider.setPaintTicks(true);
		slider.setMinorTickSpacing(5);
		slider.setMajorTickSpacing(25);
		slider.setPaintLabels(true);
		
		
		slider.setFont(new Font("MV Boli",Font.PLAIN, 16));
		label.setFont(new Font("MV Boli",Font.TYPE1_FONT, 20));
		
		slider.setOrientation(SwingConstants.VERTICAL);
		
		slider.addChangeListener(this);
		
		slider.setBounds(150, 30, 100, 250);
		label.setBounds(160,  250, 100, 100);
		
		label.setText("°C: "+slider.getValue());

        
		panel.setLayout(null);
		panel.add(slider);
		panel.add(label);
		frame.add(panel);
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420, 420);
		frame.setLayout(new FlowLayout(FlowLayout.CENTER));
     	frame.setVisible(true);
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		if(e.getSource()==slider) {
			label.setText("°C: "+slider.getValue());
		}

	}

}
