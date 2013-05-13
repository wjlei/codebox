package main;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}

public class Add_Two_Numbers {
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int c = 0;
		ListNode p1 = l1, p2 = l2,ans=new ListNode(-1),ansh=ans;
		while (p1 != null && p2 != null) {
			int num = p1.val + p2.val+c;
			c = num / 10;
			num = num % 10;
			ans.next =new ListNode(num);
			ans=ans.next;
			p1=p1.next;p2=p2.next;
		}
		if(p1==null){
			while (p2 != null) {
				int num = c + p2.val;
				c = num / 10;
				num = num % 10;
				ans.next = new ListNode(num);
				ans=ans.next;
				p2=p2.next;
			}
		}
		else if(p2==null){
			while (p1 != null) {
				int num = c + p1.val;
				c = num / 10;
				num = num % 10;
				ans.next = new ListNode(num);
				ans=ans.next;
				p1=p1.next;
			}
		}
		if(c!=0){
			ans.next = new ListNode(c);
		}
		return ansh.next;

	}
	public static void main(String args[]){
		ListNode l1=new ListNode(5);	
		ListNode l2=new ListNode(5);
		ListNode kk=addTwoNumbers(l1,l2);	
		for(ListNode mm=kk;mm!=null;mm=mm.next){
			System.out.println(mm.val);
		}
		
	}
	

}
