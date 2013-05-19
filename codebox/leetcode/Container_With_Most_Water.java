package main;

public class Container_With_Most_Water {
    public static int maxArea(int[] height) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	if(height.length<=1)
    		return 0;
    	int left=0;
    	int right=height.length-1;
    	int max=0;
    	while(left<=right){
    		max=Math.max(max,Math.min(height[left],height[right])*(right-left));
    		if(height[left]<height[right]){
    			left++;
    		}
    		else
    			right--;
    	}
    	return max;
        
    }
	public static void main(String args[]) {
		int height[]={1,2,4,3};
		System.out.println(maxArea(height));
	}

}
