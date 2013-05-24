package main;

public class Search_in_Rotated_Sorted_Array {
	public int search(int[] A, int target) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int l = 0;
		int r = A.length - 1;
		while (l <= r) {
			int mid = (l + r) / 2;
			if (A[mid] == target) {
				return mid;
			} else if (A[mid] <= A[r] && (A[mid] < target && target <= A[r])) {
				l = mid + 1;
			} else if (A[mid] <= A[r]) {
				r = mid - 1;
			} else if (A[l] <= A[mid] && (A[l] <= target && target < A[mid])) {
				r = mid - 1;
			} else if (A[l] <= A[mid]) {
				l = mid + 1;
			}

		}
		return -1;

	}

}
