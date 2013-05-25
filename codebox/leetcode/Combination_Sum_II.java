package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Combination_Sum_II {
    static void  solve(int[] candidates, int start,int target,Set<ArrayList<Integer>> ans,ArrayList<Integer> temp,int sum){
	if(sum>target)
	    return;
	if(sum==target){
	    ans.add(temp);
	    return ;
	}
	for(int i=start+1;i<candidates.length;i++){
	    int value= candidates[i];
	    ArrayList<Integer> AL=new ArrayList<Integer>(temp);
	    AL.add(value);
	    solve(candidates,i,target,ans,AL,sum+value);
	}
	
    }
    public static ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
	Arrays.sort(num);
	 Set<ArrayList<Integer>> ans=new  HashSet<ArrayList<Integer>>();
	 ArrayList<ArrayList<Integer>> fans=new  ArrayList<ArrayList<Integer>>();
	 ArrayList<Integer> temp=new ArrayList<Integer>();
	 solve(num,-1,target,ans,temp,0);//-1
	 for(ArrayList<Integer> i:ans){
	     fans.add(i);
	 }
	 
	 return fans;
        
    }
    public static void main(String args[]){
	int num[]={1};
	System.out.println(combinationSum2(num,1));
    }

}
