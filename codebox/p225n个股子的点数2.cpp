#include<iostream>
#include<math.h>
using namespace std;
int g_maxvalue=6;
void printprobability(int number){
  if(number<1)
    return;
  int *pprobabilities[2];
  pprobabilities[0]=new int[g_maxvalue*number+1];
  pprobabilities[1]=new int[g_maxvalue*number+1];
  for(int i=0;i<g_maxvalue*number+1;++i){
    pprobabilities[0][i]=0;
    pprobabilities[1][i]=0;
  }
  int flag=0;
  for(int i=1;i<=g_maxvalue;++i)
    pprobabilities[flag][i]=1;
  for(int k=2;k<=number;++k){
    for(int i=0;i<k;++i)
      pprobabilities[1-flag][i]=0;
    for(int i=k;i<=g_maxvalue*k;++i){
      pprobabilities[1-flag][i]=0;
      for(int j=1;j<=i&&j<=g_maxvalue;++j)
	pprobabilities[1-flag][i]+=pprobabilities[flag][i-j];
    }
    flag=1-flag;
  }
  double total=pow((double)g_maxvalue,number);
  for(int i=number;i<=g_maxvalue*number;++i){
    double ratio=(double)pprobabilities[flag][i]/total;
    cout<<i<<":"<<ratio<<endl;
  }
  delete [] pprobabilities[0];
  delete[] pprobabilities[1];
}
int main(){
  printprobability(2);
  return 0;

}
