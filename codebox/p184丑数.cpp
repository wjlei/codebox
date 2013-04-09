#include<iostream>
using namespace std;
int imin(int number1,int number2,int number3){
  int min=(number1<number2)?number1:number2;
  min=(min<number3)?min:number3;
  return min;
}
int getuglynumber_solution2(int index){
  if(index<=0)
    return 0;
  int puglynumbers[2000];
  puglynumbers[0]=1;
  int nextuglyindex=1;
  int *pmultiply2=puglynumbers;
  int *pmultiply3=puglynumbers;
  int *pmultiply5=puglynumbers;
  while(nextuglyindex<index){
    int min=imin(*pmultiply2*2,*pmultiply3*3,*pmultiply5*5);//保证新加的最小
    puglynumbers[nextuglyindex]=min;
    while(*pmultiply2*2<=puglynumbers[nextuglyindex])//下一个数大于新加的
      ++pmultiply2;
    while(*pmultiply3*3<=puglynumbers[nextuglyindex])
      ++pmultiply3;
    while(*pmultiply5*5<=puglynumbers[nextuglyindex])
      ++pmultiply5;
    ++nextuglyindex;
  }
  int ugly=puglynumbers[nextuglyindex-1];
  delete[]puglynumbers;
  return ugly;
}
int main(){
  cout<<getuglynumber_solution2(1500)<<endl;
  system("pause");
  return 0;
}
