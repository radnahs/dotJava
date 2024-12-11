/**
 *
 * <p>Project: dotJava </p>
 * <p>Package Name: org.shandar.dotJava.udemy.MichaelPogrebinsky.sharingbetweenthreads </p>
 * <p>File Name: OneMonitorPerObject.java</p>
 * <p>Create Date: 06-Dec-2024 </p>
 * <p>Create Time: 7:05:39 pm </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2024</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */
package org.shandar.dotJava.udemy.MichaelPogrebinsky.sharingbetweenthreads;

import lombok.Data;

/**
 * These are both methods of the same object, and both are marked as
 * synchronized. If even one method is being executed, all other synchronized
 * methods of the same object become inaccessible to other threads
 */
public class OneMonitorPerObjectQuiz {

	/**
	 * When thread1 is executing sharedObject.increment();, thread2 cannot execute
	 * sharedObject.decrement();. And when thread2 is executing
	 * sharedObject.decrement(); ., thread1 cannot execute
	 * sharedObject.increment();,
	 * 
	 * That is because both methods are synchronized, and belong to the same object.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SharedClass sharedObject = new SharedClass();

		Thread thread1 = new Thread(() -> {
			while (true) {
				System.out.println(
						"SharedObject Counter " + Thread.currentThread().getName() + " - " + sharedObject.getCounter());
				sharedObject.increment();
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		Thread thread2 = new Thread(() -> {
			while (true) {
				System.out.println(
						"SharedObject Counter" + Thread.currentThread().getName() + " - " + sharedObject.getCounter());
				sharedObject.decrement();
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		thread1.start();
		thread2.start();
	}

	@Data
	private static class SharedClass {
		private int counter = 0;

		public synchronized void increment() {
			this.counter++;
		}

		public synchronized void decrement() {
			this.counter--;
		}
	}

}
