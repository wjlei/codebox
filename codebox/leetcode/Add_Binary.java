package main2;

public class Add_Binary {
    
    public static String addBinary(String a, String b) {
		String ans="";
		int la=a.length()-1;
		int lb=b.length()-1;
		int base=0;
		int carry=0;
		while(la>=0||lb>=0){
			int numa=la>=0?a.charAt(la)-'0':0;
			int numb=lb>=0?b.charAt(lb)-'0':0;
			base=numa+numb+carry;
			carry=base/2;
			base=base%2;
			ans=(char)(base+'0')+ans;
			la=la>=0?la-1:la;
			lb=lb>=0?lb-1:lb;
		}
		if(carry>0)
			ans=(char)(carry+'0')+ans;
		return ans;
	}

    public static String addBinary(String a, String b) {
        // Start typing your Java solution below
        // DO NOT write main() function
	StringBuffer abuff = new StringBuffer(a);
    	StringBuffer bbuff = new StringBuffer(b);
    	StringBuffer ans = new StringBuffer();
    	abuff=abuff.reverse();
    	bbuff=bbuff.reverse();
    	int c=0;
    	for(int i=0;i<Math.min(abuff.length(), bbuff.length());i++){
    	    int num=(int)(abuff.charAt(i)-'0')+(int)(bbuff.charAt(i)-'0')+c;
    	    c=num/2;
    	    num=num%2;
    	    ans.append((char)(num+'0'));
    	}
    	for(int i=Math.min(abuff.length(), bbuff.length());i<Math.max(abuff.length(), bbuff.length());i++){
    	int num;
    	    if(abuff.length()>bbuff.length())
    	         num=c+(int)(abuff.charAt(i)-'0');
    	    else
    		 num=c+(int)(bbuff.charAt(i)-'0');
    	    c=num/2;
    	    num=num%2;
    	    ans.append((char)(num+'0'));
    	}
    	if(c>0)
    	 ans.append('1');
    	ans.reverse();
    	String ansto=ans.toString();
    	return ansto;
    }
public static void main(String args[]){
   System.out.println( addBinary("1","111"));
    
}
}
