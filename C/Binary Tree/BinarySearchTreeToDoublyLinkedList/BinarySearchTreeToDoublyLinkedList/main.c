//
//  main.c
//  BinarySearchTreeToDoublyLinkedList
//
//  Created by Thomas Sin on 2016-09-23.
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

void printDoublyLinkedList(BinaryTreeNode* head)
{
    if(head == NULL)
        return;
    printf("Doubly Linked List :\n");
    while(head != NULL)
    {
        printf("%d\n", head->m_nValue);
        head = head->m_pRight;
    }
}

BinaryTreeNode* BinaryTreeToDoublyLinkedListUtil(BinaryTreeNode* root)
{
    if(root == NULL)
        return NULL;
    //We need to traverse the tree in in-order (Left->Node->Right)
    if(root->m_pLeft != NULL)
    {
        BinaryTreeNode* left = BinaryTreeToDoublyLinkedListUtil(root->m_pLeft);
        while(left->m_pRight!=NULL)
            left = left->m_pRight;
        left->m_pRight = root;
        root->m_pLeft = left;
    }
    
    if(root->m_pRight != NULL)
    {
        BinaryTreeNode* right = BinaryTreeToDoublyLinkedListUtil(root->m_pRight);
        while(right->m_pLeft != NULL)
            right = right->m_pLeft;
        right->m_pLeft = root;
        root->m_pRight = right;
    }
    
    return root;
}

BinaryTreeNode* BinaryTreeToDoublyLinkedList(BinaryTreeNode* root)
{
    if(root == NULL)
        return NULL;
    root = BinaryTreeToDoublyLinkedListUtil(root);
    while(root->m_pLeft!=NULL)
        root = root->m_pLeft;
    return root;
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
    g-> m_pRight = NULL;
    
    // BinaryTree is like      10
    //                      6      14
    //                    4  8   12  16
    
    // Expected Outcome is: 4 -> 6 -> 8 -> 10 -> 12 -> 14 -> 16
    BinaryTreeNode* doublyLinkedList = BinaryTreeToDoublyLinkedList(a);
    printDoublyLinkedList(doublyLinkedList);
    
    return 0;
}

