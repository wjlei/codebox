package main1;

public class Sum_Root_to_Leaf_Numbers {
	static int sum;
	static void solve(TreeNode root,int temp){
		if(root.left==null&&root.right==null){
			sum+=temp*10+root.val;
			return ;
		}
		if(root.left!=null){
			solve(root.left,temp*10+root.val);
		}
		if(root.right!=null){
			solve(root.right,temp*10+root.val);
		}
	}
    public static int sumNumbers(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
		sum=0;
		if(root==null)
			return sum;
		solve(root,0);
		return sum;
    }

}
