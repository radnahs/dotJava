/**
 *
 * <p>Project: dotJava </p>
 * <p>Package Name: org.shandar.dotJava.alGods.linkedLists </p>
 * <p>File Name: QueueUsingLinkedList.java</p>
 * <p>Create Date: 10-Nov-2024 </p>
 * <p>Create Time: 1:46:11 pm </p>
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
public class QueueUsingLinkedList {

	public static void main(String[] args) {
		QueueLL theQueue = new QueueLL();
		theQueue.insert(88, 88.99);
		theQueue.insert(22, 22.99);
		theQueue.insert(33, 33.99);

		theQueue.displayQueue();

		theQueue.insert(99, 99.99);
		theQueue.insert(11, 11.99);

		theQueue.displayQueue();

		theQueue.remove();
		theQueue.remove();

		theQueue.displayQueue();

	}

}

class LinkQULL {
	public int iData;
	public double dData;
	public LinkQULL nextLinkQULL;

	public LinkQULL(int iData, double dData) {
		this.iData = iData;
		this.dData = dData;
		// this.nextLinkQULL = null; // not needed as the
	}

	public void displayLinkQULL() {
		System.out.println("{ " + iData + ", " + dData + " }");
	}

}

class ListQULL {

	private LinkQULL first;
	private LinkQULL last;

	public ListQULL() {
		this.first = null;
		this.last = null;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public void insertLast(int iD, double dD) {
		LinkQULL newLinkQULL = new LinkQULL(iD, dD);
		if (isEmpty()) {
			first = newLinkQULL;
		} else {
			last.nextLinkQULL = newLinkQULL;
		}
		last = newLinkQULL;
	}

	public double deleteFirst() {
		double temp = this.first.dData;
		if (first.nextLinkQULL == null) {
			this.last = null;
		}
		this.first = this.first.nextLinkQULL;
		return temp;
	}

	public void displayQULL() {
		LinkQULL current = first;
		while (current != null) {
			current.displayLinkQULL();
			current = current.nextLinkQULL;
		}
		System.out.println();
	}

}

class QueueLL {

	private ListQULL theList;

	public QueueLL() {
		theList = new ListQULL();
	}

	public void insert(int iD, double dD) {
		theList.insertLast(iD, dD);
	}

	public double remove() {
		return theList.deleteFirst();
	}

	public void displayQueue() {
		System.out.print("Queue (front-->rear): ");
		theList.displayQULL();
	}
}
