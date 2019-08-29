package org.unclesky4.algorithm.牛客网leetcode.树;

/**
题目描述
求给定二叉树的最小深度。最小深度是指树的根结点到最近叶子结点的最短路径上结点的数量。
Given a binary tree, find its minimum depth.The minimum depth is the number of nodes 
along the shortest path from the root node down to the nearest leaf node.
*/

/**
 * 
 * @author unclesky4 2019.08.22
 *
 */
public class MinDepth {

	public static int minDepth(TreeNode root) {
		if (root == null)
			return 0;
		if (root.left == null && root.right == null)
			return 1;
		if (root.left == null)
			return minDepth(root.right) + 1;
		if (root.right == null)
			return minDepth(root.left) + 1;
		return Math.min(minDepth(root.left) + 1, minDepth(root.right) + 1);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		
		root.left = new TreeNode(5);
		root.left.left = new TreeNode(1);
		
		root.right = new TreeNode(9);
		
		
		System.out.println(minDepth(root));
	}

}

class TreeNode {
	int data;
	TreeNode left;
	TreeNode right;
	
	public TreeNode() {}

	TreeNode(int val) {
		data = val;
	}
}