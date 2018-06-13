package com.prac.graph;

/**
 * @author Manish Karki
 * 
 */

public class Parent {

	int data = 50;

	void change(Parent parent) {
		parent.data = parent.data + 100;// changes will be in the local variable only
	}

	public static void main(String args[]) {
		Parent op = new Parent();

		System.out.println("before change " + op.data);
		op.change(op);
		System.out.println("after change " + op.data);

	}

}
