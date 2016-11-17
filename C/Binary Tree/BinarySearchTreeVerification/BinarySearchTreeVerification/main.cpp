//
//  main.cpp
//  BinarySearchTreeVerification
//
//  Created by Thomas Sin on 2016-09-24.
//  Copyright © 2016 sin. All rights reserved.
//

#include <iostream>
#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>
#include <assert.h>
#include <vector>
#include <stdbool.h>

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


//Solution 1
bool isBST_Solution1Util(BinaryTreeNode* pRoot, int min, int max)
{
    if(pRoot == NULL)
        return true;
    if(pRoot->m_nValue > max || pRoot->m_nValue < min)
        return false;
    bool left = isBST_Solution1Util(pRoot->m_pLeft, min, pRoot->m_nValue);
    bool right = isBST_Solution1Util(pRoot->m_pRight, pRoot->m_nValue, max);
    return left&&right;
}

bool isBST_Solution1(BinaryTreeNode* pRoot)
{
    //1st Soln: Use pre-order approach and verify the range of values of the visited node.
    if(pRoot == NULL)
        return true;
    int min = std::numeric_limits<int>::min();
    int max = std::numeric_limits<int>::max();
    return isBST_Solution1Util(pRoot, min, max);
}


// Solution 2
bool isBST_Solution2Util(BinaryTreeNode* pRoot, int& prev)
{
    if(pRoot == NULL)
        return true;
    
    return isBST_Solution2Util(pRoot->m_pLeft, prev)
            && pRoot->m_nValue >= prev
            && isBST_Solution2Util(pRoot->m_pRight, prev = pRoot->m_nValue);
}

bool isBST_Solution2(BinaryTreeNode* pRoot)
{
    //2nd Soln: Use In-order approach and verify if visited node has greater value than prev.
    if(pRoot == NULL)
        return true;
    int prev = std::numeric_limits<int>::min();
    return isBST_Solution2Util(pRoot, prev);
}

int main(int argc, const char * argv[]) {
    // insert code here...
    BinaryTreeNode* a = CreateBinaryTreeNode(10);
    BinaryTreeNode* b = CreateBinaryTreeNode(6);
    BinaryTreeNode* c = CreateBinaryTreeNode(14);
    BinaryTreeNode* d = CreateBinaryTreeNode(4);
    BinaryTreeNode* e = CreateBinaryTreeNode(8);
    BinaryTreeNode* f = CreateBinaryTreeNode(12);
    BinaryTreeNode* g = CreateBinaryTreeNode(16);
    a->m_pLeft = b;
    a->m_pRight = c;
    b->m_pLeft = d;
    b->m_pRight = e;
    c->m_pLeft = f;
    c->m_pRight = g;
    d->m_pLeft = NULL;
    d->m_pRight = NULL;
    e->m_pLeft = NULL;
    e->m_pRight = NULL;
    f->m_pLeft = NULL;
    f->m_pRight = NULL;
    g->m_pLeft = NULL;
    g->m_pRight = NULL;
    // BinaryTree is like      10
    //                      6       14
    //                    4  8    12  16
    
    // Expected outcome would be : true
    bool soln1 = isBST_Solution1(a);
    printf("Is the tree Binary Search Tree?    Pre-order Soln: %d\n", soln1);
    
    bool soln2 = isBST_Solution2(a);
    printf("Is the tree Binary Search Tree?    In-order Soln: %d\n", soln2);
    return 0;
}



