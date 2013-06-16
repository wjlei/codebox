package main3;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Binary_Tree_Zigzag_Level_Order_Traversal {
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
	// Start typing your Java solution below
	// DO NOT write main() function
	ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
	if (root == null)
	    return ans;
	Deque<TreeNode> q1 = new ArrayDeque<TreeNode>();
	Deque<TreeNode> q2 = new ArrayDeque<TreeNode>();
	q1.add(root);
	ArrayList<Integer> temp;
	while (!(q1.isEmpty() && q2.isEmpty())) {
	    temp = new ArrayList<Integer>();
	    while (!q1.isEmpty()) {
		TreeNode node = q1.pollFirst();
		temp.add(node.val);
		if (node.left != null)
		    q2.add(node.left);
		if (node.right != null)
		    q2.add(node.right);
	    }
	    if (temp.size() > 0) {
		ans.add(temp);
		temp = new ArrayList<Integer>();
	    }
	    while (!q2.isEmpty()) {
		TreeNode node = q2.pollLast();
		temp.add(node.val);
		if (node.right != null)
		    q1.addFirst(node.right);
		if (node.left != null)
		    q1.addFirst(node.left);

	    }
	    if (temp.size() > 0)
		ans.add(temp);
	}
	return ans;

    }

}
