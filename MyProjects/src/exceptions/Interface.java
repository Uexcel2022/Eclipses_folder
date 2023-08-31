package exceptions;

public class Interface {
	public static void main(String[] args) {
//		Person p = new Combination();
//		Employee em = new Combination();
//		System.out.println(p.person(1248, "Udoka", "Jide", 19));
//		System.out.println(em.employee("MMS", "Lecturer", 203.65));
		Student p1 = new Combination();
		Student st = new Duplicate();
		Interface.acceptStudentObj(p1);
		Interface.acceptStudentObj(st);
		
	}
	
	public static void acceptStudentObj(Student obj) {
		obj.student();
	}
}


interface Student{
	void student();
}

interface Person extends Student {

	String person(int ID, String firstName, String lastName, int age);

}

abstract class Employee {
	public abstract String employee(String deptName, String designation, double salary);
}


class Combination extends Employee implements Person {
	public void student() {
		System.out.println("Student in Combination class!");
	}

	public String person(int ID, String firstName, String lastName, int age) {

		return String.format("ID: %s \nFirst name: %s  \nLast name: %s  \nAge: %s", ID, firstName, lastName, age);
	}

	public String employee(String department, String designation, double salary) {

		return "Employee ID: "
				+ String.format("\nDepartment: %s \nDesignation: %s \nSalary: %.2f", department, designation, salary);
	}

}

class Duplicate implements Student{
	public void student() {
		System.out.println("Student in Duplicate class!");
	}
	
}


