package main1;

public class Permutation_Sequence {
    public static void nextPermutation(int[] num) {
	// Start typing your Java solution below
	// DO NOT write main() function
	if (num.length <= 1)
	    return;
	int i = 0;
	boolean isfind = false;
	for (i = num.length - 2; i >= 0; i--) {
	    if (num[i] < num[i + 1]) {
		isfind = true;
		break;
	    }
	}
	if (isfind) {
	    int j = 0;
	    for (j = num.length - 1; j >= 0; j--) {
		if (num[i] < num[j]) {
		    break;
		}
	    }
	    int temp = num[j];
	    num[j] = num[i];
	    num[i] = temp;
	} else {
	    i = -1;
	}
	i = i + 1;
	int k = num.length-1;
	while (i < k) {//reverse i+1 to end
	    int temp = num[i];
	    num[i] = num[k];
	    num[k] = temp;
	    k--;
	    i++;
	}

    }
    public String getPermutation(int n, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	int num[]=new int[n];
    	for(int i=1;i<=n;i++)
    		num[i-1]=i;
    	int mod=1;
    	for(int i=1;i<=n;i++)
    		mod=mod*i;
    	for(int i=0;i<k%mod;i++){
    	   nextPermutation(num);
    	}
    	String ans="";
    	for(int i=0;i<n;i++)
    		ans+=(char)(num[i]+'0');
        return ans;
    }

}
