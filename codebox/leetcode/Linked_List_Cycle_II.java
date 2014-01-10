package main;

public class Linked_List_Cycle_II {
	public ListNode detectCycle(ListNode head) {
    	if(head==null)
    		return null;
    	ListNode onstep=head;
    	ListNode twostep=head;
    	while(true){
    		if(onstep.next==null)
    			return null;
    		else
    			onstep=onstep.next;
    		if(twostep.next==null||twostep.next.next==null)
    			return null;
    		else
    			twostep=twostep.next.next;
    		if(onstep==twostep)
    			break;
    	}
    	onstep=head;
    	while(true){
    		if(onstep==twostep)
    			return onstep;
    		onstep=onstep.next;
    		twostep=twostep.next;
    	}
    }
    public static void main(String args[]) {

    }

}
