#include<iostream>
#include<fstream>
using namespace std;
int main(){
  ofstream file("data");
  int count=0;
  for(int i=0;i<10;i++){
    for(int j=0;j<10;j++)
      file<<count++<<" ";
    file<<endl;
  }
  file.close();
  return 0;
}
