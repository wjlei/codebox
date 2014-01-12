package main;

import java.util.ArrayList;

public class Binary_Tree_Preorder_Traversal {
	public static void solve(TreeNode root,ArrayList<Integer> ans){
		ans.add(root.val);
		if(root.left!=null)
			solve(root.left,ans);
		if(root.right!=null)
			solve(root.right,ans);
	}
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
    	ArrayList<Integer> ans=new ArrayList<Integer>();
    	if(root==null)
    		return ans;
    	solve(root,ans);
    	return ans;
        
    }
    public static void main(String args[]) {


    }

}
