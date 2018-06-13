package com.prac.string;

import java.util.List;
import java.util.ListIterator;
import java.util.Vector;

public class ListIteratorExample {

	public static void main(String[] args) {
		List<Integer> vector = new Vector<>();
		for (int i = 0; i < 10; i++) {
			vector.add(i);
		}

		ListIterator<Integer> listIterator = vector.listIterator(5);
		while (listIterator.hasPrevious())
			System.out.println(listIterator.previous());
	}

}
