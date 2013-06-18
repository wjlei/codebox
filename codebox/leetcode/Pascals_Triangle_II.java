package main3;

import java.util.ArrayList;

public class Pascals_Triangle_II {
    public ArrayList<Integer> getRow(int rowIndex) {
        // Start typing your Java solution below
        // DO NOT write main() function
	ArrayList<Integer> pre=new ArrayList<Integer>();
	for(int i=0;i<=rowIndex;i++){
	    ArrayList<Integer> cur=new ArrayList<Integer>();
	    int p=0;
	    for(int val:pre){
		cur.add(val+p);
		p=val;
	    }
	    cur.add(1);
	    pre=cur;
	}
	return pre;
        
    }

}
