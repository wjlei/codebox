package main3;

public class Populating_Next_Right_Pointers_in_Each_Node_II {
    public void connect(TreeLinkNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
	if (root == null)
	    return;
	root.next = null;
	TreeLinkNode pre = root;

	while (pre != null) {
	    TreeLinkNode head = null, last = null;
	    for (; pre != null; pre = pre.next) {
		if (head == null) {
		    if (pre.left != null) {
			head = pre.left;
			last = head;
		    }
		    if (pre.right != null) {
			if (head == null) {
			    head = pre.right;
			    last = head;
			} else {
			    last.next = pre.right;
			    last = last.next;
			}
		    }
		} else {
		    if (pre.left != null) {
			last.next = pre.left;
			last = last.next;
		    }
		    if (pre.right != null) {
			last.next = pre.right;
			last = last.next;
		    }
		}
	    }
	    pre=head;
	    if(last!=null)
	      last.next=null;
	}
        
    }

}
