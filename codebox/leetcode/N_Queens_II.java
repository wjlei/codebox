package main;

import java.util.ArrayList;
import java.util.Arrays;

public class N_Queens_II {
    static boolean check(int state[],int index,int line,int n){
 	for(int i=0;i<n;i++){
 	    if(state[i]!=-1&&Math.abs(state[i]-line)==Math.abs(i-index))
 		return false;
 	}
 	return true;
     }
     public static void solve(int state[],int n,int line){
 	if(line==n){
 	   
 	   count++;
 	    return ;
 	}
 	
 	for(int i=0;i<n;i++){
 	    if(state[i]==-1&&check(state,i,line,n)){
 		state[i]=line;
 		solve(state,n,line+1);
 		state[i]=-1;
 	    }
 	}
 	
     }
     
     static int count;
     public int totalNQueens(int n) {
         // Start typing your Java solution below
         // DO NOT write main() function
         int state[]=new int[n];
         Arrays.fill(state,-1);
         count=0;
         solve(state,n,0);
         return count;
        
     }

}
