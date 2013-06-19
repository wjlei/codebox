package main3;

public class Best_Time_to_Buy_and_Sell_Stock_III {
   static public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
	int a[]=new int[prices.length];
	int b[]=new int[prices.length];
	int dp[]=new int[prices.length+1];
	int max=0;
    	int min=Integer.MAX_VALUE;
    	for(int i=0;i<prices.length;i++){
		min=Math.min(min, prices[i]);
		max=Math.max(max, prices[i]-min);
		a[i]=max;
	}
	max=0;
    	int high=0;
    	for(int i=prices.length-1;i>=0;i--){
		high=Math.max(high, prices[i]);
		max=Math.max(max, high-prices[i]);
		b[i]=max;
	}
    	for(int i=0;i<=prices.length;i++){
             dp[i]=(i>0?a[i-1]:0)+(i<prices.length?b[i]:0);
	}
    	max=0;
    	for(int i=0;i<=prices.length;i++){
            max=Math.max(dp[i], max);
	}
    	return max;
    }
    static public void main(String args[]){

	int num[]={2,1,4,5,2,9,7};
	
	System.out.println(maxProfit(num));
    }

}
