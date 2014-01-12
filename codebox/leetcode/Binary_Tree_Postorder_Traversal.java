package main;

import java.util.ArrayList;

public class Binary_Tree_Postorder_Traversal {
	public static void solve(TreeNode root,ArrayList<Integer> ans){
		if(root.left!=null)
			solve(root.left,ans);
		if(root.right!=null)
			solve(root.right,ans);
		ans.add(root.val);
	}
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
    	ArrayList<Integer> ans=new ArrayList<Integer>();
    	if(root==null)
    		return ans;
    	solve(root,ans);
    	return ans;
        
    }
    public static void main(String args[]) {


    }

}
