package com.prac.tusharroy;

/**
 * @author Manish Karki
 * 
 */

public class TestBuilder {
	
	public static void main(String[] args) {
		BuilderDemo bd = new BuilderDemo.Builder(
				"500 GB", "2 GB").setBluetoothEnabled(true)
				.setGraphicsCardEnabled(true).build();
		System.out.println(bd);
	}

}
