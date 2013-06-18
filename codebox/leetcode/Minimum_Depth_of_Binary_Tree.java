package main3;

public class Minimum_Depth_of_Binary_Tree {
    int min;
    void solve(TreeNode root,int deep){
	if(root.left==null&&root.right==null){
	    min=Math.min(min, deep);
	}
	if(root.left!=null)
	solve(root.left,deep+1);
	if(root.right!=null)
	solve(root.right,deep+1);
    }
    public int minDepth(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        min=Integer.MAX_VALUE;
        if(root==null)
            return 0;
        solve(root,1);
        return min;
    }

}
