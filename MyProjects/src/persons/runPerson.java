package persons;

import java.util.Scanner;

import resources.resource;

public class runPerson {
	static Scanner sc = new Scanner(System.in);
	static String[] values = new String[7];
	static String[] prompt = { "ID", "First Name", "Last name", "Age", " ", "Designation", " Salary" };
	static String[] chosen = { "", "students", "employees" };

	public static String getString(String prompt) {
		System.out.print(prompt + ": ");
		return sc.nextLine().trim(); //+ ":" + prompt;
	}

	public static void main(String[] args) {

		String choice = null;
		do {

			try {
				if (choice == null)
					choice = getString("\n1. Student object\n2. employee object \n0. Exit");
				if (choice.equals("0")) {
					sc.close();
					break;
				}

				if (choice.equals("1")) {
					prompt[4] = "Course-Enrolled";
				} else if (choice.equals("2")) {
					prompt[4] = "Department";
				} else {
					System.err.println("Error! Enter 1 or 2");
					choice = null;
					continue;
				}

				String person = getString("Enter number of " + chosen[Integer.valueOf(choice)] + " or 0 to reset");
				int persons = Integer.parseInt(person);
				if (persons == 0) {
					choice = null;
					continue;
				}

				if (persons < 1) {
					System.err.println("Error! must be greater than 0");
					continue;
				}

				accept(choice, persons);
				choice = null;

			} catch (NumberFormatException e) {
				System.err.println("Error " + e.getMessage() + "! Enter a number.");
			} catch (Exception e) {
				System.out.println("Error " + e.getMessage());
			}
		} while (true);
	}

	public static void accept(String choice, int persons) {

		Person[] person = new Person[persons];
		int obj = 0;
		int num;
		int count = 0;
		do {
			for (int i = 0; i < values.length;) {
				if (i == 0 || i == 3 || i == 6) {
					System.out.print(prompt[i] + ": ");
					try {
						values[i] = String.valueOf(Double.parseDouble(sc.nextLine()));
						if (Double.parseDouble(values[i]) <= 0 && i == 6) {
							System.err.println("Invalid! Salary must be > 0");
							continue;
						}
						if ((Double.parseDouble(values[i]) <= 0 || Double.parseDouble(values[i]) > 120) && i == 3) {
							System.err.println("Invalid! Age must be > 1 and < = 120");
							continue;
						}
						if (Double.parseDouble(values[i]) <= 0 && i == 0) {
							System.err.println("Invalid! ID must be > 0");
							continue;
						}

					} catch (NumberFormatException e) {
						System.err.println("\nError " + e.getMessage() + "! Numbers only.\n");
						continue;
					} catch (Exception e) {
						System.err.println("Error! " + e.getMessage());
						continue;
					}
				} else {
					String string = "";
					String check = "";
					if (i == 4 || i == 5) {
						string = getString(prompt[i]);
						check = resource.isAlpha(string,"- ");
					} else {
						string = getString(prompt[i]);
						check = resource.isAlpha(string,"");
					}
					
					if(string.isBlank()){
						System.err.println(prompt[i] +" field is empty!");
						continue;
					}

					if (check != null) {
						System.err.println("Invalid because of: " + check);
						continue;
					} else
						values[i] = resource.capitalized(string).trim();

					if (choice.equals("1") && i == 4)
						break;
				}

				i++;

			}

			System.out.println();
			for (int i = 0; i < values.length; i++) {
				if (i == 0 || i == 3)
					values[i] = String.valueOf((int) Double.parseDouble(values[i]));
				System.out.println((i + 1) + ". " + prompt[i] + ": " + values[i]);
				count = i;
				if (choice.equals("1") && i == 4) {
					break;
				}
			}

			do {
				System.out.print("To edit: \nEnter the number or -1 to submit: ");
				num = Integer.parseInt(sc.nextLine());
				if (num < 0) {
					if (choice.equals("1")) {
						person[obj] = new Student(Double.parseDouble(values[0]), values[1], values[2],
								Double.parseDouble(values[3]), values[4]);
						break;
					} else {
						person[obj] = new Employee(Double.parseDouble(values[0]), values[1], values[2],
								Double.parseDouble(values[3]), values[4], values[5], Double.parseDouble(values[6]));
						break;
					}

				}
				if (num - 1 > (count)) {
					System.out.println("The number is out of range!");
					continue;
				}

				if (num - 1 == 0 || num - 1 == 3 || num - 1 == 6) {
					System.out.print(prompt[num - 1] + ": ");
					try {
						String hold = values[num - 1];
						values[num - 1] = String.valueOf(Double.parseDouble(sc.nextLine()));
						if ((Double.parseDouble(values[num - 1]) < 1 || Double.parseDouble(values[num - 1]) > 120)
								&& num - 1 == 3) {
							System.err.println("Invalid! Age must be > 1 and < = 120");
							values[num - 1] = hold;
							continue;
						}

						if (Double.parseDouble(values[num - 1]) < 1 && num - 1 == 6) {
							System.err.println("Invalid! Salary must be > 0");
							values[num - 1] = hold;
							continue;
						}
						if (Double.parseDouble(values[num - 1]) < 1 && num - 1 == 0) {
							System.err.println("Invalid! ID must be > 0");
							values[num - 1] = hold;
							continue;
						}

					} catch (NumberFormatException e) {
						System.err.println("\nError " + e.getMessage() + "! Numbers only.\n");
						System.out.println("The change could not be effected.");
					} catch (Exception e) {
						System.err.println("Error! " + e.getMessage());
						System.out.println("The change could not be effected.");
					}
				} else {
					String string;
					String check;
					if (num - 1 == 4 || num - 1 == 5) {
						string = getString(prompt[num - 1]);
						check = resource.isAlpha( string, " -");
					} else {
						string = getString(prompt[num - 1]);
						check = resource.isAlpha(string, "");
					}
					
					if(string.isBlank()){
						System.err.println( prompt[num - 1] + " field is empty!");
						continue;
					}
					 
					if (check != null) {
						System.err.println("\nInvalid because of : " + check + "\n");
						System.out.println("The change could not be effected.");
					} else {
						values[num - 1] = resource.capitalized(string).trim();
					}
				}

			} while (num != -1);
			obj++;
		} while (obj < persons);
		acceptPerson(person);
	}

	public static void acceptPerson(Person[] person) {
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

	}

}

class Person {
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
		return "Student ID: " + super.toString() + String.format("\nCourse-enrolled: %s", course);
	}
}

class Employee extends Person {
	String designation;
	String department;
	double salary;

	public Employee(double ID, String firstName, String lastName, double age, String deptName, String designation,
			double salary) {
		super(ID, firstName, lastName, age);
		this.designation = designation;
		this.salary = salary;
		this.department = deptName;
	}

	@Override
	public String toString() {
		return "Employee ID: " + super.toString()
				+ String.format("\nDepartment: %s \nDesignation: %s \nSalary: %.2f", department, designation, salary);
	}

}
