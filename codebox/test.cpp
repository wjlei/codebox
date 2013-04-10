#include<stdio.h>
#include<iostream>
using namespace std;
int test(){
  char *p="microsoft";
  char *x="microsoft";
  printf("%d\n",p);
  printf("%d\n",x);
  return p==x;
}
int main(){
  printf("%d",test());
  return 1;
}
