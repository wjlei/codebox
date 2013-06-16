package main3;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Binary_Tree_Level_Order_Traversal_II {
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
	ArrayList<ArrayList<Integer>> ans1=new ArrayList<ArrayList<Integer>>();
	Deque<ArrayList<Integer>> ans=new ArrayDeque<ArrayList<Integer>>();
	if(root==null)
	    return ans1;
	Queue<TreeNode> q1=new LinkedList<TreeNode>();
	Queue<TreeNode> q2=new LinkedList<TreeNode>();
	q1.add(root);
	ArrayList<Integer> temp;
	while(!(q1.isEmpty()&&q2.isEmpty())){
	    temp=new ArrayList<Integer>();
	    while(!q1.isEmpty()){
		TreeNode node=q1.poll();
		temp.add(node.val);
		if(node.left!=null)
		    q2.add(node.left);
		if(node.right!=null)
		    q2.add(node.right);
	    }
	    if (temp.size() > 0) {
		ans.add(temp);
		temp = new ArrayList<Integer>();
	    }
	    while(!q2.isEmpty()){
		TreeNode node=q2.poll();
		temp.add(node.val);
		if(node.left!=null)
		    q1.add(node.left);
		if(node.right!=null)
		    q1.add(node.right);
		
	    }
	    if (temp.size() > 0) 
	        ans.add(temp);
	}
	while(!ans.isEmpty()){
	    ans1.add(ans.pollLast());
	}
	
	return ans1;
        
    }

}
