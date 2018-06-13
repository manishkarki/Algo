package com.prac.interview;


/**
 * @author Manish Karki
 * 
 */

public class ShutDownHookDemo {

	public static void main(String[] args) {
		Runtime.getRuntime().addShutdownHook(new Thread() {
			public void run() {
				System.out.println("Shutdown Hook is running !"+Runtime.getRuntime().availableProcessors());
			}
		});
		System.out.println("Application Terminating ...");
	}
}
