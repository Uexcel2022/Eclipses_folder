
package hackerrank;
import resources.resource;

import java.util.Scanner;

public class AngryProfessor {
	int testCases = 0;
	int studentsInTheClass;
	int cancelationThreshold;
	String outOfRangeArrivalTime;
	int j = 0;
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		AngryProfessor ap = new AngryProfessor();
		ap.test();
	}

	public void test() {
		do {
			System.out.print("Enter number of test cases: ");
			String validTestCases = sc.nextLine().strip();
			if (validTestCases.isBlank()) {
				System.err.println("Error! You've entered nothing.");
				continue;
			}
			String isDigit = resource.isNumber(validTestCases, "-");
			if (isDigit != null) {
				System.err.println(isDigit);
				continue;
			}
			testCases = Integer.parseInt(validTestCases);
			if (testCases >= 1 && testCases <= 10) {
				break;
			}
			System.err.println("Invalid range of test cases. Enter a value from 1 - 10");
		} while (true);

		do {
			System.out.print("Enter  the number of Students  space  Cancelation threshold: ");
			String NK = sc.nextLine().trim();
			if (NK.isBlank()) {
				System.err.println("Error! You've entered nothing.");
				continue;
			}
			String isDigit = resource.isNumber(NK, "- ");
			if (isDigit != null) {
				System.err.println(isDigit);
				continue;
			}
			String validation = NKvalidation(NK);
			if (validation != null) {
				System.err.println(validation);
			} else {
				do {
					System.out.print("Enter arrival time: ");
					String studentArrivalTime = sc.nextLine();
					if (studentArrivalTime.isBlank()) {
						System.err.println("Error! You've entered nothing.");
						continue;
					}
					isDigit =resource.isNumber(studentArrivalTime, "- ");
					if (isDigit != null) {
						System.err.println(isDigit);
						continue;
					}
					String outcome = arrivalTimeValidation(studentArrivalTime);
					if (outcome.equalsIgnoreCase("error")) {
						System.err.println("Error! The arrival time values are not spaced eg 1 -1 0 ");
					} else if (outcome.equalsIgnoreCase("error1")) {
						System.err.println("Invalid arrival time!!");
					} else if (outcome.equalsIgnoreCase("invalidArrivalTime")) {
						System.err.println(
								"Error! The arrival time value of " + outOfRangeArrivalTime + " is out of range");
					} else if (outcome.equalsIgnoreCase("greater")) {
						System.err.println("Error! The arrival time is greater than students in the class.");
					} else {
						System.out.println(outcome);
						j++;
						break;
					}
				} while (true);

			}

		} while (j < testCases);

	}

	public String NKvalidation(String nk) {
		boolean isSpaced = false;
		if (nk.length() > 2) {
			for (int i = 0; i < nk.length(); i++) {
				if (String.valueOf(nk.charAt(i)).isBlank()) {
					isSpaced = true;
					break;
				}
			}
			if (isSpaced) {
				String[] validNK = nk.split(" ");
				studentsInTheClass = Integer.valueOf(validNK[0]);
				cancelationThreshold = Integer.valueOf(validNK[1]);

				if (cancelationThreshold > studentsInTheClass && studentsInTheClass > 0) {
					return "Error! The cancelation threshold (" + cancelationThreshold
							+ ") is greater than the (" + studentsInTheClass + ") students in the class.";
//					return "greaterThan";
				}

				if (studentsInTheClass < 1 && cancelationThreshold < 1) {
					return "Error! The number of students (" + studentsInTheClass + " is off range (1- 1000) " + 
							"\nError! The cancelation threshold (" + cancelationThreshold + ") is off range (-100 - 100)";
//					return "Zero";
				}
				if (studentsInTheClass < 1) {
					return "Error! The number of students (" + studentsInTheClass + ")  is out of (1 - 1000) range.";
//					return "OutOfRange";
				}

				if (cancelationThreshold < 1) {
					return "Error! The cancelation threshold value (" + cancelationThreshold
							+ ") is out of (-100 - 100) range.";
//					return "thresholdZero";
				}

				if (cancelationThreshold > studentsInTheClass) {
					return "KgreaterThanN";
				}

				if (studentsInTheClass > 1000) {
					return "Error! The number of students (" + studentsInTheClass + ")  is out of (1 - 1000) range.";
//					return "OutOfRange";
				}
			} else
				return "Error! Cancelation threshold value was ommited.";
		} else
			return "Error! Cancelation threshold value was ommited.";

		return null;
	}

	public String arrivalTimeValidation(String arrivalTime) {

		if (studentsInTheClass > 1) {
			boolean isSpaced = false;
			for (int i = 0; i < arrivalTime.length(); i++) {
				if (String.valueOf(arrivalTime.charAt(i)).isBlank()) {
					isSpaced = true;
				}
			}
			if (isSpaced) {
				String[] validArrivalTime = (arrivalTime.split(" "));
				if (validArrivalTime.length > studentsInTheClass) {
					return "greater";
				}
				for (String avt : validArrivalTime) {
					if (Integer.valueOf(avt) < -100 || Integer.valueOf(avt) > 100) {
						outOfRangeArrivalTime = avt;
						return "invalidArrivalTime";
					}
				}
				int positeArrivalTimeCount = 0;
				for (String avt : validArrivalTime) {
					if (Integer.valueOf(avt) <= 0) {
						positeArrivalTimeCount++;
					}
				}
				if (positeArrivalTimeCount >= cancelationThreshold) {
					return "No";
				} else
					return "Yes";

			} else {
				for (int i = 0; i < arrivalTime.length(); i++) {
					if (arrivalTime.charAt(i) == '-') {
						return "error";
					}
				}

				if (Integer.valueOf(arrivalTime) < -100 || Integer.valueOf(arrivalTime) > 100) {
					outOfRangeArrivalTime = arrivalTime;
					return "invalidArrivalTime";
				} else
					return "Yes";
			}
		} else {
			for (int i = 0; i < arrivalTime.length(); i++) {
				if ((arrivalTime.charAt(i) == '-' || String.valueOf(arrivalTime.charAt(i)).isBlank()) && i > 0) {
					return "error1";
				}
			}
			if (Integer.valueOf(arrivalTime) < -100 || Integer.valueOf(arrivalTime) > 100) {
				outOfRangeArrivalTime = arrivalTime;
				return "invalidArrivalTime";
			} else if (Integer.valueOf(arrivalTime) <= 0) {
				return "No";
			} else
				return "Yes";
		}
	}

	
}