package main1;

public class Length_of_Last_Word {
    public int lengthOfLastWord(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	
    	String ans[]=s.split(" ");
    	if(ans.length<=0)
    		return 0;
    	return ans[ans.length-1].length();
        
    }

}
