//
//  main.cpp
//  Searching_FindLargest&SmalestInListSortedAsTwoSections
//
//  Created by Thomas Sin on 2017-12-28.
//  Copyright © 2017 TomSin. All rights reserved.
//



//Q. Find the largest and smallest # in a list. THe list is sorted as two sections,
//   one in ascending order and the other in descending order
//    input: {2, 3, 4, 5, 6, 7, 10, 9, 8, 7}
//      output: 2, 10
#include <iostream>
#include <array>
#include <vector>

int findSmallest(std::vector<int> vector)
{
    return vector[0]<vector[vector.size()-1] ? vector[0]:vector[vector.size()-1];
}

int findBiggest(std::vector<int> vector)
{
    int low = 0;
    int high = vector.size() - 1;
    
    while(low <= high)
    {
        int mid = (low + high) / 2;
        if(vector[mid] > vector[mid-1] && vector[mid] > vector[mid + 1])
            return vector[mid];
        else if(vector[mid] < vector[mid+1])
            low = mid + 1;
        else if(vector[mid] > vector[mid+1])
            high = mid - 1;
    }
    return -1;
}

int main(int argc, const char * argv[]) {
    
    std::vector<int> vector = {2, 3, 4, 5, 6, 7, 10, 9, 8, 7};
    
    
    std::cout << findSmallest(vector) << std::endl;
    std::cout << findBiggest(vector) << std::endl;
    
    
    return 0;
}
