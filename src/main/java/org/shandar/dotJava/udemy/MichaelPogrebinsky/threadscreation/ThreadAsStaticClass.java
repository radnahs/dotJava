/**
 *
 * <p>Project: dotJava </p>
 * <p>Package Name: org.shandar.dotJava.udemy.MichaelPogrebinsky.threadscreationpart2 </p>
 * <p>File Name: ThreadAsStaticClass.java</p>
 * <p>Create Date: 01-Dec-2024 </p>
 * <p>Create Time: 1:10:58 am </p>
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
public class ThreadAsStaticClass {

	public static void main(String[] args) {
		Thread threadT = new NewThread();
		Thread threadR = new Thread(new NewRunnableThread());
		threadT.start();
		threadR.start();
	}

	private static class NewThread extends Thread {
		@Override
		public void run() {
			Thread.currentThread().setName("ThreadThread");
			System.out.println("Hello from :- "+ Thread.currentThread().getName());//Hello from :- Thread-0

			System.out.println("Hello from :- "+ this.getName());//Hello from :- Thread-0

		}
	}

	private static class NewRunnableThread implements Runnable{
		@Override
		public void run() {
			Thread.currentThread().setName("RunnableThread");
			System.out.println("Hello from :- "+ Thread.currentThread().getName());//Hello from :- Thread-0

			//System.out.println("Hello from :- "+ this.getName());//Hello from :- Thread-0

		}
		
	}

}
