#include<iostream>
#include<math.h>
using namespace std;
int g_maxValue=6;
int* pprobabilities;
void probability(int original,int current,int sum,int*probabilities){
  if(current==1)
    pprobabilities[sum-original]++;
  else{
    for(int i=1;i<=g_maxValue;++i)
      probability(original,current-1,i+sum,pprobabilities);
  }
}
void probability(int number,int*pprobabilities){
  for(int i=1;i<=g_maxValue;++i)
    probability(number,number,i,pprobabilities);
}
void PrintProbability(int number){
  if(number<1)
    return ;
  int maxsum=number*g_maxValue;
  pprobabilities=new int[maxsum-number+1];
  for(int i=number;i<=maxsum;++i)
    pprobabilities[i-number]=0;
  probability(number,pprobabilities);
  int total=pow((double)g_maxValue,number);
  for(int i=number;i<=maxsum;++i){
    double ratio=(double)pprobabilities[i-number]/total;
    cout<<i<<":"<<ratio<<endl;
  }
  delete pprobabilities;

}
int main(){
  PrintProbability(10);
  return 1;
}
