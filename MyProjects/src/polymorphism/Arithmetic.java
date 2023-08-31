package polymorphism;

public class Arithmetic {
	String arithmetic(double num1, String op, double num2) {
		double result = 0;
		if (op.equals("*") || op.equals("+") || op.equals("/") || op.equals("-")) {
			if (op.equals("*"))
				result = num1 * num2;

			else if (op.equals("+"))
				result = num1 + num2;

			else if (op.equals("-"))
				result = num1 - num2;

			else if (op.equals("/"))
				result = num1 / num2;

			return String.format("%s %s %s = %s", num1, op, num2, result);
		} else
			return "error";
	}

	public static void main(String[] args) {
		Arithmetic ar = new Arithmetic();
		String result1 = ar.arithmetic(8, "*", 2);
		ar.display(result1);
		String sResult1 = Arithmetic.arithmetic(5, 10, "+");
		ar.display(sResult1);
		String result2 = ar.arithmetic(8, "-", 2);
		ar.display(result2);
		String result3 = ar.arithmetic(8, "*", 2);
		ar.display(result3);

	}

	static String arithmetic(double num1, double num2, String op) {
		if (op.equals("*") || op.equals("+") || op.equals("/") || op.equals("-")) {
			double result = switch (op) {
			case "+" -> num1 + num2;
			case "/" -> num1 / num2;
			case "-" -> num1 - num2;
			case "*" -> num1 * num2;
			default -> 0;
			};
			return String.format("%s %s %s = %s", num1, op, num2, result);
		} else
			return "error";
	}

	void display(String result) {
		if (result.equalsIgnoreCase("error"))
			System.out.println("The arithmetic operation could not be resolved");
		else
			System.out.println(result);
	}
}
