package com.example;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {

	Semaphore binary = new Semaphore(1);

	public static void main(String[] args) {

		final SemaphoreTest test = new SemaphoreTest();

		new Thread() {
			@Override
			public void run() {
				test.mutualExclusion();
			}
		}.start();
		
		
		new Thread() {
			@Override
			public void run() {
				test.mutualExclusion();
			}
		}.start();
	}

	private void mutualExclusion() {
		
		try 
		{
			binary.acquire();
			
			System.out.println(Thread.currentThread().getName()+ " inside mutual "
					+ "exclusive region");
			
		}catch(InterruptedException ie) 
		{
			ie.printStackTrace();
		}
		finally 
		{
			binary.release();
			System.out.println(Thread.currentThread().getName()+ "  outside of  mutual "
					+ "exclusive region");
		}
		

	}

}
