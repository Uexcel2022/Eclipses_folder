package inheritance;

public class RunShoe {

	public static void main(String[] args) {
		Walking w1 = new Walking("Hanwag", 43.5, true);
		Walking w2 = new Walking("Merrel", 42, false);
		Running rn = new Running("Nike", 43, 250);
		Shoe[] shoe = { rn, w1, w2 };
		for (Shoe n : shoe) {
			if (n.getClass().getSimpleName().equals("Running")) {
				Running r = (Running) n;
				System.out.println(String.format("%-10s  size %-6s %.0f grams / shoe", r.brand, r.size, r.weight));
			}
			if (n.getClass().getSimpleName().equals("Walking")) {
				Walking w = (Walking) n;
				if (w.goreTex) {
					System.out.println(String.format("%-8s size %-5s Gore-Tex", w.brand, w.size));
				} else
					System.out.println(String.format("%-10s size %-6s No Gore-Tex", w.brand, w.size));
			}
		}
	}
}






//System.out.println(w2.getClass().getName());