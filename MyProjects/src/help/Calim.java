package help;
//import java.util.Arrays;
import java.util.Scanner;

public class Calim {
	
	
	public void show() {
//		String [] A = {"To School", " In the Mosque", "Eba", "Exam"};
//		String [] status = {"Running", "Sitting", "Eating", "Writing"};
		
//		String [] A = new String[4];  
//		String  [] status = new String[4]; 
		
		String [] A;
		int  [] price;
		
		A = new String [4];
		price = new int[4]; 
			
		A[0] = "Laptop";
		A[1] = "Charger";
		A[2] = "Palmtop";
		A[3] = "Mouse";
		
		price[0] = 200000;
		price[1] =  5000;
		price[2] =  100000;
		price[3] =  3500;
		
		for(int n : price) {
	       System.out.println(n);
		}
	}
			
//	System.out.println(Arrays.toString(A));
//		for(int i = 0; i < A.length; i++) {
//			System.out.println(A[i] + " : " + price[i]);
//		}
//		
//	}
	
	
	
	int j = 0;
	String[] paint;
	String[] description = { "-", "-", "-", "-" };
	Scanner sc = new Scanner(System.in);
	String [][] multid = new String[3][4];

	Calim() {

		paint = new String[4];
		paint[0] = "A";
		paint[1] = "B";
		paint[2] = "B";
		paint[3] = "C";
	}

	void display() {
		for (String p[] : multid) {
			for (String n : p) {
				System.out.println(n);
				
			}	
			
		}	
//		while (j < paint.length) {
//			System.out.print("\nEnter a string: ");
//			String value = sc.nextLine();
//			System.out.println(j);
//    
//			for (int i = 0; i < paint.length; i++) {
//				if (paint[i] != null && paint[i].equalsIgnoreCase(value)) {
//					description[i] = paint[i];
//					paint[i] = null;
//					j++;
//					System.out.println(j);
//					display();			
//
//				}
////				for (String p : description) {
////					if (p != null)
////						System.out.println(p);
////				}
//			}
//		}
	}

	public static void main(String[] args) {
		Calim c = new Calim();
		c.show();
//		c.display();
	}

}





















