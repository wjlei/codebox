#include<iostream>
using namespace std;
void f1(int *&j){
  int l=20;
  int *k=&l;
  j=k;
  k=0;
}
void any_function_use_local_variables(){
  int a,b,c;
  a=b=c=100;
}
int main(){
  int i=10;
  int *j=&i;
  f1(j);
  cout<<*j<<endl;
  any_function_use_local_variables();
  cout<<*j<<endl;
  return 0;
}
