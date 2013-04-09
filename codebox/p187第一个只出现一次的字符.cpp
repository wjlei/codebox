#include<iostream>
using namespace std;
char firstnotrepeatingchar(char* pstring){
  if(pstring==NULL)
    return '\0';
  const int tablesize=256;
  unsigned int hashtable[tablesize];
  for(unsigned int i=0;i<tablesize;++i)
    hashtable[i]=0;
  char*phashkey=pstring;
  while(*(phashkey)!='\0')
    hashtable[*(phashkey++)]++;
  phashkey=pstring;
  while(*phashkey!='\0'){
    if(hashtable[*phashkey]==1)
      return *phashkey;
    phashkey++;
  }
  return '\0';
}
int main(){
  cout<<firstnotrepeatingchar("abaccdeff")<<endl;
  return 0;
}
