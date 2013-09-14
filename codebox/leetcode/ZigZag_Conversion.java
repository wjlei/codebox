package prepare;

public class ZigZag_Conversion {
    public static String convert(String s, int nRows) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	String ans="";
    	int ngroup=nRows*2-2;
    	if(ngroup==0)
    		return s;
    	int n=(int) Math.ceil(1.0*s.length()/ngroup);
    	for(int i=0;i<nRows;i++){
    		for(int j=0;j<n&&j*ngroup+i<s.length();j++){
    			ans+=s.charAt(j*ngroup+i);
    			if(ngroup-i<ngroup&&ngroup-i>nRows-1&&j*ngroup+ngroup-i<s.length())
    				ans+=s.charAt(j*ngroup+ngroup-i);
    		}
    	}
    	return ans;
    }
    public static void main(String args[]){
    	System.out.print(convert("PAYPALISHIRING", 3));
    }

}
