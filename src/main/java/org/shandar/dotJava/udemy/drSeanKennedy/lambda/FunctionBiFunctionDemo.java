/**
 *
 * <p>Project: dotJava </p>
 * <p>Package Name: org.shandar.dotJava.udemy.drSeanKennedy.lambda </p>
 * <p>File Name: FunctionBiFunctionDemo.java</p>
 * <p>Create Date: 24-Nov-2024 </p>
 * <p>Create Time: 11:42:43 pm </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2024</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */
package org.shandar.dotJava.udemy.drSeanKennedy.lambda;

import java.util.function.BiFunction;
import java.util.function.Function;


/**
 * <pre>
 * 
 * Used for:  
 * 
 * <b>Interface					Functional Method</b>
 * Function<T, R>				R apply(T t)
 * BiFunction<T, U, R>			R apply(T t, U u)
 * 
 * </pre>
 */
public class FunctionBiFunctionDemo {

	public static void main(String[] args) {
		FunctionBiFunctionDemo tFBF = new FunctionBiFunctionDemo();
		tFBF.function();
		tFBF.biFunction();
	}
	
    public void function() {
        // Function<T, R> is a functional interface i.e. one abstract method:
        //      R apply(T t)
        Function<String, Integer> fn2 = s -> s.length();
        System.out.println("Function: " + fn2.apply("Moscow"));// 6
    }
    
    public void biFunction() {
        // BiFunction<T, U, R> is a functional interface i.e. one abstract method:
        //      R apply(T t, U u)
        BiFunction<String, String, Integer> biFn   = (s1, s2) -> s1.length() + s2.length();
        System.out.println("BiFunction: " + biFn.apply("William", "Shakespeare"));// 18

        BiFunction<String, String, String> biFn2   = (s1, s2) -> s1.concat(s2);
        System.out.println("BiFunction: " + biFn2.apply("William ", "Shakespeare"));// William Shakespeare
    }

}
