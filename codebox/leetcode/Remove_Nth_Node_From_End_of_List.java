package main;


public class Remove_Nth_Node_From_End_of_List {
	 public ListNode removeNthFromEnd(ListNode head, int n) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
		 if(head==null)
			 return head;
		 ListNode last=head;
		 ListNode pre=null;
		 ListNode cur=null;
		 for(int i=0;i<n-1;i++){
			 last=last.next;
			 if(last==null){
				 return head;
			 }
		 }
		 cur=head;
		 while(true){
			 if(last.next==null){
				 if(pre==null)
					 head=head.next;
				 else{
					 pre.next=cur.next;
				 }
				 break;
			 }
			 last=last.next;
			 pre=cur;
			 cur=cur.next;
			 
		 }
		 return head;
		 
	        
	    }
	

}
