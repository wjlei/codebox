#include<iostream>
using namespace std;

int main(){
  enum day{Sun,Mon,Tue,Wed,Thu,Fri,Sat};
  int a=Sun;
  cout<<a<<endl;
  cin.get();
  return 0;
}


/*********************************************
 *枚举
格式:
    enum <枚举类型名> {<枚举表>}; (见例1)
    enum {<枚举表>}<变量名表>; (见例2)

       第一个枚举值对应着一个整型数,通常情况下,第一个枚
举值对应着常量值0,后面低次.(特殊用法参考 例3 例4)

enum bool {false,true}; //bool类型就是C++预定义的枚举
*********************************************/
// #include <iostream>
// using namespace std;

// int main()
// {
//     //例1
//     // enum day{Sun,Mon,Tue,Wed,Thu,Fri,Sat};//定义一个day的枚举
//     // day d = Sun; //d只能等于"Sun,Mon,Tue,Wed,Thu,Fri,Sat"中的一个,没有其它值!
//     // cout<<"value is "<<d<<endl;
    
//     //也可以定义多个变量
//     enum day{Sun,Mon,Tue,Wed,Thu,Fri,Sat};
//     //  day d1,d2,d3;
//     //  d1 = Thu;   d2 = Sat;   d3 = Tue;
//     int a=Sun;
//     //cout<<"d1 && d2 && d3 "<<d1<<" "<<d2<<" "<<d3<<endl;
    
//     // //例2
//     // enum {Sun,Mon,Tue,Wed,Thu,Fri,Sat} d;
//     // d = Mon;
//     // cout<<"value is "<<d<<endl;
    
//     // //例3
//     // enum {Sun=10,Mon,Tue,Wed,Thu,Fri,Sat} d1,d2,d3,d4;
//     // d1 = Sun;   d2 = Mon;   d3 = Tue;   d4 = Wed;
//     // cout<<d1<<" "<<d2<<" "<<d3<<" "<<d4<<endl; //输出 10 11 12 13
    
//     // //例4
//     // enum {Sun=10,Mon=1,Tue,Wed,Thu,Fri,Sat} d1,d2,d3,d4;
//     // d1 = Sun;   d2 = Mon;   d3 = Tue;   d4 = Wed;
//     // cout<<d1<<" "<<d2<<" "<<d3<<" "<<d4<<endl; //输出 10 1 2 3
//     return 0;
// }
