package main1;

public class Best_Time_to_Buy_and_Sell_Stock_II {
    public static int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	int ans=0;
    	boolean get=false;
    	int getprice=0;
    	for(int i=0;i<prices.length-1;i++){
    		if(get==false&&prices[i]<=prices[i+1]){
    			get=true;
    			getprice=prices[i];
    		}
    		else if(get==true&&prices[i]>prices[i+1]){
    			get=false;
    			ans+=prices[i]-getprice;
    		}
    	}
    	if(get){
    		ans+=prices[prices.length-1]-getprice;
    	}
    	return ans;
        
    }
    public static void main(String args[]){
    	int num[]={2,1};
    	System.out.println(maxProfit(num));
    }

}
