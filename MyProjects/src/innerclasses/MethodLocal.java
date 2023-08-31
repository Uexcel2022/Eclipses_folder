package innerclasses;

public class MethodLocal {
	private String x = "MyouterCLass";
	
	public void display() {
//		final String string = "Method local inner class";
		System.out.println(x);
		
		class Inner{
			final String z = "Local variable";
			
			public void print() {
				System.out.println("Outer x: " + x);
				System.out.println("Inner z: "+ z);
			}
			
		}
		Inner obj = new Inner();
		obj.print();
	}

}
