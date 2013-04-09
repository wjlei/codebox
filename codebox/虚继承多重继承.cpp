#include <iostream>  
using namespace std;  
  
class Vehicle  
{  
    public:  
        Vehicle(int weight = 0)  
        {  
            Vehicle::weight = weight;  
            cout<<"载入Vehicle类构造函数"<<endl;  
        }  
        void SetWeight(int weight)  
        {  
            cout<<"重新设置重量"<<endl;  
            Vehicle::weight = weight;  
        }  
        virtual void ShowMe() = 0;  
    protected:  
        int weight;  
};  
class Car:virtual public Vehicle//汽车，这里是虚拟继承  
{  
    public:  
        Car(int weight=0,int aird=0):Vehicle(weight)  
        {  
            Car::aird = aird;  
            cout<<"载入Car类构造函数"<<endl;  
        }  
        void ShowMe()  
        {  
            cout<<"我是汽车！"<<endl;  
        }  
    protected:  
        int aird;  
};  
  
class Boat:virtual public Vehicle//船,这里是虚拟继承  
{  
    public:  
        Boat(int weight=0,float tonnage=0):Vehicle(weight)  
        {  
            Boat::tonnage = tonnage;  
            cout<<"载入Boat类构造函数"<<endl;  
        }  
        void ShowMe()  
        {  
            cout<<"我是船！"<<endl;  
        }  
    protected:  
        float tonnage;  
};  
  
class AmphibianCar:public Car,public Boat//水陆两用汽车,多重继承的体现  
{  
    public:  
  AmphibianCar(int weight,int aird,float tonnage)  //虚继承类必须在子类被初始化，子类无法初始化则无法继承
        :Vehicle(weight),Car(weight,aird),Boat(weight,tonnage)  
        //多重继承要注意调用基类构造函数  
        {  
            cout<<"载入AmphibianCar类构造函数"<<endl;  
        }  
        void ShowMe()  
        {  
	  Boat::ShowMe();
          //  cout<<"我是水陆两用汽车！"<<endl;  
        }  
        void ShowMembers()  
        {  
            cout<<"重量："<<weight<<"顿，"<<"空气排量："<<aird<<"CC，"<<"排水量："<<tonnage<<"顿"<<endl;  
        }  
};  
int main()  
{  
    AmphibianCar a(4,200,1.35f);  
    a.ShowMe();  
    //  a.ShowMembers();  
    //   a.SetWeight(3);  
    //   a.ShowMembers();  
    return 0;   
}
