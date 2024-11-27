/**
 *
 * <p>Project: dotJava </p>
 * <p>Package Name: org.shandar.dotJava.udemy.drSeanKennedy.lambda </p>
 * <p>File Name: ConsumerBiConsumerDemo.java</p>
 * <p>Create Date: 24-Nov-2024 </p>
 * <p>Create Time: 8:14:40 pm </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2024</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */
package org.shandar.dotJava.udemy.drSeanKennedy.lambda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * <pre>
 * 
 * Used for:  transform the input into an output (types are the same)
 * 
 * <b>Interface					Functional Method</b>
 * Consumer< T >				void accept(T t)
 * BiConsumer<T, U>				void accept(T t, U u)
 * 
 * </pre>
 */
public class ConsumerBiConsumerDemo {

	public static void main(String[] args) {
		ConsumerBiConsumerDemo tCBC = new ConsumerBiConsumerDemo();
		tCBC.consumer();
		tCBC.biConsumer();
	}

	/**
	 * Consumer<T> is a functional interface 
	 * i.e. one abstract method:
	 * void accept(T t)
	 */
	public void consumer() {
		// Consumer<T> is a functional interface i.e. one abstract method:
		// void accept(T t)
		Consumer<String> printC = s -> System.out.println(s);// lambda
		printC.accept("To be or not to be, that is the question");

		List<String> names = new ArrayList<>();
		names.add("John");
		names.add("Mary");
		names.forEach(printC); // John, Mary

	}

	/**
	 * BiConsumer<T, U> is a functional interface 
	 * i.e. one abstract method: 
	 * void accept(T t, U u)
	 */
	public void biConsumer() {
		// BiConsumer<T, U> is a functional interface i.e. one abstract method:
		// void accept(T t, U u)
		var mapCapitalCities = new HashMap<String, String>();
		// Note: The return value of put(k,v) is just ignored (and not returned from the
		// lambda)
		BiConsumer<String, String> biCon = (key, value) -> mapCapitalCities.put(key, value);
		biCon.accept("Dublin", "Ireland");
		biCon.accept("Washington D.C.", "USA");
		System.out.println(mapCapitalCities);// {Dublin=Ireland, Washington D.C.=USA}

		BiConsumer<String, String> mapPrint = (key, value) -> System.out.println(key + " is the capital of: " + value);
		mapCapitalCities.forEach(mapPrint); // Dublin is the capital of: Ireland
											// Washington D.C. is the capital of: USA

	}
}
