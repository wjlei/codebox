package main3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import main3.Word_Ladder_II.node;
public class Word_Ladder {

    static   class node {
  	node(String in, int len, node ip) {
  	    ss = in;
  	    l = len;
  	    p = ip;
  	}
  	String ss;
  	int l;
  	node p;
  }

      static    Queue<node> q;
     static   ArrayList<ArrayList<String>> ans;
     static    int minlen;
     
     static    public void makepath(node n){
         ArrayList<String> path = new ArrayList<String>();
         node p = n;
         while(p != null){
             path.add(0, p.ss);
             p = p.p; 
         }
         ans.add(path);
     }

      static void solve(String end, HashSet<String> dict) {
  	int level=0;
  	Set<String> visited=new HashSet<String>();
  	Set<String> tempvisited=new HashSet<String>();
  	while (!q.isEmpty()) {
  	    node temp = q.poll();
  	    if(temp.l>level){
  		level=temp.l;
  		visited.addAll(tempvisited);
  		tempvisited.clear();
  	    }
  	    if (temp.l > minlen)
  		break;
  	    if (temp.ss.equals(end)) {
  		minlen = Math.min(minlen, temp.l);
  		break;
  	    }
  	    HashSet<String> newset = neighbours.get(temp.ss);
  	    Set<String> remove=new HashSet<String>();
  	    if (newset != null && newset.size() > 0) {
  		for (String si : newset) {
  		    if (!visited.contains(si)) {
  			q.offer(new node(si, temp.l + 1, temp));
  			tempvisited.add(si);
  		    }
  		    else{
  			remove.add(si);
  		    }
  		}
  		newset.removeAll(remove);
  	    }
  	}

      }
     static   HashMap<String, HashSet<String>> neighbours;
  static   void calcNeighbours(String str, HashSet<String> dict) {
         int length = str.length();
         char [] chars = str.toCharArray();
         for (int i = 0; i < length; i++) {
             
             char old = chars[i]; 
             for (char c = 'a'; c <= 'z'; c++) {
                 if (c == old)  
          	   continue;
                 chars[i] = c;
                 String newstr = new String(chars);                
                 if (dict.contains(newstr)) {
                     HashSet<String> set = neighbours.get(str);
                     if (set != null) {
                         set.add(newstr);
                     } else {
                         HashSet<String> newset = new HashSet<String>();
                         newset.add(newstr);
                         neighbours.put(str, newset);
                     }
                 }                
             }
             chars[i] = old;
         }
     }
     
   static  public int ladderLength(String start, String end, HashSet<String> dict)  {
  	// Start typing your Java solution below
  	// DO NOT write main() function
  	minlen = Integer.MAX_VALUE;
  	neighbours=new HashMap<String, HashSet<String>>();
  	ans = new ArrayList<ArrayList<String>>();
  	dict.add(end);
  	dict.add(start);
  	for(String s:dict)
  	   calcNeighbours(s,dict);
  	q = new LinkedList<node>();
  	q.offer(new node(start, 0, null));
  	solve(end, dict);
  	return Math.max(minlen, 0);

      }
}
