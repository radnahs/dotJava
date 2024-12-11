/**
 *
 * <p>Project: dotJava </p>
 * <p>Package Name: org.shandar.dotJava.udemy.MichaelPogrebinsky.sharingbetweenthreads </p>
 * <p>File Name: AtomicOperaionsDemo.java</p>
 * <p>Create Date: 06-Dec-2024 </p>
 * <p>Create Time: 8:20:49 pm </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2024</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */
package org.shandar.dotJava.udemy.MichaelPogrebinsky.sharingbetweenthreads;

import java.util.Random;

public class AtomicOperaionsDemo {

	public static void main(String[] args) {
		Metrics metrics = new Metrics();
		
		BussinessLogic bussinessLogicThread1 = new BussinessLogic(metrics);
		BussinessLogic bussinessLogicThrad2 = new BussinessLogic(metrics);
		MetricsPrinter metricsPrinter = new MetricsPrinter(metrics);
		
		bussinessLogicThread1.start();
		bussinessLogicThrad2.start();
		metricsPrinter.start();
	}

	public static class MetricsPrinter extends Thread {
		private Metrics metrics;

		public MetricsPrinter(Metrics metrics) {
			super();
			this.metrics = metrics;
		}

		@Override
		public void run() {
			while (true) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				double currentAverage = metrics.getAverage();
				System.out.println("Current Average is " + currentAverage);
			}
		}
	}

	public static class BussinessLogic extends Thread {
		private Metrics metrics;
		private Random random = new Random();

		public BussinessLogic(Metrics metrics) {
			super();
			this.metrics = metrics;
		}

		@Override
		public void run() {
			while (true) {
				long start = System.currentTimeMillis();

				try {
					Thread.sleep(random.nextInt(10));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				long end = System.currentTimeMillis();

				metrics.addSample(end - start);
			}
		}
	}

	public static class Metrics {
		private long count = 0;
		private volatile double average = 0.0; // as double is not atomic in nature, thus we add volatile to make it
												// atomic.

		public void addSample(long sample) {
			double currentSum = average * count;
			count++;
			average = currentSum + sample / count;
		}

		public double getAverage() {
			return average;
		}

	}

}
