package main3;


public class Scramble_String {

    public static boolean isScramble(String s1, String s2) {
	// Start typing your Java solution below
	// DO NOT write main() function
	if (s1.length() != s2.length())
	    return false;
	int n = s1.length();
	int dp[][][] = new int[s1.length()][s1.length()][s1.length()];
	for (int i = 0; i < n; i++) {
	    for (int j = 0; j < n; j++) {
		if (s1.charAt(i) == s2.charAt(j))
		    dp[0][i][j] = 1;
	    }
	}
	for(int l=2;l<=n;l++){
	    for(int i=0;i+l-1<n;i++){
		for(int j=0;j+l-1<n;j++){
		    int state=0;
		     for(int m=1;m<l;m++){
			 int ii=m-1;
			 int yy=l-m-1;
			 if(i+m<n&&j+m<n&&dp[m-1][i][j]==1&&dp[l-m-1][i+m][j+m]==1)//i and j two string,first cut m and l-m
			     state=1;                                              // compare 1->1 2->2
			 else if(i+m<n&&j+l-m<n&&dp[m-1][i][j+l-m]==1&&dp[l-m-1][i+m][j]==1)//cut m and l-m compare 1->2,2->1
			     state=1;                                                        // don`t need check l-m and m
		     }
		     dp[l-1][i][j]=state;
		}
	    }
	}
	return dp[n-1][0][0]==1?true:false;
    }
    public static void main(String args[]) {
      	System.out.println(isScramble("great","rgtae"));
      	System.out.println(isScramble("ab","ba"));
    }

}
