package encapsulation;
//This means restricting access to the properties of a class 

//from being access directly from other classes 

public class Employee2 {
	private String employeeID;
	private String firstName;
	private String lastName;
	private String designation;
	private String department;
	private String joinedDate;
	private String birthDate;
	private String maritalStatus;
	private String marriageDate;
	private String phone;
	private String address;
	private String email;
	private int salary;

	public Employee2(String employeeID, String firstName, String lastName, String designation, String department,
			String joinedDate, String birthDate, String maritalStatus, String marriageDate, String phone,
			String address, String email, int salary) {
		this.employeeID = employeeID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.designation = designation;
		this.department = department;
		this.joinedDate = joinedDate;
		this.birthDate = birthDate;
		this.maritalStatus = maritalStatus;
		this.marriageDate = marriageDate;
		this.phone = phone;
		this.address = address;
		this.email = email;
		this.salary = salary;
	}

	public String getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getJoinedDate() {
		return joinedDate;
	}

	public void setJoinedDate(String joinedDate) {
		this.joinedDate = joinedDate;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getMarriageDate() {
		return marriageDate;
	}

	public void setMarriageDate(String marriageDate) {
		this.marriageDate = marriageDate;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee ID: " + employeeID + "\nFirst name: " + firstName + "\nLast name : " + lastName
				+ "\nDesignation : " + designation + "\nDepartment: " + department + "\nJoined date: " + joinedDate
				+ "\nDate of birth: " + birthDate + "\nMarital status: " + maritalStatus + "\nMarriage Date: "
				+ marriageDate + "\nPhone: " + phone + "\nAddress: " + address + "\nEmail: " + email + "\nSalary: "
				+ salary;
	}

}
