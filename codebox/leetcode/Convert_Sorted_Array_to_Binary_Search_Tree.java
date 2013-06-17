package main1;

 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }

public class Convert_Sorted_Array_to_Binary_Search_Tree {
	TreeNode solve(int[] num,int l,int r){
		if(l>r)
			return null;
		int mid=l+(r-l)/2;
		TreeNode root=new TreeNode(num[mid]);
		root.left=solve(num,l,mid-1);
		root.right=solve(num,mid+1,r);
		return root;
	}
	
    public TreeNode sortedArrayToBST(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	return solve(num,0,num.length-1);
        
    }

}
