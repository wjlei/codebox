package main;

public class First_Missing_Positive {
 static   void swap(int num[],int a,int b){
	int temp=num[a];
	num[a]=num[b];
	num[b]=temp;
    }
    public static  int firstMissingPositive(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
	for(int i=0;i<A.length;i++){
	    while(A[i]>0&&A[i]!=i+1){
		if(A[i]-1<A.length){
		    if(A[A[i]-1]==A[i])//[1,1]
			  A[i]=-1;
		    else
		       swap(A,i,A[i]-1);
		}
		else//[4]
		    A[i]=-1;
	    }
	}
	int i=0;//[],[2],[1,2,3,4]
	for(i=0;i<A.length;i++){
	    if(A[i]!=i+1)
		return i+1;
	}
	return i+1;
        
    }
    public static void main(String args[]){
	int num[]={1,1};
	System.out.println(firstMissingPositive(num));
    }

}
