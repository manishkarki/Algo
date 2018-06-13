package com.prac.hackerrank.ds;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*The first line has an integer arrayCount. In each of the next  lines there will be an integer d denoting number of integers on that
 *  line and
then there will be d space-separated integers. In the next line there will be an integer q denoting number of queries. Each query will
consist of two integers x  and y.
In each line, output the number located in yth position of xth line. If there is no such position, just print "ERROR!"*/

/**
 * @author Manish Karki
 * 
 */

public class ArrayListQueryGet {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int arrayCount = sc.nextInt();
		int d = 0;
		List<Integer[]> arrayList = new ArrayList<Integer[]>();
		for (int i = 0; i < arrayCount; i++) {
			d = sc.nextInt();
			Integer[] arr = new Integer[d];
			for (int j = 0; j < d; j++) {
				arr[j] = sc.nextInt();
			}
			arrayList.add(arr);
		}
		int q = 0;
		q = sc.nextInt();
		for (int i = 0; i < q; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			try {
				System.out.println(arrayList.get(x - 1)[y - 1]);
			} catch (Exception e) {
				System.out.println("ERROR!");
			}
			;

		}
		sc.close();
	}

}
