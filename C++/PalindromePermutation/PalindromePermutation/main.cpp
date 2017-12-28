//
//  main.cpp
//  PalindromePermutation
//
//  Created by Thomas Sin on 2017-12-28.
//  Copyright © 2017 TomSin. All rights reserved.
//

#include <iostream>
#include <string>

bool isPalindromePermutation(std::string str)
{
    int hashTable[128] = {};
    int countOdd = 0;
    for(std::string::iterator it=str.begin(); it != str.end(); ++it)
    {
        int count = ++hashTable[*it];
        if(count % 2 == 1)
            countOdd ++;
        else
            countOdd --;
    }
    
    if(countOdd > 1)
        return false;
    
    return true;
}

int main(int argc, const char * argv[]) {
    std::string a = "tactcoa"; //tacocat, atcocta
    std::string b = "apokl";
    
    std::cout << isPalindromePermutation(a) << std::endl;
    std::cout << isPalindromePermutation(b) << std::endl;
}
