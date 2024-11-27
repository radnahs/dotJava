/**
 *
 * <p>Project: dotJava </p>
 * <p>Package Name: org.shandar.dotJava.udemy.drSeanKennedy.lambda </p>
 * <p>File Name: SupplierDemo.java</p>
 * <p>Create Date: 24-Nov-2024 </p>
 * <p>Create Time: 7:57:18 pm </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2024</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */
package org.shandar.dotJava.udemy.drSeanKennedy.lambda;

import java.time.LocalTime;
import java.util.function.Supplier;

/**
 * <pre>
 * 
 * Used for:  when you want to supply value values without any input
 * 
 * <b>Interface					Functional Method</b>
 * Supplier< T >				T get()
 * 
 * </pre>
 */
public class SupplierDemo {

	public static void main(String[] args) {
		SupplierDemo testSupplier = new SupplierDemo();
		testSupplier.supplier();
	}

	public void supplier() {
		// Supplier<T> is a functional interface i.e. one abstract method:
		// T get()
		Supplier<StringBuilder> supSB = () -> new StringBuilder();
		System.out.println("Supplier SB: " + supSB.get().append("SK"));// Supplier SB: SK

		Supplier<LocalTime> supTime = () -> LocalTime.now();
		System.out.println("Supplier time: " + supTime.get());// Supplier time: 09:11:39.121101600

		Supplier<Double> sRandom = () -> Math.random();
		System.out.println(sRandom.get());// e.g. 0.782467864130131
	}

}
