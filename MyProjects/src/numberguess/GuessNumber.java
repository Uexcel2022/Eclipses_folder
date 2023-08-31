package numberguess;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class GuessNumber {
	int randomNum;
	int attempts;
	JFrame frame;
	JButton enterBtn;
	JButton resetBtn;
	JPanel panel;
	JLabel label;
	JTextField numGuessed;
	JTextArea result;

	public static void main(String[] args) {
		new GuessNumber();
	}

	public GuessNumber() {
		frame = new JFrame();
		frame.setResizable(false);
		panel = new JPanel();
		frame.setLayout(null);
		panel.setLayout(null);
		Font font = new Font("consolas", Font.TRUETYPE_FONT, 13);
		ImageIcon img = new ImageIcon("src/BroCode/R.jpg");
//		ImageIcon img2 = new ImageIcon("src/NumberGuess/refresh.png");
		
		
		frame.setIconImage(img.getImage());

		enterBtn = new JButton("Enter");
		resetBtn = new JButton("Reset");
		label = new JLabel("Guess a number from 1 - 80:");
		numGuessed = new JTextField();
		label.setLabelFor(numGuessed);
		result = new JTextArea();
		result.setEditable(false);

		result.setBounds(10, 10, 200, 35);
		label.setBounds(23, 55, 300, 25);
		numGuessed.setBounds(23, 80, 175, 25);
		result.setFont(font);
		result.setBorder(BorderFactory.createLineBorder(Color.decode("#BCC6CC"), 1, true));
		numGuessed.setFont(font);
		numGuessed.setBorder(BorderFactory.createLineBorder(Color.decode("#BCC6CC"), 1, true));

		enterBtn.setSize(100, 36);
		enterBtn.setBounds(23, 120, 70, 25);
		resetBtn.setBounds(128, 120, 70, 25);
		panel.setBounds(17, 0, 220, 150);
//		enterBtn.setFocusable(false);
//		resetBtn.setFocusable(false);
		resetBtn.setFocusPainted(false);
		enterBtn.setFocusPainted(false);
//		resetBtn.setIcon(img2);
		resetBtn.setBorder(BorderFactory.createLineBorder(Color.decode("#BCC6CC"), 1));
		enterBtn.setBorder(BorderFactory.createLineBorder(Color.decode("#BCC6CC"), 1));
	
	

		panel.add(label);
		panel.add(numGuessed);
		panel.add(enterBtn);
		panel.add(resetBtn);
		panel.add(result);
		panel.setBackground(Color.decode("#DADBDD"));
		panel.setBorder(BorderFactory.createLineBorder(Color.decode("#98AFC7"), 1, true));
		frame.add(panel);

		frame.setTitle("Guess Number");
		frame.setVisible(true);
		frame.setSize(270, 204);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		randomNum = randomNumber();
		Listeners();
	}

	public int randomNumber() {
		Random random = new Random();
		int number = random.nextInt(1, 81);
		return number;
	}

	public void comparism() {
		try {
			int userGuess = Integer.parseInt(numGuessed.getText());

			if (randomNum == userGuess) {
				attempts++;
				result.setText("Success! \nNumber of attempts: " + attempts);
			} else if (userGuess > randomNum) {
				result.setText("Too high!");
				attempts++;
			} else {
				result.setText("Too Low!");
				attempts++;
			}
		} catch (NumberFormatException e) {
			result.setText("Invalid input!");
			result.setForeground(Color.red);
			numGuessed.setForeground(Color.red);
		}

	}

	public void Listeners() {
		enterBtn.addActionListener(e -> {
			if (!result.getText().contains("Success!") && !result.getText().contains("reset...")) {
				comparism();
			} else {
				result.setText("Please reset...");
			}

		});

		numGuessed.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				if (!result.getText().contains("Success!") && !result.getText().contains("reset...")) {
					numGuessed.setText(null);
					result.setText(null);
					result.setForeground(Color.black);
					numGuessed.setForeground(Color.black);

				}

			}
		});

		resetBtn.addActionListener(e -> {
			numGuessed.setText(null);
			result.setText(null);
			attempts = 0;
			result.setForeground(Color.black);
			numGuessed.setForeground(Color.black);
			randomNum = randomNumber();

		});

	}

}
