package main3;

public class Valid_Palindrome {
    boolean ischar(char c){
	if(c<='z'&&c>='a')
	    return true;
	if(c<='9'&&c>='0')
	    return true;
	else
	    return false;
    }
    public boolean isPalindrome(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
	s=s.toLowerCase();
	int i=0;int j=s.length()-1;
	while(i<j){
	    while(i<=s.length()-1&&!ischar(s.charAt(i)))
		i++;
	    while(j>=0&&!ischar(s.charAt(j)))
		j--;
	    if(i>j)
		return true;
	    if(ischar(s.charAt(i))&&ischar(s.charAt(j))&&s.charAt(i)!=s.charAt(j))
		return false;
	    i++;j--;// update
	}
	return true;
    }

}
