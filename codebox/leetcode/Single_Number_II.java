package main;

public class Single_Number_II {
    public static int singleNumber(int[] A) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
    	int an=100;
        int ans[]=new int[an];
        int n=A.length;
		for (int i = 0; i < n; i++) {
			long num=(long)A[i]-Integer.MIN_VALUE;
			String temp = Long.toString(num, 3);
			int aj = an - 1;
			for (int j = temp.length() - 1; j >= 0; j--, aj--) {
				ans[aj] += (int) (temp.charAt(j) - '0');
			}
		}
        long returnans=0;
        for(int i=0;i<an;i++)
        	returnans=returnans*3+ans[i]%3;
        return (int)(returnans+Integer.MIN_VALUE);
    }
    public static void main(String args[]){
    	int A[]={43,16,45,89,45,-2147483648,45,2147483646,-2147483647,-2147483648,43,2147483647,-2147483646,-2147483648,89,-2147483646,89,-2147483646,-2147483647,2147483646,-2147483647,16,16,2147483646,43};
    	System.out.print(singleNumber(A));
    }

}
