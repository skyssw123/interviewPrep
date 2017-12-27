//
//  main.cpp
//  SortClass
//
//  Created by Thomas Sin on 2017-12-27.
//  Copyright © 2017 TomSin. All rights reserved.
//

#include <iostream>
#include <algorithm>
#include <vector>
class Rectangle
{
private:
    int width, height;
public:
    int area;
    void setValue(int x, int y)
    {
        width = x;
        height = y;
        area = x * y;
    }
    
    int displayArea()
    {
        return this->area;
    }
    
};

bool compare(const Rectangle& l, const Rectangle& r)
{
    return l.area < r.area;
}

int main(int argc, const char * argv[]) {
    Rectangle rectangle1, rectangle2, rectangle3;
    rectangle1.setValue(4, 5);
    rectangle2.setValue(2, 1);
    rectangle3.setValue(10, 5);
    std::cout<< rectangle1.displayArea() << std::endl; //20
    std::cout<< rectangle2.displayArea() << std::endl; //2
    std::cout<< rectangle3.displayArea() << std::endl; //50
    
    std::vector<Rectangle> vector; // = {rectangle1, rectangle2, rectangle3}
    vector.push_back(rectangle1);
    vector.push_back(rectangle2);
    vector.push_back(rectangle3);
    
    
    std::cout<< std::endl;
    
    std::sort(vector.begin(),vector.end(), compare);
    
    for(std::vector<Rectangle>::iterator it=vector.begin(); it!=vector.end(); ++it)
    {
        std::cout << (*it).displayArea() << std::endl;
    }
    
    std::cout<< std::endl;
    
    return 0;
}

