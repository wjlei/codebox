#include<iostream>
using namespace std;
#include <stdio.h>
#include <string.h>
int main ()
{
  char * pch;
  char str[] = "Example string";
  pch = (char*) memchr (str, 'p', strlen(str));
  if (pch!=NULL){
    printf ("'p' found at position %d.\n", pch-str+1);
    cout<<pch<<endl;
  }
  else
    printf ("'p' not found.\n");
  return 0;
}

