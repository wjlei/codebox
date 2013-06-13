package main3;

public class Validate_Binary_Search_Tree {
    public boolean inorder(TreeNode root){
	if(root.left!=null){
	    if(!inorder(root.left))
		return false;
	}
	if(root.val>value)
	    value=root.val;
	else
	    return false;
	if(root.right!=null){
	    if(!inorder(root.right))
		return false;
	}
	return true;
    }
    public int value;
    public boolean isValidBST(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
	if(root==null)
	    return true;
        value=Integer.MIN_VALUE;
        return inorder(root);
    }

}
