package interfaces;

interface Jide{
	void Add();
}

interface Paul{
	void subtraction();
	void divide();
}

interface Tolu{
	void multiply();
}



public class Calculator implements Jide, Paul, Tolu{
	int x, y;
	Calculator(int x , int y){
		this.x = x;
		this.y = y;
	}
	public void Add() {
      System.out.println(String.format("%s + %s = %s",x, y, x+y));
	}
	public void subtraction() {
	System.out.println(String.format("%s  -  %s = %s",x, y, x-y));
	}
	public void divide() {
		System.out.println(String.format("%s  /  %s = %s",x, y, x/y));
	}
	
	public void multiply() {
		System.out.println(String.format("%s * %s = %s",x, y, x*y));
	}
	
	public static void main(String[] args) {
		Calculator cal = new Calculator(10, 5);
		cal.Add();
		cal.divide();
		cal.multiply();
		cal.subtraction();
	}

} 
	





