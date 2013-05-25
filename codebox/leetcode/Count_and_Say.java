package main;

import java.util.Arrays;

public class Count_and_Say {
    public static String countAndSay(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
	String ans="1";
	//int count[]=new int[20];
	for(int i=1;i<n;i++){
	    String temp="";
	    char character=ans.charAt(0);
	    int count=1;
	    for(int j=1;j<ans.length();j++){
		if(character==ans.charAt(j)){
		    count++;
		}
		else{
		    temp+=(char)(count+'0');
		    temp+=character;
		    character=ans.charAt(j);
		    count=1;
		}
	    }
	    temp+=(char)(count+'0');//finish
	    temp+=character;
	    ans=temp;
	}
	return ans;
        
    }
    public static void main(String args[]){
	System.out.println(countAndSay(3));
    }

}
