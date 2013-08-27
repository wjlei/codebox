package main3;

public class Interleaving_String {
    
    
    public static boolean isInterleave(String s1, String s2, String s3) {// like start from the (0,0) can reach the (n,m)
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s1.length()+s2.length()!=s3.length())
            return false;
        int dp[][]=new int[s1.length()+1][s2.length()+1];
        dp[0][0]=1;
        for(int i=1;i<=s1.length();i++){
            if(s1.charAt(i-1)==s3.charAt(i-1))
                dp[i][0]=1;
            else
                break;
        }
        for(int i=1;i<=s2.length();i++){
            if(s2.charAt(i-1)==s3.charAt(i-1))
                dp[0][i]=1;
            else
                break;
        }
        for(int i=1;i<=s1.length();i++){
            for(int j=1;j<=s2.length();j++){
                if(dp[i-1][j]==1){
                    if((i-1<s1.length()&&s3.charAt(i+j-1)==s1.charAt(i-1)))//must be i+1
                        dp[i][j]=1;// it can go down
                }
                if(dp[i][j-1]==1){
                    if((j-1<s2.length()&&s3.charAt(i+j-1)==s2.charAt(j-1)))//must be j+1
                        dp[i][j]=1;// it can go right
                }
            }
        }
        return dp[s1.length()][s2.length()]==1?true:false;
        
    }
    public static void main(String args[]) {
      	System.out.println(isInterleave("aabc", "abad","aabcbaad"));
    }
    
}
