package main;

import java.util.Arrays;
import java.util.Comparator;
class node implements Comparable {
	public int num;
	public int index;

	public node(int innum, int inindex) {
	    num = innum;
	    index = inindex;
	}

	public int compareTo(Object o) {
	    return this.num - ((node) o).num;
	}
 }
public class Two_Sum {


    public static int[] twoSum(int[] numbers, int target) {
	// Start typing your Java solution below
	// DO NOT write main() function
	int n=numbers.length;
	node[] num=new node[n];
	for(int i=0;i<n;i++){
	    num[i]=new node(numbers[i],i+1);
	}
	Arrays.sort(num);
	int i=0;int j=n-1;
	int ans[] = new int[2];
	while(i<=j){
	    int sum=num[i].num+num[j].num;
	    if(sum==target){
		ans[0]=Math.min(num[i].index, num[j].index);
		ans[1]=Math.max(num[i].index, num[j].index);
		break;
	    }
	    if(sum<target)
		i++;
	    if(sum>target)
		j--;
	}
	return ans;
    }
    public static void main(String[] args) {
	int numbers[]={150,24,79,50,88,345,3};
	int oo[]=twoSum(numbers,200);
	System.out.println(oo);
    }

}
