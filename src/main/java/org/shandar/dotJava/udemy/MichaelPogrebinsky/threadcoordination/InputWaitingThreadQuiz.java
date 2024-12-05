/**
 *
 * <p>Project: dotJava </p>
 * <p>Package Name: org.shandar.dotJava.udemy.MichaelPogrebinsky.threadcoordination </p>
 * <p>File Name: InputWaitingThreadQuiz.java</p>
 * <p>Create Date: 03-Dec-2024 </p>
 * <p>Create Time: 4:13:10 pm </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2024</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */
package org.shandar.dotJava.udemy.MichaelPogrebinsky.threadcoordination;

import java.io.IOException;

/**
 * the only way to programmatically stop the application is to make the thread a
 * daemon. Unfortunately System.in.read() does not respond to
 * Thread.interrupt();
 * 
 * <pre>
 * The only ways to stop the application are: 
 * 1. For the user to type in the letter 'q'. 
 * 2. Set <code>thread.setDaemon(true);</code> in the main method, before starting the thread 
 * 3. Forcefully kill the application
 * </pre>
 */
public class InputWaitingThreadQuiz {

	public static void main(String[] args) {
		Thread thread = new Thread(new WaitingForUserInput());
		thread.setDaemon(true);
		thread.setName("InputWaitingThreadQuiz");
		thread.start();
		// thread.interrupt();
	}

	private static class WaitingForUserInput implements Runnable {
		@Override
		public void run() {
			try {
				while (true) {
					char input = (char) System.in.read();
					if (input == 'q') {
						return;
					}
				}
			} catch (IOException e) {
				System.out.println("An exception was caught " + e);
			}
			;
		}
	}
}
