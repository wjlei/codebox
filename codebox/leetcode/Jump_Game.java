package main1;

public class Jump_Game {
    public boolean canJump(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	if(A.length<=1)//greedy is good;
    		return true;
    	int i=0;
    	int step=1;
    	int right=i+A[i];
    	while(right<A.length-1){
    		int index=i;
    		boolean update=false;
    		for(int j=i+1;j<=i+A[i];j++){
    			if(j+A[j]>right){
    				update=true;
    				index=j;
    				right=j+A[j];
    			}
    		}
    		if(!update)
    			break;
    		i=index;
    		step++;
    	}
    	
    	return right==A.length-1;
        
    }

}
