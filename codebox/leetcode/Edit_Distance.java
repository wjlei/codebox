package main2;

import java.util.Arrays;

public class Edit_Distance {
    public static int minDistance(String word1, String word2) {
        // Start typing your Java solution below
        // DO NOT write main() function
	int n1=word1.length()+1;
	int n2=word2.length()+1;
	int table[][]=new int[n1][n2];
	for(int i=0;i<n1;i++){
	    Arrays.fill(table[i], Integer.MAX_VALUE);
	}
	for(int i=0;i<n1;i++){
	    table[n1-1-i][n2-1]=i;
	}
	for(int i=0;i<n2;i++){
	    table[n1-1][n2-1-i]=i;
	}
	for(int i=n1-2;i>=0;i--){
	    for(int j=n2-2;j>=0;j--){
		int num1;
		if(word1.charAt(i)==word2.charAt(j))
		    num1=table[i+1][j+1];
		else
		    num1=table[i+1][j+1]+1;
		int num2=Math.min(table[i+1][j],table[i][j+1])+1;
		num2=Math.min(num1, num2);
		table[i][j]=Math.min(table[i][j], num2);
	    }
	}
	return table[0][0];
        
    }
    public static void main(String args[]){
	System.out.print(minDistance("","a"));
    }
}
