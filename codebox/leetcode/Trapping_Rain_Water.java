package main;

public class Trapping_Rain_Water {
	public static int trap(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
		if(A.length<=1)
			return 0;
		int index=0;
		int max=A[index];
		for(int i=0;i<A.length;i++){
			if(A[i]>max){
				index=i;
				max=A[i];
			}
		}
		int leftindex=0;
		int rightindex=A.length-1;
		int ans=0;
		for(int i=0;i<index;i++){
			if(A[i]<A[leftindex]){
				ans+=A[leftindex]-A[i];
			}
			else
				leftindex=i;
			
		}
		for(int i=A.length-1;i>index;i--){
			if(A[i]<A[rightindex]){
				ans+=A[rightindex]-A[i];
			}
			else
				rightindex=i;
			
		}
		return ans;
        
    }
	public static void main(String args[]) {
		int A[]={0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(trap(A));
	}

}
