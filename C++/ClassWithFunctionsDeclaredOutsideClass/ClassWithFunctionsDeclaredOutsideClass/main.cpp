//
//  main.cpp
//  ClassWithFunctionsDeclaredOutsideClass
//
//  Created by Thomas Sin on 2018-01-02.
//  Copyright © 2018 TomSin. All rights reserved.
//

#include <iostream>

class Rectangle{
public:
    int width; int height;
    int getWidth();
    int getHeight();
    Rectangle()
    {
        width = 0; height = 0;
    }
    Rectangle(int x, int y)
    {
        width = x; height = y;
    }
};

int Rectangle::getWidth()
{
    return width;
}

int Rectangle::getHeight()
{
    return height;
}

int main(int argc, const char * argv[]) {
    Rectangle rect = Rectangle(49, 38);
    std::cout<<rect.getWidth() << " " << rect.getHeight() << std::endl;
    return 0;
}
