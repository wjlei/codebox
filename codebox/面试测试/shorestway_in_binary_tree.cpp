#include<iostream>
#include<string>
#include<vector>
#include <algorithm>
using namespace std;
class node{
public:
  node(int in){
    val=in;
    left=NULL;
    right=NULL;
  }
public:
  int val;
  node*left;
  node*right;
};
int get=0;
int findtheshortest(node*root,node*p1,node*p2){
  if(root==NULL)
    return -1;
  int leftdis=findtheshortest(root->left,p1,p2);
  int rightdis=findtheshortest(root->right,p1,p2);
  if(root==p1||root==p2){
    if(leftdis<0&&rightdis<0){
      return 1;
    }
    else if((leftdis>=0&&rightdis<0)||(leftdis<0&&rightdis>=0)){
      get=1; 
      return leftdis>=0?leftdis:rightdis;
    }
  }
  else if(get==1)
    return leftdis>=0?leftdis:rightdis;
  else{
    if(leftdis<0&&rightdis<0)
      return -1;
    else if(leftdis>=0&&rightdis>=0){
      get=1; 
      return leftdis+rightdis;
    }
    else
      return leftdis>=0?leftdis+1:rightdis+1;
  }

}

int main(){
  node node1(1),node2(2),node3(3),node4(4),node5(5),node6(6),node7(7),node8(8),node9(9),node10(10),node11(11),node12(12),node13(13),node14(14),node15(15);
  node8.left=&node4;node8.right=&node12;
  node4.left=&node2;node4.right=&node6;node12.left=&node10;node12.right=&node14;
  node2.left=&node1;node2.right=&node3;node6.left=&node5;node6.right=&node7;node10.left=&node9;node10.right=&node11;node14.left=&node13;node14.right=&node15;
  cout<<findtheshortest(&node8,&node3,&node4)<<endl;


  system("pause");
  return 1;
}
