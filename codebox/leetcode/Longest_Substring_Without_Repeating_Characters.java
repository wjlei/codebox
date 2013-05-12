package main;

import java.util.HashSet;
import java.util.Set;

public class Longest_Substring_Without_Repeating_Characters {
    public int lengthOfLongestSubstring(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
	Set<Character> charstate=new HashSet<Character>();;
        int i=0;
        int j=0;
        int max=0;
        for(j=0;j<s.length();j++){
            if(charstate.contains(s.charAt(j))){
        	max=Math.max(max, j-i);
        	while(true){
        	    if(s.charAt(i)==s.charAt(j)){
        		i++;
        		break;
        	    }
        	    charstate.remove(s.charAt(i));
        	    i++;
        	}
            }
            else
        	charstate.add(s.charAt(j));
        }
        max=Math.max(max, j-i);//!! end refresh
        return max;
    }

}
