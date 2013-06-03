package main2;

import java.util.Stack;

public class Largest_Rectangle_in_Histogram {
    public static int largestRectangleArea(int[] height) {
	// Start typing your Java solution below
	// DO NOT write main() function
	Stack<Integer> stack = new Stack<Integer>();//keep the left
	Stack<Integer> index = new Stack<Integer>();//keep the index  if height[i]<stack.top the stack r=height[i],l=stack-1
	int max = 0;
	for (int i = 0; i < height.length; i++) {
	    if (stack.size() > 0) {
		if (height[i] > stack.peek()) {
		    stack.push(height[i]);
		    index.push(i);
		} else {
		    while (stack.size() > 0 && height[i] < stack.peek()) {
			int num = stack.pop();
			index.pop();
			int l=stack.size()>0?index.peek():-1;
			max = Math.max(max, num*(i-l-1));
		    }
		    stack.push(height[i]);
		    index.push(i);
		}

	    } else {
		stack.push(height[i]);
		index.push(i);
	    }
	}
	while(stack.size() > 0){
	        int num = stack.pop();
	        index.pop();
		int l=stack.size()>0?index.peek():-1;
		max = Math.max(max, num*(height.length-l-1));
	}
	return max;

    }
    public static void main(String args[]){
	int num[]={0,0,0,0,0,0,0,0,2147483647};
	System.out.println(largestRectangleArea(num));
	
    }
}
