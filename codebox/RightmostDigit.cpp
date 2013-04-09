#include<iostream>
using namespace std;
long long qj(long long m,long long n){
  if(n==1)
    return (m%10);
  else if(n==0)
	  return 1;
  else if(n%2==1){
    long long nn=qj(m,n/2);
    return (nn*nn*m%10);
  }
  else{
    long long nn=qj(m,n/2);
    return (nn*nn%10);
  }
}
int main(){
  long long n;
  cin>>n;
  while(n--){
    long long m,rst=1;
    cin>>m;
    rst=qj(m,m);
    cout<<rst<<endl;

  }
 // system("pause");
  return 1;
}
