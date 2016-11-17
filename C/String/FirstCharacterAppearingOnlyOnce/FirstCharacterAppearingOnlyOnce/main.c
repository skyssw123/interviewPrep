//
//  main.c
//  FirstCharacterAppearingOnlyOnce
//
//  Created by Thomas Sin on 2016-09-28.
//  Copyright © 2016 sin. All rights reserved.
//

#include <stdio.h>
#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>
#include <assert.h>
//Q: Implement a function to find the first character in a string which only appears once.
//For example: It returns ‘b’ when the input is “abaccdeff”.

char FirstNotRepeatingChar(char* pString)
{
    if(pString == NULL)
        return '\0';
    
    const unsigned int tableSize = 256; //Since character has 8 bits, there are 2^8 = 256 combinations
    unsigned int hashTable[256] = {0};
    char* pHashKey = pString;
    while(*pHashKey != '\0')
    {
        hashTable[*pHashKey]++;
        pHashKey++;
    }
    pHashKey = pString;
    while(*pHashKey != '\0')
    {
        if(hashTable[*pHashKey] == 1)
            return (*pHashKey);
        pHashKey++;
    }
    return '\0';
}

int main(int argc, const char * argv[]) {
    char input[10] = "abaccdeff\0";
    //Expected Outcome: 'b'
    char result = FirstNotRepeatingChar(input);
    printf("The result is: %c\n", result);
    
    return 0;
}