#include<iostream>
using namespace std;
template<typename T>
class base{
public:
  base(){
    uu=1;
  }
  static int uu;
};
class dd:public base<dd>
{
public:
  void chang(int kk){
    uu=kk;}
  void show(void){
    cout<<uu<<endl;
  }
};
class ii:public base<ii>
{
public:
  void chang(int kk){
    uu=kk;}
  void show(void){
    cout<<uu<<endl;
  }
};
template<typename T> int base<T>::uu;
int main(){
  dd d1;
  ii u1;
  d1.show();
  u1.show();
  d1.chang(10);
  u1.show();
  d1.show();
  return 1;


}
