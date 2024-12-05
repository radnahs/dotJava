/**
 *
 * <p>Project: dotJava </p>
 * <p>Package Name: org.shandar.dotJava.udemy.MichaelPogrebinsky.threadscreation </p>
 * <p>File Name: ThreadUncaughtException.java</p>
 * <p>Create Date: 01-Dec-2024 </p>
 * <p>Create Time: 12:51:08 am </p>
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
public class ThreadUncaughtException {
	
	public static void main(String[] args) throws InterruptedException{
		Thread thread = new Thread(()->{
			//Code that will run in a new thread
            throw new RuntimeException("Intentional Exception");
		});
		
		thread.setName("Misbehaving thread");
		
		/*thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
			
			@Override
			public void uncaughtException(Thread t, Throwable e) {
				System.out.println("A critical error happened in thread " + t.getName()
                + " the error is " + e.getMessage());
			}
		});*/
		
		thread.setUncaughtExceptionHandler((t,e)->{
			System.out.println("A critical error happened in thread " + t.getName()
            + " the error is " + e.getMessage());
		});
		
		thread.start();

	}

}
