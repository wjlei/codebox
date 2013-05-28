package main1;

public class Maximum_Subarray {
	public int maxSubArray(int[] A) {
		// 负数最大也要考虑
		int max = 0;
		int localmax = 0;
		for (int i = 0; i < A.length; i++) {
			localmax += A[i];
			if (localmax < 0) {
				localmax = 0;
			}
			max = Math.max(max, localmax);
		}
		if (max == 0) {
			max=Integer.MIN_VALUE;
			for (int i = 0; i < A.length; i++) {
				max = Math.max(max, A[i]);
			}
		}
		return max;
	}

}
