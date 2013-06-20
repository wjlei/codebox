package main3;

import java.util.ArrayList;

public class Palindrome_Partitioning_II {


    static public int minCut(String s) {
	// Start typing your Java solution below
	// DO NOT write main() function
	int n = s.length();
	boolean dp[][] = new boolean[n][n];
	int line[]=new int[n+1];
	for(int i=0;i<=n;i++){
	    line[i]=n-i;
	}
	for (int i = n-1; i >= 0; i--) {
	    for(int j=i;j<n;j++){
		if(s.charAt(i)==s.charAt(j)&&(j-i<2||dp[i+1][j-1])){//when update dp state up line
		     dp[i][j]=true;
		     line[i]=Math.min(line[i], line[j+1]+1);
		}
	    }
	}
	return line[0]-1;

    }

    static public void main(String args[]) {
	System.out.println(minCut("aab"));
    }

}
