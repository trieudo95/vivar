package managa.factor.testing;

public class ThreadB extends ThreadSept implements Runnable{

	@Override
	protected Object clone() throws CloneNotSupportedException {

		return super.clone();
	}

	@Override
	public void run() {
		System.out.println("Create thread B implements Runnable in number : " + getOrder());
	}

	@Override
	public synchronized void start() {
		run();
		super.start();
		stop();
	}

}
