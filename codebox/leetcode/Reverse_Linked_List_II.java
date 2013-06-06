package main2;

public class Reverse_Linked_List_II {
   static ListNode reverse(ListNode head,ListNode end,ListNode lastone){
       if(head==end||head==null){
	   head.next=lastone;
	   return end;
       }
       ListNode pre=lastone;
       ListNode next=head.next;
       while(head!=end){
	   head.next=pre;
	   pre=head;
	   head=next;
	   if(next!=null)
	       next=next.next;
       }
       head.next=pre;
       return end;
	
    }
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
	if(head==null||head.next==null)
	    return head;	    
	ListNode ans=new ListNode(0);
	ans.next=head;
	ListNode pre=ans;
	ListNode cur=head;
	ListNode last=head;
	for(int i=1;i<m&&cur!=null;i++){
	    pre=cur;
	    cur=cur.next;
	}
	for(int i=1;i<n&&last!=null;i++){
	    last=last.next;
	}
	pre.next=reverse(cur,last,last.next);
	return ans.next;
        
    }
    public static void main(String args[]) {
	ListNode head =new ListNode(-1);
	head.next=new ListNode(-3);
   	System.out.print(reverseBetween(head,1,2) );
        }


}
