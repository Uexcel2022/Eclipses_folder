package exceptionhandling;

@SuppressWarnings("serial")

class UdokaException extends RuntimeException {

	public UdokaException(String message) {

		super(message);
	}

}

public class Testing {

	public static void main(String[] args) {
		int num1 = 18, num2 = 9;
		try {
			if (num2 == 0) {
				throw new UdokaException("Cannot divide a number by Zero");
			}
			System.out.println(num1 / num2);

		} catch (UdokaException e) {
			System.err.println(e);
		}

		ExceptionDocking dc = new ExceptionDocking();
		try {
			dc.show();
		} catch (ArithmeticException e) {
			System.out.println(e);
		}
		System.out.println("OK");
	}
	
}

class ExceptionDocking {

	public void show() throws ArithmeticException {

		System.out.println(20 / 4);

	}

}
