import java.util.concurrent.*;
import java.util.Random;

public class ExecutorServiceExample {
	public static void main(String args[]) {
		Random random = new Random(); // Create an executor of thread pool size
										// 3
		ExecutorService executor = Executors.newFixedThreadPool(3); // Sum up
																// wait
																	// times to
																	// know when
																	// to
																	// shutdown
		int waitTime = 600;
		for (int i = 0; i < 10; i++) {
			String name = "NamePrinter " + i;
			int time = random.nextInt(500);
			waitTime += time;
			Runnable runner = new TaskPrint(name, time);
			System.out.println("Adding: " + name + " / " + time);
			executor.execute(runner);
		}
		try {
			Thread.sleep(waitTime);
			executor.shutdown();
			executor.awaitTermination(waitTime, TimeUnit.MILLISECONDS);
		} catch (InterruptedException ignored) {

		}
		System.exit(0);
	}
}
