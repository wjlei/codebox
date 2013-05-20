package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class the4Sum {
    public static ArrayList<ArrayList<Integer>>  fourSum(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	Set<ArrayList<Integer>> ans=new HashSet<ArrayList<Integer>>();
    	ArrayList<ArrayList<Integer>> ans1=new ArrayList<ArrayList<Integer>>();
    	Arrays.sort(num);
		for (int h = 0; h < num.length; h++) {
			for (int i = h + 1; i < num.length; i++) {
				int l = i + 1;
				int r = num.length - 1;
				ArrayList<Integer> temp = new ArrayList<Integer>();
				while (l < r) {// not ==
					if (num[h]+num[i] + num[l] + num[r] < target)
						l++;
					else if (num[h]+num[i] + num[l] + num[r] > target)
						r--;
					else if (num[h]+num[i] + num[l] + num[r] == target) {
						temp.add(num[h]);
						temp.add(num[i]);
						temp.add(num[l]);
						temp.add(num[r]);
						ans.add(temp);
						l++;
						temp = new ArrayList<Integer>();
					}
				}
			}
		}
    	for(ArrayList<Integer> itr:ans){
    		ans1.add(itr);
    	}
    	return ans1;
    }
    public static void main(String args[]){
    	int s[]={1,0,-1,0,-2,2};
    	System.out.print(fourSum(s,0));
    }

}
