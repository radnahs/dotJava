/**
 *
 * <p>Project: dotJava </p>
 * <p>Package Name: org.shandar.dotJava.udemy.MichaelPogrebinsky.threadscreationpart2 </p>
 * <p>File Name: DifferentThreadStart.java</p>
 * <p>Create Date: 01-Dec-2024 </p>
 * <p>Create Time: 1:39:21 am </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2024</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */
package org.shandar.dotJava.udemy.MichaelPogrebinsky.threadscreation;

/**
 * 
 */
public class DifferentThreadStart {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Thread thread1 = new Thread(()->{
			System.out.println("going for walk");
		});
		
		Thread thread2 = new Thread(()->{
			System.out.println("going for swim");
		});
		
		thread1.start();
		thread2.start();
		System.out.println("going home");

	}

}
