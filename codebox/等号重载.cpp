#include<iostream>
using namespace std;
class a{
public:
  a(){
    cout<<"1"<<endl;
    bb=0;
  }
  ~a(){
    cout<<"2"<<endl;
  }
  a(a&in){
    cout<<"3"<<endl;
    this->bb=in.bb;
  }
  // a& operator =(const a&in){//为了连续赋值 a=b=c=d;
  //   cout<<"4"<<endl;
  //   this->bb=in.bb;
  //   return *this;
  // }
  void operator =(const a&in){
    cout<<"4"<<endl;
    this->bb=in.bb;
    // return *this;
  }
  int bb;
};
int main(){
  a ta;
  a tb;
  tb.bb=100;
  //  cout<<(ta=tb).bb<<endl;
  ta=tb;
  cout<<ta.bb<<endl;
  return 0;
}
