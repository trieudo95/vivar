package managa.factor.testing;

public class ThreadSept extends Thread{
	
	public ThreadSept() {
		
	}
	
	public ThreadSept(int order) {
		super();
		this.order = order;
	}
	
	private int order;

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}
	
	public void runThread() {
		System.out.println("Thread running "+getOrder());
	}

	@Override
	public synchronized void start() {
	
	}
	
	
	
}
