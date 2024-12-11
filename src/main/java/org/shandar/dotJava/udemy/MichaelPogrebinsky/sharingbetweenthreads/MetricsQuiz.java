/**
 *
 * <p>Project: dotJava </p>
 * <p>Package Name: org.shandar.dotJava.udemy.MichaelPogrebinsky.sharingbetweenthreads </p>
 * <p>File Name: Metrics.java</p>
 * <p>Create Date: 11-Dec-2024 </p>
 * <p>Create Time: 12:10:34 pm </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2024</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */
package org.shandar.dotJava.udemy.MichaelPogrebinsky.sharingbetweenthreads;

/**
 * That's right! Multiple threads calling reset and addSample methods will lock the locks in a different order, which may result in a deadlock
 */
public class MetricsQuiz {

	private long count;
	private double average;
	private long max;

	private Object countLock = new Object();
	private Object averageLock = new Object();
	private Object maxLock = new Object();

	public void addSample(long sample) {
		synchronized (countLock) {
			synchronized (averageLock) {
				synchronized (maxLock) {
					average = (average * count + sample) / (++count);
					max = Math.max(max, sample);
				}
			}
		}
	}

	public void reset() {
		synchronized (maxLock) {
			synchronized (averageLock) {
				synchronized (countLock) {
					count = 0;
					max = Integer.MIN_VALUE;
					average = 0.0;
				}
			}
		}
	}

	public long getCount() {
		synchronized (countLock) {
			return count;
		}
	}

	public long getMax() {
		synchronized (maxLock) {
			return max;
		}
	}

	public double getAverage() {
		synchronized (averageLock) {
			return average;
		}
	}

}
