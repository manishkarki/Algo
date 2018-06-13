package com.prac.interview;

/**
 * @author Manish Karki
 * 
 */

class Student{
	
}

public class NewInstanceDemo {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		Object obj = Class.forName(args[0]).newInstance();
		System.out.println("Object created for:"+obj.getClass().getSimpleName());
		char l = 'l';
		char o = 'o';
		System.out.print("Y" + "O");
        System.out.print(l+o);

	}
}
