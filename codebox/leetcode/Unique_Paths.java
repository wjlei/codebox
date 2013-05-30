package main2;

import java.util.Arrays;

public class Unique_Paths {
    public static int uniquePaths(int m, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
	int table[][]=new int[m][n];
        for(int i=0;i<m;i++)
            Arrays.fill(table[i], 0);
        table[0][0]=1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
        	if(i+1<m)
        	    table[i+1][j]+=table[i][j];
        	if(j+1<n)
        	    table[i][j+1]+=table[i][j];
            }
        }
        return table[m-1][n-1];
    }
    public static void main(String args[]){
   	for(int i=1;i<=6*4;i++){
   	    System.out.println(uniquePaths(1,2));
   	}
   	
       }
}
