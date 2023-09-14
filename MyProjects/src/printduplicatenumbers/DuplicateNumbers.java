package printduplicatenumbers;

import java.util.Arrays;

public class DuplicateNumbers {

	public static void printDuplicateNumbers(Integer[] numbers) {

		String duplicateNubers = "";
		String[] stringNumArray = {};
		for (int i = 0; i < numbers.length; i++) {
			for (int j = i + 1; j < numbers.length; j++) {
				if (numbers[i] == numbers[j]) {
					boolean invalidate = false;
					for (String n : stringNumArray) {
						if (n.equals(numbers[i].toString())) {
							invalidate = true;
							break;
						}
					}
					if (!invalidate) {
						duplicateNubers += numbers[j] + " ";
						stringNumArray = duplicateNubers.split(" ");
						break;
					}
				}
			}

		}

		System.out.println("String of duplicate numbers: " + duplicateNubers);
		System.out.println("Array of duplicate numbers: " + Arrays.toString(stringNumArray));

	}

	public static void main(String[] args) {
		Integer[] numbers = { 1, 33, 6, 33, 7, 3, 1, 3, 2 };
		DuplicateNumbers.printDuplicateNumbers(numbers);
	}

}
