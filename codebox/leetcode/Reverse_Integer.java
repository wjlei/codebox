package main;

public class Reverse_Integer {
	 public int reverse(int x) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
		 boolean minus=false;
		 if(x<0){
			 minus=true;
			 x=-x;
		 }
		 int ans=0;
		 while(x!=0){
			 int n=x%10;
			 ans=ans*10+n;
			 x=x/10;
		 }
		 if(minus)
			 ans=-ans;
		 return ans;
	        
	    }

}
