package main3;

import java.util.ArrayList;

public class Path_Sum_II {
    void solve(TreeNode root,int temp,int sum,ArrayList<ArrayList<Integer>>ans,ArrayList<Integer>templist){
	ArrayList<Integer>t=(ArrayList<Integer>) templist.clone();
	t.add(root.val);
	if(root.left==null&&root.right==null){
	    if(temp+root.val==sum)
		ans.add(t);
	    return ;
	}
	if(root.left!=null){
	    solve(root.left,temp+root.val,sum,ans,t);
	}
	if(root.right!=null){
	    solve(root.right,temp+root.val,sum,ans,t);
	}
	
    }
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        // Start typing your Java solution below
        // DO NOT write main() function
	ArrayList<ArrayList<Integer>> ans=new ArrayList<ArrayList<Integer>>();
	if(root==null)
	    return ans;
	ArrayList<Integer>templist=new ArrayList<Integer>();
	solve(root,0,sum,ans,templist);
	return ans;
        
    }

}
