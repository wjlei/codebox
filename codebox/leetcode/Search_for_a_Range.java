package main;

public class Search_for_a_Range {
    public static  int[] searchRange(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	int ans[]=new int[2];
    	int l=0;int r=A.length-1;
    	boolean isfind=false;
    	while(l<=r){
    		int mid=(l+r)/2;
    		if(A[mid]<target){
    			l=mid+1;
    		}
    		else{
    			r=mid-1;
    			if(A[mid]==target)
    			  isfind=true;
    		}
    	}
    	if(isfind)
    	   ans[0]=r+1;
    	else
    		ans[0]=-1;
    	l=0;r=A.length-1;isfind=false;
    	while(l<=r){
    		int mid=(l+r)/2;
    		if(A[mid]<=target){
    			l=mid+1;
    			if(A[mid]==target)
      			  isfind=true;
    		}
    		else
    			r=mid-1;
    	}
    	l=l-1;
    	if(isfind)
    	   ans[1]=l;
    	else
    		ans[1]=-1;
    	
    	return ans;
        
    }
    public static void main(String args[]){
    	int num[]={5, 7, 7, 8, 8, 10};
    	int ans[]=searchRange(num,5);
    	System.out.println(ans[0]);
    	System.out.println(ans[1]);
    	
    }

}
