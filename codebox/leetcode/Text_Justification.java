package main2;

import java.util.ArrayList;

public class Text_Justification {
   static String solve(String[] words,int l,int r,int L){
       String ans="";
       if(l==r){
	   ans+=words[l];
	   for(int i=words[l].length();i<L;i++)
	       ans+=" ";
	   return ans;
	   
       }
	int num=0;
	for(int i=l;i<=r;i++){
	    num+=words[i].length();
	}
	int numspace=L-num;
	for(int i=l;i<r;i++){
	    ans+=words[i];
	    int addspace=numspace/(r-l);
	    if(numspace%(r-l) >i-l)
		addspace++;
	    for(int j=0;j<addspace;j++)
		ans+=" ";
	}
	ans+=words[r];
	return ans;
    }
    public static ArrayList<String> fullJustify(String[] words, int L) {
        // Start typing your Java solution below
        // DO NOT write main() function
	ArrayList<String> ans=new ArrayList<String>();
	int l=0;int r=0;
	int count=0;
	while(r<words.length){
	    count+=words[r].length();
	    if(count+r-l>L){
		ans.add(solve(words,l,r-1,L));
		l=r;
		r--;
		count=0;
	    }
	    r++;
	}
	String anss="";
	for(int i=l;i<r;i++){
	    anss+=words[i];
	    if(i!=r-1)
	    anss+=" ";
	}
	while(anss.length()<L){
	    anss+=" ";
	}
	
	ans.add(anss);
	return ans;
        
    }
    public static void main(String args[]){
	String[] words={"What","must","be","shall","be."};
	System.out.println(fullJustify( words, 12));
	
    }

}
