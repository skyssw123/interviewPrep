#include <iostream>

template<class T>
T GetMax(T a, T b)
{
    return a > b ? a : b;
}

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
    T decrease();
};

template<class T>
T myContainer<T>::decrease()
{
    return --element;
}

//template specialization:
template<>
class myContainer<char>{
    char element;
public:
    myContainer(char arg)
    {
        element = arg;
    }
    char uppercase()
    {
        if(element >= 'a' && element <= 'z')
            element += ('A'-'a');
        return element;
    }
    char lowercase();
};

char myContainer<char>::lowercase()
{
    if(element >= 'A' && element <= 'Z')
        element -= ('A'-'a');
    return element;
}

int main()
{
    std::cout<< GetMax<float>(4.7, 8.1) << std::endl; // 8.1
    
    myContainer<int> intContainer (7);
    std::cout << intContainer.decrease() << std::endl; //6
    std::cout << intContainer.increase() << std::endl; //7
    
    myContainer<char> charContainer('c');
    std::cout << charContainer.uppercase() << std::endl; // C
    std::cout << charContainer.lowercase() << std::endl; // c
    std::cout << charContainer.lowercase() << std::endl; // c
    
    return 0;
}



