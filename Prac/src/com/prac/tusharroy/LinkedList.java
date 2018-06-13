package com.prac.tusharroy;

/**
 * @author Manish Karki
 * 
 */

public class LinkedList {

	public Node root;

	public LinkedList() {
		root = null;
	}

	public void addNode(int value) {
		Node n = new Node(value);
		
		// at beginning the root is null, so check for that
		if(root == null){
			root = n;
			root.next = null;
			return;
		}
		
		n.next = null;
		// traverse until null is found then simply add the new node as next
		Node n1 = root;
		
		while( n1.next != null){
			n1 = n1.next;
		}
		
		n1.next = n;
		return;
		
	}

	private static class Node {
		int value;
		Node next;

		public Node(int value) {
			this.value = value;
			this.next = null;
		}
	}

	public Node reverseList(Node head) {
		Node current = head;
		Node previous = null;// node to track the previous node in iteration
		Node next = null; // node to point to current node's next

		while (current != null) {
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}
		return previous;
	}
	
	public void display(Node head){
		//
		Node currNode = head;
		while(currNode!=null){
			System.out.print(currNode.value + "->" );
			currNode=currNode.next;
		}
	}


	public static void main(String[] args) {
		LinkedList node = new LinkedList();
		node.addNode(13);
		node.addNode(12);
		node.addNode(13);
		node.addNode(14);
		node.addNode(15);
		node.addNode(16);
		
		System.out.println("_______LinkedList______");
		node.display(node.root);
		Node reverse = node.reverseList(node.root);
		System.out.println();
		node.display(reverse);

	}

}
