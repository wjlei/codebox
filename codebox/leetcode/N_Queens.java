package main;

import java.util.ArrayList;
import java.util.Arrays;

public class N_Queens {
    static boolean check(int state[],int index,int line,int n){
	for(int i=0;i<n;i++){
	    if(state[i]!=-1&&Math.abs(state[i]-line)==Math.abs(i-index))
		return false;
	}
	return true;
    }
    public static void solve(ArrayList<int[]> ans,int state[],int n,int line){
	if(line==n){
	   
	    ans.add(state.clone());
	    return ;
	}
	
	for(int i=0;i<n;i++){
	    if(state[i]==-1&&check(state,i,line,n)){
		state[i]=line;
		solve(ans,state,n,line+1);
		state[i]=-1;
	    }
	}
	
    }
    
    
    public static ArrayList<String[]> solveNQueens(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int state[]=new int[n];
        Arrays.fill(state,-1);
        ArrayList<int[]> ans=new ArrayList<int[]> ();
        solve(ans,state,n,0);
        ArrayList<String[]> finalans=new ArrayList<String[]> ();
        for(int[] itr: ans){
            String[] lines=new String[n];
            for(int i=0;i<n;i++){
        	String line="";
        	for(int j=0;j<n;j++){
        	    if(j==itr[i])
        		line+="Q";
        	    else
        		line+=".";
        	}
        	lines[i]=line;
            }
            finalans.add(lines);
        }
        return finalans;
    }
    public static void main(String args[]){
	System.out.println(solveNQueens(4));
	
    }

}
