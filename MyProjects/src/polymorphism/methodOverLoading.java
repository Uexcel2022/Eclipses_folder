package polymorphism;
// Polymorphism means many behavours. This mean an entity can behave differently.
// One way to implement polymorphism is method overloading.

public class methodOverLoading {
	
	int multiplication(int num1, int num2) {
		return (num1* num2);
	}
	
	int multiplication(int num1, int num2, int num3) {
		return (num1 * num2 * num3);
	}
	
	double multiplication(double num1, double num2) {
		return (num1 * num2);
	}
	
	public static void main(String[] args) {
		methodOverLoading mol = new methodOverLoading();
		System.out.println(mol.multiplication(5, 4));
		System.out.println(mol.multiplication(5, 4, 2));
		System.out.println(mol.multiplication(5.5, 4.5));	
	}

}




