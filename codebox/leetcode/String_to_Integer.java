package main;

public class String_to_Integer {
    public static int atoi(String str) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	if(str.length()==0||str==null)
    		return 0;
        boolean valid=false;
        boolean beyondmax=false;
        boolean minus=false;
        boolean hashnum=false;
        int ans=0;
        int i=0;
        while(str.charAt(i)==' '){
        	i++;
        }
        if(str.charAt(i)=='+')
        	i++;
        else if(str.charAt(i)=='-'){
        	minus=true;
        	i++;
        }
        while(i<str.length()){
        	if(str.charAt(i)>'9'||str.charAt(i)<'0')
        		break;
        	int temp=ans*10+str.charAt(i)-'0';
        	if(temp<ans||(temp-(str.charAt(i)-'0'))/10!=ans){//-2147483648  10522545459&1932610867
        		beyondmax=true;
        		break;
        	}
        	ans=temp;
        	hashnum=true;
        	i++;
        }
        if(i==str.length()&&hashnum)
        	valid=true;
        if(beyondmax&&minus)
        	return Integer.MIN_VALUE;
        else if(beyondmax)
        	return Integer.MAX_VALUE;
        else if(minus)
        	return -ans;
        else
        	return ans;
    }
    public static void main(String args[]){
    	System.out.print(atoi("2147483648"));
    }

}
