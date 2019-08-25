package com.example;

import java.util.concurrent.Semaphore;

public class SemaphoreTask  implements Runnable{

	private Semaphore semaphore;
	
	
	
	public SemaphoreTask(Semaphore semaphore) {
		this.semaphore = semaphore;
	}



	@Override
	public void run() {
		
		try {
			semaphore.acquire();
			CommonTask.doTask();
			
		}catch(InterruptedException ie) 
		{
			ie.printStackTrace();
			
		}finally 
		{
			semaphore.release();
		}

	
	
	}
	

}
