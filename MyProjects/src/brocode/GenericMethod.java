package brocode;

public class GenericMethod {

	Integer[] integerArray = { 1, 2, 4, 4, 5 };
	Character[] charArray = { 'H', 'e', 'l', 'l', 'o' };
	String[] stringArray = { "B", "Y", "E", };
	Double[] doubleArray = {2.0, 1.1, 4.5 };
	
	public static void main(String[] args) {
		
//		Generic.display(integerArray);
//		Generic.display(charArray);
//		Generic.display(stringArray);
//		Generic.display(doubleArray);
//		
//		System.out.println(Generic.ReturnItem(integerArray));
//		System.out.println(Generic.ReturnItem(charArray));
//		System.out.println(Generic.ReturnItem(stringArray));
//		System.out.println(Generic.ReturnItem(doubleArray));
		
//		MyInteger integer = new  MyInteger(6);
//		MyDouble  _double = new MyDouble(11.7);
//		MyString  string = new MyString("Hello");
//		MyCharacter character = new MyCharacter('B');
//		System.out.println(integer.getValue());
//		System.out.println(_double.getValue());
//		System.out.println(string.getValue());
//		System.out.println(character.getValue());
		
		
	}
	// Generic Methods

	public static <Thing> void display(Thing[] array) {

		for (Thing n : array) {
			System.out.print(n+ " ");
		}System.out.println();
	}
	
	public static <Thing> Thing ReturnItem (Thing[] array){
		
		return array[0];
	}

}


class MyInteger{
	Integer x;
	
	public MyInteger(Integer x) {
		this.x = x;
	}
	
	public Integer getValue() {
		return x;
	}
	
}


class MyString{
	String string ="";
	
	public  MyString(String string) {
		this.string = string;
	}
	
	public String getValue() {
		return string;
	}
	
}


class MyDouble{
	Double num;;
	
	public  MyDouble(Double num) {
		this.num = num;
	}
	
	public Double getValue() {
		return num;
	}
	
}


class MyCharacter{
	Character num;;
	
	public  MyCharacter(Character num) {
		this.num = num;
	}
	
	public Character getValue() {
		return num;
	}
	
}

























