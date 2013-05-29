package main1;
  class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }
 }
public class Rotate_List {
    public static ListNode rotateRight(ListNode head, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	if(head==null||head.next==null||n==0)
    		return head;
    	int length=0;
    	ListNode last=head;
    	while(last!=null){
    		length++;
    		last=last.next;
    	}
    	last=head;
    	n=n%length;
    	for(int i=0;i<n;i++){
    		last=last.next;
    		if(last==null)
    			return head;
    	}
    	ListNode cur=head;
    	while(last.next!=null){
    		last=last.next;
    		cur=cur.next;
    	}
    	last.next=head;
    	head=cur.next;
    	cur.next=null;
    	return head;
    	
        
    }
    public static void main(String args[]){
    	ListNode head=new ListNode(1);
    	head.next=new ListNode(2);
    	rotateRight(head,1);
    }

}
