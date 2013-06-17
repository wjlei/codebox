package main1;

public class Convert_Sorted_List_to_Binary_Search_Tree {
	TreeNode solve(ListNode head,int l,int r){
		if(l>r)
			return null;
		int mid=l+(r-l)/2;
		ListNode cur=head;
		for(int i=l;i<mid;i++)
			cur=cur.next;
		TreeNode root=new TreeNode(cur.val);
		root.left=solve(head,l,mid-1);
		root.right=solve(cur.next,mid+1,r);
		return root;
	}
    public TreeNode sortedListToBST(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	ListNode cur=head;
    	int len=0;
    	while(cur!=null){
    		cur=cur.next;
    		len++;
    	}
    	return solve(head,0,len-1);
    }

}
