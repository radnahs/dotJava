/**
 *
 * <p>Project: dotJava </p>
 * <p>Package Name: org.shandar.dotJava.udemy.MichaelPogrebinsky.sharingbetweenthreads </p>
 * <p>File Name: RaceCondition.java</p>
 * <p>Create Date: 09-Dec-2024 </p>
 * <p>Create Time: 2:38:10 pm </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2024</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */
package org.shandar.dotJava.udemy.MichaelPogrebinsky.sharingbetweenthreads;

/**
 * 
 */
public class RaceCondition {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SharedClass sharedClass = new SharedClass();
		Thread thread1 = new Thread(()->{
			for(int i=0; i<Integer.MAX_VALUE ;i++) {
				sharedClass.increment();
			}
		});
		
		Thread thread2 = new Thread(()->{
			for(int i=0; i<Integer.MAX_VALUE ;i++) {
				sharedClass.checkForDataRace();
			}
		});
		
		thread1.start();
		thread2.start();
		
	}

	
	public static class SharedClass{
		private int x=0;
		//volatile private int x=0
		private int y=0;;
		//volatile private int y=0;
		
		public void increment() {
			x++;
			y++;
		}
		
		public void checkForDataRace(){
			if(y>x) {
				System.out.println("y > x - Data Race is detected");
			}
		}
	}
}
