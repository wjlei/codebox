package main2;

import java.util.ArrayList;

public class Combinations {
    void solve(ArrayList<ArrayList<Integer>> ans,int i,ArrayList<Integer> temp,int k,int n){
	if(k==0){
	    ans.add(temp);
	    return;
	}
	if(i>n)
	    return;
	ArrayList<Integer> next=(ArrayList<Integer>) temp.clone();
	solve(ans,i+1,next,k,n);
	next.add(i);
	solve(ans,i+1,next,k-1,n);
	
    }
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
	ArrayList<ArrayList<Integer>> ans=new ArrayList<ArrayList<Integer>>();
	ArrayList<Integer> temp=new ArrayList<Integer> ();
	solve(ans,1,temp,k,n);
	return ans;
    }

}
