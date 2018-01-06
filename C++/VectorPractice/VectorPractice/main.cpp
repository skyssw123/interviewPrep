//
//  main.cpp
//  VectorPractice
//
//  Created by Thomas Sin on 2018-01-06.
//  Copyright © 2018 TomSin. All rights reserved.
//

#include <iostream>
#include <vector>

int main(int argc, const char * argv[]) {
    std::vector<int> a (5) ;//= {0, 0, 0, 0, 0};
    a = {1, 3, 5, 7 , 9};
    for(std::vector<int>::iterator it = a.begin(); it != a.end(); ++it)
    {
        std::cout<<*it<<std::endl;
    }
    std::cout << "Hello, World!\n";
    return 0;
}
