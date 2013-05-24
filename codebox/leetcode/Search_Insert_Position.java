package main;

public class Search_Insert_Position {
	 public int searchInsert(int[] A, int target) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
			int l=0;int r=A.length-1;
	    	boolean isfind=false;
	    	while(l<=r){
	    		int mid=(l+r)/2;
	    		if(A[mid]==target)
	    			return mid;
	    		else if(A[mid]<target){
	    			l=mid+1;
	    		}
	    		else{
	    			r=mid-1;
	    		}
	    	}
	    	return l;
	        
	    }

}
