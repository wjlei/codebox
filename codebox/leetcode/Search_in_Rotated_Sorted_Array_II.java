package main2;

public class Search_in_Rotated_Sorted_Array_II {
  static  boolean along(int[] A, int l,int r,int target){
	for(int i=l;i<=r;i++){
	    if(A[i]==target)
		return true;
	}
	return false;
    }
    public boolean search(int[] A, int target) {
	// Start typing your Java solution below
	// DO NOT write main() function
	int l = 0;
	int r = A.length - 1;
	while (l <= r) {
	    int mid = (l + r) / 2;
	    if (A[mid] == target) {
		return true;
	    }else if(A[mid] == A[r]&&A[l]==A[mid]){
		return along(A,l,r,target);		
	    }
	    else if (A[mid] <= A[r] && (A[mid] < target && target <= A[r])) {
		l = mid + 1;
	    } else if (A[mid] <= A[r]) {
		r = mid - 1;
	    } else if (A[l] <= A[mid] && (A[l] <= target && target < A[mid])) {
		r = mid - 1;
	    } else if (A[l] <= A[mid]) {
		l = mid + 1;
	    }
	}
	return false;

    }

}
