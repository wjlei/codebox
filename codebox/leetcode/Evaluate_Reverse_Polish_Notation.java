package main;

import java.util.Stack;

public class Evaluate_Reverse_Polish_Notation {
    public static int evalRPN(String[] tokens) {
        Stack<Integer> ss=new Stack<Integer>();
        for(int i=0;i<tokens.length;i++){
        	if(tokens[i].equals("+")){
        		int s2=ss.pop();
        		int s1=ss.pop();
        		ss.push(s1+s2);
        	}
        	else if(tokens[i].equals("-")){
        		int s2=ss.pop();
        		int s1=ss.pop();
        		ss.push(s1-s2);
        	}
        	else if(tokens[i].equals("*")){
        		int s2=ss.pop();
        		int s1=ss.pop();
        		ss.push(s1*s2);
        	}
        	else if(tokens[i].equals("/")){
        		int s2=ss.pop();
        		int s1=ss.pop();
        		ss.push(s1/s2);
        	}
        	else{
        		ss.push(Integer.parseInt(tokens[i]));
        	}
        }
        return ss.pop();
    }
    public static void main(String args[]) {
    	String[] ss={"0","3","/"};
    	System.out.print(evalRPN(ss));

    }

}
