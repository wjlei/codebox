package main2;

import java.util.Stack;

public class Maximal_Rectangle {
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
    public static int maximalRectangle(char[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
	if(matrix==null||matrix.length==0)
	    return 0;
	int max=0;
	int m=matrix.length;
	int n=matrix[0].length;
	int state[]=new int[n];
	for(int i=0;i<m;i++){
	    for(int j=0;j<n;j++){
		 state[j]=matrix[i][j]=='1'?state[j]+1:0;//single init enough.
	    }
	   max=Math.max(max,largestRectangleArea(state));
	}
	return max;
        
    }
public static void main(String args[]){
    char[][] matrix={{'0'}};
    maximalRectangle(matrix);
    
}
}
