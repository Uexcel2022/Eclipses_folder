package workingwithenum;

import java.util.Scanner;

enum gender {
	Male, Female, M, F
}

public class Enums {

	String name;
	String enums;
	int p;

	enum status {
		Pending, Done, Successful, Failed
	};

	@Override
	public String toString() {
		return String.format("%s %s", name, enums);
	}

	public static void main(String[] args) {
		courses.getAllScore();
		System.out.println("\nTo update score one by one:\n");
		courses.updateScore();
		System.out.println("\nTo up many score: \n");
		courses.reviewScore();
	}

	public void info(String name, status enums) {

		this.name = name;
		this.enums = String.format("%s", enums);
	}

	enum courses {

		Java(73), SQL(69), Python(78), HTML5(76);

		private int score;

		private courses(int price) {

			this.score = price;
		}

		private courses() {

			score = 0;
		}

		public int getScore() {
			return score;
		}

		public void setScore(int score) {
			this.score = score;
		}

		public static void reviewScore() {
			System.out.println("--------------Options--------------\n* Enter new score  OR" 
					+ "\n* Enter -1 to skipp it or -2 to exit.");
			int score;
			boolean modified = false;
			Scanner sc = new Scanner(System.in);
			for (courses items : courses.values()) {
				System.out.println(items + ": " + items.score);

				do {
					System.out.print("Enter: ");
					score = sc.nextInt();
					if (score == -1) {
						break;
					} else if (score == -2) {
						break;
					} else if (score < 0 || score > 100) {
						System.err.println("Invalid score range of < 0 or > 100");
						continue;
					} else {
						items.setScore(score);
						modified = true;
						break;
					}
				} while (true);

				if (score == -2) {
					break;
				}
			}

			if (modified) {
				System.out.println("Current Score: ");
				for (courses items : courses.values()) {
					System.out.println(items + ": " + items.score);
				}
			} else
				System.err.println("No changes were made to the scores");
			sc.close();
		}

		public static void getAllScore() {
			System.out.println("Course and Score");
			for (courses i : courses.values()) {
				System.out.println(String.valueOf(i + ": " + i.getScore()));
			}
		}

		public static void updateScore() {
			String name;
			Scanner sc = new Scanner(System.in);
			do {
				System.out.print("Enter course or -1 to exit: ");
				name = sc.nextLine();
				if (name.equalsIgnoreCase("-1")) {
					System.out.println("Exit");
					break;
				}
				boolean found = false;
				for (courses i : courses.values()) {
					String stockItem = String.valueOf(i);
					if (stockItem.equalsIgnoreCase(name)) {
						System.out.print("Update " + i + " score: ");
						int score = Integer.parseInt(sc.nextLine());
						i.setScore(score);
						System.out.println("New " + i + " score : " + i.getScore());
						found = true;
					}
				}
				if (found == false)
					System.err.println("\nCourse not found. Verify you have not entered incorrect name\n");

			} while (true);
			if (name == "a%fty27!@") {
				sc.close();
			}
		}

	}

}
