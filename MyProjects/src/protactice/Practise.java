package protactice;

import java.util.Arrays;
import java.util.Scanner;

public class Practise {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
//		String sentence = "Java is good is good is good";
		Scanner sc = new Scanner(System.in);
		Practise p = new Practise();
//		p.copyToArray();
//		String m = p.replaceChars(sentence, "o", "");
//		System.out.println(m);
		p.stringBuilder();
		sc.close();

	}

	public String relaceAllChars(String string, String replace, String replacement) {
		for (int i = 0; i < string.length(); i++) {
			if (String.valueOf(string.charAt(i)).equals(replace.toUpperCase())) {
				return string.replace(replace.toUpperCase(), replacement);
			}
		}

		for (int j = 0; j < string.length(); j++) {
			if (String.valueOf(string.charAt(j)).equals(replace)) {
				return string.replace(replace, replacement);
			}
		}

		return null;
	}

	public void copyToArray() {
		String sentence = "Java is good is good is good";
//	String n =	sentence.concat(" and love coding");
//	System.out.println(n);
//	System.out.println(sentence.contains("Java")); //partial match returns true;
//	System.out.println(sentence.contentEquals("Java is good")); //complete match returns 
//	System.out.println(sentence.endsWith("good"));
//	System.out.println(sentence.equals("Java is good")); // complete match returns true
//		System.out.println(sentence.indent(0)); margin control;
//		System.out.println(sentence.replaceAll(sentence, "come"));
//		String s = "C o A";
//		String[] i  = s.split(" ");
//		System.out.println(i[2]);
//		System.out.println(sentence.indexOf("d", sentence.length()-1)); // search for the char and its index
//		System.out.println(sentence.replaceFirst("good", "simple")); // replace first occurrence of char/word
//		System.out.println(sentence.replaceAll("good", "simple"));// replace all appearance of char/word
//		System.out.println(sentence.substring(12));// start to end
//		System.out.println(sentence.substring(0, 4)); // start and end point
//		System.out.println(sentence.subSequence(0, 12)); // Start and end
		
		System.out.println(sentence);
		int strtIndex = sentence.lastIndexOf("g");

		int endIndex = sentence.lastIndexOf("d") + 1;

		char[] array = new char[20];
		sentence.getChars(strtIndex, endIndex, array, 16);
		System.out.println(Arrays.toString(array));
	}

	public String replaceChars(String string, String replace, String replacement) {
		boolean isIn = false;
		char[] sot = string.toCharArray();
		String newString = " ";
		for (char n : sot) {
			if (String.valueOf(n).equalsIgnoreCase(replace)) {
				newString += replacement;
				isIn = true;
			} else {
				newString += String.valueOf(n);
			}
		}
		if (isIn)
			return newString;
		else
			return null;
	}

	public void stringBuilder() {
		StringBuilder sb = new StringBuilder();
		sb.append("Come " );
		sb.append(8.9);
		sb.append(" compromise");
		sb.replace(0, 8, "Love");
//		sb.reverse();
		System.out.println(sb);
	}
}





















