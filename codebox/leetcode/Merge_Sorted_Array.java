package main2;

public class Merge_Sorted_Array {
    public void merge(int A[], int m, int B[], int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
	int j=m-1;
	int k=n-1;
	for(int i=m+n-1;i>=0;i--){
	    if(k>=0&&j>=0&&B[k]>A[j]){
		A[i]=B[k];
		k--;
	    }
	    else if(k>=0&&j>=0&&B[k]<=A[j]){
		A[i]=A[j];
		j--;
	    }
	    else if(k>=0){
		A[i]=B[k];
		k--;
	    }
	    else if(j>=0){
		A[i]=A[j];
		j--;
	    }
	}
        
    }

}
