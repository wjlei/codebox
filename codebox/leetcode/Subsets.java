package main2;

import java.util.ArrayList;
import java.util.Arrays;

public class Subsets {
    void solve(ArrayList<ArrayList<Integer>> ans,int i,ArrayList<Integer> temp,int[] S){
	if(i==S.length){
	    ArrayList<Integer> next=(ArrayList<Integer>) temp.clone();
	    ans.add(next);
	    return ;
	}
	ArrayList<Integer> next=(ArrayList<Integer>) temp.clone();
	solve(ans,i+1,next,S);
	next.add(S[i]);
	solve(ans,i+1,next,S);
    }
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        // Start typing your Java solution below
        // DO NOT write main() function
	Arrays.sort(S);
	ArrayList<ArrayList<Integer>> ans=new ArrayList<ArrayList<Integer>>();
	ArrayList<Integer> temp=new ArrayList<Integer> ();
	solve(ans,0,temp,S);
        return ans;
    }

}
