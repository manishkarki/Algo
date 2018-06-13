package com.prac.leetcode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Manish Karki
 * 
 */

public class MultiSpaceReplacement {
	
	public void replace(String str){
        Pattern pattern = Pattern.compile("^+ |  +| +$");
        Matcher matcher = pattern.matcher(str);
        System.out.println(matcher.replaceAll(""));
        
    }
    
    public static void main(String args[]){
        String str = "     This is Manish  Karki  ";
        MultiSpaceReplacement mrs = new MultiSpaceReplacement();
        mrs.replace(str);
    }


}
