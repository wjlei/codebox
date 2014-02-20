#include <iostream>
#include "BaseClass.hpp"

int main(int argc, const char * argv[])
{

    BaseClass *pVar = (BaseClass*)ClassFactory::sharedClassFactory().getClassByName("HelloClass") ;
    pVar->registProperty() ;
    
    int pValue = 10341230 ;
    
    pVar->m_propertyMap["setm_pValue"](pVar, &pValue) ;
    pVar->display() ;
    // insert code here...
    std::cout << "Hello, World!\n";
	//system("pause");
    return 0;
}

