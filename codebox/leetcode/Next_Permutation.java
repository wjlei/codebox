package main;

public class Next_Permutation {
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
    public static void main(String args[]){
	int num[]={1,2,3,4};
	for(int i=0;i<30;i++){
	nextPermutation(num);
	for(int j=0;j<4;j++)
	System.out.print(num[j]+" ");
	System.out.println();
	}
	
    }

}
