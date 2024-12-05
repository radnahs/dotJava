/**
 *
 * <p>Project: dotJava </p>
 * <p>Package Name: org.shandar.dotJava.udemy.MichaelPogrebinsky.threadscreation </p>
 * <p>File Name: ThreadBasics.java</p>
 * <p>Create Date: 01-Dec-2024 </p>
 * <p>Create Time: 12:07:56 am </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2024</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */
package org.shandar.dotJava.udemy.MichaelPogrebinsky.threadscreation;

/**
 * 
 */
public class ThreadBasics {

	public static void main(String[] args) throws InterruptedException {
		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {
				// Code that will run in a new thread
				System.out.println("we are now in thread " + Thread.currentThread().getName());
				System.out.println("Current thread priority is " + Thread.currentThread().getPriority());
			}
		});

		thread.setName("New worker thread");

		thread.setPriority(Thread.MAX_PRIORITY);

		System.out.println("We are in thread: " + Thread.currentThread().getName() + " "
				+ Thread.currentThread().getId() + " before starting a new thread");
		thread.start();
		System.out.println("We are in thread: " + Thread.currentThread().getName() + " "
				+ Thread.currentThread().getId() + " after starting a new thread");

		//Thread.sleep(10000);

		
		Thread threadL = new Thread(() -> {
			// Code that will run in a new thread
			System.out.println("we are now in thread " + Thread.currentThread().getName());
			System.out.println("Current thread priority is " + Thread.currentThread().getPriority());
		});
		
		System.out.println("We are in thread: " + Thread.currentThread().getName() + " "
				+ Thread.currentThread().getId() + " before starting a new thread");
		threadL.start();
		System.out.println("We are in thread: " + Thread.currentThread().getName() + " "
				+ Thread.currentThread().getId() + " after starting a new thread");

	}

}
