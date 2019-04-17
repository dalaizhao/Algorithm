#include<stdio.h>

struct TreeNode{
    int val;
    struct TreeNode *left;
    struct TreeNode *right;
}

bool recursive(struct TreeNode* root , int val){
    if(root == NULL){
        return true;
    }
    if(root->val == val){
        bool left = true;
        bool right =true;
        if(root->left != NULL){
            left = recursive(root->left,root->val);
        }
        if(root->right != NULL){
            right = recursive(root->right,root->val);
        }
        return left && right;
    }
    return false;

}


bool isUnivalTree(struct TreeNode* root){
    if(root == NULL){
        return true;
    }
    return recursive(root,root->val);
}
