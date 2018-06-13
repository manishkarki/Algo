package com.prac.tusharroy;

import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Manish Karki
 * 
 */


public class ABCD_Block_N_Static {
	

	public static void main(String... args) throws ClassNotFoundException {
		/*Class abClass = ABCD_Block_N_Static.class;
		
		Method[] m = abClass.getDeclaredMethods();
		List<String> arr = new ArrayList<>();
		
		for(Method m1: m){
			arr.add(m1.getName());
		}
		
		System.out.println(arr);*/
		System.out.println("  manish karki  ".trim());
		SimpleDateFormat myFormat = new SimpleDateFormat("dd MM yyyy");
		String inputString1 = "23 01 1997";
		String inputString2 = "27 04 1997";

		try {
		    Date date1 = myFormat.parse(inputString1);
		    Date date2 = myFormat.parse(inputString2);
		    long diff = date2.getTime() - date1.getTime();
		    System.out.println ("Days: " + diff/(1000*60*60*24));
		} catch (ParseException e) {
		    e.printStackTrace();
		}
		
		
	}
}
