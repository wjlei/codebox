#ifndef ClassFactory_hpp
#define ClassFactory_hpp

#include<string>
#include<map>
#include<iostream>
using namespace std ;

typedef void* (*createClass)(void) ;

class ClassFactory
{
public:
	ClassFactory() {};
    
	virtual ~ClassFactory(){} ;
    
    void* getClassByName(string className) 
	{
		map<string, createClass>::const_iterator iter ;

		iter = m_classMap.find(className) ; 
		if ( iter == m_classMap.end() )
			return NULL ;
		else 
			return iter->second() ;
	};
    
    void registClass(string name, createClass method) 
	{
		m_classMap.insert(pair<string, createClass>(name, method)) ;
	};
    
	static ClassFactory& sharedClassFactory()
	{
		static ClassFactory _sharedClassFactory ;
		return _sharedClassFactory ;
	};
    
private:
    map<string, createClass> m_classMap ;
} ;


#endif


