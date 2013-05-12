package main;

import java.util.Arrays;

public class Median_of_Two_Sorted_Arrays {
    public static int findk(int A[], int B[], int k) {
	if (A.length == 0)
	    return B[k - 1];
	if (B.length == 0)
	    return A[k - 1];
	if(k==A.length+B.length)
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
	if (valueBK_1 <= valueAK && valueAK <= valueBK) {
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
}
