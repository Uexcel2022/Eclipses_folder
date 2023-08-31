package calculation;

import java.util.Scanner;

public class Assert {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.print("Enter a number: ");
		int num1 = sc.nextInt();
		System.out.print("Enter a number: ");
		int num2 = sc.nextInt();

		assert (num1 >0) && (num2 >0) : "\"At least, one of the numbers is Zero\"";
		System.out.println(String.format("%s * %s = %s", num1, num2, num1*num2));
		System.out.println(String.format("%s + %s = %s", num1, num2, num1+num2));
		System.out.println(String.format("%s - %s = %s", num1, num2, num1-num2));
		System.out.println(String.format("%s / %s = %s", num1, num2, num1/num2));

	}

}
