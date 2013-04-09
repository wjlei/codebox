#include<iostream>
#include<stdio.h>
using namespace std;
int bsearch(int num[],int ln,int key){
	int l=0,r=ln-1;

	while(l<=r){
		int mid=(l+r)/2;
		if(num[mid]==key){
			return mid;
		}
		else if(num[mid]<key)
			l=mid+1;
		else 
			r=mid-1;
	}
	return l;

}
int main(){
//	freopen("data","r",stdin);
	int T;
	cin>>T;
	int num[1000];
	while(T--){
		int n;
		cin>>n;
		for(int i=0;i<n;i++){
			cin>>num[i];    
		}
		int ln=1;
		for(int i=1;i<n;i++){
			int loc=bsearch(num,ln,num[i]);
			ln=max(loc+1,ln);
			num[loc]=num[i];
		}
		cout<<ln<<endl;
	}
//	freopen("CON","r",stdin);
//	system("pause");
	return 1;
}
