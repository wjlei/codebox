package main;

public class Reorder_List {
	public void reorderList(ListNode head) {
		if(head==null||head.next==null)
			return ;
		ListNode odd=head;
		ListNode oddcur=odd;
		ListNode even=head.next;
		ListNode evencur=even;
		int count=3;
		for(ListNode cur=head.next.next;cur!=null;cur=cur.next){
			if(count%2==1){
				oddcur.next=cur;
				oddcur=cur;
			}
			else{
				evencur.next=cur;
				evencur=cur;
			}
			count++;
		}
		oddcur.next=null;evencur.next=null;
		ListNode pre=null,cur=even,last=even.next;
		while(last!=null){
			cur.next=pre;
			pre=cur;
			cur=last;
			last=last.next;
		}
		cur=head;
		count=2;
		while(odd!=null&&even!=null){
			if(count%2==1){
				cur.next=odd;
				odd=odd.next;
				cur=odd;
			}
			else{
				cur.next=even;
				even=even.next;
				cur=even;
			}
			count++;
		}
		

    }
    public static void main(String args[]) {

    }

}
