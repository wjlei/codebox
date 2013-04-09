#include<iostream>
using namespace std;
class ta{
public:
  ta(){
    cout<<"1"<<endl;
  }
  virtual void yy(){cout<<"gg"<<endl;};
  virtual~ta(){
    cout<<"2"<<endl;
  }
};
class tb:public ta
{
public:
  tb(){
    cout<<"3"<<endl;
  }
 void yy(){
    cout<<"hello"<<endl;
  }
  ~tb()
  {
    cout<<"4"<<endl;
  }
};
int main(){
  ta *bb;
  bb=new tb();
  bb->yy();
  delete bb;
  return 0;

}
