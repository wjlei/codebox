#include<iostream>
using namespace std;
typedef struct node{
  int x;
  int y;
  int h;
}node;
node line[10000+100];
int map[110][110];
int dp[110][110];
int compare (const void * a, const void * b)
{
  return (((node*)b)->h-((node*)a)->h);
}
int main(){
#ifdef _DEBUG
  freopen("data","r",stdin);
#endif
  int m,n;
  int count=0;
  cin>>m>>n;
  for(int i=0;i<m;i++){
    for(int j=0;j<n;j++){
      dp[i][j]=1;
      cin>>map[i][j];
      line[count].x=j;
      line[count].y=i;
      line[count++].h=map[i][j];
    }
  }
  qsort(line,count,sizeof(node),compare);
  for(int i=0;i<count-1;i++){
    if(line[i].y-1>=0&&map[line[i].y][line[i].x]>map[line[i].y-1][line[i].x]&&dp[line[i].y][line[i].x]+1>dp[line[i].y-1][line[i].x])
      dp[line[i].y-1][line[i].x]=dp[line[i].y][line[i].x]+1;
    if(line[i].y+1<m&&map[line[i].y][line[i].x]>map[line[i].y+1][line[i].x]&&dp[line[i].y][line[i].x]+1>dp[line[i].y+1][line[i].x])
      dp[line[i].y+1][line[i].x]=dp[line[i].y][line[i].x]+1;
    if(line[i].x-1>=0&&map[line[i].y][line[i].x]>map[line[i].y][line[i].x-1]&&dp[line[i].y][line[i].x]+1>dp[line[i].y][line[i].x-1])
      dp[line[i].y][line[i].x-1]=dp[line[i].y][line[i].x]+1;
    if(line[i].x+1<n&&map[line[i].y][line[i].x]>map[line[i].y][line[i].x+1]&&dp[line[i].y][line[i].x]+1>dp[line[i].y][line[i].x+1])
      dp[line[i].y][line[i].x+1]=dp[line[i].y][line[i].x]+1;
  }
  int imax=0;
  for(int i=0;i<m;i++){
    for(int j=0;j<n;j++){
      imax=max(imax,dp[i][j]);
    }
  }
  cout<<imax<<endl;
#ifdef _DEBUG
  freopen("CON","r",stdin);
  system("pause");
#endif
  return 1;
}
