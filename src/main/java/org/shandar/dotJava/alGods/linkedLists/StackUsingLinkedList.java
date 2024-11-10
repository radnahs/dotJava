/**
 *
 * <p>Project: dotJava </p>
 * <p>Package Name: org.shandar.dotJava.alGods.linkedLists </p>
 * <p>File Name: StackUsingLinkedList.java</p>
 * <p>Create Date: 10-Nov-2024 </p>
 * <p>Create Time: 1:47:14 pm </p>
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
public class StackUsingLinkedList {

	public static void main(String[] args) {
		StackLL theStack = new StackLL();
		theStack.push(22, 22.22);
		theStack.push(66, 66.22);
		theStack.push(33, 33.22);
		theStack.push(88, 88.22);
		theStack.push(11, 11.22);

		theStack.displayStack();

		theStack.pop();
		theStack.pop();

		theStack.displayStack();

		theStack.push(99, 99.22);
		theStack.push(00, 00.22);

		theStack.displayStack();

	}

}

class LinkSULL {
	public int iData;
	public double dData;
	public LinkSULL nextLinkSULL;

	public LinkSULL(int iData, double dData) {
		super();
		this.iData = iData;
		this.dData = dData;
	}

	public void displayLinkSULL() {
		System.out.println("{ " + iData + ", " + dData + " }");
	}

}

class ListSULL {

	private LinkSULL first;

	public ListSULL() {
		this.first = null;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public void insertFirst(int iD, double dD) {
		LinkSULL newLinkSULL = new LinkSULL(iD, dD);
		newLinkSULL.nextLinkSULL = first;
		first = newLinkSULL;
	}

	public double deleteFirst() {
		LinkSULL temp = first;
		first = first.nextLinkSULL;
		return temp.dData;
	}

	public void displaySULL() {
		LinkSULL current = first;
		while (current != null) {
			current.displayLinkSULL();
			current = current.nextLinkSULL;
		}
		System.out.println();
	}

}

class StackLL {

	private ListSULL theList;

	public StackLL() {
		this.theList = new ListSULL();
	}

	public void push(int iD, double dD) {
		theList.insertFirst(iD, dD);
	}

	public double pop() {
		return theList.deleteFirst();
	}

	public boolean isEmpty() {
		return theList.isEmpty();
	}

	public void displayStack() {
		System.out.print("Stack (top-->bottom): ");
		theList.displaySULL();
	}

}