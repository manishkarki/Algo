package com.prac.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Manish Karki
 * 
 */

public class TinyUrl {
	
	List<String> urls = new ArrayList<String>();
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        urls.add(longUrl);
        return String.valueOf(urls.size()-1);
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        int index = Integer.valueOf(shortUrl);
        return (index<urls.size())?urls.get(index):"";
    }
    
    public static void main(String[] args) {
		TinyUrl tiny = new TinyUrl();
		System.out.println(tiny.encode("https://leetcode.com/problems/design-tinyurl"));
		System.out.println(tiny.decode("0"));
		System.out.println(1<<8);
	}

}
