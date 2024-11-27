/**
 *
 * <p>Project: dotJava </p>
 * <p>Package Name: org.shandar.dotJava.udemy.drSeanKennedy.lambda </p>
 * <p>File Name: PredicateDemo.java</p>
 * <p>Create Date: 24-Nov-2024 </p>
 * <p>Create Time: 3:07:28 pm </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2024</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */
package org.shandar.dotJava.udemy.drSeanKennedy.lambda;

import java.util.function.Predicate;

interface Evaluate<T> {
	public boolean isNegative(T t); // similar to Predicate
}

public class PredicateDemo {

	public static void main(String[] args) {

		// Evaluate<T> is a functional interface i.e. one abstract method:
		// boolean isNegative(T t); // similar to java.util.function.Predicate

		// Evaluate<Integer> lambda = i->i<0;
		Evaluate<Integer> lambda = i -> {
			return i < 0;
		};

		System.out.println("Evaluate: " + lambda.isNegative(-1)); // true
		System.out.println("Evaluate: " + lambda.isNegative(+1));// false

		// Predicate<T> is a functional interface i.e. one abstract method:
		// boolean test(T t)

		Predicate<Integer> predicate = i -> i < 0;
		System.out.println("Predicate: " + predicate.test(-1)); // true
		System.out.println("Predicate: " + predicate.test(+1));// false

		int x = 4;
		System.out.println("Is " + x + " even? " + check(4, n -> n % 2 == 0));// true
		x = 7;
		System.out.println("Is " + x + " even? " + check(7, y -> y % 2 == 0));// false

		String name = "Mr. Joe Bloggs";
		System.out.println("Does " + name + " start with Mr. ? " + check("Mr. Joe Bloggs", s -> s.startsWith("Mr.")));// true
		name = "Ms. Ann Bloggs";
		System.out.println("Does " + name + " start with Mr. ? " + check("Ms. Ann Bloggs", s -> s.startsWith("Mr.")));// false

	}

	public static <T> boolean check(T t, Predicate<T> lambda) {
		return lambda.test(t);
	}
	
}