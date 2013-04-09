#include<iostream>
#include<algorithm>
using namespace std;
struct node{
  int x,y,flag,id;
  bool operator < (const struct node & P) const{
    return x<P.x||(x==P.x&&flag<P.flag);
  };
}num[200020];
int pos[200020];
int y[200020];
int main(){
#ifdef _DEBUG
  freopen("data","r",stdin);
#endif
  int n;
  cin>>n;
  while(n--){
    int a;
    scanf("%d",&a);
    for(int i=0;i<a;i++){
      scanf("%d %d",&num[2*i].x,&num[2*i].y);
      scanf("%d %d",&num[2*i+1].x,&num[2*i+1].y);
      num[2*i].flag=0;
      num[2*i+1].flag=1;
      num[2*i].id=num[2*i+1].id=i;
    }
    //从已有的序列，先占位再更新
    sort(num,num+a*2);//将X排序
    int cnt=0;
    for(int i=0;i<2*a;i++){
      if(num[i].flag==0)
	pos[num[i].id]=lower_bound(y+1,y+1+cnt,num[i].y)-y;//用左下点占位
      else{
	int tp=pos[num[i].id];
	if(tp>cnt)
	  y[++cnt]=num[i].y;//扩张
	else
	  y[tp]=min(num[i].y,y[tp]);//更新原来的位置
      }
    }
    printf("%d\n",cnt);
  }
#ifdef _DEBUG
  freopen("CON","r",stdin);
  system("pause");
#endif
  return 0;
}
