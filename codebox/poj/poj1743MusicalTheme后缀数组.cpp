//后缀数组   LCP  不重叠  最长重复字串
//x rank排序 sa 中间缓存
#include <cstdio>
#include <cstring>
#include<iostream>
#define maxn 50
int n,a[maxn],ws[maxn],wa[maxn],wb[maxn],wv[maxn],rank[maxn],hei[maxn];
int cmp(int *r,int a,int b,int l){
   return (r[a] == r[b] && r[a + l] == r[b + l]);
}
void DA(int r[],int sa[],int n,int m){
   int i,j,p,*x = wa,*y = wb,*t;
   for (i = 0;i < m;i ++) 
	   ws[i] = 0;
   for (i = 0;i < n;i ++) 
	   ws[x[i] = r[i]] ++;//hash单个字符统计
   for (i = 1;i < m;i ++) 
	   ws[i] += ws[i - 1];//前序累加，相当于区分排名
   for (i = n - 1;i >= 0;i --)
	   sa[-- ws[x[i]]] = i;//相当于瓜分排名 1瓜分前六
   for (p = 1,j = 1;p < n;j *= 2,m = p){//j 步长
	   for (p = 0,i = n - j;i < n;i ++) 
		   y[p ++] = i;
	   for(int i=0;i<n;i++){
		   std::cout<<sa[i]<<" ";//
	   }
	   std::cout<<std::endl;
	   for (i = 0;i < n;i ++) 
		   if (sa[i] >= j) 
			   y[p ++] = sa[i] - j;
       for (i = 0;i < n;i ++) wv[i] = x[y[i]];
	   for(int i=0;i<n;i++){
		   std::cout<<wv[i]<<" ";//
	   }
	   std::cout<<std::endl;
       for (i = 0;i < m;i ++) ws[i] = 0;
       for (i = 0;i < n;i ++) ws[wv[i]] ++;
       for (i = 1;i < m;i ++) ws[i] += ws[i - 1];
       for (i = n - 1;i >= 0;i --) sa[-- ws[wv[i]]] = y[i];
	   for(int i=0;i<n;i++){
		   std::cout<<sa[i]<<" ";//
	   }
	   std::cout<<std::endl;
       for (t = x,x = y,y = t,p = 1,x[sa[0]] = 0,i = 1;i < n;i ++)
           x[sa[i]] = cmp(y,sa[i - 1],sa[i],j) ? p - 1 : p ++;
	   for(int i=0;i<n;i++){
		   std::cout<<x[i]<<" ";//
	   }
	   std::cout<<std::endl;
   }
}
void Height(int *r,int *sa,int n){
   int i,j,k = 0;
   for (i = 1;i < n;i ++) rank[sa[i]] = i;
   for (i = 0;i < n;hei[rank[i ++]] = k)
       for (k ? k -- : 0,j = sa[rank[i] - 1];r[i + k] == r[j + k];k ++);
}
int can(int k,int sa[]){
   int maxx,minx,la = sa[0];
   for (int i = 1;i < n;){
       maxx = minx = la;
       for (;hei[i] >= k && i < n;i ++){
           if (sa[i] > maxx) maxx = sa[i];
           if (sa[i] < minx) minx = sa[i];
       }
       if (maxx - minx >= k) return 1;
       for (;hei[i] < k && i < n;i ++);
       la = sa[i - 1];
   }
   return 0;
}
int main(){
	int r[maxn],sa[maxn];
#ifdef _DEBUG
	freopen("data","r",stdin);
#endif
   while(scanf("%d",&n),n != 0){
       memset(sa,0,sizeof sa);
  //     for (int i = 0;i < n;i ++) scanf("%d",&a[i]);
	    for (int i = 0;i < n;i ++) scanf("%d",&r[i]);
   //    r[0] = 199;
     //  for (int i = 1;i < n;i ++) r[i] = a[i] - a[i - 1] + 90;
  //     r[n ++] = 0;
       DA(r,sa,n,10);
       Height(r,sa,n);
       int l = 0,r = n,mid,flg;
       while(l < r - 1){
           mid = l + r >> 1;
           flg = can(mid,sa);
           if (flg) l = mid;
           else r = mid;
       }
       if (l >= 4) printf("%d\n",l + 1);
       else printf("0\n");
   }
#ifdef _DEBUG
	freopen("CON","r",stdin);
	system("pause");
#endif
   return 0;
}