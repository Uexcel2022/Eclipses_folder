package inheritance;

public class Shoe {
	public final String brand;
	public final double size;

	public Shoe(String brand, double size) {
		this.brand = brand;
		this.size = size;
	}

}

class Walking extends Shoe {
	public final boolean goreTex;

	public Walking(String brand, double size, boolean type) {
		super(brand, size);
		this.goreTex = type;
	}

}

class Running extends Shoe {
	public final double weight;

	public Running(String brand, double size, double weight) {
		super(brand, size);
		this.weight = weight;

	}

}

class Display {

	void display(Walking obj1, Running obj2) {
		Object[] name = { obj1.brand, obj1.size, obj1.goreTex, String.format("%.0f", obj2.weight) + " grams / shoe" };
		for (Object c : name) {
			if (c.equals(true)) {
				c = "Gore-Tex";
			}
			if (c.equals(false)) {
				c = "No Gore-Tex";
			}
			System.out.print(c + " ");
		}
		System.out.println();
	}

	void display(Running obj) {
		Object[] name = { obj.brand, "size", obj.size, String.format("%.0f", obj.weight) + " grams / shoe" };
		for (Object c : name) {
			System.out.print(c + " ");
		}
		System.out.println();
	}

	void display(Walking obj) {
		Object[] name = { obj.brand, "size", obj.size, obj.goreTex };
		for (Object c : name) {
			if (c.equals(true)) {
				c = "Gore-Tex";
			}
			if (c.equals(false)) {
				c = "No Gore-Tex";
			}
			System.out.print(c + " ");
		}
		System.out.println();
	}

	void display(Running obj1, Walking obj2) {
		Object[] name = { obj1.brand, "size", obj1.size, obj2.goreTex,
				String.format("%.0f", obj1.weight) + " grams / shoe" };
		for (Object c : name) {
			if (c.equals(true)) {
				c = "Gore-Tex";
			}
			if (c.equals(false)) {
				c = "No Gore-Tex";
			}

			System.out.print(c + " ");
		}
		System.out.println();
	}

}

//for (int i = 0; i < String.valueOf(c).length(); i++) {
//if (String.valueOf(c).charAt(i) == '.' && String.format("%.0f", c).length() > 2) {
//	c = String.format("%.0f", c) + " grams / shoe";
//}
//}
