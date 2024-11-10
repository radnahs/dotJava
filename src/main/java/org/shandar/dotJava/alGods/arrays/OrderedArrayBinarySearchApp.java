/**
 *
 * <p>Project: dotJava </p>
 * <p>Package Name: org.shandar.dotJava.alGods.arrays </p>
 * <p>File Name: OrderedArrayBinarySearchApp.java</p>
 * <p>Create Date: 10-Nov-2024 </p>
 * <p>Create Time: 1:14:44 pm </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2024</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */
package org.shandar.dotJava.alGods.arrays;

/**
 * 
 */
public class OrderedArrayBinarySearchApp {

	public static void main(String[] args) {
		OrderedArray orderedArray = new OrderedArray(20);
		orderedArray.insert(23);
		orderedArray.insert(34);
		orderedArray.insert(41);
		orderedArray.insert(11);
		orderedArray.insert(20);
		orderedArray.insert(33);
		orderedArray.insert(45);
		orderedArray.insert(14);
		orderedArray.insert(12);
		orderedArray.insert(13);
		orderedArray.insert(5);
		orderedArray.insert(2);
		orderedArray.insert(1);
		orderedArray.insert(19);
		orderedArray.insert(31);
		orderedArray.insert(27);
		orderedArray.insert(39);
		orderedArray.insert(50);
		orderedArray.insert(10);

		orderedArray.display();

		int searchKey = 41;
		if (orderedArray.find(searchKey) != orderedArray.size()) {
			System.out.println("Found " + searchKey);
		} else {
			System.out.println("Can't Found " + searchKey);
		}
		orderedArray.display();

		orderedArray.delete(19);
		orderedArray.delete(20);
		orderedArray.delete(45);

		orderedArray.display();

	}

}

class OrderedArray {

	private long[] a;
	private int nElems;

	public OrderedArray(int max) {
		a = new long[max];
		nElems = 0;
	}

	public int size() {
		return nElems;
	}

	public int find(long searchKey) {
		int lowerBound = 0;
		int upperBound = nElems - 1;
		int currentIndex;

		while (true) {
			currentIndex = (lowerBound + upperBound) / 2;
			if (a[currentIndex] == searchKey) {
				return currentIndex;
			} else if (lowerBound > upperBound) {
				return nElems;
			} else {
				if (a[currentIndex] < searchKey) {
					lowerBound = currentIndex + 1;
				} else {
					upperBound = currentIndex - 1;
				}
			}
		}
	}

	public void insert(long value) {
		int j;
		for (j = 0; j < nElems; j++) {
			if (a[j] > value) {
				break;
			}
		}
		for (int i = nElems; i > j; i--) {
			a[i] = a[i - 1];
		}
		a[j] = value;
		nElems++;
	}

	public boolean delete(long value) {
		int j = find(value);
		if (j == nElems) {
			return false;
		} else {
			for (int i = j; i < nElems; i++) {
				a[i] = a[i + 1];
			}
			nElems--;
			return true;
		}
	}

	public void display() {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + ",");
		}
		System.out.println();
	}

}
