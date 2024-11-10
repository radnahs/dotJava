/**
 *
 * <p>Project: dotJava </p>
 * <p>Package Name: org.shandar.dotJava.alGods.linkedLists </p>
 * <p>File Name: LinkedListAppV1.java</p>
 * <p>Create Date: 10-Nov-2024 </p>
 * <p>Create Time: 1:41:30 pm </p>
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
public class LinkedListAppV1 {

	public static void main(String[] args) {
		LinkedListV1 theLL = new LinkedListV1();
		theLL.insertFirst(22, 2.99);
		theLL.insertFirst(88, 8.99);
		theLL.insertFirst(55, 5.99);
		theLL.insertFirst(44, 4.99);

		theLL.displayListV1();

		while (!theLL.isEmpty()) {
			LinkV1 aLink = theLL.deleteFirst();
			System.out.print("deleted ");
			aLink.displayLink();
			System.out.println(" ");
		}
		theLL.displayListV1();
	}

}

class LinkV1 {
	public int iData;
	public double dData;
	public LinkV1 next;

	public LinkV1(int iData, double dData) {
		this.iData = iData;
		this.dData = dData;
	}

	public void displayLink() {
		System.out.println("{ " + iData + ", " + dData + " }");
	}

}

class LinkedListV1 {

	private LinkV1 first;

	public LinkedListV1() {
		this.first = null;
	}

	public boolean isEmpty() {
		return (first == null);
	}

	public void insertFirst(int id, double dd) {
		LinkV1 newLinkV1 = new LinkV1(id, dd);
		newLinkV1.next = first;
		first = newLinkV1;
	}

	public LinkV1 deleteFirst() {
		LinkV1 temp = first;
		first = first.next;
		return temp;
	}

	public void displayListV1() {
		System.out.print("List (first --> last : ");
		LinkV1 current = first;

		while (current != null) {
			current.displayLink();
			current = current.next;
		}
		System.out.println(" ");
	}

}
