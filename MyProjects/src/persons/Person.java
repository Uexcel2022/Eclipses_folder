//package persons;
//
//import java.util.Scanner;
//
//public class Person {
//	protected String firstName;
//	protected String lastName;
//	protected int age;
//	protected int ID;
//	static String[] chosen = { "", "students", "employees" };
//
//	public Person(double ID, String firstName, String lastName, double age) {
//		this.ID = (int) ID;
//		this.firstName = firstName;
//		this.lastName = lastName;
//		this.age = (int) age;
//
//	}
//
//	@Override
//	public String toString() {
//		return String.format("%s \nFirst name: %s  \nLast name: %s  \nAge: %s", ID, firstName, lastName, age);
//	}
//
//	public static void main(String[] args) {
//
//		String choice = null;
//		do {
//
//			try {
//				if (choice == null)
//					choice = Get.getString("\n1. Student object\n2. employee object \n0. Exit\n");
//				String[] splitted = choice.split(":");
//				choice = splitted[0];
//				if (choice.equals("0")) {
//					break;
//				}
//				if (!choice.equals("1") && !choice.equals("2")) {
//					System.err.println("Error! Enter 1 or 2");
//					choice = null;
//					continue;
//				} else {
//
//					String check = Get
//							.getString("Enter number of " + chosen[Integer.valueOf(choice)] + " or 0 to reset:\n");
//					String[] splittedcheck = check.split(":");
//					int persons = Integer.parseInt(splittedcheck[0]);
//					if (persons == 0) {
//						choice = null;
//						continue;
//					}
//
//					if (persons < 1) {
//						System.err.println("Error! must be greater than 0");
//						continue;
//					}
//
//					Get.accept(choice, persons);
//					choice = null;
//				}
//
//			} catch (NumberFormatException e) {
//				System.err.println("Error " + e.getMessage() + "! Enter a number.");
//			} catch (Exception e) {
//				System.out.println("Error " + e.getMessage());
//			}
//		} while (true);
//	}
//}
//
//class Student extends Person {
//	String course;
//
//	public Student(double ID, String firstName, String lastName, double age, String course) {
//		super(ID, firstName, lastName, age);
//		this.course = course;
//	}
//
//	@Override
//	public String toString() {
//		return "Student ID: " + super.toString() + String.format("\nCourse-enrolled: %s", course);
//	}
//}
//
//class Employee extends Person {
//	String designation;
//	String department;
//	double salary;
//
//	public Employee(double ID, String firstName, String lastName, double age, String deptName, String designation,
//			double salary) {
//		super(ID, firstName, lastName, age);
//		this.designation = designation;
//		this.salary = salary;
//		this.department = deptName;
//	}
//
//	@Override
//	public String toString() {
//		return "Employee ID: " + super.toString()
//				+ String.format("\nDepartment: %s \nDesignation: %s \nSalary: %.2f", department, designation, salary);
//	}
//
//}
//
//class Get {
//	static String[] values;
//	static String[] prompt;
//	static String invalidChar = "";
//	static Scanner sc = new Scanner(System.in);
//
//	public static double getNum(String prompt) {
//		System.out.print(prompt + ":");
//		return Double.parseDouble(sc.nextLine());
//	}
//
//	public static String getString(String prompt) {
//		System.out.print(prompt + ": ");
//		return sc.nextLine().trim() + ":" + prompt;
//	}
//
//	public static void acceptPerson(Person[] person) {
//		for (Person n : person) {
//			if (n != null && n.getClass().getSimpleName().equals("Student")) {
//				Student obj = (Student) n;
//				System.out.println("\n" + obj);
//			} else {
//				if (n != null) {
//					Employee obj = (Employee) n;
//					System.out.println("\n" + obj);
//				}
//			}
//		}
//
//	}
//
//	public static void accept(String choice, int persons) {
//
//		int count = 0;
//
//		Person[] person = new Person[persons];
//		if (choice.equals("1")) {
//			values = new String[5];
//			prompt = new String[5];
//		} else {
//			values = new String[7];
//			prompt = new String[7];
//		}
//
//		while (count < persons) {
//			try {
//				if (values[0] == null) {
//					values[0] = String.valueOf(Get.getNum("ID"));
//					prompt[0] = "ID";
//				}
//				if (Double.parseDouble(values[0]) < 1) {
//					values[0] = null;
//					System.err.println("\nError! must not be less than 1\n");
//					continue;
//				}
//
//				if (values[1] == null) {
//					values[1] = Get.checkString(Get.getString("First name"));
//					prompt[1] = "First name";
//				}
//				if (values[1] == null) {
//					System.err.println("\nInvalid because of : " + invalidChar + "\n");
//					continue;
//				}
//				if (values[2] == null) {
//					values[2] = Get.checkString(Get.getString("Last name"));
//					prompt[2] = "Last name";
//				}
//				if (values[2] == null) {
//					System.err.println("\nInvalid because of : " + invalidChar + "\n");
//					continue;
//				}
//
//				if (values[3] == null) {
//					values[3] = String.valueOf(Get.getNum("Age"));
//					prompt[3] = "Age";
//				}
//				if (Double.parseDouble(values[3]) < 1 || Double.parseDouble(values[3]) > 120) {
//					values[3] = null;
//					System.err.println("\nError! must not be < 1 or >120\n");
//					continue;
//				}
//
//				if (choice.equals("1")) {
//					if (values[4] == null) {
//						values[4] = Get.checkString(Get.getString("Course-Enrolled"));
//						prompt[4] = "Course-Enrolled";
//					}
//					if (values[4] == null) {
//						System.err.println("\nInvalid because of : " + invalidChar + "\n");
//						continue;
//					}
//					edit();
//					Student st = new Student(Double.parseDouble(values[0]), values[1], values[2],
//							Double.parseDouble(values[3]), values[4]);
//					person[count] = st;
//					values = new String[5];
//
//				} else if (choice.equals("2")) {
//					if (values[4] == null) {
//						values[4] = checkString(getString("Department"));
//						prompt[4] = "Department.";
//					}
//					if (values[4] == null) {
//						System.err.println("\nInvalid because of : " + invalidChar + "\n");
//						continue;
//					}
//					if (values[5] == null) {
//						values[5] = Get.checkString(getString("Designation"));
//						prompt[5] = "Designation";
//					}
//					if (values[5] == null) {
//						System.err.println("\nInvalid because of : " + invalidChar + "\n");
//						continue;
//					}
//					if (values[6] == null) {
//						values[6] = String.valueOf(getNum("Salary"));
//						prompt[6] = "Salary";
//					}
//					if (Double.parseDouble(values[6]) < 1) {
//						values[6] = null;
//						System.err.println("\nError! must not be less than 1\n");
//						continue;
//					}
//
//					edit();
//					Employee em = new Employee(Double.parseDouble(values[0]), values[1], values[2],
//							Double.parseDouble(values[3]), values[4], values[5], Double.parseDouble(values[6]));
//					person[count] = em;
//					values = new String[7];
//				}
//
//				count++;
//
//			} catch (NumberFormatException e) {
//				System.err.println("\nError " + e.getMessage() + "! Numbers only.\n");
//			} catch (Exception e) {
//				System.out.println("Error! " + e.getMessage());
//			}
//		}
//		acceptPerson(person);
//	}
//
//	public static String checkString(String string) {
//		String alpha = null;
//		String[] splittedString = string.split(":");
//		string = splittedString[0];
//		String isIn[] = new String[string.length()];
//		String notIn[] = new String[string.length()];
//
//		if (splittedString[1].equalsIgnoreCase("Course-Enrolled") || splittedString[1].equalsIgnoreCase("Department")
//				|| splittedString[1].equalsIgnoreCase("Designation")) {
//			alpha = "abcdefghijklmnop qrstuvwxyz-.";
//		} else
//			alpha = "abcdefghijklmnopqrstuvwxyz";
//
//		char[] alphaChr = alpha.toCharArray();
//		for (int i = 0; i < string.length(); i++) {
//			for (int j = 0; j < alphaChr.length; j++) {
//				if (String.valueOf(alphaChr[j]).equalsIgnoreCase(String.valueOf(string.charAt(i)))) {
//					isIn[i] = String.valueOf(string.charAt(i));
//				} else
//					notIn[i] = String.valueOf(string.charAt(i));
//			}
//		}
//		invalidChar = "";
//		for (int i = 0; i < isIn.length; i++) {
//			if (isIn[i] == null) {
//				invalidChar += notIn[i];
//			}
//		}
//		if (invalidChar.length() > 0) {
//			if (invalidChar.isBlank()) {
//				invalidChar = "unsual charater spacing.";
//				return null;
//			} else
//				return null;
//		}
//
//		String titleCase = String.valueOf(string.charAt(0)).toUpperCase();
//		for (int i = 1; i < string.length(); i++) {
//			titleCase += string.charAt(i);
//		}
//		return titleCase;
//	}
//
//	public static void edit() {
//		int num;
//		int count = 0;
//		for (int i = 0; i < values.length; i++) {
//			if (i == 0 || i == 3)
//				values[i] = String.valueOf((int) Double.parseDouble(values[i]));
//			System.out.println((i + 1) + ". " + prompt[i] + ": " + values[i]);
//			count++;
//		}
//		do {
//			System.out.print("To edit: \nEnter the number or -1 to submit: ");
//			num = Integer.parseInt(sc.nextLine());
//			if (num < 0) {
//				return;
//			}
//			if (num - 1 > (count - 1)) {
//				System.out.println("The number is out of range!");
//				continue;
//			}
//
//			if (num - 1 == 0 || num - 1 == 3 || num - 1 == 6) {
//				System.out.print("Enter new value for \"" + prompt[num - 1] + "\": ");
//				try {
//					values[num - 1] = String.valueOf(Double.parseDouble(sc.nextLine()));
//				} catch (NumberFormatException e) {
//					System.err.println("\nError " + e.getMessage() + "! Numbers only.\n");
//					System.out.println("The change could not be effected.");
//				} catch (Exception e) {
//					System.err.println("Error! " + e.getMessage());
//					System.out.println("The change could not be effected.");
//				}
//			} else {
//				String hold = values[num - 1];
//				values[num - 1] = checkString(getString(prompt[num - 1]));
//				if (values[num - 1] == null) {
//					values[num - 1] = hold;
//					System.err.println("\nInvalid because of : " + invalidChar + "\n");
//					System.out.println("The change could not be effected.");
//				}
//			}
//
//		} while (num != -1);
//	}
//
//}
