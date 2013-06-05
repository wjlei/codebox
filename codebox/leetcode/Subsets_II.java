package main2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Subsets_II {
    void solve(Set<ArrayList<Integer>> ans,int i,ArrayList<Integer> temp,int[] S){
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
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
	Arrays.sort(num);
	Set<ArrayList<Integer>> ans=new HashSet<ArrayList<Integer>>();
	ArrayList<Integer> temp=new ArrayList<Integer> ();
	solve(ans,0,temp,num);
	ArrayList<ArrayList<Integer>> trans=new ArrayList<ArrayList<Integer>>();
	for(ArrayList<Integer> itr:ans){
	    trans.add(itr);
	}
        return trans;
        
    }

}
