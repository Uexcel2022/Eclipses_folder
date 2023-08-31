package brocode;

import java.util.Random;

public class RandomClass {
	public static void main(String[] args) {
		RandomClass.random();
	}

	public static void random() {
		Random random = new Random();
		int x = random.nextInt(6)+1;
		System.out.println(x);
		double y = random.nextDouble();
		System.out.println(y);
		boolean z = random.nextBoolean();
		System.out.println(z);
	}
}
