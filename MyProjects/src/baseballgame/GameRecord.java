package baseballgame;

import java.util.ArrayList;

public class GameRecord {
	
	/*
	   Project Description
	   C: remove the previous value
	   D: add value: previous value * 2
	   +: add value: sum of 2 previous values;
	 */

	public static void main(String[] args) {

		ArrayList<String> scoreOps1 = new ArrayList<>();
		ArrayList<String> scoreOps2 = new ArrayList<>();
		ArrayList<String> scoreOps3 = new ArrayList<>();

		scoreOps1.add("5");
		scoreOps1.add("2");
		scoreOps1.add("c");
		scoreOps1.add("d");
		scoreOps1.add("+");

		scoreOps2.add("5");
		scoreOps2.add("-2");
		scoreOps2.add("4");
		scoreOps2.add("c");
		scoreOps2.add("d");
		scoreOps2.add("9");
		scoreOps2.add("+");
		scoreOps2.add("+");
		
		scoreOps3.add("1");

		GameRecord.manipulateArray(scoreOps1);
		GameRecord.manipulateArray(scoreOps2);
		GameRecord.manipulateArray(scoreOps3);

	}

	public static void manipulateArray(ArrayList<String> value) {

		ArrayList<String> check = new ArrayList<>();
		String previusValue = "";
		for (int i = 0; i < value.size(); i++) {
			
			if (value.get(i).equalsIgnoreCase("c") && i > 0) {
				check.remove(previusValue);
			}

			if ((value.get(i).equalsIgnoreCase("d") && i > 0)) {
				check.add("d");
				int num = Integer.parseInt(check.get(check.indexOf("d")-1));
				check.add(String.valueOf(num* 2));
				check.remove("d");
			}

			if ((value.get(i).equalsIgnoreCase("+") && i > 0)) {
				check.add("+");
				int firstNum = Integer.parseInt(check.get(check.indexOf("+")-1));
				int secendNum = Integer.parseInt(check.get(check.indexOf("+")-2));
				check.add(String.valueOf(firstNum+secendNum));
				check.remove("+");
			}

			if (!value.get(i).equalsIgnoreCase("c") && !value.get(i).equalsIgnoreCase("d")
					&& !value.get(i).equalsIgnoreCase("+")) {
				
				check.add(value.get(i));
				previusValue = value.get(i);
			}
			System.out.println(check);
		}
		int sum = 0;
		for (String n : check) {
			sum += Integer.parseInt(n);
		}
		System.out.println("\nTotal sum: "+ sum);
		System.out.println();
	}

}
