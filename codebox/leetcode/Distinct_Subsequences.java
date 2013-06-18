package main3;

public class Distinct_Subsequences {
    public static int numDistinct(String S, String T) {
        // Start typing your Java solution below
        // DO NOT write main() function
	int m=T.length()+1;
	int n=S.length()+1;
	int dp[][]=new int[m][n];
	for(int j=0;j<n;j++){
	    dp[0][j]=1;
	}
	for(int i=1;i<m;i++){
	    for(int j=1;j<n;j++){
		if(T.charAt(i-1)==S.charAt(j-1)){
		    dp[i][j]=dp[i][j-1]+dp[i-1][j-1];
		}
		else{
		    dp[i][j]=dp[i][j-1];
		}
	    }
	}
	return dp[m-1][n-1];
    }
//    public int numDistinct(String S, String T) {
//        // Start typing your Java solution below
//        // DO NOT write main() function
//            int m=T.length()+1;
//	int n=S.length()+1;
//	int dp[][]=new int[m][n];
//	dp[0][0]=1;
//	for(int i=1;i<m;i++){
//	    for(int j=1;j<n;j++){
//		if(T.charAt(i-1)==S.charAt(j-1)){
//		    int sum=0;
//		    for(int k=0;k<j;k++){
//			sum+=dp[i-1][k];
//		    }
//		    dp[i][j]=sum;
//		}
//	    }
//	}
//	int sum=0;
//	for(int j=1;j<n;j++)
//	    sum+=dp[m-1][j];
//	return sum;
//        
//    }
    static public void main(String args[]){
	System.out.println(numDistinct("rabbbit","rabbit"));
    }

}
