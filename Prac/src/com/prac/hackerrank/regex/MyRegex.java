package com.prac.hackerrank.regex;

/**
 * @author Manish Karki
 * 
 */

public class MyRegex {
	
	/*000.12.12.034
	121.234.12.12
	23.45.12.56
	00.12.123.123123.123
	122.23
	Hello.IP*/
	
	String zeroTo255 = "([0-9]|[0-9][0-9]|(0|1)[0-9][0-9]|2[0-4][0-9]|25[0-5])";
    public String pattern = zeroTo255 + "." + zeroTo255 + "." + zeroTo255 + "." + zeroTo255;
    
    public static void main(String[] args) {
    	System.out.println("000.12.12.034".matches(new MyRegex().pattern));
    	System.out.println("121.234.12.12".matches(new MyRegex().pattern));
    	System.out.println("23.45.12.56".matches(new MyRegex().pattern));
    	System.out.println("00.12.123.123123.123".matches(new MyRegex().pattern));
    	System.out.println("122.23".matches(new MyRegex().pattern));
    	System.out.println("Hello.IP".matches(new MyRegex().pattern));
	}

}
