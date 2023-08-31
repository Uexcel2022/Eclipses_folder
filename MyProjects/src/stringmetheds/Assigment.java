package stringmetheds;

import java.util.Scanner;

public class Assigment {

	public static void main(String[] args) {
		Assigment md = new Assigment();

		String string;
		String userOption;
		String previousChange = "";

		System.out.println("Welcome...");
		System.out.println("Please note!!!");
		System.out.println("This application offers a very limited string manipution options.");
		System.out.println("We do hope you'll find it helpful.");
		Scanner sc = new Scanner(System.in);
		System.out.print("\nEnter a string: ");
		string = sc.nextLine().trim();
		System.out.println("\n__________OPTIONS__________");
		System.out.println("U __ Make all letters uppercase");
		System.out.println("L __  Make all letters lowercase case");
		System.out.println("R __ Reverse the string");
		System.out.println("C __ Change of occurrences of ch1 to ch2 eg [C A T] C  ch1=A  ch2=T");
		System.out.println("Z __ Undo the most recent changes");

		do {
			System.out.print("\nChoose an options or enter x to exit: ");
			userOption = sc.nextLine().trim();
			if (!userOption.equalsIgnoreCase("X")) {
				if (userOption.equalsIgnoreCase("U")) {
					previousChange = string;
					String upperCase = string.toUpperCase();
					string = upperCase;

				} else if (userOption.equalsIgnoreCase("L")) {
					previousChange = string;
					String lowerCase = string.toLowerCase();
					string = lowerCase;
				} else {
					if (userOption.charAt(0) == 'C' || userOption.charAt(0) == 'c' && userOption.length() == 5) {
						int isSpaced = md.checkIspaced(userOption);
						if (isSpaced == 4) {
							String[] valid = userOption.split(" ");
							previousChange = string;
							String newString = md.replaceChar(string, valid[1], valid[2]);
							if (newString != null) {
								string = newString;
							} else
								System.err.println("\nFailed! The character to be replaced is not in the string.\n");

						} else
							System.err.println("\nIncorrect input. Expected format [x x x] eg [Cc Oo Aa].");

					} else if (userOption.equalsIgnoreCase("R")) {
						previousChange = string;
						String reverseString = "";
						int lastIndext = string.length() - 1;
						for (int i = lastIndext; i >= 0; i--) {
							reverseString += (string.charAt(i));
						}
						string = reverseString;

					} else if (userOption.equalsIgnoreCase("Z")) {
						string = previousChange;
					} else
						System.err.println("You have made an invalid selection");
				}
			}
		} while (!userOption.equalsIgnoreCase("x"));

		System.out.println("\n" + string);
		sc.close();
	}

	public int checkIspaced(String userInput) {
		int isSpaced = 0;
		for (int i = 0; i < userInput.length(); i++) {
			if (i == 1 || i == 3) {
				if (String.format("%s", userInput.charAt(i)).isBlank()) {
					isSpaced += i;
				}
			}
		}
		return isSpaced;
	}

	public String relaceAllChars(String string, String replace, String replacement) {
		for (int i = 0; i < string.length(); i++) {
			if (String.valueOf(string.charAt(i)).equals(replace.toUpperCase())) {
				return string.replace(replace.toUpperCase(), replacement);
			}
		}

		for (int i = 0; i < string.length(); i++) {
			if (String.valueOf(string.charAt(i)).equals(replace)) {
				return string.replace(replace, replacement);
			}
		}

		return null;
	}

	public String replaceChar(String string, String replace, String replacement) {
		boolean isIn = false;
		char[] sort = string.toCharArray();
		String newString = " ";
		for (char i : sort) {
			if (String.valueOf(i).equalsIgnoreCase(replace)) {
				newString += replacement;
				isIn = true;
			} else
				newString += String.valueOf(i);
		}
		if (isIn) {
			return newString;
		} else {
			return null;
		}
	}

	public String replaceCharWithLoop(String string, String replace, String replacement) {
		boolean isIn = false;
		String newString = " ";
		for (int i = 0; i < string.length(); i++) {
			if (String.format("%s", string.charAt(i)).equalsIgnoreCase(replace)) {
				newString += replacement;
				isIn = true;
			} else
				newString += String.format("%s", string.charAt(i));
		}
		if (isIn) {
			return newString;
		} else {
			return null;
		}
	}
}
