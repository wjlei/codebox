package main;

import java.util.Set;

public class Word_Break {
    public boolean wordBreak(String s, Set<String> dict) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
    	   int len=s.length();
    	    if(len<1)
    	    	return false;

    	    boolean [][]seg = new boolean[len][len];

    	    for(int seg_len = 1; seg_len <= len; ++seg_len) {
    	        for(int i = 0; i <= len-seg_len; ++i) {
    	            seg[i][seg_len-1] = false;
    	            if(dict.contains((s.substring(i, i+seg_len)))){
    	                seg[i][seg_len-1] = true;
    	                continue;
    	            }
    	            for(int j = 1; j < seg_len; ++j) {
    	                if(seg[i][j-1] && seg[i+j][seg_len-j-1]) {
    	                    seg[i][seg_len-1] = true;
    	                    break;
    	                }
    	            }
    	        }
    	    }

    	    return seg[0][len-1];
    }

}
