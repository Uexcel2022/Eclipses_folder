package inheritance;

import java.util.Scanner;

public class Person {
	protected String firstName;
	protected String lastName;
	protected int age;
	protected int ID;
	static String[] chosen = { "", "students", "employees" };

	public Person(double ID, String firstName, String lastName, double age) {
		this.ID = (int) ID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = (int) age;

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		do {
			System.out.print("\nCreate instance of: \n1. Student \n2. Employee \n0. Exit ");
			System.out.print("\nEnter the option number: ");
			int choice = Integer.parseInt(sc.nextLine());
			if (choice == 0) {
				sc.close();
				return;
			}
			if (choice == 1 || choice == 2) {
				System.out.print("Enter the number of \"" + chosen[choice] + "\" or 0 to reset: ");
				int num = Integer.parseInt(sc.nextLine());
				if (num == 0) {
					continue;
				}
				Input in = new Input(choice, num);
				Person[] person = in.input();
				for (Person n : person) {
					if (n != null && n.getClass().getSimpleName().equals("Student")) {
						Student obj = (Student) n;
						System.out.println("\n" + obj);
					} else {
						if (n != null) {
							Employee obj = (Employee) n;
							System.out.println("\n" + obj);
						}
					}
				}

			} else
				System.err.println("You have made an invalid selection");
		} while (true);
	}

	@Override
	public String toString() {
		return String.format("%s \nFirst name: %s  \nLast name: %s  \nAge: %s", ID, firstName, lastName, age);
	}
}

class Student extends Person {
	String course;

	public Student(double ID, String firstName, String lastName, double age, String course) {
		super(ID, firstName, lastName, age);
		this.course = course;
	}

	@Override
	public String toString() {
		return "StudentID: " + super.toString() + String.format("\nCourse-enrolled: %s", course);
	}
}

class Employee extends Person {
	String designation;
	String deptName;
	double salary;

	public Employee(double ID, String firstName, String lastName, double age, String deptName, String designation,
			double salary) {
		super(ID, firstName, lastName, age);
		this.designation = designation;
		this.salary = salary;
		this.deptName = deptName;
	}

	@Override
	public String toString() {
		return "Employee ID: " + super.toString()
				+ String.format("\nDept Name: %s \nDesignation: %s \nSalary: %.2f", deptName, designation, salary);
	}
}

class Input {
	protected int num;
	protected int choice;
	protected Person[] person;
	Scanner sc;
	private String value;
	protected String[] values;
	protected String[] prompt = { "ID", "firstName", "LastName", "age", "courseEnrolled", "deptName", "designation",
			"salary" };

	public Input(int choice, int num) {
		this.choice = choice;
		this.num = num;
		person = new Person[num];
		sc = new Scanner(System.in);
		if (choice == 1) {
			values = new String[5];
		} else
			values = new String[7];
	}

	public Person[] input() {
		int count = 0;
		do {

			if (choice == 1 || choice == 2) {
				for (int i = 0; i < prompt.length; i++) {

					if (choice == 2 && prompt[i] == "courseEnrolled")
						continue;

					if (prompt[i] == "age" || prompt[i] == "salary" || prompt[i] == "ID") {
						System.out.print("Enter " + prompt[i] + " or 0 to exit: ");
						value = String.valueOf(Double.parseDouble(sc.nextLine()));

					} else {
						System.out.print("Enter " + prompt[i] + " or 0 to exit: ");
						value = upperCase(sc.nextLine());
					}

					if (value.equalsIgnoreCase("0")) {
						count = -1;
						break;
					}

					if (i > 4 && choice == 2) {
						values[i - 1] = value;
					} else {
						values[i] = value;
					}

					if (choice == 1 && prompt[i] == "courseEnrolled") {
						break;
					}
				}
			}

			if (count == -1) {
				break;
			}
			int confirm = 0;
			do {
				System.out.print("Enter a number to submit or 0 to edit: ");
				confirm = Integer.parseInt(sc.nextLine());
				if (confirm == 0) {
//					edit();
					System.out.print("Enter the error: ");
					String error = sc.nextLine();
					for (int i = 0; i < values.length; i++) {
						if (prompt[i] == "age" || prompt[i] == "ID")
							values[i] = String.valueOf((int) Double.parseDouble(values[i]));
						if (values[i].equalsIgnoreCase(error)) {
							System.out.print("Enter new value for \"" + values[i] + "\": ");
							if (prompt[i] == "age" || prompt[i + 1] == "salary" || prompt[i] == "ID") {
								values[i] = String.valueOf(Double.parseDouble(sc.nextLine()));
							} else
								values[i] = upperCase(sc.nextLine());
						}
					}
				}
			} while (confirm == 0);

			if (choice == 2) {
				Employee em = new Employee(Double.parseDouble(values[0]), values[1], values[2],
						Double.parseDouble(values[3]), values[4], values[5], Double.parseDouble(values[6]));
				person[count] = em;
				count++;

			} else {
				Student st = new Student(Double.parseDouble(values[0]), values[1], values[2],
						Double.parseDouble(values[3]), values[4]);
				person[count] = st;
				count++;
			}

		} while (count < num);
		return person;

	}

	public String upperCase(String string) {
		String c = String.valueOf(string.charAt(0)).toUpperCase();
		String newString = c;
		for (int i = 1; i < string.length(); i++) {
			newString += string.charAt(i);
		}
		return newString;
	}
}

//
//	public void edit() {
//		int count = 0;
//		for (int i = 0; i < values.length; i++) {
//			if (prompt[i] == "age" || prompt[i] == "ID")
//				values[i] = String.valueOf((int) Double.parseDouble(values[i]));
//			System.out.println(i + ". " + values[i]);
//			count++;
//		}
//
//		do {
//			System.out.print("Enter the number or -1 to exit: ");
//			int num = Integer.parseInt(sc.nextLine());
//			if (num < 0) {
//				return;
//			}
//			if (num > (count - 1)) {
//				System.out.println("The number is out of range!");
//				continue;
//			}
//
//			System.out.print("Enter new value for \"" + values[num] + "\": ");
//
//			if (num == 0 || num == 3 || num == 6) {
//				values[num] = String.valueOf(Double.parseDouble(sc.nextLine()));
//			} else
//				values[num] = upperCase(sc.nextLine());
//		} while (num != -1);
//	}
//
//}


