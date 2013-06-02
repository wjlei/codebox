package main2;

public class Remove_Duplicates_from_Sorted_List {
    public ListNode deleteDuplicates(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
	if(head==null||head.next==null)
	    return head;
	ListNode pre=head;
	ListNode cur=head.next;
	while(cur!=null){
	    if(pre.val!=cur.val){
		pre.next=cur;
		pre=pre.next;
	    }
	    cur=cur.next;
	}
	pre.next=null;
	return head;
	
        
    }

}
