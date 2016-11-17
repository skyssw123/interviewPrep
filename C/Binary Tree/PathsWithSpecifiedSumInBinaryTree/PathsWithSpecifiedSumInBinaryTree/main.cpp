//
//  main.cpp
//  PathsWithSpecifiedSumInBinaryTree
//
//  Created by Thomas Sin on 2016-09-23.
//  Copyright © 2016 sin. All rights reserved.
//

#include <iostream>
#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>
#include <assert.h>
#include <vector>

typedef struct BinaryTreeNode BinaryTreeNode;
struct BinaryTreeNode
{
    int m_nValue;
    BinaryTreeNode* m_pLeft;
    BinaryTreeNode* m_pRight;
};

BinaryTreeNode* CreateBinaryTreeNode(int value)
{
    BinaryTreeNode* node = (BinaryTreeNode*)malloc(sizeof(BinaryTreeNode));
    node->m_nValue = value;
    return node;
}

void FindPathUtil(BinaryTreeNode* root, int expectedSum, int currentSum, std::vector<int>& path)
{
    //It is required to traverse tree in pre-order (Node -> Left -> Right)
    if(root == NULL)
        return;
    currentSum += root->m_nValue;
    path.push_back(root->m_nValue);
    bool leaf = (root->m_pLeft == NULL)&&(root->m_pRight == NULL);
    if(leaf && expectedSum == currentSum)
    {
        printf("\nPath Found! : \n");
        std::vector<int>::iterator iter = path.begin();
        for(;iter < path.end(); iter ++)
        {
            printf("%d\n", *iter);
        }
    }
    
    if(root -> m_pLeft != NULL)
        FindPathUtil(root->m_pLeft, expectedSum, currentSum, path);
    if(root -> m_pRight != NULL)
        FindPathUtil(root->m_pRight, expectedSum, currentSum, path);
    
    //Before returning back to its parents, remove it from path..
    path.pop_back();
}

void FindPath(BinaryTreeNode* root, int expectedSum)
{
    std::vector<int> path;
    int currentSum = 0;
    if(root == NULL)
        return;
    FindPathUtil(root, expectedSum, currentSum, path);
}

int main(int argc, const char * argv[]) {
    // insert code here...
    BinaryTreeNode* a = CreateBinaryTreeNode(10);
    BinaryTreeNode* b = CreateBinaryTreeNode(5);
    BinaryTreeNode* c = CreateBinaryTreeNode(12);
    BinaryTreeNode* d = CreateBinaryTreeNode(4);
    BinaryTreeNode* e = CreateBinaryTreeNode(7);
    a->m_pLeft = b;
    a->m_pRight = c;
    b->m_pLeft = d;
    b->m_pRight = e;
    c->m_pLeft = NULL;
    c->m_pRight = NULL;
    d->m_pLeft = NULL;
    d->m_pRight = NULL;
    e->m_pLeft = NULL;
    e->m_pRight = NULL;
    
    // BinaryTree is like      10
    //                      5      12
    //                    4  7
    
    // Expected outcome would be : (10, 5, 7) ,  (10, 12)
    FindPath(a, 22);
    
    return 0;
}



