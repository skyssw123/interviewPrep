//
//  main.c
//  ClosestNodeInBinaryTree
//
//  Created by Thomas Sin on 2016-09-24.
//  Copyright © 2016 sin. All rights reserved.
//

#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>
#include <assert.h>

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

BinaryTreeNode* getClosestNode(BinaryTreeNode* pRoot, int value)
{
    //Q. Given a Binary Search Tree and a value k, please find a node in the binary search tree whose value is closes to k.
    int min = 9999999;
    BinaryTreeNode* closestNode = NULL;
    while(pRoot != NULL)
    {
        int distance = abs(value - pRoot->m_nValue);
        if(distance < min)
        {
            min = distance;
            closestNode = pRoot;
        }
        
        if(distance == 0)
            break;
        
        if(pRoot->m_nValue > value)
            pRoot = pRoot->m_pLeft;
        else if(pRoot->m_nValue < value)
            pRoot = pRoot->m_pRight;
    }
    return closestNode;
}

int main(int argc, const char * argv[]) {
    // insert code here...
    BinaryTreeNode* a = CreateBinaryTreeNode(32);
    BinaryTreeNode* b = CreateBinaryTreeNode(24);
    BinaryTreeNode* c = CreateBinaryTreeNode(41);
    BinaryTreeNode* d = CreateBinaryTreeNode(21);
    BinaryTreeNode* e = CreateBinaryTreeNode(28);
    BinaryTreeNode* f = CreateBinaryTreeNode(36);
    BinaryTreeNode* g = CreateBinaryTreeNode(47);
    BinaryTreeNode* h = CreateBinaryTreeNode(14);
    BinaryTreeNode* i = CreateBinaryTreeNode(25);
    BinaryTreeNode* j = CreateBinaryTreeNode(31);
    BinaryTreeNode* k = CreateBinaryTreeNode(39);
    a->m_pLeft = b;
    a->m_pRight = c;
    b->m_pLeft = d;
    b->m_pRight = e;
    c->m_pLeft = f;
    c->m_pRight = g;
    d->m_pLeft = h;
    d->m_pRight = NULL;
    e->m_pLeft = i;
    e->m_pRight = j;
    f->m_pLeft = NULL;
    f->m_pRight = k;
    g->m_pLeft = NULL;
    g-> m_pRight = NULL;
    h->m_pLeft = NULL;
    h-> m_pRight = NULL;
    i->m_pLeft = NULL;
    i-> m_pRight = NULL;
    j->m_pLeft = NULL;
    j-> m_pRight = NULL;
    k->m_pLeft = NULL;
    k-> m_pRight = NULL;
    // Input value is 29 and the input binary tree is like:
    //                             32
    //                      24            41
    //                   21    28      36     47
    //                 14    25  31      39
    
    // Expected outcome: 28
    BinaryTreeNode* closetNode = getClosestNode(a, 29);
    printf("The value of closest node is : %d \n", closetNode->m_nValue);
    
    return 0;
}
