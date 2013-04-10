#include<iostream>
#include<stdio.h>
#include<math.h>
#define PI acos(-1.0)
using namespace std;
int main(){
  int T;
  cin>>T;
  while(T--){
    int x;
    scanf("%d",&x);
	if(x==1)
		printf("1\n");
	else
        printf("%d\n",(int)ceil((0.5*log(2.0*x*PI)+x*log(1.0*x)-x)/log(10.0)));
  }
  system("pause");
  return 1;
}
