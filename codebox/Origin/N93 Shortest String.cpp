//哈密尔顿回路法，kmp
#include<iostream>
#include<algorithm>
using namespace std;
char q[1200000],p[1200000];
int inext[1200000];
void getnext(){
	int len=strlen(q),i,j,k=0,l;
	inext[1]=0;
	for (l=2;l<=len;l++){
		while (k>0&&q[k]!=q[l-1])
			k=inext[k];
		if (q[k]==q[l-1]){
			k++;
		}
		inext[l]=k;
	}
}
int kmp(){
	int ans=0,i,n=strlen(p),m=strlen(q),l=0;
	getnext();
	for (i=0;i<n;i++){
		while (l>0&&p[i]!=q[l]){
			l=inext[l];
		}
		if (q[l]==p[i])
			l++;
		if (l==m){
			ans++;
			return 1;
			l=inext[l];
		}
	}
	return ans;
}
string ss[16],s[16];
char str[310000];
int dp[1<<16][16];
int a[16][16];
bool cmp(const string &x,const string &y){
	return x.length()<y.length();
}
int main(){
#ifdef _DEBUG
	freopen("data","r",stdin);
#endif 
	int i,j,k,n;
	while (scanf("%d",&n)!=EOF){
		int sum=0;
		for (i=0;i<n;i++){
			scanf("%s",str);
			ss[i]=(string)str;
		}
		sort(ss,ss+n,cmp);
		int pp=0;
		for (i=0;i<n;i++){//遍历一遍所有的组合，将能被包含的子串踢出
			for (j=i+1;j<n;j++){
				strcpy(q,ss[i].c_str());
				strcpy(p,ss[j].c_str());
				if (kmp())
					break;
			}
			if (j==n)
				s[pp++]=ss[i];//剔除已经有的子串
		}
		n=pp;
		for (i=0;i<n;i++){
			sum+=(int)s[i].length();
		}
		for (i=0;i<n;i++){//获得数组组合能约减数//             acd   cdb   abac
		                                     //        acd      0     2     0
			for (j=0;j<n;j++){               //        cdb      0     0     0
			                                 //       abac      2     1     0
				if (i==j)                    //      acdabac 求得最后c的next，即得abac acd 能减少两个 ！！！
					a[i][j]=0;
				else{
					strcpy(q,s[j].c_str());
					strcat(q,s[i].c_str());
					int l=strlen(q);
					getnext();
					a[i][j]=inext[l];//获得next数组关于q的
				}
			}
		}


		memset(dp,0,sizeof(dp));
		for (i=0;i<n;i++){
			dp[1<<i][i]=0;
		}
		for (i=0;i<(1<<n);i++){//从1到111，有几个字符串已加入的状态
			for (j=0;j<n;j++){
				if (i&(1<<j)){//j这个字符串是否已加入
					for (k=0;k<n;k++){
						if ((i&(1<<k)))//k字符串已加入则跳过
							continue;
						dp[i|(1<<k)][k]=max(dp[i|(1<<k)][k],dp[i][j]+a[j][k]);//在j结尾的字符串后，加入以K作为结尾的字符串。
					}
				}
			}
		}
		int ans=0;
		for (i=0;i<n;i++){
			ans=max(ans,dp[(1<<n)-1][i]);
		}
		printf("%d\n",sum-ans);
	}
#ifdef _DEBUG
	freopen("CON","r",stdin);
	system("pause");
#endif
	return 0;
}

