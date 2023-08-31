package encapsulation;


public class RunEmployee {
	public static void main(String[] args) {
		Employee emp = new Employee
				("0021M","Udoka", "Excellence","Manager", "Marketing","12-02-1975",
					"24-06-1990", "Single", "0", "08038263824", "2899","uexcel@gmail.com", 
					250000);
		System.out.println(emp);
//		System.out.println("EmployeeID: "+emp.getEmployeeID());
//		System.out.println("First name: " +emp.getFirstName());
//		System.out.println("Last name: " + emp.getLastName());
		
		
		

//		String info = emp.toString();
//		 System.out.println(info);
		
//		System.out.println(emp.getfirstName() + " " + emp.getlastName());
//		System.out.println(emp.getTitle());
//		System.out.println(emp.getSalary());
//		emp.setLastName("Jude");
//		emp.setFirstName("Ambode");
//		emp.setSalary(500000);
//		emp.birthDate("17-06-1970");
//		emp.setTitle("Managing Director");
//		System.out.println(emp.toString());	
						
	}

}
