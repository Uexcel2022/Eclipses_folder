package inheritance;

public class Nigeria extends Registration {
	protected String phone;
	protected String address;
	
	
	public  Nigeria(String phone, String address,
			             String firstName, String lastName, 
		                 String email, int age)
	{
		    super(firstName, lastName, email, age);
			this.address = address;
			this.phone = phone;
	}

	void nigeria() {
		System.out.println("First name: "+firstName);
		System.out.println("Last name: "+lastName);
		System.out.println("Age: "+age);
		System.out.println("Phone: "+phone);
		System.out.println("Email: "+email);
		System.out.println("Address: "+address);
	}
		void setPhone(String phone) {
			this.phone = phone;
		}
		
		void setAddress(String address) {
			this.address = address;
		}
}
