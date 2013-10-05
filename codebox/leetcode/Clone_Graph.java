package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

 class UndirectedGraphNode {
     int label;
     ArrayList<UndirectedGraphNode> neighbors;
     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
};
public class Clone_Graph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
    	if(node==null)
    		return null;
        Map<Integer,UndirectedGraphNode> cache=new HashMap<Integer,UndirectedGraphNode>();
        Queue<UndirectedGraphNode> q=new LinkedList<UndirectedGraphNode>();
        Set<Integer> iset=new HashSet<Integer>();
        UndirectedGraphNode ans=null;
        q.offer(node);
        while(!q.isEmpty()){
        	UndirectedGraphNode temp=q.poll();
        	if(!cache.containsKey(temp.label)){
        		cache.put(temp.label, new UndirectedGraphNode(temp.label));
        	}
        	if(ans==null)
        		ans=cache.get(temp.label);
        	iset.add(temp.label);
        	UndirectedGraphNode newtemp=cache.get(temp.label);
        	for(UndirectedGraphNode itr:temp.neighbors){
            	if(!cache.containsKey(itr.label)){
            		cache.put(itr.label, new UndirectedGraphNode(itr.label));
            	}
            	newtemp.neighbors.add(cache.get(itr.label));
            	if(!iset.contains(itr.label)){
            		q.offer(itr);
            		iset.add(itr.label);
            	}
        	}
        }
        return ans;
    }
}
