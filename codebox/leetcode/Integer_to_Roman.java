package main;

public class Integer_to_Roman {
    public static String pretoRoman(int pre,int i){
	String list[]={"I","V","X","L","C","D","M"};
	int n=list.length;
	String prefix="";
	if(pre<4){//1-4
	    for(int j=0;j<pre;j++){
		prefix+=list[n-i-1];
	    }
	}
	else if(pre==4){//4
	    prefix+=list[n-i-1];
	    prefix+=list[n-i];
	}
	else if(pre<9){//5-9
	    prefix+=list[n-i];
	    for(int j=0;j<pre-5;j++){
		prefix+=list[n-i-1];
	    }
	}
	else {//9
	    prefix+=list[n-i-1];
	    prefix+=list[n-i+1];
	}
	return prefix;
	
    }
    public static  String intToRoman(int num) {
        // Start typing your Java solution below
        // DO NOT write main() function
	
	int count=1000;
	String ans="";
	for(int i=0;count>0;i+=2){
	    int pre=num/count;
	    ans+=pretoRoman(pre,i);
	    num=num%count;
	    count=count/10;
	}
	return ans;
        
    }
    public static void main(String args[]){
	System.out.println(intToRoman(1));
    }

}
