void insertion(int a[],int L,int R){
  for(int i=R;i>L;i--){// since i-1,so i>L get the min to a[0]
    if(a[i]<a[i-1])
      swap(a[i-1],a[i]);
  }
  for(int i=L+2;i<=R;i++){
    int j;
    int v=a[i];
    for(j=i;a[j-1]>v;j--){//since the min at the a[0], limit isn't need
      a[j]=a[j-1];
    }
    a[j]=v;
  }
}
void shellsort(int a[],int L,int R){
  int h;
  for(h=1;h<=(R-L)/9;h=3*h+1);
  for(;h>0;h/=3){
    for(int i=L+h;i<=R;i++){//insert sort
      int j; int v=a[i];
      for(j=i;j>=L+h&&a[j-h]>v;j-=h){//no min,so need j>=L+h
	a[j]=a[j-h];
      }
      a[j]=v;
    }
  }
}
//关键字索引统计 稳定
void distcount(int a[],int L,int R){
  int cnt[M];//for hash
  int b[maxN];//for cache
  for(int j=0;j<M;j++)
    cnt[j]=0;
  for(int i=L;i<=R;i++)
    cnt[a[i]+1]++;//make the key word+1 ex. 2,count at cnt[3]
  for(int j=1;j<M;j++)
    cnt[j]+=cnt[j-1];
  for(int i=L;i<=R;i++)
    b[cnt[a[i]]++]=a[i];//since cnt[a[i]+1], so cnt[a[i]] is the rank start cnt[a[i]+1] is the rank end;
  for(int i=L;i<=R;i++)
    a[i]=b[i-L];//copy back
}
