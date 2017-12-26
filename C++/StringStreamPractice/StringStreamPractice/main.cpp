//
//  main.cpp
//  StringStreamPractice
//
//  Created by Thomas Sin on 2017-12-26.
//  Copyright © 2017 TomSin. All rights reserved.
//

#include <iostream>
#include <sstream>
#include <string>

int main(int argc, const char * argv[]) {
    
    std::stringstream sstream ("initial String", std::ios_base::app | std::ios_base::out);
    sstream << " appended String";
    
    std::cout << sstream.str() << std::endl;
    
    return 0;
}
