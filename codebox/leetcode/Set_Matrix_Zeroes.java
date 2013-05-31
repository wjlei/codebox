package main2;

public class Set_Matrix_Zeroes {
    public void setZeroes(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
	boolean lmark=false;
	boolean rmark=false;
	int m=matrix.length;
	int n=matrix[0].length;
	for(int i=0;i<n;i++){
	    if(matrix[0][i]==0)
		lmark=true;
	}
	for(int i=0;i<m;i++){
	    if(matrix[i][0]==0)
		rmark=true;
	}
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
        	if(matrix[i][j]==0){
        	    matrix[i][0]=0;
        	    matrix[0][j]=0;
        	}
            }
        }
	for(int i=1;i<n;i++){
	    if(matrix[0][i]==0){
		for(int j=0;j<m;j++)
		    matrix[j][i]=0;
	    }
	}
	for(int i=1;i<m;i++){
	    if(matrix[i][0]==0){
		for(int j=0;j<n;j++)
		    matrix[i][j]=0;
	    }
	}
	if (lmark) {
	    for (int j = 0; j < n; j++)
		matrix[0][j] = 0;

	}
	if (rmark) {
	    for (int j = 0; j < m; j++)
		matrix[j][0] = 0;

	}
    }


}
