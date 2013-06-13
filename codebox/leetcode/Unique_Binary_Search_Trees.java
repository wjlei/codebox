package main3;

public class Unique_Binary_Search_Trees {
    public int numTrees(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
	int c = 1; 
        for (int i = 2; i <= n; i++) 
               c = 2*(2*i-1)*c/(i+1);
        return c;
        
    }

}
