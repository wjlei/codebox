#include<iostream>
#include<stdio.h>
#include<string>
using namespace std;
class node{
public:
	node(char in){
		for(int i=0;i<100;i++)
			next[i]=NULL;
		count=0;
		m=in;
	}
	char m;
	class node* next[100];
	int count;
};
void maketree(node *&root,string ss){

	if(ss.size()==0)
		return;
	if(root==NULL){
		root=new node('*');
	}
	node *temp=root;
	for(int si=0;si<ss.size();si++){
		if(temp->next[ss[si]-'a']==NULL){
			temp->next[ss[si]-'a']=new node(ss[si]);
			temp->next[ss[si]-'a']->count++;
		}
		else{
			temp->next[ss[si]-'a']->count++;
		}
		temp= temp->next[ss[si]-'a'];
	}
}
void printout(node *&root,string s){
	if(root==NULL)
		return ;
	node * temp=root;
	for(int i=0;i<s.size();i++){
		if(temp->next[s[i]-'a']->count==1){
			cout<<temp->next[s[i]-'a']->m;
			break;
		}
		if(temp->next[s[i]-'a']!=NULL){
			cout<<temp->next[s[i]-'a']->m;
			temp=temp->next[s[i]-'a'];
		}
	}
	cout<<endl;
}
int main(){
	//freopen("data","r",stdin);
	string s;
	string ss[1000];
	int kk=0;
	node* root=NULL;
	while(cin>>s){
	//	cout<<s<<endl;
		maketree(root,s);
		ss[kk++]=s;
	}
	for(int i=0;i<kk;i++){
		cout<<ss[i]<<" ";
		printout(root,ss[i]);
	}
	//getchar();
	return 0;
}
