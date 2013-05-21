package main;

import java.util.ArrayList;

public class Generate_Parentheses {
	public static void makeParentheses(int left,int right,int n,String temp,ArrayList<String> ans){
		if(left==n&&right==n){
			ans.add(temp);
			return ;
		}
		if(left<=n){
			makeParentheses(left+1,right,n,temp+'(',ans);
		}
		if(right<left){
			makeParentheses(left,right+1,n,temp+')',ans);
		}
		
		
	}
	 public ArrayList<String> generateParenthesis(int n) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
		 ArrayList<String> ans=new ArrayList<String>();
		 makeParentheses(0,0,n,"",ans);
		 return ans;
		 
	        
	    }

}
