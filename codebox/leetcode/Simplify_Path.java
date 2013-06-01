package main2;

import java.util.Stack;

public class Simplify_Path {
    public static String simplifyPath(String path) {
        // Start typing your Java solution below
        // DO NOT write main() function
	Stack<String> pathstack=new Stack<String>();
	int j=0;
	String dot="";
	String name="";
	while(j<path.length()){
	   if(path.charAt(j)=='.'){
	       dot+=".";
	   }
	   else if(path.charAt(j)=='/'){
	       if(dot.equals("..")){
		   if(pathstack.size()>0)
		       pathstack.pop();
		   
	       }
	       else if(dot.equals(".")){
		   
	       }
	       if(name.length()>0){
		   pathstack.push(name);
		   name="";
	       }
	       dot="";
	   }
	   else{
	       if(dot.equals(".")){
	          name+=".";
	          dot="";
	       }
	       name+=path.charAt(j);
	   }
	   j++;
	}
	if(name.length()>0){
	    pathstack.push(name);
	}
	if(dot.equals("..")){//last ..
	    if(pathstack.size()>0)
		   pathstack.pop();
	}
	String ans="";
	while(pathstack.size()>0){
	    ans="/"+pathstack.pop()+ans;
	}
	if(ans.length()==0)
	    ans+="/";
	return ans;
        
    }
    public static void main(String args[]){
	
	System.out.println( simplifyPath("/.hidden"));
	
    }

}
