//
//  main.c
//  ReverseWordsInASentence
//
//  Created by Thomas Sin on 2016-09-26.
//  Copyright © 2016 sin. All rights reserved.
//

#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>
#include <assert.h>
//Q.Reverse the order of words in a sentence, but keep words themselves unchanged.

void Print(char *pBegin)
{
    while(*pBegin != 0)
    {
        printf("%c\n", *pBegin);
        pBegin++;
    }
}

void Reverse(char *pBegin, char* pEnd)
{
    if(pBegin == NULL || pEnd == NULL)
        return;
    while(pBegin < pEnd)
    {
        char temp = *pBegin;
        *pBegin = *pEnd;
        *pEnd = temp;
        pBegin++, pEnd--;
    }
}

char* ReverseSentence(char* pData)
{
    if(pData == NULL)
        return NULL;
    char* pBegin = pData;
    char* pEnd = pData;
    
    while(*pEnd != '\0')
    {
        pEnd++;
    }
    pEnd--;
    
    Reverse(pBegin, pEnd);  //Reverse every characters in a sentence first.
    
    pBegin = pEnd = pData;
    
    while(*pBegin != '\0')
    {
        if(*pBegin == ' ')
        {
            pBegin++, pEnd++;
        }
        
        if(*pEnd == ' ' || *pEnd == '\0')
        {
            Reverse(pBegin, (pEnd-1));
            pBegin = pEnd;
        }
        
        else
        {
            pEnd++;
        }
    }
    
    return pData;
}


int main(int argc, const char * argv[]) {
    char input[16] = "I am a student.\0";
    char* a = ReverseSentence(input);
    //Expected Outcome: "student. a am I"
    Print(a);
    return 0;
}
