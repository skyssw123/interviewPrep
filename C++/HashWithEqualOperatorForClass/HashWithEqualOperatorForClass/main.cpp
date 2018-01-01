//
//  main.cpp
//  HashWithEqualOperatorForClass
//
//  Created by Thomas Sin on 2017-12-31.
//  Copyright © 2017 TomSin. All rights reserved.
//

#include <iostream>
#include <string>
#include <unordered_set>

class Rectangle
{
public:
    int width; int height;
    Rectangle()
    {
        width = 0; height = 0;
    }
    Rectangle(int x, int y)
    {
        width = x; height = y;
    }
    bool operator == (const Rectangle& anotherRectangle) const
    {
        return (width == anotherRectangle.width && height == anotherRectangle.height);
    }
};

namespace std
{
    template<>
    struct hash<Rectangle>
    {
        size_t operator() (const Rectangle & k) const
        {
            return k.width + k.height;
        }
    };
}

int main(int argc, const char * argv[]) {
    Rectangle rectangle1 = Rectangle(1, 3);
    Rectangle rectangle2 = Rectangle(13, 23);
    Rectangle rectangle3 = Rectangle(599, 698);
    Rectangle rectangle4 = Rectangle(13, 23);
    
    std::unordered_set<Rectangle> t;
    t.insert(rectangle1);
    t.insert(rectangle2);
    t.insert(rectangle3);
    t.insert(rectangle4);
    
    for(std::unordered_set<Rectangle>::iterator it=t.begin(); it!=t.end(); ++it)
    {
        Rectangle rect = (*it);
        std::cout<< rect.width << " " << rect.height << std::endl;
    }
    
    return 0;
}
