package main2;

public class Partition_List {
    public static ListNode partition(ListNode head, int x) {
	// Start typing your Java solution below
	// DO NOT write main() function
	ListNode ans = new ListNode(0);
	ans.next = head;
	ListNode j = ans;
	ListNode pre = ans;
	for (ListNode i = head; i != null;) {
	    if (i.val < x) {
		if (i == j.next) {//special judge dont swap make trouble
		    j = j.next;
		} else {
		    pre.next = i.next;
		    i.next = j.next;
		    j.next = i;
		    i = pre;
		    j = j.next;
		}
	    }
	    pre = i;
	    if (i != null)
		i = i.next;
	}
	return ans.next;

    }

    public static void main(String args[]) {
	ListNode head = new ListNode(1);
	head.next = new ListNode(3);
	head.next.next=new ListNode(2);
	System.out.println(partition(head, 3));

    }

}
