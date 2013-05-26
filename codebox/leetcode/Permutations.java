package main;

import java.util.ArrayList;

public class Permutations {
    public static void swap(int num[],int a,int b){
	int temp=num[a];
	num[a]=num[b];
	num[b]=temp;
    }
    public static void solve(int[] num,int index,ArrayList<ArrayList<Integer>> ans){
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
    public static ArrayList<ArrayList<Integer>> permute(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
	ArrayList<ArrayList<Integer>> ans=new ArrayList<ArrayList<Integer>>();
	solve(num,0,ans);
        return ans;
    }
    public static void main(String args[]){
	int num[]={1,2,3};
	System.out.println(permute(num));
    }

}
