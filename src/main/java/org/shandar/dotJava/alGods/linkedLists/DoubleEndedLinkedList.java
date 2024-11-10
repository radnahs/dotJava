/**
 *
 * <p>Project: dotJava </p>
 * <p>Package Name: org.shandar.dotJava.alGods.linkedLists </p>
 * <p>File Name: DoubleEndedLinkedList.java</p>
 * <p>Create Date: 10-Nov-2024 </p>
 * <p>Create Time: 1:37:50 pm </p>
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
public class DoubleEndedLinkedList {

	public static void main(String[] args) {
		LinkedListDE linkedListDE = new LinkedListDE();
		linkedListDE.insertFirst(22, 22.99);
		linkedListDE.insertFirst(66, 66.99);
		linkedListDE.insertFirst(44, 44.99);

		linkedListDE.insertLast(33, 33.99);
		linkedListDE.insertLast(11, 11.99);
		linkedListDE.insertLast(77, 77.99);

		linkedListDE.displayDELL();

		linkedListDE.deleteFirst();
		linkedListDE.deleteFirst();

		linkedListDE.displayDELL();
	}

}

class LinkDELL {

	public int iData;
	public double dData;
	public LinkDELL nextLinkDELL;

	/**
	 * @param iD
	 * @param dD
	 */
	public LinkDELL(int iD, double dD) {
		this.iData = iD;
		this.dData = dD;
	}

	public void displayLinkDELL() {
		System.out.println("{ " + iData + ", " + dData + " }");
	}

}

class LinkedListDE {

	private LinkDELL first;
	private LinkDELL last;

	public LinkedListDE() {
		this.first = null;
		this.last = null;
	}

	public boolean isEmpty() {
		return this.first == null;
	}

	public void insertFirst(int iData, double dData) {
		LinkDELL newLink = new LinkDELL(iData, dData);
		if (isEmpty()) {
			this.last = newLink;
		}
		newLink.nextLinkDELL = this.first;
		this.first = newLink;
	}

	public void insertLast(int iData, double dData) {
		LinkDELL newLink = new LinkDELL(iData, dData);
		if (isEmpty()) {
			this.first = newLink;
		} else {
			this.last.nextLinkDELL = newLink;
		}

		this.last = newLink;
	}

	public double deleteFirst() {
		double temp = this.first.dData;
		if (this.first.nextLinkDELL == null) {
			this.last = null;
		}
		this.first = first.nextLinkDELL;
		return temp;
	}

	public void displayDELL() {
		System.out.print(" List (first-->last): ");
		LinkDELL current = this.first;
		while (current != null) {
			current.displayLinkDELL();
			current = current.nextLinkDELL;
		}
		System.out.println("");

	}
}
