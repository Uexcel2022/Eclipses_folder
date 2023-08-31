package numberguess;

import java.util.Random;

import javax.swing.JOptionPane;

public class OptionPaneStyle {
	static int random = 0;

	public OptionPaneStyle() {
		random = randomNumber();
	}

	public static void main(String[] args) {
		new OptionPaneStyle();
		int userGuess = 0;
		int attempts = 0;

		do {
			try {
				userGuess = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter a number frem 1-80:"));
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Invalid input");
				continue;
			}

			if (userGuess == random) {
				attempts++;
				JOptionPane.showMessageDialog(null, "Congratulation! \nNumber of attempts: " + attempts);
			} else {
				if (userGuess > random) {
					attempts++;
					JOptionPane.showMessageDialog(null, "Too hight!");
				} else {
					attempts++;
					JOptionPane.showMessageDialog(null, "Too low!");
				}

			}

		} while (userGuess != random);

	}

	public int randomNumber() {
		Random random = new Random();
		int number = random.nextInt(1, 81);
		return number;
	}

}
