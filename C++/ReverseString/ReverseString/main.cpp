//
//  main.cpp
//  ReverseString
//
//  Created by Thomas Sin on 2017-12-29.
//  Copyright © 2017 TomSin. All rights reserved.
//

#include <iostream>
#include <string>
void reverseString(char* charArray, int size)
{
    int low = 0;
    int high = size - 1;
    while(low < high)
    {
        char temp = charArray[high];
        charArray[high] = charArray[low];
        charArray[low] = temp;
        low ++; high --;
    }
    return;
}

int main(int argc, const char * argv[]) {
    std::string str = "Hi! My name is Tom";
    char charArray[str.size()];
    strcpy(charArray, str.c_str());
    reverseString(charArray, str.size());
    for(char* it = charArray; *it; ++it)
    {
        std::cout<< *it;
    }
    std::cout<<std::endl;
    return 0;
}
