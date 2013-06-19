package main3;

public class Binary_Tree_Maximum_Path_Sum {
    int max;
    public int solve(TreeNode root){
	int l=0,r=0;
	if(root.left!=null){
	    l=solve(root.left);
	}
	if(root.right!=null){
	    r=solve(root.right);
	}
	max=Math.max(max, l+r+root.val);
	max=Math.max(max, l+root.val);
	max=Math.max(max, r+root.val);
	max=Math.max(max, root.val);
	int back=Math.max(l+root.val, r+root.val);
	return Math.max(root.val, back);
	
    }
    
    public int maxPathSum(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
	max=Integer.MIN_VALUE;
        if(root==null)
            return 0;
        solve(root);
        
        return max;
        
    }

}
