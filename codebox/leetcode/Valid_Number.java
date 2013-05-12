package main;

public class Valid_Number {
	public static boolean isNumber(String s){
		boolean sign=false;
		boolean ise=false;
		boolean isdouble=false;
		boolean apparenum=false;
		int i=0;
		while(i<s.length()&&s.charAt(i)==' '){
			i++;
		}
		for(;i<s.length();i++){
			if(s.charAt(i)>='0'&&s.charAt(i)<='9'){
				apparenum=true;
				continue;
			}
			if(s.charAt(i)=='+'||s.charAt(i)=='-'){
				if(sign||apparenum)
					return false;
				sign=true;
				continue;
			}
			if(s.charAt(i)=='.'){
				if(ise)
					return false;
				if(isdouble)
					return false;
				isdouble=true;
				if(apparenum)//.号前后必须要有数字
					continue;
				else{
					i++;
					if(i==s.length())//只有“.”
						return false;
					if(s.charAt(i)>='0'&&s.charAt(i)<='9'){
						apparenum=true;
						continue;
					}
					else
						return false;
				}
					
			}
			if(s.charAt(i)=='e'){//e之前可以是小数,必须有数字出现，e之后是符号整数
				if(ise)
					return false;
				if(!apparenum)
					return false;
				sign=false;
				ise=true;
				apparenum=false;
			}
			else if(s.charAt(i)==' ')//再出现‘ ’
				break;
			else
				return false;
			
		}
		while(i<s.length()&&s.charAt(i)==' '){
			i++;
		}
		if(i==s.length()&&apparenum)
			return true;
		else
			return false;
		
	}
	public static void main(String args[]){
		String s="+e6";
		System.out.println(isNumber(s));
	}

}
