package com.dalai.par;

//606. Construct String from Binary Tree
public class ConstructStringFromBinaryTree {

	/*
	 * You need to construct a string consists of parenthesis and integers from a
	 * binary tree with the preorder traversing way.
	 * 
	 * The null node needs to be represented by empty parenthesis pair "()". And you
	 * need to omit all the empty parenthesis pairs that don't affect the one-to-one
	 * mapping relationship between the string and the original binary tree.
	 */
	public String tree2str(TreeNode t) {

		String root = "";
		if (t == null)
			return root;
		String left = tree2str(t.left);
		String right = tree2str(t.right);
		if (left == "" && right != "") {
			root += t.val + "()(" + right + ")";
		} else if (left != "" && right != "") {
			root += t.val + "(" + left + ")(" + right + ")";
		} else if (left != "" && right == "") {
			root += t.val + "(" + left + ")";
		} else {
			root += t.val;
		}
		return root;
	}

}
