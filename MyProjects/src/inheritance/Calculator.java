package inheritance;
// you must create a constructor that match the one in the parent class

// we must make a constructor call to the parents

public class Calculator extends BasicCalculator {

	public String subtraction(int num1, int num2) {
		this.num1 = num1;
		this.num2 = num2;
		return String.valueOf((num1 - num2) + " ; " + "from the child's class - subtration method");

	}

	public static void main(String[] args) {
//		Calculator cal = new Calculator();
//		System.out.println(cal.subtraction(9, 3));
//		System.out.println(cal.multiplication(2, 3));
//		System.out.println(cal.addition(7, 5));
//		
//		BasicCalculator bc = new Calculator();
//		System.out.println(bc.subtraction(6, 2));
//		System.out.println(bc.addition(4, 6));

		calc cl1 = new calc(7, 8);
		cl1.add();;
	}

	public String multiplication(int num1, int num2) {
		this.num1 = num1;
		this.num2 = num2;
		return String.valueOf((num1 * num2) + " " + "; from child's class - multiplication method");
	}
     interface myinterface{
    	 public static final int size = 9;
    	 public abstract void display();
    	 static void greet() {}
    	 default void greets() {}
    	 
     }
     
     
}

// hello 2

class arithmetic {
	int x = 0, y = 0;

	arithmetic(int x, int y) {
		this.x = x;
		this.y = y;

		System.out.println("Perent constructor with argument");
	}

       arithmetic() {
		System.out.println("Perent constructor with argument");
	}

	void add() {
		System.out.println("Add from parent class");
		String sum = String.format(" %s + %s = %s", x, y, x + y);
		System.out.println(sum);
	}
}

class calc extends arithmetic {

	public calc(int x, int y) {
		super(x, y);
		System.out.println("Child constructor");
	}

	public calc() {

	}

	void add() {
		super.add();
		System.out.println("Add from child's class");
	}

}
