package main;

public class Remove_Duplicates_from_Sorted_Array {
	   public int removeDuplicates(int[] A) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
		   if(A.length<1)
			   return 0;
		   int j=0;
		   for(int i=1;i<A.length;i++){
			   if(A[i]!=A[j]){
				   A[++j]=A[i];
			   }
		   }
		   return j+1;
	        
	    }

}
