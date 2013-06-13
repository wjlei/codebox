package main3;

public class Same_Tree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Start typing your Java solution below
        // DO NOT write main() function
	if(p==null&&q==null)
	    return true;
	if(p==null||q==null)
	    return false;
	if(p.val!=q.val)
	    return false;
	if((isSameTree(p.left,q.left)&&isSameTree(p.right,q.right)))
	    return true;
	else
	    return false;
        
    }

}
