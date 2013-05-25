package main;

import java.util.ArrayList;
import java.util.Arrays;

public class Combination_Sum {
    static void  solve(int[] candidates, int start,int target,ArrayList<ArrayList<Integer>> ans,ArrayList<Integer> temp,int sum){
	if(sum>target)
	    return;
	if(sum==target){
	    ans.add(temp);
	    return ;
	}
	for(int i=start;i<candidates.length;i++){
	    int value= candidates[i];
	    ArrayList<Integer> AL=new ArrayList<Integer>(temp);
	    AL.add(value);
	    solve(candidates,i,target,ans,AL,sum+value);
	}
	
    }
    public static ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
	Arrays.sort(candidates);
	 ArrayList<ArrayList<Integer>> ans=new  ArrayList<ArrayList<Integer>>();
	 ArrayList<Integer> temp=new ArrayList<Integer>();
	 solve(candidates,0,target,ans,temp,0);
	 return ans;
    }
    public static void main(String args[]){
	int num[]={2,3,6,7};
	System.out.println(combinationSum(num,7));
    }

}
