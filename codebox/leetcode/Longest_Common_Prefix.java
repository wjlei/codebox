package main;

public class Longest_Common_Prefix {
	public static String longestCommonPrefix(String[] strs) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (strs.length <= 0)
			return "";
		String common = strs[0];
		for (int i = 1; i < strs.length; i++) {
			String temp = "";
			for (int j = 0; j < Math.min(common.length(), strs[i].length()); j++) {
				
				if (common.charAt(j) == strs[i].charAt(j))
					temp += common.charAt(j);
				else{
					break;
				}
			}
			common=temp;
			
		}
		return common;

	}
	public static void main(String args[]) {
		String strs[]={"ab","ac"};
		System.out.println(longestCommonPrefix(strs));
	}
}
