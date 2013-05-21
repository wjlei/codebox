package main;

public class Swap_Nodes_in_Pairs {
	public static void reverselist(ListNode cur,ListNode end){
		ListNode pre=null;
		ListNode last=cur.next;
		while(cur!=end){
			cur.next=pre;
			pre=cur;
			cur=last;
			last=last.next;
		}
		cur.next=pre;
		
	}
    public static ListNode swapPairs(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	int group=2;
    	if(head==null||head.next==null)
    		return head;
    	ListNode cur=head;//cur the current paragraph last one
    	ListNode next=head;//last the last paragraph last one
    	head=head.next;
    	ListNode pre=null;//pre previous paragraph last one
    	while(next!=null){
    		ListNode last=cur;
    		for(int i=0;i<group-1&&last.next!=null;i++)
    			last=last.next;
    		if(pre!=null)
    			pre.next=last;
    		pre=cur;
    		next=last.next;//to another block
    		reverselist(cur,last);
    		cur=next;
    	}
    	pre.next=null;
    	return head;
        
    }
    public static void main(String args[]){
    	ListNode head=new ListNode(1);
    	ListNode cur=head;
    	cur.next=new ListNode(2);
    //	cur=cur.next;
    	swapPairs(head);
    }

}
