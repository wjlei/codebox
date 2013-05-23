package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Substring_with_Concatenation_of_All_Words {
    public ArrayList<Integer> findSubstring(String S, String[] L) {
        // Start typing your Java solution below
        // DO NOT write main() function
	ArrayList<Integer> ans=new ArrayList<Integer>();
	Map<String,Integer> table=new HashMap<String,Integer>();
	int org[]= new int[L.length];
	  Arrays.fill(org, 0);
	for(int i=0;i<L.length;i++){
	    if(table.get(L[i])==null){
	      table.put(L[i],i);
	      org[i]++;
	    }
	    else{
		org[table.get(L[i])]++;
	    }
	}
	int n=L.length;
	int m=L[0].length();
	int state[]= new int[L.length];
	for(int i=0;i<=S.length()-m*n;i++){
	     Arrays.fill(state, 0);
	     int count=0;
	     for(int j=0;j<n;j++){
		String temp=S.substring(i+j*m,i+j*m+m);
		if(table.get(temp)!=null){
		    int index=table.get(temp);
		    if(state[index]<org[index]){
			state[index]++;
			count++;
		    }
		    else
			break;
		}
	     }
	     if(count==n){
		 ans.add(i);
	     }
	}
	return ans;
        
    }

}
