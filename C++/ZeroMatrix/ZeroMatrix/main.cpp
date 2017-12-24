//
//  main.cpp
//  ZeroMatrix
//
//  Created by Thomas Sin on 2017-12-22.
//  Copyright © 2017 TomSin. All rights reserved.
//

#include <iostream>
#include <array>
#include <vector>
#include <algorithm>


// For std::array
std::array<std::array<int, 5>, 5> nullifyRow(int col, std::array<std::array<int, 5>, 5> array)
{
    for(int i = 0; i < 5; i++)
    {
        array[i][col] = 0;
    }
    
    return array;
}

std::array<std::array<int, 5>, 5> nullifyCol(int row, std::array<std::array<int, 5>, 5> array)
{
    for(int j = 0; j < 5; j++)
    {
        array[row][j] = 0;
    }
    
    return array;
}

std::array<std::array<int, 5>, 5> setZero(std::array<std::array<int, 5>, 5> array)
{
    bool row[5] = {};
    bool col[5] = {};
    
    for(int i = 0; i < 5 ; i ++)
    {
        for(int j = 0; j < 5; j ++)
        {
            if(array[i][j] == 0)
            {
                row[i] = 1;
                col[j] = 1;
            }
        }
    }
    
    for(int i = 0; i < 5; i ++)
    {
        if(row[i] == 1)
            array = nullifyCol(i, array);
    }
    
    for(int j = 0; j < 5; j ++)
    {
        if(col[j] == 1)
            array = nullifyRow(j, array);
    }
    
    return array;
}

std::array<std::array<int, 5>, 5> generateMatrix()
{
    std::array<std::array<int, 5>, 5> matrix = {{}};
    for(int i = 0; i < matrix.size(); i++)
    {
        for(int j = 0; j < matrix.size(); j++)
        {
            matrix[i][j] = 1;
        }
    }
    return matrix;
}

void printMatrix(std::array<std::array<int, 5>, 5> matrix)
{
    for(int i = 0; i < matrix.size(); i++)
    {
        for(int j = 0; j < matrix[0].size(); j++)
        {
            std::cout << matrix[i][j] << " ";
        }
        std::cout << "\n";
    }
}


//For array[][]
void nullifyRow2(int col, int array[5][5])
{
    for(int i = 0; i < 5; i++)
        array[i][col] = 0;
}

void nullifyCol2(int row, int array[5][5])
{
    for(int j = 0; j < 5; j++)
        array[row][j] = 0;
}

void setZero2(int array[5][5])
{
    bool row[5] = {};
    bool col[5] = {};
    for(int i = 0; i < 5; i++)
    {
        for(int j = 0; j < 5; j++)
        {
            if(array[i][j] == 0)
            {
                row[i] = 1;
                col[j] = 1;
            }
        }
    }
    
    for(int i = 0; i < 5 ; i++)
    {
        if(row[i] == 1)
            nullifyCol2(i, array);
    }
    
    for(int j = 0; j < 5 ; j++)
    {
        if(col[j] == 1)
            nullifyRow2(j, array);
    }
}

void generateMatrix2(int a[5][5])
{
    for(int i = 0; i < 5 ; i ++)
    {
        for(int j = 0; j < 5 ; j ++)
            a[i][j] = 1;
    }
}

void printMatrix2(int matrix[5][5])
{
    for(int i = 0; i < 5; i++)
    {
        for(int j = 0; j < 5; j++)
        {
            std::cout << matrix[i][j] << " ";
        }
        std::cout << "\n";
    }
}

int main(int argc, const char * argv[]) {
    
    //Pass by Value using std::array<>...
    
    std::array<std::array<int, 5>, 5> matrix = generateMatrix();
    matrix[1][1] = 0;
    matrix[3][2] = 0;
    printMatrix(matrix);
    matrix = setZero(matrix);
    std::cout << "\n\n";
    printMatrix(matrix);
    std::cout << "\n\n";
    
    //Pass by Reference using array[][]...
    
    int matrix2[5][5];
    generateMatrix2(matrix2);
    matrix2[1][1] = 0;
    matrix2[3][2] = 0;
    printMatrix2(matrix2);
    setZero2(matrix2);
    std::cout << "\n\n";
    printMatrix2(matrix2);
    
    return 0;
}


