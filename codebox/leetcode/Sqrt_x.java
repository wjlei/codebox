package main2;

public class Sqrt_x {
    public int sqrt(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
	long l=0;long r=x;
	while(l<=r){
	    long mid=(l+r)/2;
	    if(mid*mid==x)
		return (int)mid;
	    else if(mid*mid<x)
		l=mid+1;
	    else 
		r=mid-1;
	}
	return (int)l-1;
        
    }

}
