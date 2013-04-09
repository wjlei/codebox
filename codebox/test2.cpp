#include<iostream>
#include<fstream>
using namespace std;
class a{
public:
  a(){
    cout<<"hello"<<endl;
  }
};
int main(){
  ifstream ifile("data");
  char buff[10];
  a * pa;
  ifile>>buff;
  pa= new a;
  return 0;


}
