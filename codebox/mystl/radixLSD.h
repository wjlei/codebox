//二进制快速排序
//digit(a[i],w) a[i]从左开始第w位为1或0
void quicksortB(int a[],int L,int R,int w){
  int i=L,j=R;
  if(R<=L||w>maxwordlen)
    return;
  while(j!=i){
    while(digit(a[i],w)==0&&(i<j))//find 1
      i++;
    while(digit(a[j],w)==1&&(j>i))//find 0
      j--;
    swap(a[i],a[j]);//swap 0,1
  }
  if(digit(a[r],w)==0)//check all 0 state
    j++;
  quicksortB(a,L,j-1,w+1);//so sort 0
  quicksortB(a,j,R,w+1);//sort 1
}
void radixLSD(int a[],int L,int R){
  int cnt[M];
  int b[maxN];//for cache
  for(int w=maxwordlen-1;w>=0;w--){
    for(int j=0;j<M;j++)//关键字索引统计
      cnt[j]=0;
    for(int i=L;i<=R;i++)
      cnt[digit(a[i],w)+1]++;
    for(int j=1;j<M;j++)
      cnt[j]+=cnt[j-1];
    for(int i=L;i<=R;i++)
      b[cnt[digit(a[i],w)]++]=a[i];
    for(int i=L;i<=R;i++)
      a[i]=b[i-L];
  }
}
