package main2;

import java.util.ArrayList;

public class Gray_Code {
   static void solve(int n,int i,ArrayList<Integer> ans,char num[]){
	if(i==n){
	    String temp=new String(num);
	    ans.add(Integer.parseInt(temp,2));
	    return ;
	}
	solve(n,i+1,ans,num);
	if(num[i]=='1'){
	    num[i]='0';
	    solve(n,i+1,ans,num);
	}
	else{
	    num[i]='1';
	    solve(n,i+1,ans,num);
	}
    }
    public static ArrayList<Integer> grayCode(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
	ArrayList<Integer> ans=new ArrayList<Integer>();
	if(n==0){
	    ans.add(0);
	    return ans;}
        char num[]=new char[n];
        for(int i=0;i<n;i++)
            num[i]='0';
        
        solve(n,0,ans,num);
        return ans;
    }
    public static void main(String args[]) {
   	System.out.print(grayCode(2) );
        }

}
