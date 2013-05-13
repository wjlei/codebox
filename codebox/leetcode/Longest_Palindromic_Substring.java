package main;

import java.util.Arrays;

public class Longest_Palindromic_Substring {
    public static String longestPalindrome(String s) {
	// Start typing your Java solution below
	// DO NOT write main() function
	String temp = new String();
	int countnum[] = new int[2 * s.length() + 1];
	Arrays.fill(countnum, 0);
	temp += '$';
	for (int i = 0; i < s.length() - 1; i++) {
	    temp += s.charAt(i);
	    temp += '#';
	}
	temp += s.charAt(s.length() - 1);
	int right = 1;
	int axle = 1;
	for (int i = 1; i < temp.length(); i++) {
	    int edge = Math.min(countnum[2 * axle - i], right - i);
	    while (i + edge < temp.length()
		    && temp.charAt(i - edge) == temp.charAt(i + edge))
		edge++;
	    countnum[i] = edge;
	    if (i + edge > right) {
		right = i + edge;
		axle = i;
	    }
	}
	int max = 0;
	int index = 0;
	boolean isj=false;
	for (int i = 1; i < temp.length(); i++) {
	    if (countnum[i] > max||(countnum[i] ==max&&isj==false)) {//choose #,better than num abb $a#b#b 1 1 2 2 1 maybe return b
		if(temp.charAt(i)=='#')
		    isj=true;
		else
		    isj=false;
		index = i;
		max = countnum[i];
	    }
	}
	String ans = "";
	if (temp.charAt(index) == '#') {
	    for (int i = index + 1; i < index + max; i++) {
		if (temp.charAt(i) != '#')
		    ans +=temp.charAt(i);
	    }
	    for (int i = index - 1; i > index - max; i--) {
		if (temp.charAt(i) != '#')
		    ans = temp.charAt(i) + ans;
	    }
	} else {
	    ans+=temp.charAt(index);
	    for (int i = index+2; i < index + max; i++) {
		if (temp.charAt(i) != '#')
		    ans += temp.charAt(i);
	    }
	    for (int i = index-2; i > index - max; i--) {
		if (temp.charAt(i) != '#')
		    ans = temp.charAt(i) + ans;
	    }
	}
	return ans;

    }

    public static void main(String args[]) {
	System.out.println(longestPalindrome("abb"));
    }

}
