//
//  main.cpp
//  ExampleCPlusPlusProject
//
//  Created by Thomas Sin on 2017-12-20.
//  Copyright © 2017 TomSin. All rights reserved.
//

#include <iostream>
#include <vector>
#include <unordered_map>
#include <string>



int main(int argc, const char * argv[]) {
    
    std::unordered_map<std::string, std::string> hashMap;
    std::vector<int> vector (4, 5);
    
    hashMap.emplace("hello","hi");
    hashMap.emplace("sorry", "my Bad");
    hashMap.emplace("great", "awesome");
    hashMap.emplace("key", "door");
    
    for(std::unordered_map<std::string, std::string>::iterator it = hashMap.begin(); it != hashMap.end() ; ++it)
    {
        std::cout<< "key : " << it->first << "   value: " << it->second << std::endl;
    }
    
    
    
    std::cout<< hashMap.at("sorry") << std::endl;
    std::cout<< hashMap.at("great") << std::endl;
    std::cout<< hashMap.size() << std::endl;
    
    
    
    return 0;
}

