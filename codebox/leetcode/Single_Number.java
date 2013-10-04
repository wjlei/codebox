package main;

public class Single_Number {
    public int singleNumber(int[] A) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
    	int n=A.length;
    	int ans=0;
    	for(int i=0;i<n;i++)
    		ans^=A[i];
    	return ans;
        
    }

}
