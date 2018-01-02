#include <iostream>

template<class T>
class myContainer{
    T element;
public:
    myContainer(T arg)
    {
        element = arg;
    }
    T increase()
    {
        return ++element;
    }
};

template<>
class myContainer<char> {
    char element;
public:
    myContainer(char arg)
    {
        element = arg;
    }
    char uppercase()
    {
        if(element >= 'a' && element <= 'z')
            element += ('A' - 'a');
        return element;
    }
};

int main()
{
    myContainer<float> a (11.2);
    std::cout<< a.increase() << std::endl;
    
    myContainer<char> b ('f');
    std::cout<< b.uppercase() << std::endl;
    return 0;
}
