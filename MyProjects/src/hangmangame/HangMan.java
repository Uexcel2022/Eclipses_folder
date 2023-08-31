package hangmangame;

import java.util.Scanner;

import exception.UdokaException;

public class HangMan {
	Scanner sc = new Scanner(System.in);

	void showmenu() {
		System.out.println("Please select an option from the following menu");
		System.out.println("1. Play Game");
		System.out.println("2. View Instruction");
		System.out.println("3. Exit Game");
	}

	void playGame() {
		String userInput;
		String word = "Love is the greatest of All";

		do {
			System.out.print("\nEnter a letter or 0: ");
			userInput = sc.nextLine().strip().toUpperCase();

			if (userInput.equalsIgnoreCase("0")) {
				System.out.println("Goodbye...");
				exitGame();

			} else if (userInput.length() != 1) {
				System.err.println("Invalid input");
				continue;

			} else {
				char letter = userInput.charAt(0);
				boolean found = false;
				for (int i = 0; i < word.length(); i++) {
					if (String.valueOf(word.charAt(i)).equalsIgnoreCase(String.valueOf(letter))) {
						found = true;
						break;
					}
				}

				if (found)
					System.out.println("\nPresent ");
				else
					System.err.println("\nNot Present");
			}

		} while (true);
	}

	void gameInstructions() {
		System.out.println("\nGame Instructions method called.");
	}

	void exitGame() {
		System.out.println("\nExit Game method called...");
		System.exit(0);
	}

	void runHangManGame() {
		int num = 0;
		showmenu();
		do {
			System.out.print("\nEnter your choice: ");
			try {
				num = Integer.parseInt(sc.nextLine());
				if (num < 1 || num > 3) {
					throw new UdokaException("The option is unavailble.");
				}
			} catch (UdokaException e) {
				System.err.println("Errior! " + e.getMessage());
				num = 0;
				continue;
			} catch (NumberFormatException e) {
				System.err.println("Error! " + "Enter the number of the menu you have chosen.");
				num = 0;
				continue;
			} catch(Exception e) {
				System.out.println("Sorry error occurred!");
			}
			
			if (num == 1) {
				playGame();
			} else if (num == 2) {
				gameInstructions();
			} else if (num == 3) {
				exitGame();
			}

		} while (num == 0);
	}

	void usingSwitch(int num) {
		switch (num) {
		case 1 -> playGame();
		case 2 -> gameInstructions();
		case 3 -> exitGame();
		default -> System.err.println("\nUnresolved");
		}
		sc.close();
	}

	void RunUsingSwitch() {
		showmenu();
		System.out.print("\nSelect:");
		int snum = sc.nextInt();
		usingSwitch(snum);
	}

}
