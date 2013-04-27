#include<iostream>
#include<string.h>
#include<vector>
#include <algorithm>
using namespace std;
int dp[4][10000];
int offset=5000;
int dp24(int num[]){
  memset(dp,0,sizeof(dp));
  for(int i=0;i<4;i++){
    for(int j=i;j>=0;j--){
      if(j==0)
	dp[j][num[i]+offset]=1;
      else{
	//a+b a-b b-a a*b a/b b/a
	for(int k=0;k<10000;k++){
	  if(dp[j-1][k]==1){
	    int a=k-offset;
	    int b=num[i];
	    int c;
	    c=a+b;
	    dp[j][c+offset]=1;
	    c=a-b;
	    dp[j][c+offset]=1;
	    c=b-a;
	    dp[j][c+offset]=1;
	    c=a*b;
	    dp[j][c+offset]=1;
	    if(b!=0){
	      c=a/b;
	      dp[j][c+offset]=1;
	    }
	    if(a!=0){
	      c=b/a;
	      dp[j][c+offset]=1;
	    }
	  }
	}
      }
    }

  }
  return dp[3][24+offset];
}
int main(){
  int num[]={1,4,8,1};
  cout<<dp24(num)<<endl;
  /*for(int i=0;i<4;i++){
    for(int j=0;j<10000;j++){
    if(dp[i][j]==1)
    cout<<j-offset<<"  ";
    }
    cout<<endl;
    }*/
  system("pause");
  return 1;
}
