#include<iostream>
#include<string>
#include<stack>
#include<stdio.h>
using namespace std;
int matrix[200][200];
void pl(string s1[],string s2[],int n1,int n2){
	for(int i=0;i<=n1;i++){
		for(int j=0;j<=n2;j++){
			matrix[i][j]=0;
		}
	}
	for(int i=1;i<=n1;i++){
		for(int j=1;j<=n2;j++){
			if(s1[i-1]==s2[j-1])
				matrix[i][j]=matrix[i-1][j-1]+1;
			else
				matrix[i][j]=max(matrix[i-1][j],matrix[i][j-1]);
		}
	}
	int ii=n1,jj=n2;
	stack<string> st;
	int first=0;
	while(ii>0&&jj>0){
		if(s1[ii-1]==s2[jj-1]){
			st.push(s1[ii-1]);
			ii--;jj--;
		}
		else if(matrix[ii-1][jj]>matrix[ii][jj-1])
			ii--;
		else
			jj--;
	}
	while(st.size()>0){
		if(first==0){
			cout<<st.top();
			st.pop();
			first=1;
		}
		else{
			cout<<" "<<st.top();
			st.pop();
		}
	}
	cout<<endl;
}
int main(){
//	freopen("data","r",stdin);
	string s1[200],s2[200],ss;
	int n1=0,n2=0,l=0;
	while(cin>>ss){
		if(ss=="#"){
			if(l==1){
				pl(s1,s2,n1,n2);
				n1=0;n2=0;
			}
			l=(l+1)%2;
			continue;
		}
		if(l==0)
			s1[n1++]=ss;
		else
			s2[n2++]=ss;
	}
//	freopen("CON","r",stdin);
//	system("pause");
	return 1;

}
