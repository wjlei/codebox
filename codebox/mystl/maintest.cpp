#include<iostream>
#include<algorithm>
#include<time.h>
#include<stdlib.h>
#define n 10000
using namespace std;
#include"bsearch.h"
#include"qsort.h"
#include"子序列和最大.h"
#include"最长上升子序列.h"
int compare(const void *p, const void *q)
{
    return (*(int *)p - *(int *)q);
}
int num[n],num1[n],num2[n];
int main(){
	int num[]={1,-1,2,-3,4,-5,6,-7};
	cout<<LIS(num,8)<<endl;
	//cout<<getbiggest(num,6)<<endl;
	//srand(time(NULL));
	//int uu=10000;
	//int qq=0;
	//int qq2=0;
	//while(uu--){
	//	for(int i=0;i<n;i++)
	//		num[i]=rand()%1000-100;
	//	for(int i=0;i<n;i++)
	//		num2[i]=num1[i]=num[i];
	//	qsort(num1,0,n-1);
	//	sort(num2,num2+n);
	//	int yy=0;
	//	for(int i=0;i<n;i++){
	//		if(num2[i]==num1[i])
	//			yy++;
	//	}
	//	//cout<<yy<<endl;
	//	if(yy==n)
	//		qq2++;
	//	int kk=rand()%1000-100;
	//	if(max((int *)bsearch(&kk,num1,n,sizeof(int),compare)-num1,-1)==bsearch(num1,kk,0,n-1))
	//		qq++;
	//}
	//cout<<qq2<<"|"<<qq<<endl;
	system("pause");
	return 0;


}