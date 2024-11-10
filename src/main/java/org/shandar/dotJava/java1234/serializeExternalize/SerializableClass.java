/**
 *
 * <p>Project: dotJava </p>
 * <p>Package Name: org.shandar.dotJava.java1234.serializeExternalize </p>
 * <p>File Name: SerializableClass.java</p>
 * <p>Create Date: 10-Nov-2024 </p>
 * <p>Create Time: 1:08:56 pm </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2024</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */
package org.shandar.dotJava.java1234.serializeExternalize;

import java.io.Serializable;

/**
 * 
 */
public class SerializableClass implements Serializable {

	private static final long serialVersionUID = -2473028153576013796l;

	private int a;
	private String str;
	private transient String strTransient;
	private static String strStatic;

	public SerializableClass() {
		this.a = 1;
		this.str = "default constructor str";
		this.strTransient = "default constructor transient str";
	}

	public SerializableClass(int a, String str, String strTransient) {
		this.a = a;
		this.str = str;
		this.strTransient = strTransient;
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public String getStrTransient() {
		return strTransient;
	}

	public void setStrTransient(String strTransient) {
		this.strTransient = strTransient;
	}

	public static String getStrStatic() {
		return strStatic;
	}

	public static void setStrStatic(String strStatic) {
		SerializableClass.strStatic = strStatic;
	}
	
}
