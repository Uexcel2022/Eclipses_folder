package inheritance;

public class Registration {
	protected String firstName;
	protected String lastName;
	protected String email;
	protected int age;
	
	public Registration (String firstName,
                                String lastName, 
		                        String email, int age) 
	{
		   this.firstName = firstName;
		   this.lastName = lastName;
		   this.email = email;
		   this.age = age;		   
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
	

}
