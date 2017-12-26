//
//  main.cpp
//  StringCompression
//
//  Created by Thomas Sin on 2017-12-26.
//  Copyright © 2017 TomSin. All rights reserved.
//

#include <iostream>
#include <sstream>
#include <string>

std::string StringCompression(std::string inputStr)
{
    std::stringstream sstream("", std::ios_base::app | std::ios_base::out);
    int countConsecutive = 0;
    for(int i = 0 ; i < inputStr.size(); ++i)
    {
        countConsecutive ++;
        if((i+1 >= inputStr.size()) || inputStr.at(i) != inputStr.at(i+1))
        {
            sstream << inputStr.at(i);
            sstream << countConsecutive;
            countConsecutive = 0;
        }
    }
    
    return sstream.str().size() > inputStr.size() ? inputStr : sstream.str();
}

int main(int argc, const char * argv[]) {
    // insert code here...
    std::string inputString1 = "abcd";
    std::cout << StringCompression(inputString1) << std::endl;
    std::string inputString2 = "aaaaeeeeeerrbwqqt";
    std::cout << StringCompression(inputString2) << std::endl;
    
    
    
    return 0;
}
