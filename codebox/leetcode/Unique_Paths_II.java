package main2;

import java.util.Arrays;

public class Unique_Paths_II {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // Start typing your Java solution below
        // DO NOT write main() function
	int m=obstacleGrid.length;
	int n=obstacleGrid[0].length;
	int table[][]=new int[m][n];
        for(int i=0;i<m;i++)
            Arrays.fill(table[i], 0);
        if(obstacleGrid[0][0]==0)//may be stark is block
         table[0][0]=1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
        	if(obstacleGrid[i][j]==1)
        	    continue;
        	if(i+1<m&&obstacleGrid[i+1][j]==0){//may be end is block
        	    table[i+1][j]+=table[i][j];
        	}
        	if(j+1<n&&obstacleGrid[i][j+1]==0)//may be end is block
        	    table[i][j+1]+=table[i][j];
            }
        }
        return table[m-1][n-1];
        
    }
    
}
