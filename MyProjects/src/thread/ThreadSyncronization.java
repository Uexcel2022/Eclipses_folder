package thread;

class Counter {
	int count = 0;

	public synchronized void counter() {
		count++;
//		System.out.println(count);
	}
	
	public int getCount() {
		return count;
	}
}

public class ThreadSyncronization extends Thread {
	
	static Counter cb = new Counter();
	public void run() {

		if (Thread.currentThread().getName().equals("count")) {
			try {
				count();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		if (Thread.currentThread().getName().equals("count2")) {
			try {
				count2();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
      
	}
    
	public void count() throws InterruptedException {

		for (int i = 0; i < 100; i++) {
			Thread.sleep(10);
			cb.counter();
		}

	}

	public void count2() throws InterruptedException {

		for (int i = 0; i < 100; i++) {
			Thread.sleep(10);
			cb.counter();
		}

	}

	public static void main(String[] args) throws InterruptedException {
		ThreadSyncronization sn = new ThreadSyncronization();
	
		Thread one = new Thread(sn);
		Thread two = new Thread(sn);
		one.setName("count");
		two.setName("count2");
		one.start();
		two.start();
		one.join();
		two.join();
		System.out.println(cb.getCount());
      

	}

}
