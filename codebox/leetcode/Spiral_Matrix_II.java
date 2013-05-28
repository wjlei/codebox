package main2;

import java.util.ArrayList;

public class Spiral_Matrix_II {
    public static int[][] generateMatrix(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
	int ans[][] = new int[n][n];
	if(n<=0)
	    return ans;
	int dr[][] = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	int table[][] = new int[n + 2][n + 2];
	for (int i = 0; i <n + 2; i++) {
	    table[0][i]=Integer.MIN_VALUE;
	    table[n+ 1][i]=Integer.MIN_VALUE;
	}
	for (int i = 0; i < n + 2; i++) {
	    table[i][0]=Integer.MIN_VALUE;
	    table[i][n + 1]=Integer.MIN_VALUE;
	}
	for(int i=0;i<n;i++){
	    for(int j=0;j<n;j++){
		table[i+1][j+1]=0;
	    }
	}
	int count=1;
	int i = 1;int j = 1;int d = 0;
	while(true){
	    if(table[i][j]==0){
		table[i][j]=count++;
	    }
	    if(table[i][j+1]!=0&&table[i+1][j]!=0&&table[i][j-1]!=0&&table[i-1][j]!=0)
		break;
	    if(table[i+dr[d][0]][j+dr[d][1]]==0){
		i+=dr[d][0];
		j+=dr[d][1];
	    }
	    else{
		d=(d+1)%4;
	    }
	    
	}
	for(int l=0;l<n;l++){
	    for(int k=0;k<n;k++){
		ans[l][k]=table[l+1][k+1];
	    }
	}
	return ans;
    }
    public static void main(String args[]) {
   	System.out.print(generateMatrix(3));

       }

}
