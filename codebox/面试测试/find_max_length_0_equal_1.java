package prepare;

public class find_max_length_0_equal_1 {

	static int findmaxlength(int num[]) {
		int moreone[] = new int[num.length + 1];
		int n=num.length;
		int leastindex[] = new int[2*n];
		int max = 0;
		for (int i = 0; i < leastindex.length; i++)
			leastindex[i] = -1;
		leastindex[n]=0;
		for (int i = 0; i < num.length; i++) {
			if (num[i] == 0)
				moreone[i+1] = moreone[i] - 1;
			else
				moreone[i+1] = moreone[i] + 1;
			if (leastindex[moreone[i+1]+n] == -1)
				leastindex[moreone[i+1]+n] = i+1;
			else {
				int len = i+1 - leastindex[moreone[i+1]+n] ;
				max = Math.max(len, max);
			}
		}
		return max;
	}

	public static void main(String args[]) {
		int a[] = { 1, 0, 1, 0, 1, 0, 1, 0,0,1};
		System.out.print(findmaxlength(a));

	}

}
