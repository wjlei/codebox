package main3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Longest_Consecutive_Sequence {
    static public int longestConsecutive(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
	Set<Integer> table=new HashSet<Integer>();
	for(int i=0;i<num.length;i++)
	    table.add(num[i]);
	int len=0;
	for(int i:num){
	    if(table.contains(i)){
		int templen=0;
		for(int j=i;table.contains(j);j++){
		    templen++;
		    table.remove(j);
		}
		for(int j=i-1;table.contains(j);j--){
		    templen++;
		    table.remove(j);
		}
		len=Math.max(templen, len);
	    }
	}
        return len;
    }
    static public void main(String args[]){

	int num[]={100, 4, 200, 1, 3, 2};
	
	System.out.println(longestConsecutive(num));
    }

}
