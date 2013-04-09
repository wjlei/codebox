#include<iostream>
#include<stdio.h>
#define MAXINT 0x1fffffff
using namespace std;
int dp[1000][1000];
int main(){
#ifdef _DEBUG
  freopen("data","r",stdin);
#endif
  int T;
  cin>>T;
  while(T--){
    int isout=0;
    int n,k,d,s;
    int pre=0;
    scanf("%d %d %d %d",&n,&k,&d,&s);
    for(int i=0;i<=k;i++){
      for(int j=0;j<=n;j++){
	dp[i][j]=MAXINT;
      }
    }
    dp[0][n]=0;//初始只能是剩下n个人。
    for(int i=1;i<=k;i++){
      int time,z;
      scanf("%d %d",&time,&z);
      if(time>s){
	if(dp[i][0]==MAXINT)
	  printf("impossible\n");
	else
	  printf("%d\n",dp[i][0]);
	isout=1;
	break;
      }
      for(int j=0;j<=n;j++){
	int carpay=0;
	for(int l=0;l<=z&&j+l<=n;l++){
	  if(l>=1)
	    carpay=d;
	  dp[i][j]=min(dp[i][j],dp[i-1][j+l]+(j+l)*(time-pre)+carpay);
	}

      }
      pre=time;
    }
    if(!isout){
      if(dp[k][0]==MAXINT)
	printf("impossible\n");
      else
	printf("%d\n",dp[k][0]);
    }
  }
#ifdef _DEBUG
  freopen("CON","r",stdin);
  system("pause");
#endif
  return 1;
}
