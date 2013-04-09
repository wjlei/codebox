#include<iostream>
using namespace std;
void coutcomb(string str,int numtake,int cur,string out){
  if(numtake==0){
    cout<<out<<endl;
    return;
  }
  coutcomb(str,numtake-1,cur+1,out+str[cur]);
  if(str.size()-cur>numtake)
    coutcomb(str,numtake,cur+1,out);
}

void coutcombN(string str){
  for(int i=1;i<=str.size();i++){
    coutcomb(str,i,0,"");
  }
}
int main(){
  coutcombN("abc");
  return 0;
}
