//进程调度
//堆优化
#include<iostream>
#include<stdio.h>
using namespace std;
typedef struct node{
  int a;
  int b;
}node;
node num[100000+10]; 
int compare (const void * a, const void * b)
{
  return (((node*)a)->b-((node*)b)->b);
}
void shift_up(int dsize){
  int i=dsize-1;
  while(i>=0){
    if(num[(i-1)/2].a<num[i].a)
      swap(num[(i-1)/2],num[i]);
    else
      break;
    i=(i-1)/2;
  }
}
void shift_down(int dsize){
  int i=0;
  while((i+1)*2-1<=dsize-1){
    if((i+1)*2<=dsize-1){
      if(num[(i+1)*2].a<num[(i+1)*2-1].a)
	i=(i+1)*2-1;
      else
	i=(i+1)*2;
    }
    else
      i=(i+1)*2-1;
    if(num[(i-1)/2].a<num[i].a)
      swap(num[(i-1)/2],num[i]);
    else
      break;
  }
}
void insert(int& dsize,int loc){
  dsize++;
  num[dsize-1]=num[loc-1];
  shift_up(dsize);
}
void del(int&dsize){
  swap(num[0],num[dsize-1]);
  dsize--;
  shift_down(dsize);
}
int main(){
#ifdef _DEBUG
  freopen("data","r",stdin);
#endif
  int T;
  cin>>T;
  while(T--){
    long long m;
    int n,Ta,Tb;
    scanf("%d %lld",&n,&m);
    scanf("%d %d",&Ta,&Tb);
    for(int i=0;i<n-1;i++){
      scanf("%d %d",&num[i].a,&num[i].b);
    }
    qsort(num,n-1,sizeof(node),compare);
    int count=0,isout=0;
    int loc=0,dsize=0;
    for(int i=0;i<n-1;i++){
      for(int j=loc;j<n-1;j++){
	if(num[j].b<=m){
	  loc++;
	  insert(dsize,loc);
	}
	else
	  break;
      }
      if(dsize>0){
	m+=num[0].a;
	del(dsize);
      }
      else{
	isout=1;
	cout<<-1<<endl;
	break;
      }
      count++;
      if(m>=Tb){
	isout=1;
	cout<<count<<endl;
	break;
      }
    }
    if(!isout)
      cout<<-1<<endl;
  }
#ifdef _DEBUG
  freopen("CON","r",stdin);
  system("pause");
#endif
  return 1;
}
