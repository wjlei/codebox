package main3;

import java.util.ArrayList;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
	val = x;
	left = null;
	right = null;
    }
}

public class Unique_Binary_Search_Trees_II {
    public static ArrayList<TreeNode> solve(int left, int right) {
	ArrayList<TreeNode> ans = new ArrayList<TreeNode>();
	if (left > right) {
	    ans.add(null);
	    return ans;
	}
	ArrayList<TreeNode> lt;
	ArrayList<TreeNode> rt;
	for (int i = left; i <= right; i++) {
	    lt=solve(left,i-1);
	    rt=solve(i+1,right);
	    for(TreeNode litr:lt){
		for(TreeNode ritr:rt){
		    TreeNode root=new TreeNode(i);
		    root.left=litr;
		    root.right=ritr;
		    ans.add(root);
		}
	    }
	}
	return ans;

    }

    public ArrayList<TreeNode> generateTrees(int n) {
	// Start typing your Java solution below
	// DO NOT write main() function
	return solve(1, n);

    }

}
