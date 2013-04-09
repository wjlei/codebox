#include<iostream>
#include<queue>
#include<vector>
using namespace std;
int main(){
  int n,i;
  long long x;
  priority_queue<long long,vector<long long>,greater<long long> > q;
  cin>>n;
  while(n--){
    cin>>x;
    q.push(x);
  }
  long long sum=0;
  while(q.size()!=1){
    long long a,b;
    a=q.top();
    q.pop();
    b=q.top();
    q.pop();
    q.push(a+b);
    sum+=a+b;
  }
  cout<<sum<<endl;
  return 1;

}
