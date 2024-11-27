/**
 *
 * <p>Project: dotJava </p>
 * <p>Package Name: org.shandar.dotJava.udemy.drSeanKennedy.lambda </p>
 * <p>File Name: MethodReferenceTypeConstructor.java</p>
 * <p>Create Date: 26-Nov-2024 </p>
 * <p>Create Time: 12:36:09 pm </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2024</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */
package org.shandar.dotJava.udemy.drSeanKennedy.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 
 */
public class MethodReferenceTypeConstructor {

	public static void main(String[] args) {
		constructorMethodReferences();
	}

	public static void constructorMethodReferences() {
		// Supplier<T>
		// T get()
		Supplier<StringBuilder> sbL = () -> new StringBuilder(); // lambda
		Supplier<StringBuilder> sbMR = StringBuilder::new; // method reference
		
		StringBuilder sb1 = sbL.get();
		sb1.append("lambda version");
		System.out.println(sb1);
		StringBuilder sb2 = sbMR.get();
		sb2.append("method reference version");
		System.out.println(sb2);

		// Function<T, R>
		// R apply(T)
		// List<String> apply(Integer)
		// ArrayList(int initialCapacity)
		Function<Integer, List<String>> alL = x -> new ArrayList(x);
		Function<Integer, List<String>> alMR = ArrayList::new;
		List<String> ls1 = alL.apply(10); // size 10
		ls1.add("21");
		System.out.println(ls1);// [21]
		List<String> ls2 = alMR.apply(5); // size 5
		ls2.add("88");
		System.out.println(ls2);// [88]
	}

}
