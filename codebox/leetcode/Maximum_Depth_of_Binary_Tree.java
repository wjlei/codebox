package main3;

public class Maximum_Depth_of_Binary_Tree {
   static  int solve(TreeNode root,int deep){
       if(root==null)
	   return 0;
       int max=0;
       if(root.left!=null)
	  max=Math.max(solve(root.left,deep+1), max);
       if(root.right!=null)
	  max=Math.max(solve(root.right,deep+1), max);
       return max+1;
    }
    public int maxDepth(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
	return solve(root,0);
        
    }

}
