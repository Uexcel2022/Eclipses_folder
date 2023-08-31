package localization;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PuzzleGame extends JFrame implements ActionListener {

	JLabel greeting;
	JLabel language;
	JComboBox<String> comboBox;

	String comboBoxSlecetedItem;
	ResourceBundle en = ResourceBundle.getBundle("myBundle", Locale.US);
	ResourceBundle fr = ResourceBundle.getBundle("myBundle", Locale.FRANCE);
	ResourceBundle de = ResourceBundle.getBundle("myBundle", Locale.GERMANY);
	ImageIcon icon = new ImageIcon("R.jpg");

	String message;
	String menu;
	String playGame;
	String viewInstructions;
	String exitGame;
	JLabel menuLabel;

	String[] Languages = { "English", "France", "Germany" };
	Font greetingFont = new Font(null, Font.PLAIN, 30);
	Font LanguageFont = new Font(null, Font.PLAIN, 15);

	public PuzzleGame() {

		this.setSize(400, 400);
		this.setTitle("Puzzle");
		this.setLayout(new FlowLayout());
		this.setIconImage(icon.getImage());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		comboBox = new JComboBox<String>();
		comboBox.setBounds(100, 160, 200, 30);
		for (String n : Languages) {
			comboBox.addItem(n);
		}

		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(400, 400));
		panel.setLayout(null);

		greeting = new JLabel("Welcome");
		language = new JLabel("Choose Languge");
		greeting.setBounds(100, 80, 200, 30);
		language.setBounds(100, 120, 200, 30);
		greeting.setFont(greetingFont);
		language.setFont(LanguageFont);

		panel.add(greeting);
		panel.add(language);
		panel.add(comboBox);
		this.add(panel);
		this.setVisible(true);
		comboBox.addActionListener(this);
		message();

	}

	public void message() {

		while (comboBoxSlecetedItem == null) {

			greeting.setText(en.getString("message"));
			language.setText(en.getString("language"));

			try {
				TimeUnit.SECONDS.sleep(3);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			greeting.setText(fr.getString("message"));
			language.setText(fr.getString("language"));

			try {
				TimeUnit.SECONDS.sleep(3);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			greeting.setText(de.getString("message"));
			language.setText(de.getString("language"));

			try {
				TimeUnit.SECONDS.sleep(3);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}

	@Override
	public void actionPerformed(ActionEvent event) {

		if (comboBox.getSelectedItem().equals("France")) {
			menu = fr.getString("menu").toUpperCase(Locale.FRANCE);
			playGame = fr.getString("playGame");
			viewInstructions = fr.getString("viewInstructions");
			exitGame = fr.getString("exit");
			menuLabel = new JLabel(menu);
			menuLabel.setBounds(120, 3, 300, 40);

		} else if (comboBox.getSelectedItem().equals("English")) {
			menu = en.getString("menu").toUpperCase(Locale.US);
			playGame = en.getString("playGame");
			viewInstructions = en.getString("viewInstructions");
			exitGame = en.getString("exit");
			menuLabel = new JLabel(menu);
			menuLabel.setBounds(150, 3, 300, 40);

		} else if (comboBox.getSelectedItem().equals("Germany")) {
			menu = de.getString("menu").toUpperCase(Locale.US);
			playGame = de.getString("playGame");
			viewInstructions = de.getString("viewInstructions");
			exitGame = de.getString("exit");
			menuLabel = new JLabel(menu);
			menuLabel.setBounds(100, 3, 300, 40);
		}
		comboBoxSlecetedItem = (String) comboBox.getSelectedItem();
		menuFrame();

	}

	public void menuFrame() {
		
		this.dispose();
		Font font = new Font(null, Font.PLAIN, 25);

		JFrame frame = new JFrame();
		frame.setSize(400, 400);
		frame.setTitle("Puzzle");
		frame.setIconImage(icon.getImage());
		frame.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(400, 400));
		panel.setLayout(null);

		JButton playGameButton = new JButton(playGame);
		JButton viewInstructionsButton = new JButton(viewInstructions);
		JButton exitButton = new JButton(exitGame);

		menuLabel.setFont(greetingFont);

		playGameButton.setFont(font);
		playGameButton.setBounds(50, 57, 300, 40);
		playGameButton.setFocusPainted(false);
		playGameButton.setBackground(Color.white);

		viewInstructionsButton.setBounds(50, 117, 300, 40);
		viewInstructionsButton.setFont(font);
		viewInstructionsButton.setBackground(Color.white);
		viewInstructionsButton.setFocusPainted(false);

		exitButton.setBounds(50, 177, 300, 40);
		exitButton.setFocusPainted(false);
		exitButton.setFont(font);
		exitButton.setBackground(Color.white);

		panel.add(menuLabel);
		panel.add(playGameButton);
		panel.add(viewInstructionsButton);
		panel.add(exitButton);

		frame.add(panel);
		frame.setVisible(true);

	}

}
