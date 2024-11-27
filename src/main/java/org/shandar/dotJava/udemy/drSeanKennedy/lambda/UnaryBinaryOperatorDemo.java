/**
 *
 * <p>Project: dotJava </p>
 * <p>Package Name: org.shandar.dotJava.udemy.drSeanKennedy.lambda </p>
 * <p>File Name: UnaryBinaryOperatorDemo.java</p>
 * <p>Create Date: 24-Nov-2024 </p>
 * <p>Create Time: 11:54:44 pm </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2024</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */
package org.shandar.dotJava.udemy.drSeanKennedy.lambda;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

/**
 * <pre>
 * 
 * Used for:  transform the input into an output (types are the same)
 * 
 * <b>Interface						Functional Method</b>
 * UnaryOperator< T >				T apply(T t)
 * BinaryOperator< T >				T apply(T t1, T t2)
 * 
 * </pre>
 */
public class UnaryBinaryOperatorDemo {

	public static void main(String[] args) {
		UnaryBinaryOperatorDemo dUBO = new UnaryBinaryOperatorDemo();
		dUBO.unaryOperator();
		dUBO.binaryOperator();
	}

	public void unaryOperator() {
		// UnaryOperator<T> extends Function<T, T> is a functional interface i.e. one
		// abstract method:
		// T apply(T t)
		UnaryOperator<String> unaryOp = name -> "My name is " + name;
		System.out.println("UnaryOperator: " + unaryOp.apply("Sean"));// My name is Sean
	}

    public void binaryOperator() {
        // BinaryOperator<T> extends BiFunction<T, T, T> is a functional interface i.e. one abstract method:
        //      T apply(T t1, T t2)
        BinaryOperator<String> binaryOp   = (s1, s2) -> s1.concat(s2);
        System.out.println("BinaryOperator: " + binaryOp.apply("William ", "Shakespeare"));// William Shakespeare
    }
}
