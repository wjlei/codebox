#include<iostream>
#include<string>
#include<string.h>
#include <stdio.h>
#include <stdlib.h>
using namespace std;
void addone(string &cnum,int cur){
  if(cur==0){
	  cnum="1"+cnum;return ;
  }
  if(cnum[cur-1]=='9'){
    cnum[cur-1]='0';
    addone(cnum,cur-1);
  }
  else
    cnum[cur-1]+=1;

}
int count1(string input){
	string z="0";
	int sum=0;
	addone(input,input.size());
	while(z!=input){
		for(unsigned int i=0;i<z.size();i++){
			if(z[i]=='1')
				sum++;
		}
		addone(z,z.size());
	}
	return sum;
}
int numberof1(unsigned int n){
  int number=0;
  while(n){
    if(n%10==1)
      number++;

    n=n/10;
  }
  return number;
}
int numberof1between1andn(unsigned int n){
  int number =0;
  for(unsigned int i=1;i<=n;++i)
    number+=numberof1(i);
  return number;
}
int powerbase10(unsigned int n){
  int result=1;
  for(unsigned int i=0;i<n;i++)
    result*=10;
  return result;
}
int numberof12(const char* strn){
  if(!strn||*strn<'0'||*strn>'9'||*strn=='\0')
    return 0;
  int first =*strn -'0';
  unsigned int length =static_cast<unsigned int>(strlen(strn));
  if(length==1&&first==0)
    return 0;
  if(length==1&&first>0)
    return 1;
  int numfirstdigit=0;
  if(first>1)
    numfirstdigit=powerbase10(length-1);
  else if(first ==1)
    numfirstdigit=atoi(strn +1)+1;
  int numotherdigits=first*(length-1)*powerbase10(length-2);
  int numrecursive = numberof12(strn+1);
  return numfirstdigit+numotherdigits+numrecursive;
}
int numberof1between1andn2(int n){
  if(n<=0)
    return 0;
  char strn[50];
  sprintf(strn,"%d",n);
  return numberof12(strn);
}
int main(){
  string s="21345";
  int num=21345;
  cout<<count1(s)<<endl;
  cout<<numberof1between1andn(num)<<endl;
  cout<<numberof1between1andn2(num)<<endl;
  return 0;
}
