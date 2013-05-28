package main2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Insert_Interval {
    public static ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        // Start typing your Java solution below
        // DO NOT write main() function
	Interval num[]=new Interval[intervals.size()];
	ArrayList<Interval> ans=new ArrayList<Interval>();
	if(intervals.size()<=0)
	    return ans;
	int i=0;
	for(Interval itr:intervals){
	    num[i]=itr;
	    i++;
	}
	Arrays.sort(num,new Comparator<Interval>(){
	    public int compare(Interval obj1, Interval obj2) {
		    Interval u1 = obj1;
		    Interval u2 =  obj2;
		    if (u1.start > u2.start) {
			return 1;
		    } else {
			return -1;
		    }
		}
	});
	Interval cur=num[0];
	for(i=1;i< intervals.size();i++){
	    if(num[i].start<=cur.end&&num[i].start>=cur.start){
		cur.end=Math.max(num[i].end, cur.end);
	    }
	    else{
		ans.add(cur);
		cur=num[i];
	    }
	}
	ans.add(cur);
	return ans;
        
    }
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        // Start typing your Java solution below
        // DO NOT write main() function
	intervals.add(newInterval);
	 return merge(intervals);
        
    }

}
