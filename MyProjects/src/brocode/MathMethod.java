package brocode;

import java.util.Scanner;

public class MathMethod {
	public static void main(String[] args) {
		 MathMethod.hypotenuse();
		
	}

	public static void math() {
		double x = 3.14;
		double y = -10;
		int b = 10;

		double z = Math.min(x, y);
		double e = Math.max(x, y);
		double a = Math.abs(y);
		double sqareRoot = Math.sqrt(b);
		System.out.println(z);
		System.out.println(e);
		System.out.println(a);
		System.out.println(sqareRoot);
		double rd = Math.round(sqareRoot);
		System.out.println(rd);

		double f = Math.floor(sqareRoot);
		double c = Math.ceil(sqareRoot);
		System.out.println(f);
		System.out.println(c);

	}

	public static void hypotenuse() {
		double a = 0;
		double b = 0;
		double c = 0;
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter side A: ");
		a = Double.parseDouble(sc.nextLine());
		System.out.print("Enter side B: ");
		b = Double.parseDouble(sc.nextLine());
		double Ab = Math.pow(a, 2) + Math.pow(b, 2);
		System.out.println(Ab);
		c = Math.sqrt(Ab);
		System.out.println(c);
		sc.close();
	}

}
