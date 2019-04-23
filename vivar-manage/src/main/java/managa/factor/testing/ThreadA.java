package managa.factor.testing;

public class ThreadA extends ThreadSept implements Runnable {

	@Override
	protected Object clone() throws CloneNotSupportedException {

		return super.clone();
	}

	@Override
	public void run() {
		System.out.println("Create thread A implements Runnable in number : " + getOrder());
		
	}

	@Override
	public synchronized void start() {
		run();
		super.start();
		stop();
		
	}

}
