package model;

public class Address {
	
	private String state;
	private String zipcode;
	
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	
	@Override
	public String toString() {
		return "Address [state=" + state + ", zipcode=" + zipcode + "]";
	}
	
		
	

}
