#include <iostream> 
#include <cstdio> 
#include <algorithm> 
#include <numeric> 
using namespace std; 
int in[3010],tmp[3010]; 
bool use[3010]; 
bool check(int k,int sh,int n) { 
  copy(in,in+n,tmp); 
  for(int i(0);i!=n-k+1;++i) 
    if(tmp[i]!=0) tmp[i+k] = (tmp[i+k]+tmp[i])%sh; 
  for(int i(n-k+1);i!=n;++i) 
    if(tmp[i]!=0) return false; 
  return true; 
} 
int main() { 
  int _,n,sh;cin>>_; 
  while(_--) { 
    int res(0); 
    cin>>n>>sh; 
    for(int i(0);i!=n;++i) 
      scanf("%d",&in[i]); 
    adjacent_difference(in,in+n,in); 
    for(int i(0);i!=n;++i) 
      if(in[i]<0) in[i]+=sh; 
    memset(use,0,sizeof use); 
    for(int k(1);k<=n;++k) if(!use[k]) { 
	if(check(k,sh,n)) ++res; 
	else for(int i(1);i*k<=n;++i) 
	       use[i*k] = true; 
      } 
    cout<<res<<'\n'; 
  } 
  return 0; 
}
