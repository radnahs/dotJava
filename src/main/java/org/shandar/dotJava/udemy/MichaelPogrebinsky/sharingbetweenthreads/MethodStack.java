/**
 *
 * <p>Project: dotJava </p>
 * <p>Package Name: org.shandar.dotJava.udemy.MichaelPogrebinsky.sharingbetweenthreads </p>
 * <p>File Name: MethodStack.java</p>
 * <p>Create Date: 06-Dec-2024 </p>
 * <p>Create Time: 3:22:12 pm </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2024</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */
package org.shandar.dotJava.udemy.MichaelPogrebinsky.sharingbetweenthreads;

public class MethodStack {

	public static void main(String[] args) {
		int x = 1;
		int y = 2;
		int res = sum(x, y);
	}

	private static int sum(int a, int b) {
		int s = a + b;
		return s;
	}

}
