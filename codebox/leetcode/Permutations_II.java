package main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Permutations_II {
    public static void swap(int num[],int a,int b){
	int temp=num[a];
	num[a]=num[b];
	num[b]=temp;
    }
    public static void solve(int[] num,int index,Set<ArrayList<Integer>> ans){
	if(index==num.length-1){
	    ArrayList<Integer> temp=new ArrayList<Integer>();
	    for(int value:num){
		temp.add(value);
	    }
	    ans.add(temp);
	    return ;
	}
	int local[]=num.clone();
	solve(local,index+1,ans);
	for(int i=index+1;i<num.length;i++){
	    local=num.clone();
	    swap(local,index,i);
	    solve(local,index+1,ans);
	}
	
    }
        
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
	Set<ArrayList<Integer>> ans=new HashSet<ArrayList<Integer>>();
	solve(num,0,ans);
	ArrayList<ArrayList<Integer>> ans1=new ArrayList<ArrayList<Integer>>();
	for(ArrayList<Integer> value:ans){
	    ans1.add(value);
	}
        return ans1;
        
    }

}
