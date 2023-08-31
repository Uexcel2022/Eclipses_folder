package innerclasses;

class Arithmetic {
	public void add() {

	}

	public void subtract() {

	}
}

class One {
	void acceptArithmethicObj(Arithmetic obj) {
		obj.add();
		obj.subtract();
	}
}

public class Innerclass {

	public void show() {
		System.out.println("The show in outer class");
	}

	class regularInner {
		public void insideShow() {
			System.out.println("The insideshow method in the inner class");

		}

		public void showB() {
			class MethodLocalInnerClass {

				public void classInmethodMethod() {
					System.out.println("from MethodLocalInnerClass in the regular inner class");
				}

			}

			MethodLocalInnerClass ml = new MethodLocalInnerClass();
			ml.classInmethodMethod();
		}
	}

	public static void main(String[] args) {
		Innerclass in = new Innerclass();
		in.show();

		regularInner iin = in.new regularInner();
		iin.insideShow();
		iin.showB();

		staticInnerClass k = new Innerclass.staticInnerClass();
		Innerclass.staticInnerClass k2 = new staticInnerClass();
		k.insideShow();
		k2.insideShow();

		new One().acceptArithmethicObj(new Arithmetic());

		One h1 = new One();
		h1.acceptArithmethicObj(new Arithmetic(){
			@Override
			public void add() {
				System.out.println("new definition");
			}
			
			public void subtract() {
				System.out.println("new definition");
			}
			
		});
	}

	static class staticInnerClass {
		public void insideShow() {
			System.out.println("The show method in the inner static class");
		}
	}
}
