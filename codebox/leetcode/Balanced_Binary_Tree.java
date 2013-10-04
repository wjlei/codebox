package main;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class Balanced_Binary_Tree {
	static boolean balance=true;

	int solve(TreeNode root) {
		if (balance) {
			if (root == null)
				return 0;
			int l = solve(root.left);
			int r = solve(root.right);
			if (Math.abs(l - r) > 1)
				balance = false;
			return Math.max(l, r) + 1;
		}
		return 0;
	}
    public boolean isBalanced(TreeNode root) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
    	balance=true;
    	solve(root);
    	return balance;
        
    }
}
