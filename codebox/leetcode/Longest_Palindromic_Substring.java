package main;

import java.util.Arrays;

public class Longest_Palindromic_Substring {
    public static String longestPalindrome(String s) {
	// Start typing your Java solution below
	// DO NOT write main() function
        //cache the data already caculate
        //~i<-index->i<-right
		String ts = "$";
		int max = 0;
		int maxindex = 0;
		for (int i = 0; i < s.length(); i++) {
			ts += "#" + s.charAt(i);
		}
		ts += "#";// make abb easy to count
		int[] dp = new int[ts.length()];
		int right = 0;
		int index = 0;
		for (int i = 1; i < ts.length(); i++) {
			int j = 0;
			if (i <= right) {
                //~i<-index->i<-right
				j = Math.min(dp[2 * index - i], right-i);//must min,the letter in the right of right not same as ~i  
			}
			for (; i + j < ts.length() && ts.charAt(i-j) == ts.charAt(i+j); j++)
				;
			if (i + j - 1 > right) {
				right = i + j - 1;
				index = i;
			}
			dp[i] = j - 1;
			if (dp[i] > max) {
				max = dp[i];
				maxindex = i;
			}
		}
		String ans1 = ts.substring(maxindex - max, maxindex+max+1);
		String ans = "";
		for (int i = 0; i < ans1.length(); i++) {
			if (ans1.charAt(i) != '#')
				ans += ans1.charAt(i);
		}
		return ans;

    }

    public static void main(String args[]) {
	System.out.println(longestPalindrome("abb"));
    }

}
