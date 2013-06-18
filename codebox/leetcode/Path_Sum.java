package main3;

public class Path_Sum {
    boolean get;
    void solve(TreeNode root,int temp,int sum){
	if(root.left==null&&root.right==null){
	    if(temp+root.val==sum)
		get=true;
	    return ;
	}
	if(root.left!=null)
	    solve(root.left,temp+root.val,sum);
	if(root.right!=null)
	    solve(root.right,temp+root.val,sum);
	
    }
    public boolean hasPathSum(TreeNode root, int sum) {
        // Start typing your Java solution below
        // DO NOT write main() function
	if(root==null){
	    return false;
	}
	get=false;
	solve(root,0,sum);
	return get;   
    }

}
