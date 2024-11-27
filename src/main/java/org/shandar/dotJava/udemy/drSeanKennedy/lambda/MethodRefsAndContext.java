/**
 *
 * <p>Project: dotJava </p>
 * <p>Package Name: org.shandar.dotJava.udemy.drSeanKennedy.lambda </p>
 * <p>File Name: MethodRefsAndContext.java</p>
 * <p>Create Date: 26-Nov-2024 </p>
 * <p>Create Time: 4:07:59 pm </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2024</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */
package org.shandar.dotJava.udemy.drSeanKennedy.lambda;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 
 */
public class MethodRefsAndContext {

	public static void main(String[] args) {
		// No Person being passed in => Supplier
		Supplier<Integer> lambda1 = () -> Person.howMany();
		Supplier<Integer> mr1 = Person::howMany;
		System.out.println(lambda1.get()); // 0
		System.out.println(mr1.get()); // 0

		// One Person to be passed in => Function
		Function<Person, Integer> lambda2 = person -> Person.howMany(person);
		Function<Person, Integer> mr2 = Person::howMany;
		System.out.println(lambda2.apply(new Person())); // 1
		System.out.println(mr2.apply(new Person())); // 1

		// Two Person's to be passed in => BiFunction
        BiFunction<Person, Person, Integer> lambda3 = (p1, p2) -> Person.howMany(p1, p2);
        BiFunction<Person, Person, Integer> mr3     = Person::howMany;
        System.out.println(lambda3.apply(new Person(), new Person()));  // 2
        System.out.println(mr3.apply(new Person(), new Person()));      // 2

	}

}

class Person {

	public static Integer howMany(Person... people) {
		return people.length;
	}

}