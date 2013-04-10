#include<iostream>
#include<stack>
using namespace std;
class node{
public:
  node(int in){
    left=NULL;
    right=NULL;
    m=in;
  }
public:
  int m;
  node *left;
  node *right;
};
void midsearch(node *root){
  if(root==NULL)
    return ;
  stack<node*> st;
  st.push(root);
  while(st.size()>0){
    while(root->left!=NULL){
      st.push(root->left);
      root=root->left;
    }
    while(st.size()>0){
      root=st.top();
      st.pop();
      cout<<root->m<<" ";
      if(root->right!=NULL){
	root=root->right;
	st.push(root);
	break;
      }
    }
  }
}
void midsearch(node *root){
  if(root==NULL)
    return ;
  stack<node*> st;
  while(root!=NULL||st.size()>0){
    if(root!=NULL){
      st.push(root);
      root=root->left;
    }
    else{
      root=st.top();
      st.pop();
      cout<<root->m<<" ";
      root=root->right;
    }
  }
}
void midsearchrc(node *root){
  if(root==NULL)
    return ;
  if(root->left!=NULL){
    midsearchrc(root->left);
  }
  cout<<root->m<<" ";
  if(root->right!=NULL){
    midsearchrc(root->right);
  }
}
int main(){
  node *root=NULL;
  root=new node(1);
  root->left=new node(2);
  root->right=new node(3);
  root->left->left=new node(4);
  root->left->right=new node(5);
  root->right->left=new node(6);
  root->right->right=new node(7);
  midsearch(root);
  cout<<endl;
  midsearchrc(root);
  cout<<endl;
  system("pause");
  return 1;
}
