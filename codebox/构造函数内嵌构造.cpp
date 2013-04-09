//res: B A C
#include<iostream>
using namespace std;
class A{
public:
  A(){
    cout<<"A"<<endl;
  }
  class B{
  public:
    B(){
      cout<<"B"<<endl;
    }
  };
  B bb;
};
class C:public A{
public:
  C(){
    cout<<"C"<<endl;
  }
};
int main(){

  C nn;
  return 1;


}
