package main;

public class Rotate_Image {

    public static void rotate(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
	int n=matrix.length;
	for(int p=0;p<n/2;p++){
	    int l=p,r=n-1-p;
	    for(int i=0;i+p<n-1-p;i++){//take four points,make +i
		int temp=matrix[p][p+i];
		matrix[p][p+i]=matrix[n-1-p-i][p];
		matrix[n-1-p-i][p]=matrix[n-1-p][n-1-p-i];
		matrix[n-1-p][n-1-p-i]=matrix[p+i][n-1-p];
		matrix[p+i][n-1-p]=temp;
		
	    }
	}
    }
    public static void main(String args[]){
	int matrix[][]={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
	rotate(matrix);
	System.out.print("1");
    }
}
