#include<iostream>
using namespace std;
typedef struct node{
  int num;
  struct node*next;
}node;
// 1->2->3->4
// |  |  |  |
// c  l  |  |
// P     c  l
node*doublereverse(node*head){
  if(head==NULL||head->next==NULL)
    return head;
  node*pre=NULL;
  node*cur=head;
  node*last=head->next;
  head=head->next;
  while(cur!=NULL&&last!=NULL){
    if(pre!=NULL)
      pre->next=last;
    cur->next=last->next;
    last->next=cur;
    pre=cur;
    cur=cur->next;
    if(last->next->next==NULL)
      break;
    last=last->next->next->next;//!
  }
  return head;

}
int main(){
  node head,p1,p2,p3,p4;
  head.num=1;
  head.next=&p1;
  p1.num=2;
  p1.next=NULL;
  p1.next=&p2;
  p2.num=3;
  p2.next=&p3;
  //p2.next=NULL;
  p3.num=4;
  //	p3.next=NULL;
  p3.next=&p4;
  p4.num=5;
  p4.next=NULL;
  node*temp;
  temp=doublereverse(&head);
  while(temp!=NULL){
    cout<<temp->num<<endl;
    temp=temp->next;
  }
  system("pause");
  return 1;
}
