package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class the4Sum {
    static class pair{
		pair(int _i,int _j){
			i=_i;
			j=_j;
		}
		int i;
		int j;
	}
	static class node{
		node(int _value,int i,int j){
			value=_value;
			ij=new pair(i,j);
		}
		int value;
		pair ij;
	}
    public static ArrayList<ArrayList<Integer>>  fourSum(int[] num, int target) {
        Set<ArrayList<Integer>> ans=new HashSet<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
        ArrayList<node> twosum=new ArrayList<node>();
        Map<Integer,ArrayList<pair>> twoset=new HashMap<Integer,ArrayList<pair>>();
        int n=num.length;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(i!=j){
                    twosum.add(new node(num[i]+num[j],i,j));
                    if(twoset.get(num[i]+num[j])!=null){
                        ArrayList<pair> temp=twoset.get(num[i]+num[j]);
                        temp.add(new pair(i,j));
                        twoset.put(num[i]+num[j], temp);
                    }
                    else{
                        ArrayList<pair> temp=new ArrayList<pair>();
                        temp.add(new pair(i,j));
                        twoset.put(num[i]+num[j], temp);
                    }
                }
            }
        }
        for(node itr:twosum){
            if(twoset.get(target-itr.value)!=null){
                ArrayList<pair> temp=twoset.get(target-itr.value);
                for(pair pitr:temp){
                    if(pitr.i!=itr.ij.i&&pitr.j!=itr.ij.j&&pitr.i!=itr.ij.j&&pitr.j!=itr.ij.i){
                        ArrayList<Integer> anstemp=new ArrayList<Integer>();
                        anstemp.add(num[itr.ij.i]);
                        anstemp.add(num[itr.ij.j]);
                        anstemp.add(num[pitr.i]);
                        anstemp.add(num[pitr.j]);
                        Collections.sort(anstemp);
                        ans.add(anstemp);
                    }
                }
            }
        }
        for(ArrayList<Integer> itr:ans){
            res.add(itr);
        }
        return res;
    }
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
