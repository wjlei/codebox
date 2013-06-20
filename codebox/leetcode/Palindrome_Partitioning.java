package main3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Palindrome_Partitioning {
  static  boolean isp(String s){
	int i=0;
	int j=s.length()-1;
	while(i<=j){
	    if(s.charAt(i)!=s.charAt(j)){
		return false;
	    }
	    i++;j--;
	}
	return true;
    }    
  static  ArrayList<ArrayList<String>> ans;
   static int n;
   static boolean dp[][];
   static void solve(ArrayList<String> temp,int start,String s){
       if(start==n){
	   ans.add(temp);
	   return ;
       }
       for(int j=start;j<n;j++){
	   if(dp[start][j]){
	       ArrayList<String> c=(ArrayList<String>) temp.clone();
	       c.add(s.substring(start,j+1));
	       solve(c,j+1,s);
	   }
       }
       
   }
   static public ArrayList<ArrayList<String>> partition(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
	n=s.length();
	dp=new boolean[n][n];
	ans=new ArrayList<ArrayList<String>>();
	for(int i=0;i<n;i++){
	    for(int j=i;j<n;j++){
		dp[i][j]=isp(s.substring(i,j+1));
	    }
	}
	solve(new ArrayList<String>(),0,s);
        return ans;
    }
    static public void main(String args[]){

	String ss="aab";
	
	System.out.println(partition(ss));
    }

}
