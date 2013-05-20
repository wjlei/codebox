package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class the3Sum_Closest {
    public static  int threeSumClosest(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	int ans=Integer.MAX_VALUE-10000;//overflow max
    	Arrays.sort(num);
    	for(int i=0;i<num.length;i++){
    		int l=i+1;
    		int r=num.length-1;
    		while(l<r){//not ==
    			if(num[i]+num[l]+num[r]<target){
    				int temp=num[i]+num[l]+num[r];
    				if(Math.abs(temp-target)<Math.abs(ans-target))
    					ans=temp;
    				l++;
    			}
    			else if(num[i]+num[l]+num[r]>target){
    				int temp=num[i]+num[l]+num[r];
    				if(Math.abs(temp-target)<Math.abs(ans-target))
    					ans=temp;
    				r--;
    			}
    			else if(num[i]+num[l]+num[r]==target){
    				int temp=num[i]+num[l]+num[r];
    				if(Math.abs(temp-target)<Math.abs(ans-target))
    					ans=temp;
    				l++;
    				
    			}
    		}
    	}
    	return ans;
    }
    public static void main(String args[]){
    	int s[]={1,1,-1,-1,3};
    	System.out.print(threeSumClosest(s,-1));
    }

}
