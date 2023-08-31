package hangmangame;

import java.util.Random;
import java.util.Scanner;

public class CountriesArray {
	String[] countriesArray;
	Random rd;
	int index;
	String country;
	Scanner sc;
	String letter;
	int failedGuesses = 0;
	String[] countryCharArray;
	String[] dashCharArray;
	String missedLetters = "";
	String[] newdashes;

	public CountriesArray() {
		countriesArray = new String[13];
		countriesArray[0] = "Nigeria";
		countriesArray[1] = "Germany";
		countriesArray[2] = "Mali";
		countriesArray[3] = "Israel";
		countriesArray[4] = "France";
		countriesArray[5] = "Egypt";
		countriesArray[6] = "Ivorycoast";
		countriesArray[7] = "Cameroon";
		countriesArray[8] = "Venizuella";
		countriesArray[9] = "Canada";
		countriesArray[10] = "Australia";
		countriesArray[11] = "Japan";
		countriesArray[12] = "Russia";
		rd = new Random();
		sc = new Scanner(System.in);
	}

	private void display() {
		if (failedGuesses <= 2) {
			for (String n : dashCharArray) {
				System.out.print(n);
			}
			if (!missedLetters.isEmpty()) {
				System.err.println("\nMissed letters: " + missedLetters + "\n");
			}
		}
	}

	public static void main(String[] args) {
		CountriesArray ac = new CountriesArray();
		ac.generateDashes();
		ac.check();
//

	}

	public void getCountry() {
		index = rd.nextInt(countriesArray.length);
		country = countriesArray[index];

		countryCharArray = new String[country.length()];
		dashCharArray = new String[country.length()];

		for (int i = 0; i < country.length(); i++) {
			countryCharArray[i] = String.valueOf(country.charAt(i));
		}

	}

	public String getCountryName() {
		index = rd.nextInt(countriesArray.length);
		country = countriesArray[index];

		return country;
	}

	public void generateDashes() {
		getCountry();

		for (int i = 0; i < country.length(); i++) {
			dashCharArray[i] = "-";
		}
	}

	public void check() {
		String[] countryMatched = new String[country.length()];
		newdashes = new String[country.length()];
		String count = "";

		do {
			do {
				for (String n : dashCharArray) {
					System.out.print(n);
				}
				System.out.print("\nEnter a letter: ");
				letter = sc.nextLine();
				if (letter.length() == 1) {
					break;
				} else
					System.err.println("Enter only one character!");
			} while (letter.length() != 1);

			boolean matched = false;
			for (int i = 0; i < countryCharArray.length; i++) {
				if (countryCharArray[i] != null && countryCharArray[i].equalsIgnoreCase(letter)) {
					newdashes[i] = countryCharArray[i];
					countryMatched[i] = countryCharArray[i];
//					dashCharArray[i] = countryCharArray[i];
//					countryCharArray[i] = null;
					matched = true;
//					break;
				} else
					newdashes[i] = dashCharArray[i];
			}
			dashCharArray = newdashes;

			if (!matched) {
				failedGuesses++;
				if (!missedLetters.contains(letter)) {
					missedLetters += letter + ' ';
				}
			}
			count = "";
			for (String n : countryMatched) {
				count += n;
			}

			if (failedGuesses > 2) {
				System.err.println("Failed");
				System.out.println("Country: " + country);
				return;
			}

		} while (!count.equalsIgnoreCase(country));

		display();

	}

}
