package careercup;

//Given an array of integers. Find two disjoint contiguous sub-arrays such that the 
//absolute difference between the sum of two sub-array is maximum. 
//* The sub-arrays should not overlap. 

//eg- [2 -1 -2 1 -4 2 8] ans - (-1 -2 1 -4) (2 8), diff = 16 

public class Max_diff_two_disjoint_contiguous_subarrays {
	static int line[]={2,-1,-2,1,-4,2,8};
	static int num=line.length;
	static int maxfromleft[]=new int[num];
	static int minfromleft[]=new int[num];
	static int minfromright[]=new int[num];
	static int maxfromright[]=new int[num];
	
	static void init(){
		int max=0;
		int min=0;
		int cur=0;
		for(int i=0;i<num;i++){
			cur+=line[i];
			if(cur<0){
				cur=0;
			}
			max=Math.max(max, cur);
			maxfromleft[i]=max;
		}
		max=0;cur=0;min=0;
		for(int i=0;i<num;i++){
			cur+=line[i];
			if(cur>0){
				cur=0;
			}
			min=Math.min(min, cur);
			minfromleft[i]=min;
		}
		max=0;cur=0;min=0;
		for(int i=num-1;i>=0;i--){
			cur+=line[i];
			if(cur<0){
				cur=0;
			}
			max=Math.max(max, cur);
			maxfromright[i]=max;
		}
		max=0;cur=0;min=0;
		for(int i=num-1;i>=0;i--){
			cur+=line[i];
			if(cur<0){
				cur=0;
			}
			min=Math.min(min, cur);
			minfromright[i]=min;
		}
	}
	static int solve(){
		init();
		int temp[]=new int[num-1];
		for(int i=0;i<num-1;i++){
			temp[i]=Math.max(Math.abs(maxfromleft[i]-minfromright[i+1]),
					Math.abs(minfromleft[i]-maxfromright[i+1]));
		}
		int max=0;
		for(int i=0;i<num-1;i++){
			max=Math.max(max, temp[i]);
		}
		return max;
	}

	public static void main(String args[]) {
		System.out.println(solve());
	}

}
