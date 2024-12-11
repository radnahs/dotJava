/**
 *
 * <p>Project: dotJava </p>
 * <p>Package Name: org.shandar.dotJava.udemy.MichaelPogrebinsky.sharingbetweenthreads </p>
 * <p>File Name: SynchronizeOnDifferentObjectsQuiz.java</p>
 * <p>Create Date: 06-Dec-2024 </p>
 * <p>Create Time: 7:20:26 pm </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2024</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */
package org.shandar.dotJava.udemy.MichaelPogrebinsky.sharingbetweenthreads;

/**
 * Both methods are indeed part of the same object, however the two synchronized
 * blocks, synchronize on different objects
 */
public class SynchronizeOnDifferentObjectsQuiz {

	public static void main(String[] args) {
		SharedClass sharedObject = new SharedClass();

		Thread thread1 = new Thread(() -> {
			while (true) {
				sharedObject.incrementCounter1();
			}
		});

		Thread thread2 = new Thread(() -> {
			while (true) {
				sharedObject.incrementCounter2();
			}
		});

		thread1.start();
		thread2.start();
	}

	static class SharedClass {
		private int counter1 = 0;
		private int counter2 = 0;

		private Object lock1 = new Object();
		private Object lock2 = new Object();

		public void incrementCounter1() {
			synchronized (lock1) {
				this.counter1++;
			}
		}

		public void incrementCounter2() {
			synchronized (lock2) {
				this.counter2++;
			}
		}
	}

}
