#include<iostream>
#include<stdio.h>
#include<fstream>
#include<string.h>
#include<string>
#define maxnum 40000
using namespace std;
int main()
{
  FILE * file;
  FILE * fp;
  string * sbuf;
  string * sbuf1;
  fp=popen("ifconfig","r");
  file=fopen("/home/wjlei/data","r");
  char buf[maxnum];
  char buf1[maxnum];
  string ip1;
  string ip2;
  fread(buf,sizeof(char),maxnum,fp);
  fread(buf1,sizeof(char),maxnum,file);
  fclose(file);
  sbuf=new string(buf);
  sbuf1=new string(buf1);
  int i=sbuf->find("10.108");
  if(i!=-1)
    ip1=sbuf->substr(i,150);
  i=sbuf1->find("10.108");
  if(i!=-1)
    ip2=sbuf1->substr(i,150);
  if(ip1!=ip2){
    file=fopen("data","w");
    fwrite(ip1.c_str(), sizeof(char), ip1.length(), file);
    fclose(file);
    popen("mail -s \"test mail from test server\" wjleimaster@bupt.edu.cn < /home/wjlei/data","r");
  }
  pclose(fp);
  return 0;
}
