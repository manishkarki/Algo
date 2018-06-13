package com.prac.hackerrank.arrays;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Manish Karki
 * 
 */

public class MergeKSortedArrays {
	
	/*Given k sorted arrays, merge them into a single sorted array.

	eg.

	merge({{1, 4, 7},{2, 5, 8},{3, 6, 9}}) = {1, 2, 3, 4, 5, 6, 7, 8, 9}
	*/
	
	public static class QueueNode implements Comparable<QueueNode>{
		int array, index, value;

		public QueueNode(int array, int index, int value){
			this.array = array;
			this.index = index;
			this.value = value;
		}
		@Override
		public int compareTo(QueueNode n) {
			if(n.value < value) return 1;
			if(n.value > value) return -1;
			return 0;
		}
		
	}
	
	public static int [] merge(int [][] arrays){
		Queue<QueueNode> pq = new PriorityQueue<>();
		//add first elements of each array
		//also calculate the total size of the result to be returned
		int size  = 0;
		for(int i = 0; i< arrays.length; i++){
			size += arrays[i].length;
			
			if(arrays[i].length > 0)
				pq.add(new QueueNode(i,0, arrays[i][0]));
		}
		
		int [] result = new int[size];
		//now take out the queueNode from pq, then put it's value into result array and from the same array whose element 
		//was added to result, fetch another element and add it to q and repeatedly do it until the queue is empty
		
		for(int i = 0; !pq.isEmpty(); i++){
			QueueNode n = pq.poll();
			result[i] = n.value;
			
			int newIndex =n.index +1;
			if(newIndex < arrays[n.array].length){
				pq.add( new QueueNode(n.array, newIndex, arrays[n.array][newIndex]));
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		int [] result = merge(new int[][]{{7,8,9},{1,2,3},{4,5,6}});
		for(int i = 0; i< result.length; i++)
			System.out.print(result[i]+" ");
	}

}
