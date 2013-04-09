#include<iostream>
using namespace std;
int num[]={0,1,5,7,8,9,6,3,11,20,17};
int isok[12][44]={0};
int main(){
  isok[0][0]=1;
  int n=5;
  for(int k=1;k<=2*n;k++){
    for(int i=min(k,n);i>=1;i--){
      for(int v=1;v<=87/2;v++){
	if(v>=num[k]&&isok[i-1][v-num[k]]){
	  isok[i][v]=1;
	}
      }
    }
    cout<<"----------------------------------"<<endl;
    for(int i=0;i<12;i++){
      for(int j=0;j<44;j++){
	cout<<isok[i][j]<<" ";
      }
      cout<<endl;
    }
  }
  return 0;
}
