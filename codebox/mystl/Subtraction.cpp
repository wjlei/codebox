//only for a>b 都是正数
#include<iostream>
#include <algorithm>
#include<string>
using namespace std;
string makeminus(string a,string b){
	reverse(a.begin(),a.end());
	reverse(b.begin(),b.end());
	string ans;
	int an=a.size();
	int bn=b.size();
	int imin=min(an,bn);
	int imax=max(an,bn);
	for(int i=an-1;i<imax-1;i++)
		a.append("0");
	for(int i=bn-1;i<imax-1;i++)
		b.append("0");
	int c=0;
	for(int i=0;i<imax;i++){
		int inta=a[i]-'0';
		int intb=b[i]-'0';
		int now=inta-intb+c;
		c=0;
		while(now<0){
			c--;
			now+=10;
		}
		ans+='0'+now;
	}
	if(c>0){
		ans+='0'+abs(c);
	}
	reverse(ans.begin(),ans.end());
	return ans;
}
int main(){
	string a,b;
	int sya=1,syb=1;
	a="12346";
	b="12345";
	string ans=makeminus(a,b);
	//clear 前导零
	cout<<ans<<endl;
	system("pause");
	return 1;
}
