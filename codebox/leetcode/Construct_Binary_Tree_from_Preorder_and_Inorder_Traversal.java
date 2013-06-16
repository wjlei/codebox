package main3;

public class Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal {
   static TreeNode solve(int[] preorder, int[] inorder,int pl,int pr,int il,int ir){
       if(pl>pr||il>ir)
	   return null;
       TreeNode root=new TreeNode(preorder[pl]);
       int ii=-1;
       for(int i=il;i<=ir;i++){
	   if(inorder[i]==preorder[pl]){
	       ii=i;
	       break;
	   }
       }
       int numl=ii-il;
       int numr=ir-ii;
       root.left=solve(preorder,inorder,pl+1,pl+numl,il,ii-1);
       root.right=solve(preorder,inorder,pr-numr+1,pr,ii+1,ir);
       return root;
	
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Start typing your Java solution below
        // DO NOT write main() function
	int n=preorder.length;
	return solve(preorder,inorder,0,n-1,0,n-1);
        
    }

}
