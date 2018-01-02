//
//  main.cpp
//  TemplateExampleWithClass
//
//  Created by Thomas Sin on 2018-01-02.
//  Copyright © 2018 TomSin. All rights reserved.
//

#include <iostream>

template<class T>
class MyPair{
    T a, b;
public:
    MyPair(T first, T second)
    {
        a = first;
        b = second;
    }
    T GetMax();
};

template<class F>
F MyPair<F>::GetMax() // if MyPair<SomethingElse>, build FAILS..
{
    F result = a > b ? a : b;
    return result;
}

int main(int argc, const char * argv[]) {
    
    MyPair<int> a (5, 69);
    std::cout << a.GetMax() << std::endl;
    
    return 0;
}
