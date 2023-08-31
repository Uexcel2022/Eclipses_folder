package brocode;

public class GenericClass<Thing> {

	Thing x;

	public GenericClass(Thing x) {
		this.x = x;
	}

	public Thing getValue() {
		return x;
	}

	public static void main(String[] args) {
//		GenericClass<Double> _double = new GenericClass<>(9.1);
//		GenericClass<Integer> integer = new GenericClass<>(10);
//		GenericClass<String> string = new GenericClass<>("Hello");
//		GenericClass<Character> character = new GenericClass<>('H');
		
//		System.out.println(_double.getValue());
//		System.out.println(integer.getValue());
//		System.out.println(string.getValue());
//		System.out.println(character.getValue());
		
//		GenericClass2<Double,Double> _double = new GenericClass2<>(9.1, 5.9);
//		GenericClass2<Integer, String> integer = new GenericClass2<>(10, "Marks");
//		GenericClass2<String, Double> string = new GenericClass2<>("Hello", 3.6);
//		GenericClass2<Character, String> character = new GenericClass2<>('H', "Hi");
//        
//		System.out.println(_double.getValue() + " " +_double.getValue2());
//		System.out.println(integer.getValue() + " " +integer.getValue2());
//		System.out.println(string.getValue()+ " " +string.getValue2());
//		System.out.println(character.getValue()+" "+character.getValue2());
		
//		GenericClass3<Integer> integer = new GenericClass3<>(20);
//		System.out.println(integer.getValue());
		
		new Assignment();

	}
}

// 2 parameters Generic class
 class GenericClass2<Thing, Thing2> {

	Thing x;
	Thing2 y;

	public GenericClass2(Thing x, Thing2 y) {
		this.x = x;
		this.y = y;
	}

	public Thing getValue() {
		return x;
	}
	
	public Thing2 getValue2() {
		return y ;
	}
 }
	
 
 // Bounded type Generic class = you can create the object of the generic class to have data
 //                                                of specific class. ex Number
 
 
 class GenericClass3<Thing extends Number> {

		Thing x;

		public GenericClass3(Thing x) {
			this.x = x;
			
		}

		public Thing getValue() {
			return x;
		}
		
	 }
		
 
 
 
 
 
 
 
 
 
 
 
 
 
	
	
	
