package managa.factor.testing;

public class ThreadTest {

	private static int max = 8;

	public static void main(String[] args) {

		ThreadA threadA = new ThreadA();

		ThreadB threadB = new ThreadB();

		for (int i = 0; i < max; i++) {
			
			threadA.setOrder(i);
			threadB.setOrder(i);

		
			threadA.start();
			threadB.start();
			
		}

	}

}
