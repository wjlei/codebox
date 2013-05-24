package main;

import java.util.Arrays;
import java.util.Stack;

public class Longest_Valid_Parentheses {
	 public int longestValidParentheses(String s) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	     Stack<Integer> stk =new  Stack<Integer>();
	     int state[]=new int[s.length()];
	     Arrays.fill(state, 0);
	     for(int i=0;i<s.length();i++){
	    	 if(s.charAt(i)=='('){
	    		 stk.push(i);
	    	 }
	    	 else{
	    		 if(stk.size()>0){
	    			 state[stk.pop()]=1;
	    			 state[i]=1;
	    		 }
	    	 }
	     }
	     int max=0;
	     int tmax=0;
	     for(int i=0;i<s.length();i++){
	    	 if(state[i]==1){
	    		 tmax++;
	    	 }
	    	 else{
	    		 max=Math.max(max, tmax);
	    		 tmax=0;
	    	 }
	    	 
	     }
	     max=Math.max(max, tmax);
	     return max;
		 
		 
	  }

}
