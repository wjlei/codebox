package prepare;

//find min length of num, contain target
public class find_min_segement_contain_target {
	
 static	int findminsegement(int num[],int target[]){
		int need[]=new int[256];
		int cur[]=new int[256];
		for(int i=0;i<target.length;i++){
			need[target[i]]++;
		}
		int left=0;int length=0;int min=Integer.MAX_VALUE;
		for(int right=0;right<num.length;right++){
			if(cur[num[right]]<need[num[right]])
				length++;
			cur[num[right]]++;
			while(cur[num[left]]-1>=need[num[left]]){
				cur[num[left]]--;
				left++;
			}
			if(length==target.length)
				min=Math.min(min, right-left+1);
		}
		return min;
		
	}
	public static void main(String args[]) {
		int a[]={1,2,3,1,1,2,4,1};
		int b[]={1,2,3,4};
		System.out.print(findminsegement(a,b));
		
	}

}
