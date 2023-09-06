package com.uexcel.vowels;

public class Vowels {

	public void vowels(String string) {
		String targetChrs = "aeiou";
		String found = "";
		String checking = "";
		for (char n : string.toCharArray()) {
			if (targetChrs.contains(String.valueOf(n).toLowerCase())) {
				if (!checking.contains(String.valueOf(n))) {
					found += n;
					checking += String.valueOf(n).toLowerCase();
				}
			}
		}
		System.out.println(found);

	}

	public static void main(String[] args) {
		Vowels v = new Vowels();
		v.vowels("cOeemo");
	}
}
