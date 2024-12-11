/**
 *
 * <p>Project: dotJava </p>
 * <p>Package Name: org.shandar.dotJava.udemy.MichaelPogrebinsky.sharingbetweenthreads </p>
 * <p>File Name: EcommerceInventory.java</p>
 * <p>Create Date: 06-Dec-2024 </p>
 * <p>Create Time: 3:46:36 pm </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2024</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */
package org.shandar.dotJava.udemy.MichaelPogrebinsky.sharingbetweenthreads;

import lombok.Data;

public class EcommerceInventory {

	public static void main(String[] args) throws InterruptedException {
		InventoryCounter inventoryCounter = new InventoryCounter();
		IncrementingThread incrementingThread = new IncrementingThread(inventoryCounter);
		DecrementingThread decrementingThread = new DecrementingThread(inventoryCounter);

		incrementingThread.start();
		decrementingThread.start();

		incrementingThread.join();
		decrementingThread.join();

		System.out.println("We currently have " + inventoryCounter.getItems() + " items");

	}

	public static class DecrementingThread extends Thread {

		private InventoryCounter inventoryCounter;

		public DecrementingThread(InventoryCounter inventoryCounter) {
			super();
			this.inventoryCounter = inventoryCounter;
		}

		public void run() {
			for (int i = 0; i < 10000; i++) {
				inventoryCounter.decrement();
			}
		}
	}

	public static class IncrementingThread extends Thread {

		private InventoryCounter inventoryCounter;

		public IncrementingThread(InventoryCounter inventoryCounter) {
			super();
			this.inventoryCounter = inventoryCounter;
		}

		public void run() {
			for (int i = 0; i < 10000; i++) {
				inventoryCounter.increment();
			}
		}
	}

	@Data
	private static class InventoryCounter {
		private int items = 0;

		public void increment() {
		//public void increment() { // incrementingThread.start(); might give negative result as the item++ is not an atomic operation
		//public synchronized void increment() {// method is synchronized to make the all the operation in the method atomic
			synchronized (STR){ //(STR) {
				items++;
			}
			
		}

		public void decrement() {
		//public void decrement() { //decrementingThread.start(); might give negative result as the item-- is not an atomic operation
		//public synchronized void decrement() { // method is synchronized to make the all the operation in the method atomic
			synchronized (STR) {//(STR) {
				items--;
			}
			
		}
	}

}
