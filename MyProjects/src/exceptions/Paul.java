package exceptions;

//import java.util.InputMismatchException;
import java.util.Scanner;
//import java.util.Scanner;
public class Paul {
	int num1 = 3;
	int num2 = 0;
	String A;
	String B = "";
	String C = " ";
	static Scanner sc = new Scanner(System.in);

	static int getNum(String prompt) {
		System.out.print(prompt + " >> ");
		return sc.nextInt();
	}

	static String getString(String prompt) {
		System.out.print(prompt + " >> ");
		return sc.nextLine();
	}

	public static void main(String[] args) throws InterruptedException {
//		Scanner sc = new Scanner(System.in);
//		Paul paul = new Paul();
		System.out.println("intput: ");
		String in = sc.nextLine();
		double n = Double.parseDouble(in);
//		int l = (int) n;
		
		System.out.println(n);

//		try {
//			System.out.println(1);
//			try {
//				paul.error();
//				System.out.println(2);
//			} catch (ArithmeticException e) {
//				System.out.println("arithmetic ex");
//				throw e;
//			}
//			System.out.println(3);
//		} catch (ArithmeticException ime) {
//			System.out.println("Exception " + ime.getMessage());
//		}
//
//		System.out.println(4);
//
//		System.out.println("Start");
//		try {
//			Thread.sleep(3000);
//		} catch (InterruptedException elloyn) {
//		}
//		System.out.println("End");
//
//		System.out.println("Start");
//		Thread.sleep(3000);
//		System.out.println("End");

//		Paul p = new Paul();
//		System.out.println(p.A.charAt(0));// Null pointer exception
//		System.out.println(p.B.charAt(0)); // StringIndexOutOfBoundException ; it's empty and it's banK
//		System.out.println(p.B.isEmpty()); // B is empty and blank;
//		System.out.println(p.C.isBlank()); // C is blank but not empty
//		String [] E = new String[-1]; // NegativeArraysSizeException
//		String [] E = new String[2];
//		System.out.println(E[2]); //ArrayIndexOutOfBoundException
//		Object [] F = new String[2];
//		F[0] =5; // ArrayStoreException 

//		try {
//			String string = getString("Enter string");
//			int num1 = getNum("Num1");
//			int num2 = getNum("Num1");
//			System.out.format("%d + %d = %d\n", num1, num2, num1 + num2);
//			System.out.format("%d - %d = %d\n", num1, num2, num1 - num2);
//			System.out.format("%d / %d = %d\n", num1, num2, num1 / num2);
//			System.out.format("%d * %d = %d\n", num1, num2, num1 * num2);
//		} catch (NumberFormatException ac) {
//			System.out.println("NumberFormatException error out: " + ac.getMessage());
//		} catch (ArithmeticException ac) {
//			System.out.println("ArithmeticException error occurred: " + ac.getMessage());
//		}catch (ArithmeticException ac) {
//			System.out.println("ArithmeticException error occurred: " + ac.getMessage());
//		} finally {

//		}

//		System.out.println("End");
//		System.out.println("");
//
//		for (int i = 0; i < 6; i++) {
//
//			try {
//
//				if (i % 2 == 0) {
//					throw new UdokaException("This is my exception");
//				}
//				if (i % 2 == 1) {
//					throw new UdokaException();
//				}
//			} catch (UdokaException e) {
//				System.out.println("Error occured: " + e.getMessage());
//			}
//
//		}
	}

	void error() {
		System.out.println("Hello");
		throw new ArithmeticException("Eniola is !smart");
	}

	
}

@SuppressWarnings("serial")
class UdokaException extends Throwable {

	public UdokaException(String message) {
		super(message);
	}

	public UdokaException() {
		super("Unknown!");
	}

}
