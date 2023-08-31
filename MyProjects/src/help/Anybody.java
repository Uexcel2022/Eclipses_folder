package help;

import java.util.Arrays;

//import java.util.Scanner;

public class Anybody {

	public static void main(String[] args) {
		Anybody an = new Anybody();
		String valid = an.validation("-", "-");
		if (valid != null) {
			System.err.println(valid);
		}

	}

	public String validation(String digit, String chars) {
		String[] validChars = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", chars };
		int charsInDigitCount = 0;
		int validCharsInDigitCount = 0;
		String unwatedChars = "";

		String validCharInDigit = "";
		String[] k = digit.split(" ");
		for (int i = 0; i < k.length; i++) {
			char[] b = k[i].toCharArray();
			for (int j = 0; j < b.length; j++) {
				charsInDigitCount++;
				for (int c = 0; c < validChars.length; c++) {
					if (String.valueOf(b[j]).equalsIgnoreCase(String.valueOf(validChars[c]))) {
						validCharInDigit += String.valueOf(b[j]) + " ";
						validCharsInDigitCount++;
					}
				}

			}
		}

		if (charsInDigitCount > validCharsInDigitCount) {
			int h = 0;
			int p = 0;
			String[] notIndex = new String[digit.length()];
			char[] v = digit.toCharArray();
			char[] y = validCharInDigit.toCharArray();
			for (p = 0; p < v.length; p++) {
				for (h = 0; h < y.length; h++) {
					if (!String.valueOf(v[p]).isBlank()) {
						if (v[p] == y[h]) {
							notIndex[p] = String.valueOf(p);
							break;
						}
					}
				}
			}
			for (int i = 0; i < notIndex.length; i++) {
				if (notIndex[i] == null && v[i] != ' ') {
					unwatedChars += (String.valueOf(digit.charAt(i))) + ' ';
				}
			}

		}
//		System.out.println(unwatedChars);
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
						}//else
//							chk2[i] = A[i];
					}
				}
			}
		}

		System.out.println(Arrays.toString(chk));
		System.out.println(Arrays.toString(chk2));
		for (int i = 0; i < chk.length; i++) {
			if (chk[i] != chk2[i]) {
				unwatedChars += chk2[i] + ' ';
			}
		}
		if (!unwatedChars.isBlank()) {
			return "Invlid character(s) detected. Remove: " + unwatedChars;
		} else
			return null;
	}
	
	

	public String isDigit(String digit, String chars) {
		String[] validChars = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", chars };
		int charsInDigitCount = 0;
		int validCharsInDigitCount = 0;
		String unwatedChars = "";
		String validCharInDigit = "";
		String[] k = digit.split(" ");
		for (int i = 0; i < k.length; i++) {
			char[] b = k[i].toCharArray();
			for (int j = 0; j < b.length; j++) {
				charsInDigitCount++;
				for (int c = 0; c < validChars.length; c++) {
					if (String.valueOf(b[j]).equalsIgnoreCase(String.valueOf(validChars[c]))) {
						validCharInDigit += String.valueOf(b[j]) + " ";
						validCharsInDigitCount++;
					}
				}
			}
		}

		if (charsInDigitCount > validCharsInDigitCount) {
			int h = 0;
			int p = 0;
			String[] notIndex = new String[digit.length()];
			char[] v = digit.toCharArray();
			char[] y = validCharInDigit.toCharArray();
			for (p = 0; p < v.length; p++) {
				for (h = 0; h < y.length; h++) {
					if (!String.valueOf(v[p]).isBlank()) {
						if (v[p] == y[h]) {
							notIndex[p] = String.valueOf(p);
							break;
						}
					}
				}
			}

			for (int i = 0; i < notIndex.length; i++) {
				if (notIndex[i] == null && v[i] != ' ') {
					unwatedChars += (String.valueOf(digit.charAt(i))) + ' ';
				}
			}

		}

		String[] A = digit.split(" ");
		for (int i = 0; i < A.length; i++) {
			if (String.valueOf(A[i]).equalsIgnoreCase("-") || String.valueOf(A[i]).equalsIgnoreCase("-0")) {
				if (String.valueOf(A[i]).equalsIgnoreCase("-")) {
					unwatedChars += String.valueOf(A[i]);
				} else
					unwatedChars += String.valueOf(A[i] + ' ');

			}
			char[] a = A[i].toCharArray();
			for (int j = 0; j < a.length; j++) {
				if (a[j] == '-' && j > 0) {
					unwatedChars += (String.valueOf(A[i]) + ' ');
				}
			}
		}
		if (!unwatedChars.isBlank()) {
			return "Invlid character(s) detected. Remove: " + unwatedChars;
		} else
			return null;
	}

}
