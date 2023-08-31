package onarray;

import java.util.Scanner;

import checkgrade.Grade;

// Functionalities 
//1. Course registration:
// - select course from the list of courses;
// - Change  courses on the list of selected courses
// - Remove  courses from the list of selected courses;
//- Add courses to the list of selected courses;
//- check for course duplicate when making changes to the existing  selected list of courses

//2. Accept score input
//- check negative value or value above 100 is not accepted
// - Allow for change of score.

//3. Score Analysis
//- compute average score and grade.

enum CourseName {

	SQL, Java, HTML5, Logic, Python, Javascript;
}

public class CourseAndResult {
	int[] numbers = { 3, 4, 5, 6 };
	int numberOfcourses;
	Scanner sc = new Scanner(System.in);
	String[] selectedCourses = new String[6];
	int[] scores;
	String confirmReg;
	int score;
	int j = 0;
	String changeScore = "0";

	public static void main(String[] args) {

		CourseAndResult cr = new CourseAndResult();
		cr.registration();

	}

	public void registration() {
		System.out.println("Course Registration Portal");
		System.out.println("--Options--\n0. Skip \n1. Select \n2. Exit");
		do {	
			for (int n : numbers) {
				System.out.println("Number of Courses: " + n);		
				System.out.print("Choose the option: ");
				int choice = Integer.parseInt(sc.nextLine());
				if (choice == 2 && numberOfcourses == 0) {
					System.err.println("Processs terminated ");
					return;
				} else if (choice == 1) {
					numberOfcourses = n;
					break;
				} else if (choice == 0) {
					continue;
				}
			}
		} while (numberOfcourses == 0);
         System.out.println("--Options--\n0. Skip \n1. Select");
		for (CourseName c : CourseName.values()) {
			System.out.println("Course: " + c);
			System.out.print("Chose the option:");
			int selectedCourse = Integer.parseInt(sc.nextLine());
			if (selectedCourse == 1 && j < numberOfcourses) {
				selectedCourses[j] = String.format("%s", c);
				j++;

				if (j == numberOfcourses) {
					break;
				}
			}
		}
		do {
			for (int i = 0; i < j; i++) {
				if (selectedCourses[i] != null)
					System.out.println(selectedCourses[i]);
			}
			System.out.println("0. make changes \n1. Submit \n2. Add courses \n3. Remove courses");
			System.out.print("Chose the option:");
			confirmReg = sc.nextLine();
			if (confirmReg.equalsIgnoreCase("0")) {
				setCourse();
			} else if (confirmReg.equalsIgnoreCase("2")) {
				addCourse();
			} else if (confirmReg.equalsIgnoreCase("3")) {
				removeCourse();
			}
		} while (!confirmReg.equalsIgnoreCase("1"));
		scores = new int[j];
		int stop = 0;
		System.out.println("Result Computation Portal");
		System.out.println("------------Options-----------\n* Enter score for the course or \n* -1 to remove the course");
		do {
			for (int i = 0; i < j; i++) {
				stop = i;
				do {
					if (selectedCourses[i] == null) {
						break;
					} else {
						System.out.print("Enter score for " + selectedCourses[i] +": ");
						score = Integer.parseInt(sc.nextLine());
						if (score == -1) {
							removeCourseAndScore();
						} else if (score >= 0 && score < 100) {
							scores[i] = score;
							break;
						} else
							System.err.println("Invalid score. 0 <= score <=100");
					}

				} while (true);
                
			}
		} while (stop+1 < j);
		do {
			for (int i = 0; i < j; i++) {
				if (selectedCourses[i] != null)
					System.out.println(selectedCourses[i] + ": " + scores[i]);
			}
			System.out.println("0. Make changes \n1. Ok ");
			System.out.print("Chose the option:");
			changeScore = sc.nextLine();
			if (changeScore.equalsIgnoreCase("0")) {
				setScore();
			} else if (changeScore.equalsIgnoreCase("1")) {
				int tolatScore = 0;
				int finalNumberOfCourses = 0;
				System.out.println("\nCourse and Score");
				for (int i = 0; i < j; i++) {
					if (selectedCourses[i] != null) {
						System.out.println(selectedCourses[i] + ": " + scores[i]);
						tolatScore += scores[i];
						finalNumberOfCourses++;
					}
				}
				int avg = tolatScore / finalNumberOfCourses;
				Grade gb = new Grade();
				String grade = gb.checkGrade2(avg);
				System.out.println("Average score: " + avg);
				System.out.println("Grade: " + grade);
				break;
			} else
				System.err.println("You have made an invalid selection");

		} while (true);

	}

	public void setCourse() {
		for (int i = 0; i < j; i++) {
			if (selectedCourses[i] != null) {
				System.out.println("Course: " + selectedCourses[i] + "\n0. Skip \n1. Edit");
				System.out.print("Chose the option:");
				String oldcourse = sc.nextLine();
				if (oldcourse.equalsIgnoreCase("1")) {
					for (CourseName n : CourseName.values()) {
						System.out.println("Change to: " + n + "\n0. Skip\n1. Accept \n3. Done");
						System.out.print("Chose the option: ");
						int selectedCourse = Integer.parseInt(sc.nextLine());
						if (selectedCourse == 3) {
							return;
						} else if (selectedCourse == 1) {
							boolean in2 = false;
							for (String ck : selectedCourses) {
								if (ck != null && ck.equals(String.format("%s", n))) {
									in2 = true;
									break;
								}
							}
							if (in2) {
								System.err.println("Course already entered");
							} else
								selectedCourses[i] = String.format("%s", n);
						}

					}
				}
			}
		}
	}

	public void setScore() {
		System.out.println("-----Options----\n0. Skip  \n2. Done \nEnter new score");
		do {
			for (int i = 0; i < j; i++) {
				if (selectedCourses[i] != null) {
					do {
						System.out.println(
								selectedCourses[i] + ": " + scores[i]);
						System.out.print("Chose the option: ");
						score = Integer.parseInt(sc.nextLine());
						if (score == 2) {
							return;
						}
						if (score >= 0 && score <= 100) {
							scores[i] = score;
							break;
						}
						System.err.println("Invalid score. 0 <= score <=100");
					} while (score != 2);
				}
			}
		} while (scores.length < j);
	}

	public void addCourse() {
        System.out.println("0. Skip \n1. Accept \n2. Done");
		for (CourseName n : CourseName.values()) {
			System.out.println("Add: " + n );
			System.out.print("Chose the option: ");
			int selectedCourse = Integer.parseInt(sc.nextLine());
			if (selectedCourse == 2) {
//				j++;
				return;
			} else if (selectedCourse == 1) {
				boolean in = false;
				for (String chk : selectedCourses) {
					if (chk != null && chk.equals(String.format("%s", n))) {
						in = true;
						break;
					}
				}
				if (in) {
					System.err.println("The course is in the list already");
					continue;
				} else {
					for (int i = 0; i < selectedCourses.length; i++) {
						if (selectedCourses[i] == null) {
							selectedCourses[i] = String.format("%s", n);
							if (i >= j) {
								j = i+1;
								break;
							}
							break;
						}

					}

				}
			}
		}
//		j++;
	}

	void removeCourse() {
		for (int i = 0; i < j; i++) {
			System.out.println("Course: " + selectedCourses[i] + "\n0. Skip \n1. Delete \n2. Done");
			System.out.print("Chose the option:");
			String deleted = sc.nextLine();
			if (deleted.equalsIgnoreCase("1")) {
				selectedCourses[i] = null;

			} else if (deleted.equalsIgnoreCase("2")) {
				return;
			}

		}
	}

	void removeCourseAndScore() {
		for (int i = 0; i < j; i++) {
			System.out.println("Course: " + selectedCourses[i] + "\n0. Skip \n1. Delete \n2. Done");
			System.out.print("Chose the option:");
			String deleted = sc.nextLine();
			if (deleted.equalsIgnoreCase("1")) {
				selectedCourses[i] = null;
				scores[i] = 0;
			} else if (deleted.equalsIgnoreCase("2")) {
				return;
			}

		}
	}
}
