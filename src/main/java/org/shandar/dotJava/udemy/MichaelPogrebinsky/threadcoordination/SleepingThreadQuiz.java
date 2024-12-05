/**
 *
 * <p>Project: dotJava </p>
 * <p>Package Name: org.shandar.dotJava.udemy.MichaelPogrebinsky.threadcoordination </p>
 * <p>File Name: SleepingThreadQuiz.java</p>
 * <p>Create Date: 03-Dec-2024 </p>
 * <p>Create Time: 8:40:15 pm </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2024</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */
package org.shandar.dotJava.udemy.MichaelPogrebinsky.threadcoordination;

import java.time.LocalDateTime;

/**
 * That is correct. As a rule of thumb, never leave a catch block empty, and use
 * the InterruptedException catch block to gracefully stop the current thread
 * (by adding some print or cleaning code before returning from the run method)
 * 
 * Without modifying the code, the application will not stop. We need to add a
 * return; statement inside the catch (InterruptedException e) block to stop the
 * application.
 */

public class SleepingThreadQuiz {

	public static void main(String[] args) {
		Thread thread = new Thread(new SleepingThread());
		thread.start();
		thread.interrupt();
	}

	public static class SleepingThread implements Runnable {

		@Override
		public void run() {
			while (true) {
				try {
					System.out.println(LocalDateTime.now());
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					e.printStackTrace();
					//return;
				}
			}
		}

	}

}
