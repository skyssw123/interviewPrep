//
//  main.cpp
//  TemplateExample
//
//  Created by Thomas Sin on 2018-01-02.
//  Copyright © 2018 TomSin. All rights reserved.
//

#include <iostream>
template<class T>
T GetMax(T a, T b)
{
    T result = a>b ? a:b;
    return result;
}

int main(int argc, const char * argv[]) {
    int i = 3, j = 5, k;
    float l = 10.0, m = 17.0, n;
    
    k = GetMax<int>(i, j); // expected outcome: k = 5
    std::cout << k << std::endl;
    
    n = GetMax<float>(l, m); // expected outcome: n = 17.0
    std::cout << n << std::endl;
    
    return 0;
}
