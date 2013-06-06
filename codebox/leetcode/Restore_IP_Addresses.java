package main2;

import java.util.ArrayList;

public class Restore_IP_Addresses {
    public static ArrayList<String> restoreIpAddresses(String s) {
	// Start typing your Java solution below
	// DO NOT write main() function
	ArrayList<String> ans = new ArrayList<String>();
	int n = s.length();
	for (int i = 1; i < n; i++) {
	    for (int j = i + 1; j < n; j++) {
		for (int k = j + 1; k < n; k++) {
		    int num1, num2, num3, num4;
		    if (i > 3||(i>1&&s.charAt(0)=='0'))
			continue;
		    num1 = Integer.parseInt(s.substring(0, i));
		    if (j-i > 3||(j-i>1&&s.charAt(i)=='0'))
			continue;
		    num2 = Integer.parseInt(s.substring(i, j));
		    if (k-j > 3||(k-j>1&&s.charAt(j)=='0'))
			continue;
		    num3 = Integer.parseInt(s.substring(j, k));
		    if (n-k > 3||n-k>1&&s.charAt(k)=='0')
			continue;
		    num4 = Integer.parseInt(s.substring(k, n));
		    if (num1 <= 255 && num2 <= 255 && num3 <= 255
			    && num4 <= 255) {
			String temp = s.substring(0, i) + ".";
			temp += s.substring(i, j ) + ".";
			temp += s.substring(j, k) + ".";
			temp += s.substring(k, n);
			ans.add(temp);
		    }
		}
	    }
	}
	return ans;

    }

    public static void main(String args[]) {
	System.out.print(restoreIpAddresses("255255255255"));
    }

}
