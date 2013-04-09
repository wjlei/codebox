#include<iostream>
using namespace std;
int num[1000000];
int getkth(int l,int r,int k){
	int ll=l,rr=r;
	while(ll<rr){
		while(num[ll]<num[rr])
			rr--;
		if(ll<rr)
			swap(num[ll],num[rr]);
		while(num[ll]<num[rr])
			ll++;
		if(ll<rr)
			swap(num[ll],num[rr]);
	}
	int ln=ll-l+1;//注意ll并不代表左边剩下个数,减去左边界
	if(ln==k)
		return(num[ll]);
	else if(ln>k){
		return getkth(l,ll-1,k);
	}
	else if(ln<k){
		return getkth(ll+1,r,k-ln);
	}
}
int main(){
#ifdef _DEBUG
	freopen("data","r",stdin);
#endif
	int n,k;
	while(cin>>n){
		cin>>k;
		for(int i=0;i<n;i++){
			cin>>num[i];
		}
		cout<<getkth(0,n-1,k)<<endl;
	}
#ifdef _DEBUG
	freopen("CON","r",stdin);
	system("pause");
#endif
	return 1;

}
