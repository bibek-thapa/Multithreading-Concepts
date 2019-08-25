package com.example;

import java.util.concurrent.Semaphore;

class Shared
{
	static int count = 0 ;
}

class MyThread extends Thread
{
	Semaphore sem;
	String threadName;
	
	public MyThread(Semaphore sem, String threadName) 
	{
		super(threadName);
		this.sem = sem;
		this.threadName = threadName;
	}

	@Override
	public void run() {
		if(this.threadName.equals("A")) 
		{
			try {
			System.out.println("Starting " + threadName);
			sem.acquire();
			for(int i = 0 ; i < 5 ; i++) 
			{
				
				Shared.count ++ ;
				System.out.println(threadName + ":" + Shared.count);
				Thread.sleep(10);
			}
			}catch(InterruptedException ie) 
			{
				ie.printStackTrace();
			}
			
				System.out.println(threadName + "releases the permit");
				sem.release();
			
		}
		
		else 
		{
			System.out.println("Starting " + threadName);
			try {
			sem.acquire();
			for(int i = 0 ; i < 5 ; i++) 
			{
				
				
					Shared.count -- ;
					System.out.println(threadName + ":" + Shared.count);	
				
			}
			}catch(InterruptedException ie) 
			{
				ie.printStackTrace();
			}
			
				System.out.println(threadName + "releases the permit");
				sem.release();
				
			}
			
		
		
	}
	
	

}

public class SemaphoreBasics {
	
	public static void main(String[] args) 
	{
		Semaphore sem = new Semaphore(1);
		
		MyThread t1 = new MyThread(sem , "A");
		MyThread t2 = new MyThread(sem, "B");
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
	}

}
