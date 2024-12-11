/**
 *
 * <p>Project: dotJava </p>
 * <p>Package Name: org.shandar.dotJava.udemy.MichaelPogrebinsky.sharingbetweenthreads </p>
 * <p>File Name: RaceConditionQuiz.java</p>
 * <p>Create Date: 09-Dec-2024 </p>
 * <p>Create Time: 3:37:58 pm </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2024</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */
package org.shandar.dotJava.udemy.MichaelPogrebinsky.sharingbetweenthreads;

/**
 * It's possible since each of the methods executes 2 instructions that do not
 * depend on each other. Therefore the compiler is free to re-arrange the order
 * of the instructions.
 * 
 * If method1() is re-arrange to
 * 
 * <pre>
 * public void method1() {
 * 		this.b = 1; int local1 = a;
 * }
 * </pre>
 * 
 * 
 * <p>
 * Then the following order of execution is possible:
 * </p>
 * 
 * Thread 1:b=1 Thread 2:local2 = b(1) Thread 2:a=2 Thread 1:local1 = a(2)
 */
public class RaceConditionQuiz {

	public static void main(String[] args) {
		SharedClass sharedClass = new SharedClass();

		Thread thread1 = new Thread(() -> sharedClass.method1());
		Thread thread2 = new Thread(() -> sharedClass.method2());

		thread1.start();
		thread2.start();
	}

	private static class SharedClass {
		int a = 0;
		int b = 0;

		public void method1() {
			int local1 = a;
			this.b = 1;
			System.out.println("local1 = " + local1 + "  b=" + b);
		}

		public void method2() {
			int local2 = b;
			this.a = 2;
			System.out.println("local2 = " + local2 + "  a=" + a);
		}
	}

}
