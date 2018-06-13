package com.prac.string;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Demo {

	public static boolean isGreaterThan3(int number) {
		return number > 3;
	}

	public static boolean isEven(int number) {
		return number % 2 == 0;
	}

	static Function<Integer, Predicate<Integer>> isGreaterThan = p -> num -> num > p;

	public static int sumValues(List<Integer> list) {
		return list.stream().reduce(0, Math::addExact);
	}

	public static void main(String[] args) {
		List<Integer> sampleList = Arrays.asList(1, 3, 4, 5, 6, 7, 2, 9);
		System.out.println(sampleList.stream().filter(isGreaterThan.apply(5)).filter(Demo::isEven).findFirst());
		
		System.out.println(sumValues(sampleList));
//		System.out.println(sumValues(sampleList, e -> e % 2 == 0));
	}
}
