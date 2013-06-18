package main3;

public class Flatten_Binary_Tree_to_Linked_List {
    public static void solve(TreeNode root){
	if(root.left!=null){
	    solve(root.left);
	}
	TreeNode tempr=root.right;
	if(root.left!=null){
	    root.right=root.left;
	    root.left=null;
	}
	while(root.right!=null&&root.right!=tempr){
	    root=root.right;
	}
	root.right=tempr;
	if(root.right!=null){
	    solve(root.right);
	}
	
    }
    
    public static void flatten(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
	if(root==null)
	    return;
	solve(root);
        
    }
    static public void main(String args[]){
	TreeNode root=new TreeNode(1);
	root.right=new TreeNode(2);
	flatten(root);
	System.out.println("hello");
    }

}
