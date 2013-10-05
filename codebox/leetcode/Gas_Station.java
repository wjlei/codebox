package main;

public class Gas_Station {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
    	int n=gas.length;
    	int leftgas=0;
    	int count=0;
    	int i=0;
    	int begin=0;
    	while(count<n){
    		if(leftgas+gas[i]-cost[i]>=0){
    			leftgas=leftgas+gas[i]-cost[i];
    			i=(i+1)%n;
    		}
    		else{
    			begin=(begin+n-1)%n;
    			leftgas=leftgas+gas[begin]-cost[begin];
    		}
    		count++;
    	}
    	if(leftgas<0)
    		return -1;
    	return begin;
        
    }
    public static void main(String args[]){
    	int gas[]={1,2};
    	int cost[]={2,1};
    	System.out.print( canCompleteCircuit(gas, cost));
    }

}
