package main2;

public class Plus_One {
    public int[] plusOne(int[] digits) {
        // Start typing your Java solution below
        // DO NOT write main() function
	int c=0;
	digits[digits.length-1]++;
	for(int i=digits.length-1;i>=0;i--){
	    int num=digits[i]+c;
	    c=num/10;
	    num=num%10;
	    digits[i]=num;
	}
	if(c>0){
	    int ans[]=new int[digits.length+1];
	    ans[0]=c;
	    for(int i=0;i<digits.length;i++)
		ans[i+1]=digits[i];
	    return ans;
	    
	}
	else
	    return digits;
        
    }

}
