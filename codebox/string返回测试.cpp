#include<iostream>
#include<string>
using namespace std;
class rstring{
public:
  rstring(){
    ss="hello";
  }
  string getstring(){
    return ss;
  }
  void chss(string in){
    ss=in;
  }
private:
  string ss;
};
int main(){
  rstring ll;
  string kk=ll.getstring();
  cout<<ll.getstring()<<endl;
  kk="todo";
  cout<<ll.getstring()<<endl;//不变
  return 1;


}
