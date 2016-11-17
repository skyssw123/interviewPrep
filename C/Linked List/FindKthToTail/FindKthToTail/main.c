//
//  main.c
//  FindKthToTail
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

ListNode* FindKthToTail(ListNode* pListHead, unsigned int k)
{
    if(pListHead == NULL || k == 0)
        return NULL;
    
    ListNode *pAhead = pListHead;
    ListNode *pBehind = NULL;
    
    for(unsigned int i = 0; i < k - 1; ++ i)
    {
        if(pAhead->m_pNext != NULL)
            pAhead = pAhead->m_pNext;
        else
        {
            return NULL;
        }
    }
    
    pBehind = pListHead;
    while(pAhead->m_pNext != NULL)
    {
        pAhead = pAhead->m_pNext;
        pBehind = pBehind->m_pNext;
    }
    
    return pBehind;
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
    
    // linked list is like    1 -> 2 -> 3 -> 4 -> 5 -> 6
    // so the 2nd element to tail is 5
    int ans = FindKthToTail(a, 2)->m_nValue;
    printf("answer : %d\n", ans);
    return 0;
}
