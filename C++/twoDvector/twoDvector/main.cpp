//
//  main.cpp
//  ExampleCPlusPlusProject
//
//  Created by Thomas Sin on 2017-12-20.
//  Copyright © 2017 TomSin. All rights reserved.
//

#include <iostream>
#include <vector>

void change2DvectorByReference(std::vector<std::vector<int>> twoDvector)
{
    twoDvector[2][1] = 8;
}

std::vector<std::vector<int>> change2DvectorByValue(std::vector<std::vector<int>> twoDvector)
{
    twoDvector[2][1] = 8;
    return twoDvector;
}

void print2Dvector(std::vector<std::vector<int>> twoDvector)
{
    for(int i = 0; i < twoDvector.size(); i++)
    {
        for(int j = 0 ; j < twoDvector[0].size(); j++)
        {
            std::cout << twoDvector[i][j] << " ";
        }
        std::cout << std::endl;
    }
}

int main(int argc, const char * argv[]) {
    std::vector<int> vector(3, 99);
    std::vector<int> vector2(3, 111);
    std::vector<int> vector3(3, 77);
    
    std::vector<std::vector<int>> twoDvector = {vector, vector2, vector3};
    change2DvectorByReference(twoDvector);
    print2Dvector(twoDvector);
    std::cout<<std::endl;
    twoDvector = change2DvectorByValue(twoDvector);
    print2Dvector(twoDvector);
    return 0;
}

