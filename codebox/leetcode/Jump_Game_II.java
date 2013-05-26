package main1;

import java.util.Arrays;

public class Jump_Game_II {
    public static  int jump(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	if(A.length<=1)//greedy is good;
    		return 0;
    	int i=0;
    	int step=1;
    	int right=i+A[i];
    	while(right<A.length-1){
    		int index=i;
    		for(int j=i+1;j<=i+A[i];j++){
    			if(j+A[j]>right){
    				index=j;
    				right=j+A[j];
    			}
    		}
    		i=index;
    		step++;
    	}
    	
    	return step;
        
    }
    
    public static void main(String args[]){
    	int num[]={0};
    	System.out.println(jump(num));
    }
}
