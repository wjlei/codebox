package main3;

import java.util.ArrayList;

public class Triangle {
 static   public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        // Start typing your Java solution below
        // DO NOT write main() function
	ArrayList<Integer> pre=new  ArrayList<Integer>();
	pre.add(0);
	for(ArrayList<Integer> itr: triangle){
	    int p=Integer.MAX_VALUE;
	    ArrayList<Integer> cur=new  ArrayList<Integer>();
	    for(int i=0;i<itr.size();i++){
		int num=itr.get(i)+pre.get(i);
		cur.add(Math.min(num, p));
		p=num;
	    }
	    pre=cur;
	    pre.add(p);
	}
	int min=Integer.MAX_VALUE;
	for(int i:pre){
	    min=Math.min(min, i);
	}
	return min;
        
    }
    static public void main(String args[]){
	ArrayList<ArrayList<Integer>> triangle=new ArrayList<ArrayList<Integer>>();
	ArrayList<Integer> j=new ArrayList<Integer>();
	j.add(1);
	triangle.add(j);
	j=new ArrayList<Integer>();
	j.add(2);j.add(3);
	triangle.add(j);
	
	System.out.println(minimumTotal(triangle));
    }
}
