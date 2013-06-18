package main3;

import java.util.ArrayList;

public class Pascals_Triangle {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        // Start typing your Java solution below
        // DO NOT write main() function
	ArrayList<ArrayList<Integer>> ans=new ArrayList<ArrayList<Integer>>();
	ArrayList<Integer> pre=new ArrayList<Integer>();
	for(int i=0;i<numRows;i++){
	    ArrayList<Integer> cur=new ArrayList<Integer>();
	    int p=0;
	    for(int val:pre){
		cur.add(val+p);
		p=val;
	    }
	    cur.add(1);
	    ans.add(cur);
	    pre=cur;
	}
	return ans;
        
    }

}
