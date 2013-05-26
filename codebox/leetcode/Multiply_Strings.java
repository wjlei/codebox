package main1;

public class Multiply_Strings {
    public static String multiply(String num1, String num2) {
        // Start typing your Java solution below
        // DO NOT write main() function 
    	StringBuffer buf1 = new StringBuffer(num1);
    	StringBuffer buf2 = new StringBuffer(num2);
    	buf1=buf1.reverse();
    	buf2=buf2.reverse();
    	StringBuffer ansbuff=new StringBuffer();
        for(int i=0;i<buf2.length();i++){
        	 int count=0;
        	 int j=0;
        	 for(j=0;j<buf1.length();j++){
        		 int num=(int)(buf2.charAt(i)-'0')*(int)(buf1.charAt(j)-'0')+count;	
        		 if(i+j>ansbuff.length()-1){
        			 count=num/10;
            		 num=num%10;
            		 ansbuff.append((char)(num+'0'));//append
        		 }
        		 else{
        			 num+=(int)(ansbuff.charAt(i+j)-'0');
        			 count=num/10;
            		 num=num%10;
            		 ansbuff.setCharAt(i+j, (char)(num+'0'));//change
        		 }
        	 }
        	 while(count>0){	
        		 if(i+j>ansbuff.length()-1){
        			 int num=count%10;
        			 count=count/10;
        			 ansbuff.append((char)(num+'0'));//append
            		 
        		 }
        		 else{
        			 int num=(int)(ansbuff.charAt(i+j)-'0')+count;
        			 count=num/10;
            		 num=num%10;
            		 ansbuff.setCharAt(i+j, (char)(num+'0'));//change
        		 }
        		 
        	 }
        }
        ansbuff.reverse();
        String ans="";
        boolean getnonzero=false;//kill 999*0=000
        for(int i=0;i<ansbuff.length();i++){
        	if(!getnonzero&&ansbuff.charAt(i)!='0'){
        		getnonzero=true;
        	}
        	if(getnonzero){
        		ans+=ansbuff.charAt(i);
        	}
        }
        if(ans.length()==0)
        	return "0";
        return ans;
        
    }
    public static void main(String args[]){
    	String num1="9";
    	String num2="99";
    	System.out.println(multiply(num1,num2));
    }

}
