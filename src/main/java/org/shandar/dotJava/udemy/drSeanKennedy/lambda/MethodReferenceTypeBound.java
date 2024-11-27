/**
 *
 * <p>Project: dotJava </p>
 * <p>Package Name: org.shandar.dotJava.udemy.drSeanKennedy.lambda </p>
 * <p>File Name: MethodReferenceTypeBound.java</p>
 * <p>Create Date: 25-Nov-2024 </p>
 * <p>Create Time: 7:54:27 pm </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2024</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */
package org.shandar.dotJava.udemy.drSeanKennedy.lambda;

import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * 
 */
public class MethodReferenceTypeBound {

	public static void main(String[] args) {
		boundMethodReferences();
	}

	public static void boundMethodReferences() {
		String name = "Mr. Joe Bloggs";
		// Supplier<T>
		// T get()
		Supplier<String> lowerL = () -> name.toLowerCase(); // lambda
		Supplier<String> lowerMR = name::toLowerCase; // method reference

		// No need to say which instance to call it on - the supplier is bound to name
		System.out.println(lowerL.get()); // mr. joe bloggs
		System.out.println(lowerMR.get());// mr. joe bloggs

		// Predicate<T>
		// boolean test(T t)
		// Even though startsWith is overloaded, boolean startsWith(String) and
		// boolean startsWith(String, int), because we are creating a Predicate which
		// has a functional method of test(T t), the startsWith(String) is used.
		// This is where "context" is important.
		Predicate<String> titleL = (title) -> name.startsWith(title);
		Predicate<String> titleMR = name::startsWith;

		System.out.println(titleL.test("Mr.")); // true
		System.out.println(titleMR.test("Ms."));// false
		
	}

}
