//
//  main.cpp
//  Iterator
//
//  Created by Thomas Sin on 2017-12-23.
//  Copyright © 2017 TomSin. All rights reserved.
//

#include <iostream>
#include <vector>

int main(int argc, const char * argv[]) {
    std::vector<int> vector (5, 99);
    
    for(std::vector<int>::iterator it = vector.begin(); it < vector.end(); ++it)
        std::cout << *it << " ";
    
    return 0;
}
