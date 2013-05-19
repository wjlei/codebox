#include<iostream>
using namespace std;
class A{
public:
  static int n;
};
int A::n;
int main(){
  A* A1=new A;
  cout<<A1->n<<endl;
  A1->n=2;
  A*A2=new A;
  cout<<A2->n<<endl;
  return 1;
}
