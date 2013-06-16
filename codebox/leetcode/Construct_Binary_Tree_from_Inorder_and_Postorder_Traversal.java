package main3;

public class Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal {
    static TreeNode solve(int[] inorder, int[] postorder, int il, int ir,int pl, int pr) {
	if (pl > pr || il > ir)
	    return null;
	TreeNode root = new TreeNode(postorder[pr]);
	int ii = -1;
	for (int i = il; i <= ir; i++) {
	    if (inorder[i] == postorder[pr]) {
		ii = i;
		break;
	    }
	}
	int numl = ii - il;
	int numr = ir - ii;
	root.left = solve(inorder,postorder, il, ii-1, pl, pl+numl-1);
	root.right = solve(inorder,postorder, ii+1, ir, pr-numr, pr-1);
	return root;

    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
	// Start typing your Java solution below
	// DO NOT write main() function
	int n=inorder.length;
	return solve(inorder,postorder,0,n-1,0,n-1);

    }

}
