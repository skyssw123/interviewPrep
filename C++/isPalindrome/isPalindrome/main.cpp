//
//  main.cpp
//  isPalindrome
//
//  Created by Thomas Sin on 2017-12-28.
//  Copyright © 2017 TomSin. All rights reserved.
//

#include <iostream>
#include <vector>
#include <string>

bool isPalindrome(std::string str)
{
    int low = 0;
    int high = str.size() - 1;
    while (low <= high)
    {
        if(str.at(low) != str.at(high))
            return false;
        ++low; --high;
    }
    return true;
}


int main(int argc, const char * argv[]) {
    std::string str = "acdeffedca";
    std::string str2 = "aaeefeeaa";
    std::string str3 = "abcd";
    std::cout << isPalindrome(str) << std::endl;
    std::cout << isPalindrome(str2) << std::endl;
    std::cout << isPalindrome(str3) << std::endl;
    return 0;
}
