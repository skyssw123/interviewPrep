//
//  main.cpp
//  TemplateExample
//
//  Created by Thomas Sin on 2018-01-02.
//  Copyright © 2018 TomSin. All rights reserved.
//

#include <iostream>

template<class T>
T GetSum(T a, T b)
{
    T result = a + b;
    return result;
}

int main(int argc, const char * argv[]) {
    int i = 3, j = 5, k;
    float l = 10.4, m = 17.8, n;
    
    k = GetSum<int>(i, j); // expected outcome: k = 8
    std::cout << k << std::endl;
    
    n = GetSum<float>(l, m); // expected outcome: n = 28.2
    std::cout << n << std::endl;
    
    n = GetSum<int>(l, m); // expected outcome: n = 27; (cuz floats are inputted as int)
    std::cout << n << std::endl;
    return 0;
}
