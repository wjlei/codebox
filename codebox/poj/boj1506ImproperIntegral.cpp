//»ý·Ö
//#include<iostream>
//#include<stdio.h>
//#include<math.h>
//#include <iomanip>
//using namespace std;
//int main(){
//#ifdef _DEBUG
//  freopen("data","r",stdin);
//#endif
//  int T;
//  cin>>T;
//  while(T--){
//    double x;
//    scanf("%lf",&x);
//    printf("%0.5f\n",(1+erf(x/sqrt(2)))/2);
//  }
//#ifdef _DEBUG
//  freopen("CON","r",stdin);
//  system("pause");
//#endif
// system("pause");
//  return 0;
//}
#include<iostream>
#include<cmath>
#include <iomanip>
using namespace std;
#define Pi 3.14159265358979
double f(double x){
	return 1.0/(sqrt(2.0*Pi))*exp(-x*x/2);
}
double sps(double a,double b){
	double ans=(b-a)/6*(f(a)+4*f((a+b)*0.5)+f(b));
	return ans;
}
double getans(double l,double r){
	double n1=sps(l,r);
	double n2=sps(l,0.5*(l+r))+sps(0.5*(l+r),r);
	//	cout<<"n1:"<<n1<<endl;
	//	cout<<"n2:"<<n2<<endl;
	if(abs(n1-n2)<0.000000001)
		return n2;
	else
		return getans(l,0.5*(l+r))+getans(0.5*(l+r),r);
}
int main(){
#ifdef _DEBUG
	freopen("data","r",stdin);
#endif
	int T;
	cin>>T;
	while(T--){
		double x;
		scanf("%lf",&x);
		printf("%0.5f\n",getans(0,x)+0.5);
	}
#ifdef _DEBUG
	freopen("CON","r",stdin);
	system("pause");
#endif
	return 0;
}