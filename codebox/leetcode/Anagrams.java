package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Anagrams {
    public ArrayList<String> anagrams(String[] strs) {
        // Start typing your Java solution below
        // DO NOT write main() function
	ArrayList<String> ans=new ArrayList<String>();
	Map<String,ArrayList<Integer>> table =new HashMap<String,ArrayList<Integer>>();
        for(int i=0;i<strs.length;i++){
           char temp[]=strs[i].toCharArray();
           Arrays.sort(temp);
           String sortedword=new String(temp);
           ArrayList<Integer> value=table.get(sortedword);
           if(value==null){
               value=new ArrayList<Integer>();
               value.add(i);
               table.put(sortedword, value);
           }
           else{
               value.add(i);
               table.put(sortedword, value);
           }
        }
        for(Map.Entry<String,ArrayList<Integer>> itr:table.entrySet()){
            ArrayList<Integer> value=itr.getValue();
            if(value.size()>1){
        	for(Integer i:value){
        	    ans.add(strs[i]);
        	}
            }
        }
        return ans;
    }

}
