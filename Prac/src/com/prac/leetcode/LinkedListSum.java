package com.prac.leetcode;

/**
 * @author Manish Karki
 * 
 */

public class LinkedListSum {

	// Definition for singly-linked list.
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		return addTwoNumbers(l1, l2, 0);
	}

	private ListNode addTwoNumbers(ListNode l1, ListNode l2, int carry) {
		if (l1 == null && l2 == null && carry == 0)
			return null;

		int sum = carry;

		if (l1 != null)
			sum += l1.val;
		if (l2 != null)
			sum += l2.val;
		ListNode result = new ListNode(sum % 10);

		if (l1 != null || l2 != null) {
			ListNode addMore = addTwoNumbers(l1 == null ? null : l1.next, l2 == null ? null : l2.next,
					((sum >= 10) ? 1 : 0));
			result.next = addMore;
		}

		return result;
	}

}
