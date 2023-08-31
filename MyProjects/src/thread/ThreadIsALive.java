package thread;

class NewThread extends Thread {
	Thread thread;

	public NewThread() {
		thread = new Thread(this, "ChiledThread");
		System.out.println("New thread:" + thread.getName() + " created");
		start();
	} 
	
	public void run(){
		for (int i = 0; i < 5; i++) {
			try {
				Thread.sleep(100);
				System.out.println(thread +"loop:" + i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

public class ThreadIsALive {
	public static void main(String[] args) throws InterruptedException {
		NewThread obj = new NewThread();
		
		System.out.println("Is Alive:" + obj.thread + " ? " + obj.isAlive());
		  
			try {
				for (int i = 0; i < 5; i++) {
				Thread.sleep(100);
				System.out.println("Is Alive:" + obj.thread + " ? " + obj.isAlive());
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
				
			}
			System.out.println("Is Alive:" + obj.thread + " ? " + obj.isAlive());
			System.out.println("Main thread is exiting");
		}
		
}
