package com.prac.interview;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author Manish Karki
 * 
 */

public class Java8Demo {
	
	public static void main(String[] args) {
//		String[] strArr = { "Manish", "Krishna", "Ramesh", "Daal", "Bhat", "KattuChor" };
		Map<String, String> arr = new HashMap<>();
		
		
		arr.put("krishna", "bhat");
		arr.put("Ramesh", "Mahasala");
		arr.put("Manish", "Jiu");
		arr.put("daju", "krishna");
		arr.put("kc", "Kc");
		arr.put("Manish", "Karki");
		arr.put("krish", "vat");
		
		Predicate<Map.Entry<String, String>> pred = (a) -> !a.getValue().equals("vat");

		List<Map.Entry<String, String>> strList = arr.entrySet().stream().filter(pred)
				.collect(Collectors.toList());
		
		arr = strList.stream().collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> newValue));
		
		strList.stream().forEach(System.out::println);

	}

}
