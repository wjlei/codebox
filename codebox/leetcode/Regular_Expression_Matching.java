package main;

import java.util.Arrays;

public class Regular_Expression_Matching {
    public static void main(String[] args) {
        String s = "aabccbcbacabaab";
        String p = ".*c*a*b.*a*ba*bb*";
        //	String s = "mississippi";
        //	String p = "m*i*si*si*si*pi";
        //	String s = "";
        //	String p = "*";
        System.out.println(ismatch(s, p));
        
    }
    public static boolean ismatch(String s, String p) {
        int pn = p.length();
        int sn = s.length();
        boolean dp[][] = new boolean[pn+1][sn + 1];
        dp[0][0] = true;
        for (int i = 1; i<=pn; i++) {
            Arrays.fill(dp[i], false);
            if (p.charAt(i-1) == '*') {
                boolean state = false;
                int j;
                if (i >= 2 && p.charAt(i - 2) == '.') {//处理。延伸
                    for (j = 0; j <= sn; j++) {// not sn-1
                        if (dp[(i - 1)][j] == true) {
                            state = true;
                            break;
                        }
                    }
                    for (; j <= sn; j++) {
                        dp[i][j] = state;
                    }
                }
                else if(i>=2){
                    for (int k = 0; k <= sn; k++) {// 处理连续的*延伸
                        if (dp[(i - 1)][k] == true) {
                            for (; k<=sn; k++) {
                                if(p.charAt(i-2)!=s.charAt(k-1))
                                    break;
                                dp[i ][k] = true;
                            }
                        }
                    }
                }
                for (j = 0; j <= sn&&i>=2; j++) {
                    if (dp[(i - 2) ][j] == true||dp[(i - 1) ][j] == true) {//处理*干掉前符号和不起任何作用
                        dp[i ][j] = true;
                    }
                }
            } else {
                for (int j = 1; j <=sn; j++) {
                    if (p.charAt(i-1) == s.charAt(j-1) || p.charAt(i-1) == '.') {
                        dp[i ][j] = dp[(i-1) ][j - 1];
                    }
                }
            }
        }
        //	System.out.print("    ");
        //	for (int j = 1; j <=sn; j++) {
        //		System.out.print(s.charAt(j-1));
        //		System.out.print(" ");
        //	}
        //	System.out.println();
        //	for (int i = 0; i<=pn; i++) {
        //	    if(i==0)
        //		System.out.print("  ");
        //	    else
        //	        System.out.print(p.charAt(i-1)+" ");
        //	    for (int j = 0; j <=sn; j++) {
        //		System.out.print(dp[i][j]?1:0);
        //		System.out.print(" ");
        //	    }
        //	    System.out.println();
        //	}
        return dp[pn][sn];
    }
    
}