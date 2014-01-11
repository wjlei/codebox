package main;

public class Reorder_List {
	public static void reorderList(ListNode head) {
		if(head==null||head.next==null)
			return ;
		ListNode odd=head;
		ListNode oddcur=odd;
		ListNode even=null;
		ListNode evencur=head.next;
		int count=0;
		while(true){
			if(evencur==null||evencur.next==null){
				even=oddcur.next;
				break;
			}
			oddcur=oddcur.next;
			evencur=evencur.next.next;
		}
		oddcur.next=null;
		ListNode pre=null,cur=even,last=even.next;
		while(cur!=null){
			cur.next=pre;
			pre=cur;
			cur=last;
			if(last!=null)
				last=last.next;
		}
		even=pre;
		cur=head;
		count=2;
		odd=odd.next;
		while(odd!=null||even!=null){
			if(count%2==1){
				cur.next=odd;
				cur=odd;
				odd=odd.next;
			}
			else{
				cur.next=even;
				cur=even;
				even=even.next;
			}
			count++;
		}
		

    }
    public static void main(String args[]) {
    	ListNode head=new ListNode(1);
    	head.next=new ListNode(2);
    	head.next.next=new ListNode(3);
    	reorderList(head);
    	for(ListNode cur=head; cur!=null;cur=cur.next){
    		System.out.println(cur.val);
    	}

    }

}
