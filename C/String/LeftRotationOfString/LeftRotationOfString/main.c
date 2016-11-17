//
//  main.c
//  LeftRotationOfString
//
//  Created by Thomas Sin on 2016-09-26.
//  Copyright © 2016 sin. All rights reserved.
//

#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>
#include <assert.h>
//Q.Left rotation of a string is to move some leading characters to its tail. Please implement a function to rotate a string.
//For example, if the input string is “abcdefg” and a number 2, the rotated result is “cdefgab”.

void Print(char *pBegin)
{
    while(*pBegin != 0)
    {
        printf("%c\n", *pBegin);
        pBegin++;
    }
}

void Reverse(char* pBegin, char* pEnd)
{
    while(pBegin < pEnd)
    {
        char temp = *pBegin;
        *pBegin = *pEnd;
        *pEnd = temp;
        pBegin++, pEnd--;
    }
}

char* LeftRotateString(char* pSt, int n)
{
    if(pSt == NULL)
        return NULL;
    int length = (int)strlen(pSt);
    char* pBegin1 = pSt;
    char* pEnd1 = pSt + n - 1;
    char* pBegin2 = pSt + n;
    char* pEnd2 = pSt + length - 1;
    Reverse(pBegin1, pEnd1);
    Reverse(pBegin2, pEnd2);
    Reverse(pBegin1, pEnd2);
    
    return pSt;
}


int main(int argc, const char * argv[]) {
    char input[16] = "I am a student.\0";
    char* a = LeftRotateString(input, 2);
    //Expected Outcome: "am a student.I "
    Print(input);
    return 0;
}
