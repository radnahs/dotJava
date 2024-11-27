/**
 *
 * <p>Project: dotJava </p>
 * <p>Package Name: org.shandar.dotJava.udemy.drSeanKennedy.lambda </p>
 * <p>File Name: PredicatBiPredicateDemo.java</p>
 * <p>Create Date: 24-Nov-2024 </p>
 * <p>Create Time: 7:52:39 pm </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2024</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */
package org.shandar.dotJava.udemy.drSeanKennedy.lambda;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

/**
 * <pre>
 * 
 * Used for:  when you want to filter/match
 * 
 * <b>Interface					Functional Method</b>
 * Predicate< T >				boolean test(T t)
 * BiPredicate<T, U>			boolean test(T t, U u)
 * 
 * </pre>
 */
public class PredicatBiPredicateDemo {

	public static void main(String[] args) {
		PredicatBiPredicateDemo testBiPredicate = new PredicatBiPredicateDemo();
		testBiPredicate.predicate();
		testBiPredicate.biPredicate();
	}

	/**
	 * Predicate<T> is a functional interface 
	 * i.e. one abstract method: 
	 * boolean test(T t);
	 */
	public void predicate() {
		// Predicate<T> is a functional interface i.e. one abstract method:
		// boolean test(T t);
		Predicate<String> pStr = s -> s.contains("City");
		System.out.println(pStr.test("Vatican City"));// true
	}

	/**
	 * BiPredicate<T, U> is a functional interface 
	 * i.e. one abstract method:  
	 * boolean test(T t, U u);
	 */
	public void biPredicate() {
		// BiPredicate<T, U> is a functional interface i.e. one abstract method:
		// boolean test(T t, U u);
		BiPredicate<String, Integer> checkLength = (str, len) -> str.length() == len;
		System.out.println(checkLength.test("Vatican City", 8));// false (length is 12)
	}

}
