/**
 *
 * <p>Project: dotJava </p>
 * <p>Package Name: org.shandar.dotJava.alGods.arrays </p>
 * <p>File Name: HighArrayApp.java</p>
 * <p>Create Date: 10-Nov-2024 </p>
 * <p>Create Time: 1:12:29 pm </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2024</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */
package org.shandar.dotJava.alGods.arrays;

/**
 * 
 */
public class HighArrayApp {
	
	public static void main(String[] args) {
		int maxSize=100;
		HighArray arr= new HighArray(maxSize);
		arr.insert(77);
		arr.insert(99);
		arr.insert(44);
		arr.insert(55);
		arr.insert(22);
		arr.insert(88);
		arr.insert(11);
		arr.insert(00);
		arr.insert(66);
		arr.insert(33);
		
		arr.display();
		
		int searchKey = 55;
		
		if(arr.find(searchKey)) {
			System.out.println("Found "+searchKey);
		}else {
			System.out.println("Can't Find " + searchKey);
		}
		
		arr.delete(55);
		arr.delete(00);
		arr.delete(99);
		
		arr.display();
		
		int searchKey1 = 55;
		
		if(arr.find(searchKey1)) {
			System.out.println("Found "+searchKey1);
		}else {
			System.out.println("Can't Find " + searchKey1);
		}
	}

}

class HighArray{
	private long[] a;
	private int nElems;

	public HighArray(int max) {
		a = new long[max];
		nElems=0;
	}
	
	public boolean find(long searchKey) {
		for (long l : a) {
			if(searchKey==l) {
				return true;
			}
		}
		return false;
	}
	
	public void insert(long value) {
		a[nElems]=value;
		nElems++;
	}
	
	public boolean delete(long value) {
		int j,i;
		boolean isDelete=false;
		long[] aTemp= new long[nElems];
		for (j = 0, i=0; j < nElems; j++) {
			if(!(value==a[j])) {
				aTemp[i]=a[j];
				i++;
			}else {
				isDelete=true;
			}
		}
		a=aTemp;
		return isDelete;
	}
	
	public void display() {
		for (int i = 0; i < nElems; i++) {
			System.out.print(a[i]+"	");
		}
		System.out.println();
	}
}
