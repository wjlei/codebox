package prepare;

public class LCS {
	public static String LCS(String a,String b){
		int n=a.length();
		int m=b.length();
		int dp[][]=new int[m+1][n+1];
		int mark[][]=new int[m+1][n+1];//1 up 2 upleft 3 left
		for(int i=1;i<=m;i++){
			for(int j=1;j<=n;j++){
				if(b.charAt(i-1)==a.charAt(j-1)){
					dp[i][j]=dp[i-1][j-1]+1;
					mark[i][j]=2;
				}
				else{
					if(dp[i-1][j]>=dp[i][j-1]){//equal put down is ok also
						dp[i][j]=dp[i-1][j];
						mark[i][j]=1;
					}
					else{
						dp[i][j]=dp[i][j-1];
						mark[i][j]=3;
					}
				}
			}
		}
		System.out.println(dp[m][n]);
		int i=m;int j=n;
		String ans="";
		while(mark[i][j]!=0){
			if(mark[i][j]==2){
			   ans=b.charAt(i-1)+ans;
			   i--;j--;
			}
			else if(mark[i][j]==1){
				i--;
			}
			else 
				j--;
		}
		return ans;
	}
	public static void main(String args[]){
		System.out.println(LCS("BDCABA","ABCBDAB"));
	}

}
