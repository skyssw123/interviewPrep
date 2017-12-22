//
//  main.cpp
//  BinarySearch
//
//  Created by Thomas Sin on 2017-12-20.
//  Copyright © 2017 TomSin. All rights reserved.
//

#include <iostream>
#include <array>


int binarySearch_loop(std::array<int, 10> a, int value)
{
    int low = 0;
    int high = a.size() - 1;
    while (low <= high)
    {
        int mid = (low + high) / 2;
        if(a[mid] == value)
        {
            return mid;
        }
        
        else if(a[mid] < value)
        {
            low = mid + 1;
        }
        
        else
            high = mid - 1;
    }
    return -1;
}

int binarySearch_recursive(std::array<int, 10> a, int low, int high, int value)
{
    if(low > high)
        return -1;
    
    int mid = (low + high) / 2;
    if(a[mid] == value)
        return mid;
    else if (a[mid] > value)
        return binarySearch_recursive(a, low, mid-1, value);
    else
        return binarySearch_recursive(a, mid+1, high, value);
}


int main(int argc, const char * argv[]) {
    // insert code here...
    std::cout << "Hello, World!\n";
    
    //int a[] = {1,2,3,4};
    std::array<int, 10> a = {1, 21, 33, 44, 55, 66, 77, 88, 99, 100};
    std::cout<< binarySearch_loop(a, 88) << "\n";    //Expected output: 7
    std::cout<< binarySearch_loop(a, 21) << "\n";    //Expected output: 1
    std::cout<< binarySearch_loop(a, 22) << "\n";    //Expected output: -1
    
    std::cout<< binarySearch_recursive(a, 0, 9, 88) << "\n";    //Expected output: 7
    std::cout<< binarySearch_recursive(a, 0, 9, 21) << "\n";    //Expected output: 1
    std::cout<< binarySearch_recursive(a, 0, 9, 22) << "\n";    //Expected output: -1
    return 0;
}



