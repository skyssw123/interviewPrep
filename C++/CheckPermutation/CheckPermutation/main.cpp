//
//  main.cpp
//  CheckPermutation
//
//  Created by Thomas Sin on 2017-12-21.
//  Copyright © 2017 TomSin. All rights reserved.
//

#include <iostream>
#include <vector>
#include <algorithm>
#include <string>
#include <array>


// Using Array
bool isPermutationUsingSorting(std::array<char, 6> a, std::array<char, 6> b)
{
    std::sort(a.begin(), a.end());
    std::sort(b.begin(), b.end());
    
    for(int i = 0; i < a.size(); i++)
    {
        if(a[i] != b[i])
            return false;
    }
    return true;
}

bool isPermutationUsingHashTable(std::array<char, 6> a, std::array<char, 6> b)
{
    int hashTable[128] = {}; //Assuming ASCII is used
    
    for(int i = 0; i < a.size(); i++)
    {
        hashTable[a[i]] ++;
    }
    
    for(int j = 0; j < b.size(); j++)
    {
        hashTable[b[j]] --;
        if(hashTable[b[j]] < 0)
            return false;
    }
    
    return true;
}

// Using Vector
bool isPermutationUsingSort_vector(std::vector<char> a, std::vector<char> b)
{
    if(a.size() != b.size())
        return false;
    
    std::sort(a.begin(), a.end());
    std::sort(b.begin(), b.end());
    
    for(int i = 0; i < a.size(); i++)
    {
        if(a[i] != b[i])
            return false;
    }
    
    return true;
}

bool isPermutationUsingHashTable_vector(std::vector<char> a, std::vector<char> b)
{
    if(a.size() != b.size())
        return false;
    
    int hashTable[128] = {};
    for(int i = 0; i < a.size(); i ++)
    {
        hashTable[a[i]] ++;
    }
    
    for(int j = 0; j < b.size(); j ++)
    {
        hashTable[b[j]] --;
        if(hashTable[b[j]] < 0)
            return false;
    }
    return true;
}

int main(int argc, const char * argv[]) {
    
    std::array<char, 6> charArray = {'T','o','m','m','y','s'};
    std::array<char, 6> charArray2 = {'o','T','m','y','s','m'};
    std::array<char, 6> charArray3 = {'a','c','e','f','w','e'};
    
    std::cout << isPermutationUsingSorting(charArray, charArray2) << "\n"; // Expected output : 1
    std::cout << isPermutationUsingSorting(charArray2, charArray3) << "\n"; // Expected output : 0
    
    std::cout << isPermutationUsingHashTable(charArray, charArray2) << "\n"; // Expected output : 1
    std::cout << isPermutationUsingHashTable(charArray2, charArray3) << "\n" << "\n"; // Expected output : 0
    
    std::vector<char> charVector = {'T','o','m','m','y','s'};
    std::vector<char> charVector2 = {'o','T','m','y','s','m'};
    std::vector<char> charVector3 = {'a','c','e','f','w','e'};
    std::vector<char> charVector4 = {'T','o','m','m','y','s', 'k'};;
    
    std::cout << isPermutationUsingSort_vector(charVector, charVector2) << "\n"; // Expected output : 1
    std::cout << isPermutationUsingSort_vector(charVector2, charVector3) << "\n"; // Expected output : 0
    
    std::cout << isPermutationUsingHashTable_vector(charVector, charVector2) << "\n"; // Expected output : 1
    std::cout << isPermutationUsingHashTable_vector(charVector2, charVector3) << "\n"; // Expected output : 0
    std::cout << isPermutationUsingHashTable_vector(charVector2, charVector4) << "\n"; // Expected output : 0
    return 0;
}


