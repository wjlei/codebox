package main3;


public class Recover_Binary_Search_Tree {
     static TreeNode node1;
   static TreeNode node2;
    static TreeNode pre;
  static  boolean isget;
    public static void inorder2(TreeNode root){
   	if(!isget){
   	    if(root.right!=null)
   		inorder2(root.right);
   	    if(pre==null||root.val<pre.val)
   		    pre=root;
   	    else{
   		  node2=pre;
   		  isget=true;
   	    }
   	    if(root.left!=null)
   		inorder2(root.left);
   	}
       }
    public static void inorder1(TreeNode root){
	if(!isget){
	    if(root.left!=null)
		inorder1(root.left);
	    if(pre==null||root.val>pre.val)
		    pre=root;
	    else{
		  node1=pre;
		  isget=true;
	    }
	    if(root.right!=null)
		inorder1(root.right);
	}
    }
    public static void recoverTree(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
	if(root==null)
	    return ;
	pre=null;
	node1=null;
	node2=null;
	isget=false;
	inorder1(root);
	pre=null;
	isget=false;
	inorder2(root);
	int temp=node1.val;
	node1.val=node2.val;
	node2.val=temp;
    }
    public static void main(String args[]) {
	TreeNode head=new TreeNode(1);
	head.left=new TreeNode(2);
	head.right=new TreeNode(3);
   	recoverTree(head);
      }

}
