package main;

public class Palindrome_Number {
	public static boolean isPalindrome(int x) {
		if(x<0)
			return false;
		long  left=1;
		while(x/left>0)
			left*=10;
		left/=10;
		while(x!=0&&x%10==x/left){
			x-=x/left*left;
			left/=100;
			x=x/10;
		}
		if(x==0)
			return true;
		else
			return false;
		
	}
	public static void main(String args[]){
		int num=2147447412;
		System.out.println(isPalindrome(num));
		
	}

}
