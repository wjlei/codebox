package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Letter_Combinations_of_a_Phone_Number {
	public static void liststring(ArrayList<String> ans,Map<Character, String> keymap,int n,String temp,String digits){
		if(n>=digits.length()){
			ans.add(temp);
			return ;
		}
		String getmap=keymap.get(digits.charAt(n));
		for(int i=0;i<getmap.length();i++){
			liststring(ans,keymap,n+1,temp+getmap.charAt(i),digits);
		}
	}
	 public ArrayList<String> letterCombinations(String digits) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
		   Map<Character,String> keymap = new HashMap<Character,String>();
		   keymap.put('1', "");
		   keymap.put('2', "abc");
		   keymap.put('3', "def");
		   keymap.put('4', "ghi");
		   keymap.put('5', "jkl");
		   keymap.put('6', "mno");
		   keymap.put('7', "pqrs");
		   keymap.put('8', "tuv");
		   keymap.put('9', "wxyz");
		   keymap.put('0', " ");
		   ArrayList<String> ans=new ArrayList<String>();
		   liststring(ans,keymap,0,"",digits);
		   return ans;
		   
	        
	    }

}
