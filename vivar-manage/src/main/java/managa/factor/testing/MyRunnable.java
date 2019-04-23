package managa.factor.testing;

public class MyRunnable implements Runnable {

	private boolean doStop = false;

	public synchronized void doStop() {
		this.doStop = true;
	}

	public synchronized boolean keepRunning() {
		return this.doStop == false;
	}

	@Override
	public void run() {
		// keep doing what this thread should do
		System.out.println("Running");

		try {
			Thread.sleep(3L * 1000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
