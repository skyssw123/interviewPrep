//
//  main.cpp
//  URLify
//
//  Created by Thomas Sin on 2017-12-28.
//  Copyright © 2017 TomSin. All rights reserved.
//

#include <iostream>
#include <string>

//Scan first to get the number of spaces.
//Scan again to update characters from the end of the string to the first letter of the string.

void URLify(char* array, int trueLength)
{
    int countSpace = 0;
    for(int i = 0; i < trueLength; i++)
    {
        if(array[i] == ' ')
            ++countSpace;
    }
    int finalLength = trueLength + countSpace * 2;
    for(int i = trueLength-1; i>=0; --i)
    {
        if(array[i] != ' ')
        {
            array[finalLength-1] = array[i];
            --finalLength;
        }
        else
        {
            array[finalLength-1] = '0';
            array[finalLength-2] = '2';
            array[finalLength-3] = '%';
            finalLength -= 3;
        }
    }
    
    return;
}

int main(int argc, const char * argv[]) {
    
    std::string str = "Mr John Smith      "; //Expected Outcome: "Mr%20John%20Smith"
    char charArray[str.size()];
    strcpy(charArray, str.c_str());
    URLify(charArray, 13);
    
    for(char * it = charArray; *it; ++it)
    {
        std::cout << *it ;
    }
    std::cout << std::endl;
    
    return 0;
}
