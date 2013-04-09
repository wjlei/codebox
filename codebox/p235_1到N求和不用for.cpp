#include<iostream>
using namespace std;
class A{
public:
  virtual unsigned int sum(unsigned int n){
    return 0;
  }
};
A* array[2];
class B:public A{
public:
  virtual unsigned int sum(unsigned int n){
    cout<<!!n<<endl;
    return array[!!n]->sum(n-1)+n;
  }
};
int main(){
  int n=10;
  A a;
  B b;
  array[0]=&a;
  array[1]=&b;
  int value=array[1]->sum(n);
  cout<<value<<endl;
  return 0;

}
