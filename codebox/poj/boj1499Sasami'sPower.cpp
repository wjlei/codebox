#include<iostream>
#include<math.h>
#include<limits>
using namespace std;
int num[200000];
struct node{
  double l;
  double r;
}rag[200000];
int main(){
#ifdef _DEBUG
  freopen("data","r",stdin);
#endif
  int T;
  cin>>T;
  while(T--){
    int n;
    scanf("%d",&n);
    for(int i=0;i<n;i++){
      scanf("%d",&num[i]);
    }
    rag[0].l=num[0]-num[1]*0.5; ;
    rag[0].r=1.0*num[0]/2;
    for(int i=1;i<n;i++){
      rag[i].l=max(1.0*num[i-1]/2,1.0*num[i-1]-rag[i-1].r);
      rag[i].r=min(1.0*num[i]/2,1.0*num[i-1]-rag[i-1].l);
    }
    rag[n].l=max(1.0*num[n-1]/2,1.0*num[n-1]-rag[n-1].r);
    rag[n].r=num[n-1]-rag[n-1].l;
    int imin=INT_MAX;
    for(int i=0;i<=n;i++){
      int temp;
      temp=floor(rag[i].r)-ceil(rag[i].l)+1;
      imin=min(imin,temp);
    }
    printf("%d\n",max(imin,0));
  }
#ifdef _DEBUG
  freopen("CON","r",stdin);
  system("pause");
#endif
  return 1;
}
