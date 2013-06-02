package main2;

public class Remove_Duplicates_from_Sorted_Array_II {
    public static  int removeDuplicates(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
	if(A.length==0)
	    return 0;
     int j=0;
     int count=1;
     for(int i=1;i<A.length;i++){
	 if(A[i]==A[j]&&count<2){
	     int temp=A[i];
	     A[i]=A[j+1];
	     A[j+1]=temp;
	     j++;
	     count++;
	 }
	 else if(A[i]!=A[j]){
	     int temp=A[i];
	     A[i]=A[j+1];
	     A[j+1]=temp;
	     j++;
	     count=1;
	 }
     }
     return j+1;
    }
    public static void main(String args[]){
	int num[]={1,1,1,2,2,3};
	System.out.print(removeDuplicates(num));
    }
}
