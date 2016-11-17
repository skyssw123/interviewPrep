//
//  main.c
//  ReverseList
//
//  Created by Thomas Sin on 2016-09-20.
//  Copyright © 2016 sin. All rights reserved.
//
#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>
#include <assert.h>

typedef struct ListNode ListNode;
struct ListNode
{
    int       m_nValue;
    ListNode* m_pNext;
};

ListNode* ReverseList(ListNode* pListHead)
{
    ListNode* reverseHead = NULL;
    ListNode* prevNode = NULL;
    ListNode* node = pListHead;
    while(node != NULL)
    {
        ListNode* next = node->m_pNext;
        if(node->m_pNext == NULL)
            reverseHead = node;
        node->m_pNext = prevNode;
        prevNode = node;
        node = next;
    }
    return reverseHead;
}

void printList(ListNode* pListHead)
{
    while (pListHead != NULL)
    {
        printf("%d\n", pListHead->m_nValue);
        pListHead = pListHead->m_pNext;
    }
}

int main(int argc, const char * argv[]) {
    // insert code here...
    ListNode* a = (ListNode*)malloc(sizeof(ListNode));
    a->m_nValue = 1;
    
    ListNode* b = (ListNode*)malloc(sizeof(ListNode));
    b->m_nValue = 2;
    
    ListNode* c = (ListNode*)malloc(sizeof(ListNode));
    c->m_nValue = 3;
    
    ListNode* d = (ListNode*)malloc(sizeof(ListNode));
    d->m_nValue = 4;
    
    ListNode* e = (ListNode*)malloc(sizeof(ListNode));
    e->m_nValue = 5;
    
    ListNode* f = (ListNode*)malloc(sizeof(ListNode));
    f->m_nValue = 6;
    
    a->m_pNext = b;
    b->m_pNext = c;
    c->m_pNext = d;
    d->m_pNext = e;
    e->m_pNext = f;
    f->m_pNext = NULL;
    
    // The initial linked list is like    1 -> 2 -> 3 -> 4 -> 5 -> 6
    // so the expected output is 6 -> 5 -> 4 -> 3 -> 2 -> 1
    
    //printList(a);
    
    ListNode* reverseHead = ReverseList(a);
    printList(reverseHead);
    
    return 0;
}
