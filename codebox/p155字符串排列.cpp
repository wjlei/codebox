#include<iostream>
using namespace std;
void permutation(char* pstr,char* pbegin){
  if(*pbegin=='\0'){
    cout<<pstr<<endl;
  }
  else{
    for(char* pch=pbegin;*pch!='\0';++pch){
      char temp =*pch;
      *pch=*pbegin;
      *pbegin=temp;
      permutation(pstr,pbegin+1);
      temp=*pch;
      *pch=*pbegin;
      *pbegin=temp;
    }

  }
}
void permutation(char* pstr){
  if(pstr==NULL)
    return;
  permutation(pstr,pstr);
}
int main(){
  char a[]="abcd";
  permutation(a);
  return 0;

}
