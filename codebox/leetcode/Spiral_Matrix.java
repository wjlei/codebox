package main2;

import java.util.ArrayList;

public class Spiral_Matrix {
    public static ArrayList<Integer> spiralOrder(int[][] matrix) {
	// Start typing your Java solution below
	// DO NOT write main() function
	ArrayList<Integer> ans = new ArrayList<Integer>();
	if(matrix.length<=0)
	    return ans;
	int dr[][] = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	int table[][] = new int[matrix.length + 2][matrix[0].length + 2];
	for (int i = 0; i < matrix[0].length + 2; i++) {
	    table[0][i]=Integer.MIN_VALUE;
	    table[matrix.length + 1][i]=Integer.MIN_VALUE;
	}
	for (int i = 0; i < matrix.length + 2; i++) {
	    table[i][0]=Integer.MIN_VALUE;
	    table[i][matrix[0].length + 1]=Integer.MIN_VALUE;
	}
	for(int i=0;i<matrix.length;i++){
	    for(int j=0;j<matrix[0].length;j++){
		table[i+1][j+1]=matrix[i][j];
	    }
	}
	int i = 1;int j = 1;int d = 0;
	while(true){
	    if(table[i][j]!=Integer.MIN_VALUE){
		ans.add(table[i][j]);
		table[i][j]=Integer.MIN_VALUE;
	    }
	    if(table[i][j+1]==Integer.MIN_VALUE&&table[i+1][j]==Integer.MIN_VALUE&&table[i][j-1]==Integer.MIN_VALUE&&table[i-1][j]==Integer.MIN_VALUE)
		break;
	    if(table[i+dr[d][0]][j+dr[d][1]]!=Integer.MIN_VALUE){
		i+=dr[d][0];
		j+=dr[d][1];
	    }
	    else{
		d=(d+1)%4;
	    }
	    
	}
	return ans;

    }

    public static void main(String args[]) {
	int matrix[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
	System.out.print(spiralOrder(matrix));

    }
}
