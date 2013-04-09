#include<iostream>
#include<stdio.h>
#include<math.h>
using namespace std;
int dp[3000];
void makedp(){
  for(int i=1;i<=2000;i++){
    dp[i]=i;
  }
  for(int i=2;i<=2000;i++){
    dp[i]=min(dp[i],dp[i-1]+1);
    for(int j=1;j<i;j++){
      int temp=ceil(1.0*i/j);
      dp[i]=min(dp[i],dp[j]+1+temp-1+temp*j-i);
    }
  }
}
int main(){
#ifdef _DEBUG
	freopen("data","r",stdin);
#endif
  int n;
  makedp();
  while(cin>>n){
    printf("%d\n",dp[n]);
  }
#ifdef _DEBUG
	freopen("CON","r",stdin);
	system("pause");
#endif
  return 1;
}
