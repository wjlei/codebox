#include<iostream>
using namespace std;
class singleton{
private:
  singleton(){cout<<"hello"<<endl;};
  static class singletoncontainer{
  private: static singleton instance =new singleton();
  };
public:
  static singleton getInstance(){
    return singletoncontainer::instance;
  }
};
int main(){
  singleton a=singleton::getInstance();
  singleton b=singleton::getInstance();
  singleton c=singleton::getInstance();
 return 0;
}
