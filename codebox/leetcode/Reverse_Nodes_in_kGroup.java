package prepare;

class ListNode
{
    int val;
    ListNode next;
    ListNode(int x)
    {
        val = x;
        next = null;
    }
}
public class reverse_kgroup {

    static ListNode reverselist(ListNode head)
    {
        ListNode pre = null;
        ListNode cur = head;
        ListNode last = cur.next;
        while (last != null)
        {
            cur.next = pre;
            pre = cur;
            cur = last;
            last = last.next;
        }
        cur.next=pre;//!
        return cur;

    }
    static ListNode reverseKGroup(ListNode head, int k)
    {
        if (head == null || head.next == null)
            return head;
        ListNode newhead=new ListNode(0);
        newhead.next=head;//!
        ListNode pre = newhead;
        ListNode cur = head;
        ListNode last = cur;
        ListNode prelast = cur;
        while (last != null)
        {
            for (int i = 0; i < k; i++)
            {
                if (last != null)
                {
                    prelast = last;
                    last = last.next;
                }
                else
                	return newhead.next;
            }
            prelast.next = null;
            pre.next = reverselist(cur);
            cur.next = last;
            pre = cur;
            cur = last;
        }
        return newhead.next;
    }
	public static void main(String args[]) {
		ListNode head;
		ListNode cur=new ListNode(1);
		ListNode last=new ListNode(2);
		head=cur;
		cur.next=last;
		reverseKGroup(head,2);
		
	}

}

package main;

public class Reverse_Nodes_in_kGroup {
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
    public static ListNode reverseKGroup(ListNode head, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
      
    	if(head==null||head.next==null)
    		return head;
    	ListNode cur=head;//cur the current paragraph last one
    	ListNode next=head;//last the last paragraph last one
    	ListNode thead=head;
    	for(int i=0;i<k-1;i++){
    		if(thead.next==null){
    			return head;
			}
    	    thead=thead.next;
    	}
    	head=thead;
    	ListNode pre=null;//pre previous paragraph last one
    	boolean end=false;
    	while(next!=null){
    		ListNode last=cur;
    		for(int i=0;i<k-1;i++){
      			if(last.next==null){
    				pre.next=cur;
    				pre=last;//prevent pre.next=null;
    				end=true;
    				break;
    			}
    			last=last.next;
    		}
    		if(end)
    			break;
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
    	cur=cur.next;
    	cur.next=new ListNode(3);
    	reverseKGroup(head, 2) ;
    }

}
