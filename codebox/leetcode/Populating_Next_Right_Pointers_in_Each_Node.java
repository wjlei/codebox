package main3;

class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;

    TreeLinkNode(int x) {
	val = x;
    }
}

public class Populating_Next_Right_Pointers_in_Each_Node {
    public static void connect(TreeLinkNode root) {
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
    static public void main(String args[]){
	connect(new TreeLinkNode(0));
    }

}
