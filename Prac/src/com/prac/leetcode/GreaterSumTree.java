package com.prac.leetcode;

/**
 * @author Manish Karki
 * 
 */
/*Given a binary search tree (BST), con­vert it into greater sum tree.
What is greater sum tree: Greater sum tree is a tree in which every TreeNode con­tains the sum of all the TreeNodes which are greater than the TreeNode.
 */
public class GreaterSumTree {
	private static int sum = 0;
	public static void main(String args[]){
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.right = new TreeNode(15);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(7);
		root.right.left = new TreeNode(12);
		root.right.right = new TreeNode(20	);

		GreaterSumTree b = new GreaterSumTree();
		b.inorder(root);
		System.out.println("");
		b.greaterTree(root);
		b.inorder(root);
		
	}

	private void greaterTree(TreeNode root) {
		if(root == null)
			return;
		else{
			greaterTree(root.right);
			int temp = root.data;
			root.data = sum;
			sum += temp;
			greaterTree(root.left);
		}
	}

	private void inorder(TreeNode root) {
		if(root != null){
			inorder(root.left);
			System.out.print("->"+root.data);
			inorder(root.right);
		}
		
	}
}

class TreeNode{
	int data;
	TreeNode left;
	TreeNode right;
	public TreeNode (int data){
		this.data = data;
		left = null;
		right = null;
	}
}
