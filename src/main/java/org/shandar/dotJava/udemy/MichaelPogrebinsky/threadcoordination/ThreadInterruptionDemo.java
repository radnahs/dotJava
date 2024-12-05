/**
 *
 * <p>Project: dotJava </p>
 * <p>Package Name: org.shandar.dotJava.udemy.MichaelPogrebinsky.threadcoordination </p>
 * <p>File Name: ThreadInterruptionDemo.java</p>
 * <p>Create Date: 03-Dec-2024 </p>
 * <p>Create Time: 7:42:04 pm </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2024</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */
package org.shandar.dotJava.udemy.MichaelPogrebinsky.threadcoordination;

import java.math.BigInteger;

/**
 * 
 */
public class ThreadInterruptionDemo {

	public static void main(String[] args) throws InterruptedException {
		// Thread thread = new Thread(new BlockingTask());
		// thread.start();
		// thread.interrupt();

		//

		Thread threadLCT = new Thread(new LongComputationTask(new BigInteger("2"), new BigInteger("10")));
		//Thread threadLCT = new Thread(new LongComputationTask(new BigInteger("200000"), new BigInteger("100000000")));
		threadLCT.start();
		Thread.sleep(10000);// to run the lower number not that big calculation
		threadLCT.interrupt();

	}

	private static class BlockingTask implements Runnable {

		@Override
		public void run() {
			try {
				Thread.sleep(50000);
			} catch (InterruptedException e) {
				System.out.println("Existing blocking thread");
				// e.printStackTrace();
			}
		}
	}

	private static class LongComputationTask implements Runnable {

		private BigInteger base;
		private BigInteger power;

		public LongComputationTask(BigInteger base, BigInteger power) {
			super();
			this.base = base;
			this.power = power;
		}

		@Override
		public void run() {
			System.out.println(base + "^" + power + " = " + powerCalculation(base, power));
		}

		private BigInteger powerCalculation(BigInteger base, BigInteger power) {
			BigInteger result = BigInteger.ONE;

			for (BigInteger i = BigInteger.ZERO; i.compareTo(power) != 0; i = i.add(BigInteger.ONE)) {
				if(Thread.currentThread().isInterrupted()) {
					System.out.println("Prematurely interrupted computation");
                    return BigInteger.ZERO;
				}
				result = result.multiply(base);
			}

			return result;

		}

	}

}
