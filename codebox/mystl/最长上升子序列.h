int bsearch(int x,int size, int num[]){
	if(x>num[size-1])
		return size;
	int l=0;int r=size-1;
	while(l<=r){
		int mid=(l+r)/2;
		if(x==num[mid])
			return mid;
		else if(x>num[mid])
			l=mid+1;
		else if(x<num[mid])
			r=mid-1;
	}
	return l;
}
void print(int num[],int path[],int level,int start){
  if(level==0)
    return ;
  int i=start;
  while(b[i]!=level)
    i--;
  print(num,path,level-1,i-1);
  cout<<a[i]<<endl;
}
int getlongestsubstring(int num[],int size){
	int longest=1;
	int path[max_len];//trace the num[i] get location P
	int cache[max_len];//dp
	cache[0]=num[0];
	path[0]=1;
	for(int i=1;i<size;i++){
		int p=bsearch(num[i],longest,cache);
		cache[p]=num[i];
		b[i]=p;
		if(p>longest-1){
			longest++;
		}

	}
	print(num,path,longest,size-1);
	return longest;
}
///编程之美原题
//int LIS(int num[],int size){
//	int maxv[100];
//	maxv[1]=num[0];
//	int LIS[100];
//	for(int i=0;i<size;i++)
//		LIS[i]=1;
//	int nMaxLIS=1;
//	for(int i=1;i<size;i++)
//	{
//		int j;
//		for(j=nMaxLIS;j>=0;j--){
//			if(num[i]>maxv[j]){
//				LIS[i]=j+1;
//				break;
//			}
//		}
//		if(LIS[i]>nMaxLIS){
//			nMaxLIS=LIS[i];
//			maxv[LIS[i]]=num[i];
//		}
//		else if(maxv[j]<num[i]&&num[i]<maxv[j+1]){
//			maxv[j+1]=num[i];
//		}
//	}
//	return nMaxLIS;
//}
