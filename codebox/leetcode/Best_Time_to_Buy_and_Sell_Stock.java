package main1;

public class Best_Time_to_Buy_and_Sell_Stock {
    public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	int max=0;
    	int min=Integer.MAX_VALUE;
    	for(int i=0;i<prices.length;i++){
    		min=Math.min(min, prices[i]);
    		max=Math.max(max, prices[i]-min);
    	}
    	return max;
        
    }

}
