/**
 *
 * <p>Project: dotJava </p>
 * <p>Package Name: org.shandar.dotJava.udemy.drSeanKennedy.lambda </p>
 * <p>File Name: MethodReferenceTypeStatic.java</p>
 * <p>Create Date: 25-Nov-2024 </p>
 * <p>Create Time: 8:52:01 pm </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2024</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */
package org.shandar.dotJava.udemy.drSeanKennedy.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

/**
 * 
 */
public class MethodReferenceTypeStatic {

	public static void main(String[] args) {
		//staticMethodReferences();
		testMultipleLambdaMR();
	}

	public static void staticMethodReferences() {
		// Static method references are considered UNBOUND also. An example static
		// method
		// is Collections.sort(List)
		// Consumer<T>
		// void accept(T t)
		// void accept(List<Integer>)
		// NB: Consumer takes one parameter => sort(List) is used, as opposed to
		// sort(List, Comparator)
		Consumer<List<Integer>> sortL = list -> Collections.sort(list);
		Consumer<List<Integer>> sortMR = Collections::sort;

		List<Integer> listOfNumbers = Arrays.asList(2, 1, 5, 4, 9);
		sortL.accept(listOfNumbers);// execution
		System.out.println(listOfNumbers); // [1, 2, 4, 5, 9]

		listOfNumbers = Arrays.asList(8, 12, 4, 3, 7);
		sortMR.accept(listOfNumbers);// execution
		System.out.println(listOfNumbers); // [3, 4, 7, 8, 12]
	}

	private static void testMultipleLambdaMR() {
		Consumer<List<Integer>> revSortLambda = list -> Collections.sort(list, (i1, i2) -> {
			if (i2 > i1) {
				return 1;
			} else if (i2 < i1) {
				return -1;
			} else {
				return 0;
			}
		});
		List<Integer> listOfNumbers = Arrays.asList(2, 1, 5, 4, 9);
		revSortLambda.accept(listOfNumbers);// execution
		System.out.println(listOfNumbers);
		
	}

}
