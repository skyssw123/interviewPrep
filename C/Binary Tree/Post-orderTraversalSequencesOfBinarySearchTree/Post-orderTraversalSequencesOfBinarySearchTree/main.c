//
//  main.c
//  Post-orderTraversalSequencesOfBinarySearchTree
//
//  Created by Thomas Sin on 2016-09-24.
//  Copyright © 2016 sin. All rights reserved.
//

#include <stdio.h>
#include <stdbool.h>
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

bool VerifySequenceOfBST(int sequence[], int length){
    //Q. Determine whether an input array is a post-order traversal sequence of a binary tree or not. If it is, return true; otherwise return false. Assume all numbers in an input array are unique.
    
    // tip 1) Post-order: left -> right -> node
    // tip 2) Root is located at the last element of array for post-order sequence of BST
    // tip 3) Other numbers are partitioned into two parts: the left numbers which are less than the value of root node, are the value of nodes in left sub-tree; the following numbers, which are greater than the value of root node, are value of nodes in the right sub-tree.
    
    if(sequence == NULL || length <= 0)
        return false;
    
    int root = sequence[length-1];
    int i = 0;
    for(; i < length-1; ++i)
    {
        if(root < sequence[i])
            break;
    }
    int j = i;
    for(; j < length-1; ++j)
    {
        if(root > sequence[j])
            return false;
    }
    bool left = true;
    if(i > 0)
        left = VerifySequenceOfBST(sequence, i);
    bool right = true;
    if(i < length-1)
        right = VerifySequenceOfBST(sequence + i, length-i-1);
    
    return left&&right;
}

int main(int argc, const char * argv[]) {
    int array[7] = {5, 3, 6, 9, 11, 10, 8};
    bool result = VerifySequenceOfBST(array, 7);
    printf("Is it post-order traversal sequence of Binary Search Tree? : %d\n", result);
    //Should be true
    
    int array2[7] = {7, 3, 6, 9, 11, 10, 8};
    bool result2 = VerifySequenceOfBST(array2, 7);
    printf("Is it post-order traversal sequence of Binary Search Tree? : %d\n", result2);
    //Should be false
    return 0;
}

