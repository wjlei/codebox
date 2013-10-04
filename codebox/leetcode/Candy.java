package main;

public class Candy {
    public int candy(int[] ratings) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int n=ratings.length;
        if(n==0)
        	return 0;
        int counts[]=new int[n];
        counts[0]=1;
        for(int i=1;i<n;i++){
        	if(ratings[i]>ratings[i-1]){
        		counts[i]=counts[i-1]+1;
        	}
        	else{
        		counts[i]=1;
        	}
        }
        for(int i=n-2;i>=0;i--){
        	if(ratings[i]>ratings[i+1]){
        		counts[i]=Math.max(counts[i], counts[i+1]+1);
        	}
        }
        int ans=0;
        for(int i=0;i<n;i++){
        	ans+=counts[i];
        }
        return ans;
    }

}
