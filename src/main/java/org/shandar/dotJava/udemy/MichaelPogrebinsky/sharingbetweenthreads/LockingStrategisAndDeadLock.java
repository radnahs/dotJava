/**
 *
 * <p>Project: dotJava </p>
 * <p>Package Name: org.shandar.dotJava.udemy.MichaelPogrebinsky.sharingbetweenthreads </p>
 * <p>File Name: LockingStrategisAndDeadLock.java</p>
 * <p>Create Date: 10-Dec-2024 </p>
 * <p>Create Time: 8:05:13 pm </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2024</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */
package org.shandar.dotJava.udemy.MichaelPogrebinsky.sharingbetweenthreads;

import java.util.Random;

/**
 * order of thread execution should be the same by both the thread to please see line 99 and 103
 */
public class LockingStrategisAndDeadLock {

	public static void main(String[] args) {
		Intersection intersection = new Intersection();
		Thread trainAThread = new Thread(new TrainA(intersection));
		Thread trainBThread = new Thread(new TrainB(intersection));

		trainAThread.start();
		trainBThread.start();
	}

	public static class TrainA implements Runnable {
		private Intersection intersection;
		private Random random = new Random();

		public TrainA(Intersection intersection) {
			super();
			this.intersection = intersection;
		}

		@Override
		public void run() {
			while (true) {
				long sleepingTime = random.nextInt(5);
				try {
					Thread.sleep(sleepingTime);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				intersection.takeRoadA();
			}
		}
	}

	public static class TrainB implements Runnable {
		private Intersection intersection;
		private Random random = new Random();

		public TrainB(Intersection intersection) {
			super();
			this.intersection = intersection;
		}

		@Override
		public void run() {
			while (true) {
				long sleepingTime = random.nextInt(5);
				try {
					Thread.sleep(sleepingTime);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				intersection.takeRoadB();
			}
		}
	}

	public static class Intersection {
		private Object roadA = new Object();
		private Object roadB = new Object();

		public void takeRoadA() {
			synchronized (roadA) {
				System.out.println("Road A is locked by thread " + Thread.currentThread().getName());

				synchronized (roadB) {
					System.out.println("Train is passing through road A");
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();

					}
				}
			}
		}

		public void takeRoadB() {
			// synchronized (roadB) {//this will lead to DeadLock
			synchronized (roadA) { // the 
				System.out.println("Road B is locked by thread " + Thread.currentThread().getName());

				// synchronized (roadA) { //this will lead to DeadLock
				synchronized (roadB) {
					System.out.println("Train is passing through road B");
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}
