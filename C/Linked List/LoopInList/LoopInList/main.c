//
//  main.c
//  LoopInList
//
//  Created by Thomas Sin on 2016-09-20.
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

void printList(ListNode* pListHead)
{
    while (pListHead != NULL)
    {
        printf("%d\n", pListHead->m_nValue);
        pListHead = pListHead->m_pNext;
    }
}

//Q1. How to check whether there is a loop in a linked list?
bool HasLoop(ListNode* pHead)
{
    if(pHead == NULL)
        return false;
    ListNode* slow = pHead->m_pNext;
    if(slow == NULL)
        return false;
    
    ListNode* fast = slow->m_pNext;
    while (slow != NULL && fast != NULL)
    {
        if(slow == fast)
            return true;
        slow = slow->m_pNext;
        fast = fast->m_pNext;
        if(fast != NULL)
            fast = fast->m_pNext;
    }
    return false;
}

//Question 2: If there is a loop in a linked list, how to get the entry node of the loop?
//The entry node is the first node in the loop from head of list.
// The entry node can be obtained by movnig n times from the head where n is the size of loop
ListNode* MeetingNode(ListNode* pHead)
{
    if(pHead == NULL)
        return NULL;
    ListNode* slow = pHead->m_pNext;
    if(slow == NULL)
        return NULL;
    ListNode* fast = slow->m_pNext;
    while (slow != NULL && fast != NULL)
    {
        if(slow == fast)
            return fast;
        slow = slow->m_pNext;
        fast = fast->m_pNext;
        if (fast != NULL)
            fast = fast->m_pNext;
    }
    return NULL;
}

ListNode* EntryNode(ListNode* pHead)
{
    ListNode* meetingNode = MeetingNode(pHead);
    if(meetingNode == NULL)
        return NULL;
    
    //This is to get n, the size of loop
    int n = 1;
    ListNode* node = meetingNode;
    while(node -> m_pNext != meetingNode)
    {
        n++;
        node = node->m_pNext;
    }
    
    //move node n steps from head
    node = pHead;
    for(int i = 0 ; i < n ; i++)
    {
        node = node->m_pNext;
    }
    
    //move node and node2
    ListNode* node2 = pHead;
    while(node != node2)
    {
        node = node->m_pNext;
        node2 = node2->m_pNext;
    }
    
    return node;
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
    printf("%d\n",HasLoop(a)); // should be false
    e->m_pNext = d;
    printf("%d\n",HasLoop(a)); // should be true
    
    printf("%d\n",EntryNode(a)->m_nValue); // should be 4, it is now pointing d..
    
    return 0;
}
