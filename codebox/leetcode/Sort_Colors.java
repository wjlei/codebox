package main2;

public class Sort_Colors {
    public void sortColors(int[] A) {
	// Start typing your Java solution below
	// DO NOT write main() function
	int n = A.length;
	int j = -1, k = n;
	for (int i = 0; i < n && i < k; i++) {
	    while (A[i] != 1 && j < i && i < k) {
		if (A[i] == 0) {
		    int temp = A[j + 1];
		    A[j + 1] = A[i];
		    A[i] = temp;
		    j = j + 1;
		} else if (A[i] == 2) {
		    int temp = A[k - 1];
		    A[k - 1] = A[i];
		    A[i] = temp;
		    k = k - 1;
		}
	    }
	}

    }

}
