package main2;

public class Remove_Duplicates_from_Sorted_List_II {
    public static ListNode deleteDuplicates(ListNode head) {
	// Start typing your Java solution below
	// DO NOT write main() function
	if (head == null || head.next == null)
	    return head;
	ListNode ans = new ListNode(0);
	ListNode pre = ans;
	ListNode cur = head;
	ListNode last = head.next;
	while (last != null) {
	    if (last.val == cur.val) {
		while (last != null && last.val == cur.val) {
		    last = last.next;
		}
		cur = last;
		if (last != null)
		    last = last.next;
		continue;
	    }

	    pre.next = cur;
	    pre = pre.next;
	    cur = last;
	    last = last.next;
	}
	if (cur != null) {
	    pre.next = cur;
	    cur.next = null;
	} else
	    pre.next = null;
	return ans.next;

    }
    public static void main(String args[]){
	ListNode head=new ListNode(1);
	head.next=new ListNode(2);
	 deleteDuplicates(head);
    }

}
