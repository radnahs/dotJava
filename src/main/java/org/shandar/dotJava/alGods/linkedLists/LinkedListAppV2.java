/**
 *
 * <p>Project: dotJava </p>
 * <p>Package Name: org.shandar.dotJava.alGods.linkedLists </p>
 * <p>File Name: LinkedListAppV2.java</p>
 * <p>Create Date: 10-Nov-2024 </p>
 * <p>Create Time: 1:45:03 pm </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2024</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */
package org.shandar.dotJava.alGods.linkedLists;

/**
 * 
 */
public class LinkedListAppV2 {

	public static void main(String[] args) {
		LinkedListV2 theLL = new LinkedListV2();
		theLL.insertFirst(22, 2.99);
		theLL.insertFirst(88, 8.99);
		theLL.insertFirst(55, 5.99);
		theLL.insertFirst(44, 4.99);
		theLL.insertFirst(44, 4.98);

		theLL.displayListV2();

		LinkV2 findV2 = theLL.find(44);

		if (findV2 != null) {
			System.out.println("found link with key " + findV2.iData);
		} else {
			System.out.println("Can't found link with key");
		}

		theLL.displayListV2();

		LinkV2 delV2 = theLL.delete(44);
		if (delV2 != null) {
			System.out.println("Deleted link with key : " + delV2.iData);
		} else {
			System.out.println("Can't found link with key");
		}

		theLL.displayListV2();

	}

}

class LinkV2 {
	public int iData;
	public double dData;
	public LinkV2 next;

	public LinkV2(int iData, double dData) {
		this.iData = iData;
		this.dData = dData;
	}

	public void displayLink() {
		System.out.println("{ " + iData + ", " + dData + " }");
	}

}

class LinkedListV2 {

	private LinkV2 first;

	/**
	 * @param first
	 */
	public LinkedListV2() {
		this.first = null;
	}

	public void insertFirst(int id, double dd) {
		LinkV2 newLinkV2 = new LinkV2(id, dd);
		newLinkV2.next = first;
		first = newLinkV2;
	}

	public LinkV2 find(int key) {
		LinkV2 current = first;
		while (current.iData != key) {
			if (current.next == null) {
				return null;
			} else {
				current = current.next;
			}
		}
		return current;
	}

	public LinkV2 delete(int key) {
		LinkV2 current = first;
		LinkV2 previous = first;
		while (current.iData != key) {
			if (current.next == null) {
				return null;
			} else {
				previous = current;
				current = current.next;
			}
		}
		if (current == first) {
			first = first.next;
		} else {
			previous.next = current.next;
		}
		return current;
	}

	public void displayListV2() {
		System.out.print("List (first --> last) : ");
		LinkV2 current = first;
		while (current != null) {
			current.displayLink();
			current = current.next;
		}
		System.out.println();
	}

}
