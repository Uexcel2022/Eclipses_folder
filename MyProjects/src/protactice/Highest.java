package protactice;

public class Highest {

	int[] numbers = { 8, 80, 10, 1, 50, 1, 4, -81, 81, 39, 74 };

	String[] strings = { "  ", "come", null, "Independence", "Chocolate", "Hi", "", "Hippopotamous", "Discovery",
			"Computer" };
	String emt = "";

	public static void main(String[] args) {

		Highest h = new Highest();
		System.out.println("Highest number: " + h.isHighest());
		System.out.println("Lowest number: " + h.isLowest());
		System.out.println("Longest word: " + h.isLongest());
		System.out.println("Shortest word: " + h.isShortest());

	}

	public int isHighest() {
		int highest = numbers[0];
		for (int n : numbers) {
			if (n > highest) {
				highest = n;
			}
		}
		return highest;
	}

	public int isLowest() {
		int lowest = numbers[0];
		for (int n : numbers) {
			if (n < lowest) {
				lowest = n;
			}
		}
		return lowest;
	}

	public String isLongest() {
		String longest = "";
		for (int i = 0; i < strings.length; i++) {
			if (strings[i] != null && !strings[i].isBlank()) {
				longest = strings[i];
				break;
			}
		}
		
		for (String n : strings) {
			if (n != null && !n.isBlank()) {
				if (n.length() > longest.length()) {
					longest = n;
				}
			}

		}
		return longest;
	}

	public String isShortest() {
		String shortest = "";
		for (int i = 0; i < strings.length; i++) {
			if (strings[i] != null && !strings[i].isBlank()) {
				shortest = strings[i];
				break;
			}
		}

		for (String n : strings) {
			if (n != null && !n.isBlank()) {
				if (n.length() < shortest.length()) {
					shortest = n;
				}
			}
		}

		return shortest;
	}

}
