package com.prac.tusharroy;

/**
 * Given that the array represents the height of different towers, identify if
 * tower is hopable
 * 
 * @author Manish Karki
 * 
 */

public class HoppableTower {

	private static boolean isHoppable(int[] towers) {

		int target = towers.length;
		int height = 0;

		for (int i = 0; i < target; i++) {
			height = Math.max(height, towers[i]);
			if (height + i >= target)
				return true;

			height -= 1;

			if (height < 0)
				return false;
		}
		return true;

	}

	public static void main(String[] args) {
		System.out.println(isHoppable(new int[] { 4, 2, 0, 0, 2, 0 }));
	}

}
