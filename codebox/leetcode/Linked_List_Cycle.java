package main;

public class Linked_List_Cycle {
    public boolean hasCycle(ListNode head) {
    	if(head==null)
    		return false;
    	ListNode onstep=head;
    	ListNode twostep=head;
    	while(true){
    		if(onstep.next==null)
    			return false;
    		else
    			onstep=onstep.next;
    		if(twostep.next==null||twostep.next.next==null)
    			return false;
    		else
    			twostep=twostep.next.next;
    		if(onstep==twostep)
    			return true;
    	}
    }
    public static void main(String args[]) {

    }

}
