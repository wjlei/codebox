package main;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Merge_k_Sorted_Lists {
	public static ListNode mergeKLists(ArrayList<ListNode> lists) {
		// Start typing your Java solution below
		// DO NOT write main() function
		Comparator<ListNode> cmp = new Comparator<ListNode>() {
			public int compare(ListNode o1, ListNode o2) {
				// TODO Auto-generated method stub
				return o1.val - o2.val;
			}
		};
		int n = lists.size();
		ListNode head = new ListNode(-1);
		ListNode cur = head;
		Queue<ListNode> pq = new PriorityQueue<ListNode>(Math.max(n, 1), cmp);
		for (ListNode itr : lists) {
			if(itr!=null)
			  pq.add(itr);
		}
		while (!pq.isEmpty()) {
			ListNode temp = pq.poll();
			if (temp.next != null)
				pq.add(temp.next);
			cur.next = temp;
			cur = cur.next;
		}
		return head.next;

	}

	public static void main(String[] args) throws Exception {
		ArrayList<ListNode> head = new ArrayList<ListNode>();
		mergeKLists(head);
	}

}
