package stringmetheds;

public class ToString {
	
	private String name;
	private int age;
	private String grade;
	
	public ToString(String name, int age, String grade) {
		this.name = name;
		this.age = age;
		this.grade = grade;
	}
	
	@Override
	public String toString() {
		return (String.format("\nName: %s \nAge: %s  \nGrade: %s",name, age, grade));
	}
	
    public static void main(String[] args) {
    	ToString str = new ToString("Udoka Excellence", 23, "A");
    	System.out.println(str);
    }

}
