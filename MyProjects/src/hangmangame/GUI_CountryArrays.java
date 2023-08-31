package hangmangame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class  GUI_CountryArrays {
	String country;
	String failed = "";
	String currentTextArea = "";
	String dashes = "";
	JTextArea textfield2;
	JButton backToMenuButton;
	Integer failedThreshold = 0;
	char[] textArea;
	
	public static void main(String[] args) {
		new GUI_CountryArrays();
	}

	public GUI_CountryArrays() {

		Font font = new Font("New Time Roman", Font.TYPE1_FONT, 22);
		Font menuTextFont = new Font("New Time Roman", Font.TYPE1_FONT, 16);

		JFrame menuFrame = new JFrame("Lassic Jumble Game");
		JPanel panel = new JPanel();
		JLabel mainLabel = new JLabel("CLASSIC JUMBLE WORD");
		JButton playGameButton = new JButton("Play Game");
		JButton instructionButton = new JButton("View Instructions");
		JButton exitButton = new JButton("Exit Game");

		GridLayout g = new GridLayout();
		g.setColumns(10);
		g.setHgap(4);
		g.setRows(5);
		g.setVgap(15);

		mainLabel.setFont(font);
		playGameButton.setFont(menuTextFont);
		instructionButton.setFont(menuTextFont);
		exitButton.setFont(menuTextFont);

		panel.setLayout(g);
		panel.add(mainLabel);
		panel.add(playGameButton);
		panel.add(instructionButton);
		panel.add(exitButton);
		menuFrame.add(panel);

		menuFrame.setLayout(new FlowLayout());
		menuFrame.setSize(350, 260);
		menuFrame.setVisible(true);
		menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		playGameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuFrame.dispose();
				JTextField texfield1 = new JTextField(10);
				textfield2 = new JTextArea();
				textfield2.setEditable(false);
				getCountry();

				Font font = new Font("New Time Roman", Font.TYPE1_FONT, 22);
				Font labelFont = new Font("New Time Roman", Font.TYPE1_FONT, 16);
				Font textFieldFont = new Font("New Time Roman", Font.TYPE1_FONT, 15);
				JFrame PlayGameFrame = new JFrame("Lassic Jumble Game");
				JPanel mainPanel = new JPanel();
				JPanel buttonPanel = new JPanel();
				JPanel panel3 = new JPanel();
				JLabel mainLable = new JLabel("CLASSIC JUMBLE WORD");
				JLabel textFied1Label = new JLabel("Enter a letter:");
				JLabel textField2Label = new JLabel("Contry:");
				JButton resetButton = new JButton("Reset");
				backToMenuButton = new JButton("Back To Menu");

				GridLayout gridLayout1 = new GridLayout();
				GridLayout gridLayout2 = new GridLayout();
				mainLable.setLabelFor(textfield2);
				textFied1Label.setLabelFor(texfield1);
				textField2Label.setLabelFor(textfield2);

				gridLayout1.setRows(7);
				gridLayout1.setColumns(1);
				gridLayout1.setVgap(5);
				gridLayout2.setHgap(10);
				gridLayout2.setRows(1);
				gridLayout2.setVgap(5);

				buttonPanel.setLayout(gridLayout2);
				panel3.setLayout(gridLayout2);

				mainLable.setFont(font);
				textFied1Label.setFont(labelFont);
				textField2Label.setFont(labelFont);
				texfield1.setFont(textFieldFont);
				textfield2.setFont(textFieldFont);
				resetButton.setFont(menuTextFont);
				backToMenuButton.setFont(menuTextFont);

				mainPanel.setLayout(gridLayout1);
				mainPanel.add(mainLable);
				mainPanel.add(textFied1Label);
				mainPanel.add(texfield1);
				mainPanel.add(textField2Label);
				mainPanel.add(textfield2);
				mainPanel.add(panel3);
				buttonPanel.add(resetButton);
				buttonPanel.add(backToMenuButton);
				mainPanel.add(buttonPanel);
				PlayGameFrame.add(mainPanel);

				PlayGameFrame.setLayout(new FlowLayout());
				PlayGameFrame.setSize(350, 320);
				PlayGameFrame.setVisible(true);
				PlayGameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
				
				texfield1.addKeyListener(new KeyAdapter() {
					public void keyTyped(KeyEvent e) {
						
						if (failedThreshold > 2) {
							texfield1.setText("Failed attempt!");
							texfield1.setForeground(Color.RED);
							texfield1.setEnabled(false);
						}
						
						if (!currentTextArea.equals(country)) {
							if (!(String.valueOf(country.toLowerCase())
									.contains(String.valueOf(e.getKeyChar()).toLowerCase()))) {
								if (!String.valueOf(e.getKeyChar()).isEmpty()
										&& !failed.contains(String.valueOf(e.getKeyChar()))
										&& !String.valueOf(e.getKeyChar()).equals("")) {
									failed += e.getKeyChar();
									failedThreshold ++;
								}
							}
							

							for (int i = 0; i < country.length(); i++) {
								if (String.valueOf((country.toLowerCase()).charAt(i))
										.equals((String.valueOf(e.getKeyChar()).toLowerCase()))) {
									textArea[i] = country.charAt(i);
									failedThreshold = 0;
								}
							}
							

							currentTextArea = "";
							for (char a : textArea) {
								currentTextArea += a;
							}
							textfield2.setText(currentTextArea);
						}
					}

					public void keyReleased(KeyEvent e) {

						if (currentTextArea.equals(country)) {
							if (failed.length() > 0) {
								texfield1.setText("Wrong guess(es): " + failed);
								texfield1.setForeground(Color.RED);
							} else {
								texfield1.setText("No wrong guess!");

							}
						}
						
						
					}

				});
				

				resetButton.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						texfield1.setEnabled(true);
						texfield1.setText(null);
						texfield1.setForeground(Color.BLACK);
						currentTextArea = "";
						failedThreshold = 0;
						getCountry();

					}

				});
				
				
				backToMenuButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						PlayGameFrame.dispose();
						new GUI_CountryArrays();
					}

				});
			}
		});
		

		exitButton.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				System.exit(0);
				menuFrame.setDefaultCloseOperation(0);
			}
		});

	}

	public void getCountry() {
		dashes = "";
		CountriesArray ar = new CountriesArray();
		country = ar.getCountryName();
		for (int i = 0; i < country.length(); i++) {
			dashes += "-";
		}
		textfield2.setText(dashes);
		textArea = dashes.toCharArray();
		failed = "";
	}

}