package main;

import java.util.Arrays;

public class Median_of_Two_Sorted_Arrays {
    public static int findk(int A[], int B[], int k) {
        if (A.length == 0)//must
            return B[k - 1];
        if (B.length == 0)//must
            return A[k - 1];
        if(k==A.length+B.length)//more quick
            return Math.max(A[A.length-1], B[B.length-1]);
        int AK = Math.max((k + 1) * A.length / (A.length + B.length), 1);//make AK>0
        int BK = k - AK + 1;
        int valueAK = AK>0?A[AK-1]:Integer.MAX_VALUE;
        int valueBK = BK>0?B[BK-1]:Integer.MAX_VALUE;
        int valueAK_1 = AK > 1 ? A[AK - 2] : Integer.MIN_VALUE;
        int valueBK_1 = BK > 1 ? B[BK - 2] : Integer.MIN_VALUE;
        if (valueAK_1 <= valueBK && valueBK <= valueAK) {
            return valueBK;
        }
        if (valueBK_1 <= valueAK && valueAK <= valueBK) {//since return valueAk so above must divide k+1;
            return valueAK;
        }
        if (valueAK <=valueBK) {
            A = Arrays.copyOfRange(A, AK , A.length);
            k = k - AK;
            return findk(A,B,k);
        } else{
            B = Arrays.copyOfRange(B, BK , B.length);
            k = k - BK;
            return findk(A,B,k);
        }
        
    }
    
    public static double findMedianSortedArrays(int A[], int B[]) {
        int sum = A.length + B.length;
        if (sum % 2 == 1) {
            int mid1 = (sum + 1) / 2;
            return findk(A, B, mid1);
        }
        else{
            int mid1 = sum  / 2;
            int mid1value=findk(A, B, mid1);
            int mid2 = mid1+1;
            int mid2value = findk(A, B, mid2);
            return 1.0 * (mid1value + mid2value) / 2;
        }
    }
    public static void main(String args[]){
        int A[]={3};
        int B[]={1,2,4};
        System.out.println(findMedianSortedArrays(A,B));
    }
    public static int findk(int A[], int B[],int k,int sa,int sb){
        if (A.length == 0)
		    return B[k - 1];
		if (B.length == 0)
		    return A[k - 1];
		int na=A.length;
		int nb=B.length;
		while(k>0){
			if(sa>=na)
				return B[sb+k-1];
			if(sb>=nb)
				return A[sa+k-1];
			int ak=Math.max((k+1)*(na-sa)/(na+nb-sa-sb), 1);
			int bk=k-ak+1;
			int ca=sa+ak<=na?A[sa+ak-1]:Integer.MAX_VALUE;
			int pa=sa+ak-2>=0?A[sa+ak-2]:Integer.MIN_VALUE;
			int cb=sb+bk<=nb?B[sb+bk-1]:Integer.MAX_VALUE;
			int pb=sb+bk-2>=0?B[sb+bk-2]:Integer.MIN_VALUE;
			if(ca>=cb&&cb>=pa)
				return B[sb+bk-1];
			else if(cb>=ca&&ca>=pb)
				return A[sa+ak-1];
			else if(ca<=cb){
			    sa=sa+ak;
			    k-=ak;
			}
			else if(ca>=cb){
				sb=sb+bk;
				k-=bk;
			}
		}
		return -1;
		
	}
	
    public static double findMedianSortedArrays(int A[], int B[]) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	
    	int na=A.length;
    	int nb=B.length;
    	double ans;
    	if((na+nb)%2==0){
    		int a=findk(A,B,(na+nb)/2,0,0);
    		int b=findk(A,B,(na+nb)/2+1,0,0);
    		ans=((double)a+(double)b)/2;
    	}
    	else{
    		ans=findk(A,B,(na+nb)/2+1,0,0);
    	}
    	return ans;
    }
}
