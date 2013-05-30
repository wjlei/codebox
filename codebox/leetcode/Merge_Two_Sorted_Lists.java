package main2;

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }
 }
public class Merge_Two_Sorted_Lists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // Start typing your Java solution below
        // DO NOT write main() function
	ListNode ans=new ListNode(0);
	ListNode cur=ans;
	while(l1!=null&&l2!=null){
	    if(l1.val<l2.val){
		cur.next=l1;
		cur=cur.next;
		l1=l1.next;
	    }
	    else{
		cur.next=l2;
		cur=cur.next;
		l2=l2.next;
	    }
	}
	cur.next=l1==null?l2:l1;
	return ans.next;
    }

}
