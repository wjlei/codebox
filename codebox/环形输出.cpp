#include<iostream>
#include<stdio.h>
#include<math.h>
#define len 4
using namespace std;
int matrix[10][10];
int main(){
  freopen("data","r",stdin);
  int ctimes=ceil(len/2);
  for(int i=0;i<len;i++)
    for(int j=0;j<len;j++)
      cin>>matrix[i][j];
  freopen("CON","r",stdin);
  for(int i=0;i<ctimes;i++){
    for(int j=i;j<len-i;j++)
      cout<<matrix[i][j]<<" ";
    for(int j=i+1;j<len-i;j++)
      cout<<matrix[j][len-i-1]<<" ";
    for(int j=len-i-1-1;j>=i;j--)
      cout<<matrix[len-i-1][j]<<" ";
    for(int j=len-i-1-1;j>i;j--)
      cout<<matrix[j][i]<<" ";
  }
  cout<<endl;
  return 0;




}
