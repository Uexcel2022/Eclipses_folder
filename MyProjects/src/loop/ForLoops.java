package loop;

import java.util.Scanner;

public class ForLoops {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		ForLoops fl = new ForLoops();
//		fl.multiloopsExecution();
		fl.greetReturn();
		fl.greetBeak();
		fl.greetContinue();;
	}

	void multiloopsExecution() {
		for (int i = 0; i < 3; i++) {
			loop2();
		}
	}

	void loop1() {
		int num = 4;
		int i;
		for (i = 1; i <= 12; i++) {
			String result = String.format("%d * %d = %d", num, i, (i * num));
			System.out.println(result);
		}

		int num1 = 5;
		int x = 1;
		for (; x <= 12;) {
			String result = String.format("%d * %d = %d", num1, x, (x * num1));
			System.out.println(result);
			x++;
		}

		int num2 = 4;
		for (int j = 1; j <= 12; j++) {
			String result = String.format("%d * %d = %d", num2, j, (j * num2));
			System.out.println(result);
		}
	}

	void loop2() {
		System.out.print("Enter a number:");
		int num = sc.nextInt();
		int i;
		for (i = 1; i <= 12; i++) {
			String result = String.format("%d * %d = %d", num, i, (i * num));
			System.out.println(result);
		}

	}

	void greetReturn() {
		System.out.println("Start");
		for (int i = 3; i <= 7; i++) {
			if (i == 5) {
				return; // return - break; - continue
			} else if (i % 4 == 0) {
				System.out.println("All 4s");
			} else {
				System.out.println(i);
			}
			System.out.println("Here at " + i);
		}
		System.out.println("end");
	}

	void greetBeak() {
		System.out.println("Start");
		for (int i = 3; i <= 7; i++) {
			if (i == 5) {
				break; // return - break; - continue
			} else if (i % 4 == 0) {
				System.out.println("All 4s");
			} else {
				System.out.println(i);
			}
			System.out.println("Here at " + i);
		} 
		System.out.println("end");
	}

	void greetContinue() {
		System.out.println("Start");
		for (int i = 3; i <=7; i++) {
			if (i == 5) {
				continue; // return - break; - continue
			} else if (i % 4 == 0) {
				System.out.println("All 4s");
			} else {
				System.out.println(i);
			}
			System.out.println("Here at " + i);
		}
		System.out.println("end");
	}
}
