#include<iostream>
using namespace std;
class CNoHeritance
{
private:
    CNoHeritance(){}
    ~CNoHeritance(){}
    friend class CParent;
};

class CParent : virtual public CNoHeritance
{
public:
    CParent(int v){m_v = v;}
    ~CParent(){};
private:
    int m_v;

public:
    void fun(){cout << "The value is: " << m_v << endl;}
};

// class CChild : public CParent //虚继承类必须在子类被初始化，子类无法初始化则无法继承
// {
// public:
//     CChild():CParent(10){}
//     ~CChild(){}
// };
int main(){
  CParent A(10);
  A.fun();
  // CChild b;
  //  b.fun();
  return 0;
}
