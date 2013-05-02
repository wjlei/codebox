#include<iostream>
#include<string>
using namespace std;
//矩阵链乘法
int getMinCost(int a[], int n){ 
	if (NULL == a || n <= 1) 
		return -1; 
	int rec[100][100] = {0};
	for (int i = 2; i < n; i++){ 
		for (int j = 0; j < n-i; j++){ 
			int nMin = INT_MAX; 
			for (int k = 1; k < i; k++) {
				nMin=min(nMin,rec[j][j+k]+rec[j+k][j+i]+a[j+i]-a[j]); 
			}
			rec[j][j+i] = nMin; 
		} 
	} 
	return rec[0][n-1]; 
}
//汉密尔顿回路
int getpay(int i,int j,int a[],int n){
	int k1,k2;
	for(k1=j;k1>=0;k1--){//找到右切点
		if((i&(1<<k1))!=0)
			break;
	}
	for(k2=j;k2<=n-3;k2++){//找到左切点
		if((i&(1<<k2))!=0)
			break;
	}
	return a[k2+1]-a[k1+1];
}
int getMinCost(int a[], int n){ 
	if (NULL == a || n <= 1) 
		return -1; 
	int dp[100] ;
	for(int i=0;i<100;i++){
		dp[i]=99;
	}
	dp[0]=0;
	int end=(1<<(n-2));
	for (int i = 0; i <end; i++){ 
		for (int j = 0; j <= n-3; j++){ 
			int rr=1<<j;
			if((i&rr)==0){
				dp[i|(1<<j)]=min(dp[i|(1<<j)],dp[i]+getpay(i,j,a,n));
			}
		} 
	} 
	return dp[end-1]; 
}
int main(){
	int a[]={0, 3, 7, 8, 11, 12};//28
	cout<<getMinCost(a,6)<<endl;
	system("pause");
	return 0;
}