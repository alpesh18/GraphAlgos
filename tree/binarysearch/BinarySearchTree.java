package com.tree.binarysearch;

public class BinarySearchTree {

	// insert a BSTNode to the binary search tree
	public void insert(BSTNode root, BSTNode n) {
		if (root == null || n == null)
			return;

		if (root.getData() > n.getData()) { // go left
			if (root.getLeftNode() == null) {
				root.setLeftNode(n);
				System.out.println("Added BSTNode to left of " + root.getData()
						+ " of value " + n.getData());
			} else {
				insert(root.getLeftNode(), n);
			}

		} else if (root.getData() < n.getData()) { // go right
			if (root.getRightNode() == null) {
				root.setRightNode(n);
				System.out.println("Added BSTNode to Right of "
						+ root.getData() + " of value " + n.getData());
			} else {
				insert(root.getRightNode(), n);
			}

		}
	}

	public boolean isValidBST(BSTNode root) {
		if (root == null)
			return true;

		while (root != null) {
			BSTNode leftNode = root.getLeftNode();
			if (leftNode != null && root.getData() > leftNode.getData()) {
				return isValidBST(leftNode);
			} else {
				return isValidBST(root.getRightNode());
			}
		}
		return false;
	}

	public static void main(String[] args) {
		BinarySearchTree bts = new BinarySearchTree();
		bts.run();
	}

	// execute the test case
	public void run() {
		// Root
		BSTNode root = new BSTNode(5);
		// Inserts
		insert(root, new BSTNode(20));
		insert(root, new BSTNode(7));
		insert(root, new BSTNode(4));
		insert(root, new BSTNode(15));

		System.out.println("\n*********InOrder Traversal***********");
		inOrderTraverse(root);
		System.out.println("\n*********PreOrder Traversal***********");
		preOrderTraverse(root);
		System.out.println("\n*********PostOrder Traversal***********");
		postOrderTraverse(root);
		System.out.println("\n*********Binary Search***********");
		System.out.println("\n" + binarySearch(root, new BSTNode(10)));
		System.out.println("\n*********Count of Nodes***********");
		System.out.println("No of nodes : " + countNodes(root));
		System.out.println("Max depth : " + maxDepth(root));

		System.out.println("Is valid : " + isValidBST(root));
	}

	public void inOrderTraverse(BSTNode root) {
		if (root != null) {
			inOrderTraverse(root.getLeftNode());
			System.out.print("  " + root.getData());
			inOrderTraverse(root.getRightNode());
		}
	}

	public void preOrderTraverse(BSTNode root) {
		if (root != null) {
			System.out.print("  " + root.getData());
			preOrderTraverse(root.getLeftNode());
			preOrderTraverse(root.getRightNode());
		}
	}

	public void postOrderTraverse(BSTNode root) {
		if (root != null) {
			postOrderTraverse(root.getLeftNode());
			postOrderTraverse(root.getRightNode());
			System.out.print("  " + root.getData());
		}
	}

	public int maxDepth(BSTNode root) {
		if (root == null) {
			return 0;
		}
		int pLeft = maxDepth(root.getLeftNode());
		int pRight = maxDepth(root.getRightNode());
		return (pLeft > pRight ? pLeft + 1 : pRight + 1);
	}

	/**
	 * Binary Search
	 * 
	 * @param root
	 * @param n
	 * @return
	 */
	public boolean binarySearch(BSTNode root, BSTNode n) {
		if (root == null || n == null) {
			return false;
		}
		System.out.println("  Testing out " + root.getData() + " for value "
				+ n.getData());
		if (root.getData() > n.getData()) {
			return binarySearch(root.getLeftNode(), n);
		} else if (root.getData() < n.getData()) {
			return binarySearch(root.getRightNode(), n);
		}
		return true;
	}

	/*
	 * remove a value from the tree, if it exists
	 * 
	 * @param key such that value.compareTo(key) == 0 for the node to remove
	 * 
	 * @param node the root of the subtree from which to remove the value
	 * 
	 * @return the new tree with the value removed
	 */
	protected BSTNode remove(int value, BSTNode node) {
		if (node == null) { // key not in tree
			return null;
		}
		if (value == node.value) { // remove this node
			if (node.leftNode == null) { // replace this node with right child
				return node.rightNode;
			} else if (node.rightNode == null) { // replace with left child
				return node.leftNode;
			} else {
				// replace the value in this node with the value in the
				// rightmost node of the left subtree
				node.value = getRightmost(node.leftNode);
				// now remove the rightmost node in the left subtree,
				// by calling "remove" recursively
				node.leftNode = remove(node.value, node.leftNode);
				// return node; -- done below
			}
		} else { // remove from left or right subtree
			if (value < node.value) {
				// remove from left subtree
				node.leftNode = remove(value, node.leftNode);
			} else { // remove from right subtree
				node.rightNode = remove(value, node.rightNode);
			}
		}
		return node;
	}

	protected int getRightmost(BSTNode node) {
		assert (node != null);
		BSTNode right = node.rightNode;
		if (right == null) {
			return node.value;
		} else {
			return getRightmost(right);
		}
	}

	/**
	 * Count number of nodes
	 * 
	 * @param root
	 * @return count
	 */
	public int countNodes(BSTNode root) {
		if (root == null)
			return 0; // The tree is empty. It contains no nodes.
		else {
			// Start by counting the root.
			int count = 1;
			// Add the number of nodes in the left subtree.
			count += countNodes(root.leftNode);
			// Add the number of nodes in the right subtree.
			count += countNodes(root.rightNode);
			return count; // Return the total.
		}
	} // end countNodes()
}
