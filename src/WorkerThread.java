
public class WorkerThread implements Runnable {
	
	private String message;
	
	public WorkerThread(String s){
		this.message=s;
	}

	public void run() {
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread().getName()+"(Start) message="+message);
		processMessage();
		System.out.println(Thread.currentThread().getName()+"(End)");
	}
	private void processMessage(){
		try
		{
			Thread.sleep(2000);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}

}
