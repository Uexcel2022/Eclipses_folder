package onthread;

//to create thread you can extend thread class OR
//implement Runnable class
//Because Runnable class has not start method 
// you need create Create thread class object pass the Runnable object into the class
// and using the Thread object to call the start method for the Runnable

class A extends Thread {
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println("Hi");
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class B extends Thread {
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println("Hello");
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class TestThread {
	public static void main(String[] args) {

//		  Thread a = new A();
//		 Thread b = new B();
//		a.start();
//		b.start();

//		Thread optimization
//         printing priority
//			System.out.println(b.getPriority());
//          Setting priority
//			a.setPriority(Thread.MAX_PRIORITY);
//		   using Thread.Sleep();
//		
//		Runnable c = new Runnable(){
//			public void run() {
//				for (int i = 0; i < 6; i++) {
//					System.out.println("Hi");
//					try {
//						Thread.sleep(30);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//
//				}
//			}
//		}

//	Created anonymous class of C and lamber expression

//		Runnable c = () -> { 
//			for (int i = 0; i < 6; i++) {
//				System.out.println("Hi");
//				try {
//					Thread.sleep(30);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			}
//
//		};
//
//		Runnable d = new D();
//
//		Thread t1 = new Thread(c);
//		Thread t2 = new Thread(d);
//		t1.start();
//		t2.start();
//
//	---------------------Thread safe---Synchronization------------

		Runnable E = new E();
		Runnable F = new F();

		Thread t3 = new Thread(E);
		Thread t4 = new Thread(F);
		t3.start();
		t4.start();
	

		try {
			t4.join();
			t3.join();		
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
         
		Counter c2 = new Counter();
		c2.getcounter();

	}
}

class C implements Runnable {
	public void run() {
		for (int i = 0; i < 6; i++) {
			System.out.println("Hi");
			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}
}

class D implements Runnable {
	public void run() { //
		for (int i = 0; i < 6; i++) {
			System.out.println("Hello");
			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}
}

//--------------Thread Safe___Syscronization-----------------

class Counter {

	static int count = 0;

	public void counter() {
		count++;
	}

	public void getcounter() {
		System.out.println(count);
	}
}

class E implements Runnable {
	Counter b = new Counter();

	public synchronized void run() {
		for (int i = 0; i < 1000; i++) {
			b.counter();
			
		}
	}
}

class F implements Runnable {
	Counter c = new Counter();

	public synchronized void run() {
		for (int i = 0; i < 1000; i++) {
			c.counter();
		}
	}
}
