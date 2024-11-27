/**
 *
 * <p>Project: dotJava </p>
 * <p>Package Name: org.shandar.dotJava.udemy.drSeanKennedy.lambda </p>
 * <p>File Name: LambdaEffectivelyFinal.java</p>
 * <p>Create Date: 25-Nov-2024 </p>
 * <p>Create Time: 2:01:48 pm </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2024</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */
package org.shandar.dotJava.udemy.drSeanKennedy.lambda;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

/**
 * 
 */
public class LambdaEffectivelyFinal {

	String name = "";

	public static void main(String[] args) {
		ArrayList<String> al = new ArrayList<>();
		al.add("John");

		int x = 12; // final or effectively final

		// Lambdas take a snapshot/picture of local variables; these local
		// variables MUST NOT change. Only setting up lambda here.
		Predicate<String> lambda = s -> {
			// x++;
			new LambdaEffectivelyFinal().name = "Kennedy"; // instance/class vars are ok
			System.out.println("x == " + x);
			return s.isEmpty() && x % 2 == 0;
		};
		filterData(al, lambda);// lambda views 'x' as 12
		System.out.println(al);

		new LambdaEffectivelyFinal().name = "Sean"; // instance/class vars are ok

		// If 'x' was allowed to change, then the method and the lambda would
		// have 2 different views of 'x'!
		// x++;
		filterData(al, lambda);// lambda views 'x' as 12
		// some code...

	}

	public static void filterData(List<String> list, Predicate<String> lambda) {
		Iterator<String> i = list.iterator();
		while (i.hasNext()) {
			if (lambda.test(i.next())) { // executing lambda here
				i.remove();
			}
		}
	}

}
