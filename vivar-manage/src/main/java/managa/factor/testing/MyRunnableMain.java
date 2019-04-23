package managa.factor.testing;

public class MyRunnableMain {
	public static void main(String[] args) {
		MyRunnable myRunnable = new MyRunnable();
		
		Thread thread = new Thread(myRunnable);
		thread.start();
		
		try {
			Thread.sleep(6L * 1000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		myRunnable.doStop();
	}

}
