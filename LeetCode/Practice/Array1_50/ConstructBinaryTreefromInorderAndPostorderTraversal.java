package com.dalai.array1_50;

/*Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.
 * */

public class ConstructBinaryTreefromInorderAndPostorderTraversal {

	// 106. Construct Binary Tree from Inorder and Postorder Traversal
	public TreeNode buildTree(int[] inorder, int[] postorder) {

		if (inorder == null || postorder == null || inorder.length == 0 || postorder.length == 0)
			return null;
		return build(inorder, 0, postorder, 0, postorder.length);

	}

	public TreeNode build(int[] inorder, int inBeg, int[] postorder, int postBeg, int len) {

		if (len == 0)
			return null;
		TreeNode root = new TreeNode(postorder[postBeg + len - 1]);
		int index = 0;
		while (index < len) {
			if (postorder[len + postBeg - 1] == inorder[index + inBeg]) {
				break;
			}
			index++;
		}

		if (index + inBeg > inBeg) {
			root.left = build(inorder, inBeg, postorder, postBeg, index);
		}

		int inRightLen = len - 1 - index;

		if (inRightLen > 0) {
			root.right = build(inorder, index + 1 + inBeg, postorder, index + postBeg, inRightLen);
		}
		return root;
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
}
