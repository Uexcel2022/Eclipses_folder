package resources;

public class resource {

	public static void main(String[] args) {
//
		System.out.println(resources.resource.isNumber("-9 -9 -.95", ".- "));

		System.out.println(Double.parseDouble("-.933"));

//		String string = Resources.resource.isDouble("-.68");

//		if (string != null) {
//			System.out.println(Resources.resource.isDigit(string, ".-"));
//		} else System.out.println("Invalid number");
	}

	public static String capitalized(String string) {
		String newString = " ";
		String[] splittedString = string.split(" ");
		for (int i = 0; i < splittedString.length; i++) {
			for (int j = 0; j < splittedString[i].length(); j++) {
				if (j == 0) {
					newString += String.valueOf(splittedString[i].charAt(j)).toUpperCase();
				} else {
					newString += String.valueOf(splittedString[i].charAt(j));
				}
			}
			newString += " ";
		}

		return newString;

	}

	public static String toTitleCase(String string) {
		String titleCase = String.valueOf(string.charAt(0)).toUpperCase();
		for (int i = 1; i < string.length(); i++) {
			titleCase += string.charAt(i);
		}

		return titleCase;
	}

	public static String isAlpha(String string, String exception) {
		if (string == null || string.isEmpty())
			return "empty!";
		String alpha = null;
		
		String isIn[] = new String[string.length()];
		String notIn[] = new String[string.length()];

		if (!exception.isEmpty()) {
			if (exception.contains("0-9")) {
				alpha = "abcdefghijklmnopqrstuvwxyz0123456789" + exception;
			} else
				alpha = "abcdefghijklmnopqrstuvwxyz" + exception;
		} else
			alpha = "abcdefghijklmnopqrstuvwxyz";

		char[] alphaChr = alpha.toCharArray();
		for (int i = 0; i < string.length(); i++) {
			for (int j = 0; j < alphaChr.length; j++) {
				if (String.valueOf(alphaChr[j]).equalsIgnoreCase(String.valueOf(string.charAt(i)))) {
					isIn[i] = String.valueOf(string.charAt(i));
				} else
					notIn[i] = String.valueOf(string.charAt(i));
			}
		}
		String invalidChar = "";
		for (int i = 0; i < isIn.length; i++) {
			if (isIn[i] == null) {
				invalidChar += notIn[i];
			}
		}
		if (invalidChar.length() > 0) {
			if (invalidChar.isBlank()) {
				invalidChar = "unsual charater spacing.";
				return invalidChar;
			} else
				return invalidChar;
		}

		return null;
	}

	public static String isNumber(String digit, String exception) {

		if (digit.contains(".") && exception.contains(".")) {
			String check = isDouble(digit);
			if (check == null) {
				return "Unrecognized number format!";
			}
		}

		String string = "0123456789" + exception;
		char[] validChars = string.toCharArray();
		char[] dig = digit.toCharArray();
		String[] isValid = new String[dig.length];
		String[] notValid = new String[dig.length];
		String unwatedChars = "";

		for (int i = 0; i < validChars.length; i++) {
			for (int j = 0; j < dig.length; j++) {
				if (validChars[i] == dig[j]) {
					isValid[j] = String.valueOf(dig[j]);
				} else
					notValid[j] = String.valueOf(dig[j]);
			}
		}

		String invalidChar = "";
		for (int i = 0; i < isValid.length; i++) {
			if (isValid[i] == null) {
				if (notValid[i].isBlank()) {
					if (!invalidChar.contains("spaced!")) {
						invalidChar += "spaced! ";
					}
				} else
					invalidChar += notValid[i];
			}

		}

		String[] A = digit.split(" ");
		String chk[] = new String[A.length];
		String chk2[] = new String[A.length];
		char[] x = unwatedChars.toCharArray();
		for (int i = 0; i < A.length; i++) {
			if (String.valueOf(A[i]).equalsIgnoreCase("-") || String.valueOf(A[i]).equalsIgnoreCase("-0")) {
				unwatedChars += String.valueOf(A[i]) + ' ';
			}

			char[] a = A[i].toCharArray();
			for (int j = 0; j < a.length; j++) {
				if (a[j] == '-' && j > 0) {
					chk2[i] = A[i];
					for (int n = 0; n < x.length; n++) {
						if (a[0] == x[n]) {
							chk[i] = A[i];
							unwatedChars = unwatedChars.replace(String.valueOf(x[n]), A[i]);
						}
					}
				}
			}
		}

		for (int i = 0; i < chk.length; i++) {
			if (chk[i] != chk2[i]) {
				unwatedChars += chk2[i] + ' ';
			}
		}

		for (int i = 0; i < invalidChar.length(); i++) {
			for (int j = 0; j < unwatedChars.length(); j++) {
				if (!unwatedChars.contains(String.valueOf(invalidChar.charAt(i)))) {
					unwatedChars += invalidChar.charAt(i);
				}
			}
		}

		if (!unwatedChars.isBlank()) {
			return "Invlid: " + unwatedChars;
		} else if (invalidChar.length() > 0) {
			return "Invlid: " + invalidChar;
		}
		return null;
	}

	private static String isDouble(String string) {
		if (string.endsWith(".")) {
			return null;
		}

		int countDot = 0;
		for (int i = 0; i < string.length(); i++) {
			if (string.charAt(i) == '.') {
				countDot++;
			}
		}

		if (countDot > 1) {
			return null;
		}

		return string;
	}

	public static String checkGrade2(int score) {

		if (score > 100) {
			return "Invalid score";
		} else if (score >= 80) {
			return "Outstanding";
		} else if (score >= 70) {
			return "Excellent";
		} else if (score >= 60) {
			return " Good";
		} else if (score >= 50) {
			return "Credit";
		} else if (score >= 40) {
			return "Pass";
		} else if (score < 40) {
			if (score < 0) {
				return "Invalid score";
			} else {
				return "Failed";
			}
		}

		return "Could not resolve request";
	}

}
