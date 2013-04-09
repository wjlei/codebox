//深入KMP
//6
//aabbbcaabbbcaabaab
//a
//AAAAAAAAAAAAAAAAAA
//BBBBBBBBB
//BBBAABAABABBBBBBAABAABAABAABAABAABA
//AABAABA
//ABCABC
//ABC
//ABABAB
//ABA
//ABABA
//ABA
//aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
//aa
//1
//0
//19
//3
//5
//5
#include<iostream>
#include<stdio.h>
#include<string.h>
using namespace std;
char str1[10000000+10];
char str2[10000000+10];
int next[10000000+10];
void get_next(char*s){//构造next数组
  next[0]=-1;
  next[1]=0;
  int n=strlen(s);
  int j=0;
  for(int i=2;i<=n;i++){
    while(j>0&&s[j]!=s[i-1])
      j=next[j];
    if(s[j]==s[i-1])
      j++;
    next[i]=j;
  }
}
int kmp(char *t,char *s){
  get_next(s);
  int n=strlen(t);
  int ns=strlen(s);
  int imax=0;//保存最长的值
  for(int i=0;i<n;i++){
    int out=0;//统计单段连续的长度
    if(t[i]==s[0]){//如果第一个字符匹配
      int count=1;//计数+1
      i++;
      int j=1;
      if(j>=ns){//整个串匹配，则累加长度
	out+=count;
	count=0;
      }
      for(;i<n;i++){
	while(j>0&&t[i]!=s[j]||j>=ns)//匹配失败时，回滚到next函数的上一点
	  j=next[j];
	if(j==0){//如果回滚到第一个字符则无覆盖，跳出
	  imax=max(imax,out);
	  break;
	}
	if(t[i]==s[j]){//相等，继续匹配
	  count++;
	  j++;
	}
	if(j>=ns){//整个串匹配，则累加长度
	  out+=count;
	  count=0;
	}
      }
      imax=max(imax,out);
    }
  }
  return imax;
}
int main(){
#ifdef _DEBUG
  freopen("data","r",stdin);
#endif
  int T;
  cin>>T;
  while(T--){
    scanf("%s",&str1);
    scanf("%s",&str2);
    cout<<kmp(str1,str2)<<endl;

  }
#ifdef _DEBUG
  freopen("CON","r",stdin);
  system("pause");
#endif
  return 1;
}
