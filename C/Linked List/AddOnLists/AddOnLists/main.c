//
//  main.c
//  AddOnLists
//
//  Created by Thomas Sin on 2016-09-21.
//  Copyright © 2016 sin. All rights reserved.
//

#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>
#include <assert.h>
#include <stdbool.h>

typedef struct ListNode ListNode;
struct ListNode
{
    int       m_nValue;
    ListNode* m_pNext;
};

ListNode* CreateListNode(int value)
{
    ListNode* node = (ListNode*)malloc(sizeof(ListNode));
    node->m_nValue = value;
    node->m_pNext = NULL;
    return node;
}


void printList(ListNode* pListHead)
{
    while (pListHead != NULL)
    {
        printf("%d\n", pListHead->m_nValue);
        pListHead = pListHead->m_pNext;
    }
}


ListNode* Reverse(ListNode* pHead)
{
    ListNode* node = pHead;
    ListNode* head = NULL;
    ListNode* next = NULL;
    ListNode* prev = NULL;
    while(node != NULL)
    {
        next = node->m_pNext;
        if(node ->m_pNext == NULL)
            head = node;
        node->m_pNext = prev;
        prev = node;
        node = next;
    }
    return head;
}

ListNode* AddNode(ListNode* pHead1, ListNode* pHead2, int* carry)
{
    int num1 = 0;
    if(pHead1 != NULL)
        num1 = pHead1->m_nValue;
    int num2 = 0;
    if(pHead2 != NULL)
        num2 = pHead2->m_nValue;
    
    int sum = num1 + num2 + *carry;
    *carry = (10 <= sum)?1:0;
    sum = (10 <= sum)?(sum-10):sum;
    
    return CreateListNode(sum);
}

void AppendNode(ListNode** pHead, ListNode** pPrev, ListNode* pNode)
{
    if(*pHead == NULL)
        *pHead = pNode;
    if(*pPrev == NULL)
        *pPrev = pNode;
    else
    {
        (*pPrev)->m_pNext = pNode;
        *pPrev = pNode;
    }
}

ListNode* AddReversed(ListNode* pHead1, ListNode* pHead2)
{
    int carry = 0;
    ListNode* pResultHead = NULL;
    ListNode* pPrev = NULL;
    while(pHead1 != NULL || pHead2 != NULL)
    {
        ListNode* node = AddNode(pHead1, pHead2, &carry);
        AppendNode(&pResultHead, &pPrev, node);
        if(pHead1 != NULL)
            pHead1 = pHead1->m_pNext;
        if(pHead2 != NULL)
            pHead2 = pHead2->m_pNext;
    }
    if(carry > 0)
    {
        ListNode* pNode = CreateListNode(carry);
        AppendNode(&pResultHead, &pPrev, pNode);
    }
    return pResultHead;
}

//Q. Nodes in a list represent a number,
// 123  : 1->2->3
// 4567 : 4->5->6->7
// Implement a function to add in two lists and store the sum into a new list.

// SOL: Reverse both lists, add them, reverse result and return.
ListNode* Add(ListNode* pHead1, ListNode* pHead2)
{
    if(pHead1 == NULL || pHead2 == NULL)
        return NULL;
    ListNode* resultHead = NULL;
    pHead1 = Reverse(pHead1);
    pHead2 = Reverse(pHead2);
    
    ListNode* pResult = AddReversed(pHead1, pHead2);
    return Reverse(pResult);
}

void hello(ListNode* pHead)
{
    pHead = CreateListNode(4);
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
    
    ListNode* g = (ListNode*)malloc(sizeof(ListNode));
    g->m_nValue = 7;
    
    // a->b->c : 1->2->3
    a->m_pNext = b;
    b->m_pNext = c;
    c->m_pNext = NULL;
    
    // d->e->f->g : 4->5->6->7
    d->m_pNext = e;
    e->m_pNext = f;
    f->m_pNext = g;
    g->m_pNext = NULL;
    
    //Expected Output : 123 + 4567 = 4690
    ListNode* result = Add(a, d);
    printList(result);
}
