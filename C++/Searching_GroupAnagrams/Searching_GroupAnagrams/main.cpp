//
//  main.cpp
//  Searching_GroupAnagrams
//
//  Created by Thomas Sin on 2017-12-25.
//  Copyright © 2017 TomSin. All rights reserved.
//

#include <iostream>
#include <algorithm>
#include <unordered_map>
#include <vector>
#include <string>
#include <array>

std::unordered_map<std::string, std::vector<std::string>> groupAnagram(std::array<std::string, 8> inputArray)
{
    std::unordered_map<std::string, std::vector<std::string>> hashmap;
    for(std::array<std::string, 8>::iterator it = inputArray.begin(); it < inputArray.end(); ++it)
    {
        std::string str = *it;
        std::string sortedStr;
        sortedStr = str;
        std::sort(sortedStr.begin(), sortedStr.end());
        if(!hashmap.count(sortedStr))
            hashmap.emplace(sortedStr, std::vector<std::string>());
        hashmap.at(sortedStr).push_back(str);
    }
    
    return hashmap;
}

int main(int argc, const char * argv[]) {
    // insert code here...
    std::array<std::string, 8> strArray = {"sucre", "abc", "cba", "recus", "kp", "cuers", "erpo", "pk"};
    
    std::unordered_map<std::string, std::vector<std::string>> hashmap = groupAnagram(strArray);
    
    for(std::unordered_map<std::string, std::vector<std::string>>::iterator it = hashmap.begin(); it != hashmap.end(); ++it)
    {
        for(int i = 0 ; i < it->second.size(); i++)
        {
            std::cout << it->second[i] << " ";
        }
            
    }
    std::cout << std::endl;
    
    return 0;
}
