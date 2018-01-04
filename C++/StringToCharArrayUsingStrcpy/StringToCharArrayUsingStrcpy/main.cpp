//
//  main.cpp
//  StringToCharArrayUsingStrcpy
//
//  Created by Thomas Sin on 2017-12-28.
//  Copyright © 2017 TomSin. All rights reserved.
//

#include <iostream>
#include <string>

int main(int argc, const char * argv[]) {
    std::string str = "Mr Johnson is Nice";
    
    char charArray[str.size()+1]; // last character is to be NULL;
    strcpy(charArray, str.c_str());
    
    for(char* it = charArray ; *it ; ++it)
    {
        std::cout<<*it<<std::endl;
    }
    
}
