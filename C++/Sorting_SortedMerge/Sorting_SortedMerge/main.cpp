//
//  main.cpp
//  Sorting_SortedMerge
//
//  Created by Thomas Sin on 2017-12-30.
//  Copyright © 2017 TomSin. All rights reserved.
//

#include <iostream>
#include <vector>
#include <array>

//Q. You are given two sorted arrays, A and B, where A has a large enough buffer at the end
//   to hold B. Write a method to merge B into A in sorted order.

// Tip: Try to move from the end of the arrays to the beginning..

std::vector<int> sorted_merge(std::vector<int> a, std::vector<int> b, int lengthA, int lengthB)
{
    int indexA = lengthA - 1;
    int indexB = lengthB - 1;
    int indexMerged = lengthA + lengthB - 1;
    while(indexMerged >= 0)
    {
        if(a[indexA] >= b[indexB])
        {
            a[indexMerged] = a[indexA];
            --indexA;
        }
        else
        {
            a[indexMerged] = b[indexB];
            --indexB;
        }
        --indexMerged;
    }
    return a;
}

int main(int argc, const char * argv[]) {
    std::vector<int> a = {1, 3, 4, 11, 18, 23, 27, 0, 0, 0 ,0, 0};
    std::vector<int> b = {2, 6, 13, 31, 55};
    
    a = sorted_merge(a, b, a.size()-5, b.size());
    
    for(std::vector<int>::iterator it = a.begin(); it != a.end(); ++it)
    {
        std::cout << *it << " ";
    }
    std::cout << std::endl;
    
    return 0;
}
