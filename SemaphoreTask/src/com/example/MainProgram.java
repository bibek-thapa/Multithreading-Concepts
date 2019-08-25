package com.example;

import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MainProgram {

	public static void main(String[] args) {
		
		Semaphore semaphore = new Semaphore(3);
		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
		for(int i=0 ; i < 10 ; i ++) 
		{
			executor.execute(new SemaphoreTask(semaphore));
		}
		
		executor.shutdown();
		
		try 
		{
			executor.awaitTermination(1, TimeUnit.DAYS);
		}catch(InterruptedException ie) 
		{
			ie.printStackTrace();
		}
	}

}
