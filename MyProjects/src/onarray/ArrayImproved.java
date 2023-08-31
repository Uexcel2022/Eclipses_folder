package onarray;

import java.util.Scanner;

import checkgrade.Grade;
/* 
* FUNCTIONALITIES
* Accept number of courses and course name via input from scanner;
* Validates number of courses and course name;
* Allows editing of course array list (removal or replacement of a course)
* Accept score for each of the courses;
* Validates score (0<= score <=100)
* Allows score array editing on two options (changes(suggestions) and change(specific))
* Display final result including Average score and Grade.
* Constraint - number of courses:  Minimum = 3 and Maximum = 10 and course duplicate is prevented)
*/

public class ArrayImproved {
	Scanner sc = new Scanner(System.in);
	private int numberOfCources;
	private String[] courseName = { "Java", "SQL", "HTML5", "Python", "Logic", "Javascript" };
	private String[] courses;
	int[] scores;
	private int j = 0;
	private int option;

	public static void main(String[] args) {
		ArrayImproved ar = new ArrayImproved();
		ar.singleArray();
	}

	void singleArray() {
		Grade ck = new Grade();

		do {
			System.out.print("Number of courses: ");
			numberOfCources = Integer.parseInt(sc.nextLine());
			if (numberOfCources < 3 || numberOfCources > 10) {
				System.err.println("Error! Minimum number of cources is 3  and Maximum is 10");
				numberOfCources = 0;
			}
		} while (numberOfCources < 3);

		courses = new String[numberOfCources];
		scores = new int[numberOfCources];

		while (j < courses.length) {
			boolean validCourseName = false;
			boolean repeated = false;
			System.out.print((j + 1) + ". Course name: ");
			String course = sc.nextLine();
			for (int i = 0; i < j; i++) {
				if (courses[i].equalsIgnoreCase(course)) {
					repeated = true;
					break;
				}
			}

			if (repeated) {
				System.err.println("You have entered " + course + " already");
				continue;

			} else {
				for (String name : courseName) {
					if (name.equalsIgnoreCase(course)) {
						validCourseName = true;
						courses[j] = name;
						break;
					}
				}

				if (!validCourseName) {
					System.err.println("You have entered an invalid course ");
					continue;
				}
			}

			j++;
		}
		do {
			int count = 1;
			for (String n : courses) {
				if (n != null) {
					System.out.println(count + ". " + n);
					count++;
				}
			}
			System.out.println("-----Options-----\n1. Make Changes \n2. Ok ");
			System.out.print("Choose option: ");
			option = Integer.parseInt(sc.nextLine());
			if (option == 1) {
				setCourse();
			} else if (option == 2) {
				setScore();
				while (true) {
					for (int i = 0; i < scores.length; i++) {
						if (courses[i] != null) {
							System.out.println((i + 1) + ". " + courses[i] + ": " + scores[i]);
						}
					}
					System.out.println("------Options----\n1. Make Changes \n2. Ok ");
					System.out.print("Choose option: ");
					option = Integer.parseInt(sc.nextLine());
					if (option == 1) {
						System.out.println("------Options----\n1. Changes \n2. Change");
						System.out.print("Choose option: ");
						option = Integer.parseInt(sc.nextLine());
						if (option == 1) {
							ReSetScore();
						} else
							ReSetAScore();
					} else if (option == 2) {
						break;
					} else
						System.out.println("You made an invalid selection");
				}
				break;
			} else
				System.out.println("You have made an invalid selection");
		} while (option != 2);

		System.out.println("\nCourse and Score:");
		int totalScore = 0;
		int finalNumberOfcourses = 0;
		for (int i = 0; i < numberOfCources; i++) {
			if (courses[i] != null) {
				totalScore += scores[i];
				finalNumberOfcourses++;
				System.out.println(String.format("%s: %s ", courses[i], scores[i]));
			}
		}

		int avgScore = (int) (totalScore / finalNumberOfcourses);
		System.out.println("Average score: " + avgScore);
		String grade = ck.checkGrade2(avgScore);
		System.out.println("Overall Grade: " + grade);
		sc.close();
	}

	public void setScore() {
		for (int i = 0; i < courses.length; i++) {
			if (courses[i] != null) {
				do {
					System.out.print("Score for " + courses[i] + ": ");
					int score = Integer.parseInt(sc.nextLine());
					if (score > 100 || score < 0) {
						String check = (score < 0) ? "Invalid score: Score(%) < 0" : "Invalid score: Score(%) > 100";
						System.err.println(check);
					} else {
						scores[i] = score;
						break;
					}
				} while (true);
			}
		}

	}

	public void ReSetScore() {
		for (int i = 0; i < courses.length; i++) {
			if (courses[i] != null) {
				System.out.println("Score for " + courses[i] + ": " + scores[i]);
				do {
					System.out.print("Enter new score or -1 to skip: ");
					int score = Integer.parseInt(sc.nextLine());
					if (score == -1) {
						break;
					} else if (score > 100 || score < 0) {
						String check = (score < 0) ? "Invalid score: Score(%) < 0" : "Invalid score: Score(%) > 100";
						System.err.println(check);
						continue;
					} else {
						scores[i] = score;
						break;
					}
				} while (true);
			}
		}

	}

	public void setCourse() {
		boolean validCourse = false;
		System.out.print("Enter current course or 0 to exit: ");
		String currentCourse = sc.nextLine();
		if (currentCourse.equalsIgnoreCase("0")) {
			return;
		}
		for (int i = 0; i < courses.length; i++) {
			if (courses[i] != null) {
				if (courses[i].equalsIgnoreCase(currentCourse)) {
					System.out.println(
							String.format("-----Options----- \n* Enter  \"null\" to remove " + courses[i] + " or"));
					do {
						System.out.print("Enter new course: ");
						validCourse = true;
						String newCourse = sc.nextLine();
						for (String name : courseName) {
							if (name.equalsIgnoreCase(newCourse)) {
								courses[i] = name;
								return;
							}
						}
						if (newCourse.equalsIgnoreCase("null")) {
							courses[i] = null;
							return;
						} else {
							System.err.println("Invalid course");
							continue;
						}
					} while (true);
				}
			}
		}
		if (!validCourse) {
			System.err.println("Invalid course");
		}
	}

	public void ReSetAScore() {
		boolean validScore = false;
		System.out.print("Enter the current  course: ");
		String course = sc.nextLine();
		for (int i = 0; i < courses.length; i++) {
			if (courses[i] != null) {
				if (courses[i].equalsIgnoreCase(course)) {
					do {
						System.out.print("Enter new score for " + courses[i] + ": ");
						int newScore = Integer.parseInt(sc.nextLine());
						if (newScore >= 0 && newScore <= 100) {
							scores[i] = newScore;
							validScore = true;
							return;
						} else if (validScore == false) {
							System.out.println("Invalid score");
						}
					} while (validScore == false);
				}
			}
		}
		System.err.println("Invalid course");
	}

}
