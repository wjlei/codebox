package main;

// get back array from pre&mid array
public class premid {
    private static int p;

    public static void main(String[] args) {
	int pre[] = { 1, 2, 4, 8, 9, 5, 3, 6, 7 };
	int mid[] = { 8, 4, 9, 2, 5, 1, 6, 3, 7 };
	int back[] = new int[100];
	p = 8;
	getback(pre, mid, back, 0, 8, 0, 8);
	for (int i = 0; i < 9; i++)
	    System.out.println(back[i]);

    }

    public static int find(int mid[], int root, int ml, int mr) {
	for (int i = ml; i <= mr; i++) {
	    if (mid[i] == root)
		return i;
	}
	return -1;
    }

    public static boolean getback(int pre[], int mid[], int back[], int pl,
	    int pr, int ml, int mr) {
	int root = pre[pl];
	int rootindex = find(mid, root, ml, mr);
	back[p--] = root;
	if (pr-(mr - rootindex)+1 >= 0 && rootindex + 1 <= mr)
	  //first right tree,mr - rootindex num of right node
	    getback(pre, mid, back, pr-(mr - rootindex)+1, pr, rootindex + 1, mr);
	if (pl + 1 <= pr-(mr - rootindex) && ml <= rootindex - 1)
	  //second left tree
	    getback(pre, mid, back, pl + 1,  pr-(mr - rootindex), ml, rootindex - 1);
	return true;

    }
}