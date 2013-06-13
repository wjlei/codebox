package main3;

public class Symmetric_Tree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Start typing your Java solution below
        // DO NOT write main() function
	if(p==null&&q==null)
	    return true;
	if(p==null||q==null)
	    return false;
	if(p.val!=q.val)
	    return false;
	if((isSameTree(p.left,q.right)&&isSameTree(p.right,q.left)))
	    return true;
	else
	    return false;
        
    }
    public boolean isSymmetric(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
	return isSameTree(root,root);
	
        
    }

}
