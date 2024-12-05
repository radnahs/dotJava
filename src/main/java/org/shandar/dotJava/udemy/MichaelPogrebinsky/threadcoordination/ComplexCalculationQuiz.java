/**
 *
 * <p>Project: dotJava </p>
 * <p>Package Name: org.shandar.dotJava.udemy.MichaelPogrebinsky.threadcoordination </p>
 * <p>File Name: ComplexCalculationQuiz.java</p>
 * <p>Create Date: 04-Dec-2024 </p>
 * <p>Create Time: 7:02:44 pm </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2024</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */
package org.shandar.dotJava.udemy.MichaelPogrebinsky.threadcoordination;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import lombok.Data;

/**
 * 
 */
public class ComplexCalculationQuiz {

	public static void main(String[] args) {
		/*
		  BigInteger base = new BigInteger("2"); 
		  BigInteger power = new BigInteger("6"); 
		  BigInteger result = PowerCalculatingThread.powerCalculation(base, power);
		  System.out.println(result);
		 */
		
		Map<BigInteger, BigInteger> inputPairs = Map.of(new BigInteger("10"), new BigInteger("2"), new BigInteger("3"), new BigInteger("4"));

		List<PowerCalculatingThread> threads = new ArrayList<ComplexCalculationQuiz.PowerCalculatingThread>();

		for (Map.Entry<BigInteger, BigInteger> entry : inputPairs.entrySet()) {
			threads.add(new PowerCalculatingThread(entry.getKey(), entry.getValue()));
		}

		for (PowerCalculatingThread thread : threads) {
			thread.start();
			try {
				thread.join(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(thread.getResult());
		}
		

		// same way as above
/*		PowerCalculatingThread thread1 = new PowerCalculatingThread(new BigInteger("10"), new BigInteger("2"));
		PowerCalculatingThread thread2 = new PowerCalculatingThread(new BigInteger("2"), new BigInteger("40"));

		thread1.start();
		thread2.start();
		
		try {
			thread1.join(5000);
			thread2.join(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(thread1.getResult());
		System.out.println(thread2.getResult());
	*/
	}

	@Data
	private static class PowerCalculatingThread extends Thread {

		private BigInteger result = BigInteger.ONE;
		private BigInteger base;
		private BigInteger power;

		public PowerCalculatingThread(BigInteger base, BigInteger power) {
			super();
			this.base = base;
			this.power = power;
		}

		@Override
		public void run() {
			this.powerCalculation(base, power);
		}

		public BigInteger powerCalculation(BigInteger base, BigInteger power) {
			for (BigInteger i = BigInteger.ZERO; i.compareTo(power) < 0; i = i.add(BigInteger.ONE)) {
				result = result.multiply(base);
			}
			return result;
		}
	}

}
