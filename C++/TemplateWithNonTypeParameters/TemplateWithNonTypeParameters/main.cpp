//
//  main.cpp
//  TemplateWithNonTypeParameters
//
//  Created by Thomas Sin on 2018-01-04.
//  Copyright © 2018 TomSin. All rights reserved.
//

#include <iostream>

template<class T, int N>
class mySequence{
    T array[N];
public:
    void setMember(int n, T value);
    T getMember(int n);
};

template<class T, int N>
void mySequence<T, N>::setMember(int n, T value)
{
    array[n] = value;
}

template<class T, int N>
T mySequence<T, N>::getMember(int n)
{
    return array[n];
}

int main(int argc, const char * argv[]) {
    mySequence<float, 5> a;
    a.setMember(0, 3.14);
    
    mySequence<char, 5> b;
    b.setMember(0, 'c');
    
    std::cout<<a.getMember(0)<<std::endl;
    std::cout<<b.getMember(0)<<std::endl;
    return 0;
}
