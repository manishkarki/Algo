package com.prac.hackerrank;

import com.prac.graph.Parent;

/**
 * @author Manish Karki
 * 
 */

public class Child extends Parent{
	
	public void main(){
		System.out.println("child");
	}
	
	public static void main(String[] args) {
		Parent p = new Child();
		Child c = (Child) p;
		c.main();
	}

}
