package hackerrank;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.regex.Pattern;

public class GUI_AgryProfessor {
	JFrame frame;
	JTextField threshold;
	JTextField arrivalTime;
	JTextArea textArea;
	JButton ok;
	JButton reset;
	Font font;
	int numberOfStudent;
	int onTimeAririvals;
	int cancelationThreshold;

	public static void main(String[] args) {
		new GUI_AgryProfessor();

	}

	public GUI_AgryProfessor() {
		font = new Font("vardana", Font.TRUETYPE_FONT, 16);
		frame = new JFrame("Angry Professor");
		frame.setResizable(false);
		frame.setLayout(null);
		frame.getContentPane().setBackground(Color.decode("#F5F5F5"));

		Color color1 = Color.decode("#FEFEFA");
		JLabel thresholdLabel = new JLabel("Enter number of students/c-threshold [eg 4 2] :");
		threshold = new JTextField();
		thresholdLabel.setLabelFor(threshold);
		threshold.setBackground(color1);

		JLabel arrivalTimeLabel = new JLabel("Enter Arrival Time [eg -1 0 1 ...nth number] :");
		arrivalTime = new JTextField();
		thresholdLabel.setLabelFor(arrivalTime);
		arrivalTime.setBackground(color1);

		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		textArea.setBackground(color1);
		textArea.setFocusable(false);
		textArea.setBorder(BorderFactory.createLineBorder(Color.decode("#CCCDC6"), 1, true));

		JPanel panel = new JPanel();
		panel.setBackground(color1);
		panel.setBorder(BorderFactory.createLineBorder(Color.decode("#CCCDC6"), 2, true));

		ok = new JButton("OK");
		reset = new JButton("Reset");
		ok.setBackground(Color.decode("#F5F5F5"));
		reset.setBackground(Color.decode("#F5F5F5"));

		thresholdLabel.setFont(font);
		threshold.setFont(font);
		arrivalTimeLabel.setFont(font);
		arrivalTime.setFont(font);
		textArea.setFont(font);
		ok.setFont(font);
		reset.setFont(font);

		frame.add(textArea);
		textArea.setBounds(19, 2, 398, 60);
		frame.add(thresholdLabel);
		thresholdLabel.setBounds(36, 70, 386, 30);
		frame.add(threshold);
		threshold.setBounds(36, 100, 365, 30);
		frame.add(arrivalTimeLabel);
		arrivalTimeLabel.setBounds(36, 130, 386, 30);
		frame.add(arrivalTime);
		arrivalTime.setBounds(36, 160, 365, 30);
		frame.add(reset);
		reset.setBounds(70, 220, 120, 30);
		frame.add(ok);
		ok.setBounds(240, 220, 120, 30);
		frame.add(panel);
		panel.setBounds(18, 1, 400, 268);

		frame.setSize(450, 330);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		listeners();

	}
	

	public void listeners() {

		threshold.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent e) {
				
				check();

			}

			public void focusGained(FocusEvent e) {
				if (textArea.getText().contains("threshold") || textArea.getText().contains("two")) {
					threshold.setText(null);
					threshold.setForeground(Color.BLACK);
					textArea.setText(null);
					textArea.setForeground(Color.BLACK);

				}

			}

		});
		
		threshold.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if(e.getExtendedKeyCode()==10) {
					 submit();
				}
				
			}
		});
		
	 arrivalTime.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				
				if (threshold.getText().isEmpty()) {
					textArea.setText("Please input the number of studuents and cancellation \nthreshold.");
					textArea.setForeground(Color.red);
					return;
				}
				
				if(e.getExtendedKeyCode()==10) {
					
					 submit();
				}
				
			}
		});


		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 submit();

			}

		});

		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				threshold.setText(null);
				threshold.setForeground(Color.BLACK);
				arrivalTime.setText(null);
				arrivalTime.setForeground(Color.BLACK);
				textArea.setText(null);
				textArea.setForeground(Color.BLACK);
				numberOfStudent = 0;
				onTimeAririvals = 0;
				cancelationThreshold = 0;

			}

		});

	}
	
	

	public String check() {
		if (!threshold.getText().isEmpty()) {
			boolean match = Pattern.matches("[1-9]+0*\s[1-9]+0*", threshold.getText());
			if (!match) {
				threshold.setForeground(Color.red);
				textArea.setText("Invalid Input! Enter two numbers [1-1000] with space in \nbetween them.");
				textArea.setForeground(Color.red);
				return null;

			} else {
				try {
					String[] isDigitThreshold = threshold.getText().split(" ");
					numberOfStudent = Integer.parseInt(isDigitThreshold[0]);
					cancelationThreshold = Integer.parseInt(isDigitThreshold[1]);

					if (cancelationThreshold > numberOfStudent) {
						textArea.setText(
								"Invalid! The cancelation threshold is greater  than the \nnumber of  students.");
						textArea.setForeground(Color.red);
						threshold.setForeground(Color.red);
						return null;
					}

				} catch (NumberFormatException er) {
					textArea.setText("The number of students or cancellation threshold not digit.");
					threshold.setForeground(Color.red);
					textArea.setForeground(Color.red);
					return null;
				} catch (Exception er) {
					textArea.setText("Error:  The number of students or cancellation threshold may not  be digit.");
					threshold.setForeground(Color.red);
					textArea.setForeground(Color.red);
					return null;
				}
			}
		}

		if (arrivalTime.getText().isEmpty() && threshold.getText().isEmpty()) {
			textArea.setText("Please input the number of studuents, cancellation \nthreshold, and arrival time!");
			textArea.setForeground(Color.red);
			return null;
		}

		if (threshold.getText().isEmpty()) {
			textArea.setText("Please input the number of studuents and cancellation \nthreshold.");
			textArea.setForeground(Color.red);
			return null;
		}

		return "ok";
	}
	
	
	
	public void submit() {
		
		String isOK = check();

		if (isOK == "ok") {

			if (arrivalTime.getText().isEmpty()) {
				if (cancelationThreshold == 1) {
					textArea.setText("\nPlease input the arrival value.");
					textArea.setForeground(Color.red);
					numberOfStudent = 0;
					onTimeAririvals = 0;
					cancelationThreshold = 0;
					return;
				} else {
					textArea.setText("\nPlease input the arrival time values.");
					textArea.setForeground(Color.red);
					numberOfStudent = 0;
					onTimeAririvals = 0;
					cancelationThreshold = 0;
					return;
				}
			}

			boolean match = Pattern.matches("(-*[0-9]+\s*-*[0-9]*)+", arrivalTime.getText());
			if (!match) {
				arrivalTime.setForeground(Color.red);
				textArea.setText("Invalid input! Enter a number or numbers with space in \nbetween them. [-100 <= N <=100] .");
				textArea.setForeground(Color.red);
				return;
			}

			try {
				String[] isDigitArrivalTime = arrivalTime.getText().split(" ");

				if (isDigitArrivalTime.length > numberOfStudent) {
					textArea.setText(
							"Invalid! The arrival time values are greater than the \nnumber of students.");
					textArea.setForeground(Color.red);
					arrivalTime.setForeground(Color.red);
					return;
				} else {
					textArea.setForeground(Color.black);
					arrivalTime.setForeground(Color.black);
				}

		
				for (String n : isDigitArrivalTime) {
					if (Integer.parseInt(n) > 100 || Integer.parseInt(n) < -100) {
						textArea.setText("\nInvalid! The arrival time <-100 or >100");
						textArea.setForeground(Color.red);
						arrivalTime.setForeground(Color.red);
						return;

					} else if (Integer.parseInt(n) <= 0) {
						onTimeAririvals++;
					}

				}

				if (onTimeAririvals >= cancelationThreshold) {
					textArea.setText("\nNo... The class was held.");
					numberOfStudent = 0;
					onTimeAririvals = 0;
					cancelationThreshold = 0;
				} else {
					textArea.setText("\nYes... The class was cancelled.");
					numberOfStudent = 0;
					onTimeAririvals = 0;
					cancelationThreshold = 0;
				}

			} catch (NumberFormatException er) {
				textArea.setText("\nOne or more arrival time values are not digit.");
				textArea.setForeground(Color.red);
				arrivalTime.setForeground(Color.red);
			} catch (Exception er) {
				textArea.setText("\nError: arrival time computation.");
				textArea.setForeground(Color.red);
				arrivalTime.setForeground(Color.red);
			}
		}
	}
}
