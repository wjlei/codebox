#ifndef DynamicClass_hpp
#define DynamicClass_hpp

#include"ClassFactory.hpp"

class DynamicClass
{
public:
    DynamicClass(string name, createClass method) 
	{
		ClassFactory::sharedClassFactory().registClass(name, method) ;//静态函数
	};
} ;

#define DECLARE_CLASS(className)\
string className##Name ;        \
static DynamicClass* m_className##dc ;
//宏处理，增加两个属性
#define IMPLEMENT_CLASS(className)  \
DynamicClass* className::m_className##dc = \
new DynamicClass(#className, className::createInstance) ; 
 //通过DynamicClass注册类
#endif
//#是将className作为字符串处理