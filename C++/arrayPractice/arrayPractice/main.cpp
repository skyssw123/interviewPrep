//
//  main.cpp
//  arrayPractice
//
//  Created by Thomas Sin on 2018-01-20.
//  Copyright © 2018 TomSin. All rights reserved.
//

#include <iostream>
#include <array>

void changeArray(std::array<int, 5> & a)
{
    a[0] = 7;  // if & is not used, array will decay into pointer..
    a[1] = 7;
    return;
}

void changeArray2(int b[])
{
    b[0] = 7;
    b[1] = 7;
}

int main(int argc, const char * argv[]) {
    // insert code here...
    std::array<int, 5> a = {1, 3, 5, 7, 9};
    changeArray(a);
    int b[5] = {1};
    changeArray2(b);
    
    for(std::array<int, 5>::iterator it = a.begin() ; it != a.end(); ++it)
    {
        std::cout<< *it << std::endl ;
    }
    std::cout<< std:: endl;
    for(int i = 0; i < 5; ++i)
    {
        std::cout<< b[i] << std::endl;
    }
    
    return 0;
}
