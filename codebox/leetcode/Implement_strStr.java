package main;

public class Implement_strStr {
	public static int kmp(String haystack,String needle){
		int next[]=new int[needle.length()];
		next[0]=0;
		int j=0;
		for(int i=1;i<needle.length();i++){
			if(needle.charAt(j)==needle.charAt(i)){
				next[i]=j;
				j++;
			}
			else{
				next[i]=j;
				while(needle.charAt(j)!=needle.charAt(i)&&j!=0)
					j=next[j];
				if(needle.charAt(j)==needle.charAt(i))
				     j++;
			}
		}
		int k=0;
		for(int i=0;i<haystack.length();i++){
			if(haystack.charAt(i)==needle.charAt(k))
				k++;
			else{
				while(haystack.charAt(i)!=needle.charAt(k)&&k!=0){
					k=next[k];
				}
				if(haystack.charAt(i)==needle.charAt(k))
					k++;
			}
			if(k==needle.length()){
				return i-k+1;
			}
		}
		return -1;
	}
    public static String strStr(String haystack, String needle) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	if(needle==null)
    		return haystack;
    	if(needle.length()==0)
    		return haystack;
    	String ans=null;
    	int index=kmp(haystack,needle);
    	if(index==-1)
    		return ans;
    	ans=haystack.substring(index);
        return ans;
    }
    public static void main(String args[]){
    	//String needle="abaabcabaabda";
    	//String needle="abaabcaba";
    	System.out.println(strStr("abcde","bcd"));
    	
    }

}
