package main2;

import java.util.ArrayList;
import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
	val = x;
    }
}

public class Binary_Tree_Inorder_Traversal {
    public static ArrayList<Integer> inorderTraversal(TreeNode root) {
	// Start typing your Java solution below
	// DO NOT write main() function
	
	ArrayList<Integer> ans = new ArrayList<Integer>();
	if(root==null)
	    return ans;
	Stack<TreeNode> stack = new Stack<TreeNode>();
	TreeNode cur = root;
	//stack.push(cur);
	while (cur!= null||!stack.isEmpty()) {//cur not cur.left trap!!
	    while (cur!= null) {
		stack.push(cur);//cur in
		cur=cur.left;
	    }
	   if(!stack.isEmpty()) {
		ans.add(stack.peek().val);
		cur = stack.peek();
		stack.pop();
		cur = cur.right;//update right
	    }
	}
	return ans;

    }
    public static void main(String args[]) {
	TreeNode head=new TreeNode(1);
	head.right=new TreeNode(2);
	head.right.left=new TreeNode(3);
   	System.out.print(inorderTraversal(head) );
      }

}
