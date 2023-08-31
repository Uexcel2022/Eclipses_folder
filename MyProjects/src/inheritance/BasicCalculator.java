package inheritance;

public class BasicCalculator {
	protected int num1;
	protected int num2;

	public String addition(int num1, int num2) {
		this.num1 = num1;
		this.num2 = num2;
		return String.valueOf((num1 + num2)+ " ; " + "from the parent's class - addition method");
	}
	public static void main(String[] args) {
		BasicCalculator ad = new BasicCalculator();
		System.out.println(ad.addition(4, 6));
	}

	public String subtraction(int num1, int num2) {
		this.num1 = num1;
		this.num2 = num2;
		return String.valueOf((num1 - num2)+ " ; " + " from the parent's class - subtraction method");
	}
}
