package main2;

public class Search_a_2D_Matrix {
    
    public boolean searchMatrix(int[][] matrix, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
	int m=matrix.length;
	int n=matrix[0].length;
	int l=0;int r=m*n-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            int i=mid/n;
            int j=mid%n;
            if(matrix[i][j]==target)
        	return true;
            else if(matrix[i][j]<target){
        	l=mid+1;
            }
            else
        	r=mid-1;
        }
        return false;
    }

}
