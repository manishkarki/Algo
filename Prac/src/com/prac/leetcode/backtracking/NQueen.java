package com.prac.leetcode.backtracking;

/**
 * @author Manish Karki
 * 
 */

public class NQueen {
	
	//a class that denotes the position of queen
	private class Position{
		int row, col;
		
		public Position(int row, int col){
			this.row = row;
			this.col = col;
		}
	}
	
	public Position[] solveNQueen(int n){
		Position [] positions = new Position[n];
		if(solveNQueenUtil(0, n, positions))
			return positions;
		else {
			return new Position[0];
		}

	}

	private boolean solveNQueenUtil(int row, int n, Position[] positions) {
		if( n == row)
			return true;
		
		for(int col = 0; col < n; col++){
			boolean foundSafe = true;
			
			for(int queen = 0; queen < row; queen++){
				//check if the queen is under attack
				if(positions[queen].col == col || positions[queen].row - positions[queen].col == row - col ||
						positions[queen].row + positions[queen].col == row + col){
					foundSafe = false;
					break;
				}
			}
			
			if(foundSafe){
				positions[row] = new Position(row, col);
				if(solveNQueenUtil(row+1, n, positions))
					return true;
			}
		}
		
		return false;
	}
	

	public static void main(String[] args) {
		NQueen nq = new NQueen();
		Position [] positions = nq.solveNQueen(6);
		
		for(Position p : positions){
			System.out.println("row:"+p.row+" col:"+ p.col);
		}
	}

}
