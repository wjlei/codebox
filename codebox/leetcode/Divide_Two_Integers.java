package main;

public class Divide_Two_Integers {
	public static int divide(int dividend, int divisor) {
		// Start typing your Java solution below
		// DO NOT write main() function
		long ans = 0;
		boolean flag=false;
		if(dividend<0&&divisor>0||dividend>0&&divisor<0){
			flag=true;			
		}
		long ldividend=dividend;//change->long int make -int will error
		ldividend=ldividend<0?-ldividend:ldividend;
		long ldivisor=divisor;
		ldivisor=ldivisor<0?-ldivisor:ldivisor;
		while (ldividend >= ldivisor) {
			long temp = 1;
			while (temp * ldivisor*2 <=ldividend) {
				temp = temp * 2;
			}
			ans += temp;
			ldividend-=temp * ldivisor;
		}
		if(flag)
			ans=-ans;
		return (int)ans;

	}
	 public static void main(String args[]){
	    	//String needle="abaabcabaabda";
	    	//String needle="abaabcaba";
	    	System.out.println(divide(-2147483648, -2147483648));
	    	
	    }

}
