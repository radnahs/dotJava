/**
 *
 * <p>Project: dotJava </p>
 * <p>Package Name: org.shandar.dotJava.udemy.MichaelPogrebinsky.threadcoordination </p>
 * <p>File Name: ThreadJoiningDemo.java</p>
 * <p>Create Date: 04-Dec-2024 </p>
 * <p>Create Time: 1:26:05 am </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2024</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */
package org.shandar.dotJava.udemy.MichaelPogrebinsky.threadcoordination;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lombok.Data;

/**
 * 
 */
public class ThreadJoiningDemo {

	public static void main(String[] args) {
		// Factorial
		List<Long> inputNumbers = Arrays.asList(100000000L, 3435L, 35435L, 2324L, 4656L, 23L, 5556L);
		//List<Long> inputNumbers = Arrays.asList(0L, 3435L, 35435L, 2324L, 4656L, 23L, 5556L);
		
		List<FactorialThread> threads = new ArrayList<ThreadJoiningDemo.FactorialThread>();

		for (Long inputNumber : inputNumbers) {
			threads.add(new FactorialThread(inputNumber));
		}

		for (FactorialThread factorialThread : threads) {
			factorialThread.setDaemon(true);
			factorialThread.start();
		}
		
		for (FactorialThread factorialThread : threads) {
			try {
				//factorialThread.join();
				factorialThread.join(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		for (int i = 0; i < inputNumbers.size(); i++) {
			FactorialThread factorialThread = threads.get(i);
			if (factorialThread.isFinished) {
				System.out.println("Factorial of " + inputNumbers.get(i) + " is " + factorialThread.getResult());
			} else {
				System.out.println("The calculation for " + inputNumbers.get(i) + " is still in progress");
			}
		}
	}

	@Data
	public static class FactorialThread extends Thread {

		private Long inputNumber;
		private BigInteger result = BigInteger.ZERO;
		private Boolean isFinished = false;

		public FactorialThread(Long inputNumber) {
			this.inputNumber = inputNumber;
		}

		@Override
		public void run() {
			this.result = factorial(inputNumber);
			this.isFinished = true;
		}

		public BigInteger factorial(Long n) {
			BigInteger tempResult = BigInteger.ONE;
			for (long i = n; i > 0; i--) {
				tempResult = tempResult.multiply(new BigInteger(Long.toString(i)));
			}
			return tempResult;
		}

	}

}
