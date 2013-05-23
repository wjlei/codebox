package main;

import java.util.HashMap;
import java.util.Map;

public class Roman_to_Integer {

    public int romanToInt(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
	int ans=0;
        Map<Character,Integer> table= new HashMap<Character,Integer>();
        table.put('M', 1000);
        table.put('D', 500);
        table.put('C', 100);
        table.put('L', 50);
        table.put('X', 10);
        table.put('V', 5);
        table.put('I', 1);
        for(int i=0;i<s.length();i++){
            int front=table.get(s.charAt(i));
            int next=0;
            if(i+1<s.length())
        	next=table.get(s.charAt(i+1));
            if(front>=next)
        	ans+=front;
            else
        	ans-=front;
        }
        return ans;
    }
}
