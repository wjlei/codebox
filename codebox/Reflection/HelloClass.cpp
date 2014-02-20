#include "HelloClass.h"
IMPLEMENT_CLASS(HelloClass)
HelloClass::HelloClass() 
{
    
}
HelloClass::~HelloClass() 
{
    
}
void* HelloClass::createInstance()
{
    return new HelloClass() ;
}
void HelloClass::registProperty() 
{
    m_propertyMap.insert(pair<string, setValue>("setm_pValue", setm_pValue)) ;
}
void HelloClass::display() 
{
    cout << *getm_pValue() << endl ;
}
