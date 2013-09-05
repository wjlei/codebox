package prepare;
class node{
	node(int in){
		value=in;
		next=null;
	}
	int value;
	node next;
}
//1->2->3->4->5 ==>5->3->4->1->2
public class reverse_in_group2 {
	
static 	node reverseingroup(node head,int m){
		if(head==null||head.next==null||m<=0)
			return head;
		node pre=null;
		node cur=head;
		node last=head;node plast=null;
		while(last!=null){
			for(int i=0;i<m;i++){
				if(last==null)
					break;
				plast=last;
				last=last.next;
			}
			plast.next=pre;
			pre=cur;
			if(last!=null)
				cur=last;
		}
		return cur;
	}
	public static void main(String args[]){
		node cur=new node(1);
		node head=cur;
		cur.next=new node(2);
		cur=cur.next;
		cur.next=new node(3);
		cur=cur.next;
		cur.next=new node(4);
		cur=cur.next;
		cur.next=new node(5);
		cur=cur.next;
		cur.next=new node(6);
		node ans=reverseingroup(head,3);
		while(ans!=null){
			System.out.println(ans.value);
			ans=ans.next;
		}
	}
	

}
