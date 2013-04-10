#include<iostream>
#include<stdio.h>
#include<vector>
#include<string>
using namespace std;
typedef struct node{
  string a;
  string b;
}node;
int main(){
#ifdef _DEBUG
  freopen("data","r",stdin);
#endif
  int T;
  int c=0;
  cin>>T;
  while(T--){
    vector<node> cache;
    vector<string> l;
    int n,m;
    cin>>n>>m;
    for(int i=0;i<m;i++){
      node temp;
      cin>>temp.a>>temp.b;
      cache.push_back(temp);
    }
    getchar();
    string line;
    getline(cin,line);
    string temp;
    for(int i=0;i<line.size();i++){
      if(line[i]!=' ')
	temp+=line[i];
      else{
	l.push_back(temp);
	temp="";
      }
    }
    if(temp.size()>0){
      l.push_back(temp);
      temp="";
    }
    for(int i=0;i<l.size();i++){
      for(int k=0;k<n-1;k++){
	for(int j=0;j<cache.size();j++){
	  if(l[i]==cache[j].a){
	    l[i]=cache[j].b;
	    break;
	  }
	}
      }
    }
    cout<<"Case #"<<++c<<": ";
    for(int i=0;i<l.size();i++){
      if(i==0)
	cout<<l[i];
      else
	cout<<" "<<l[i];
    }
    cout<<endl;
  }
#ifdef _DEBUG
  freopen("CON","r",stdin);
  system("pause");
#endif
  return 1;
}
