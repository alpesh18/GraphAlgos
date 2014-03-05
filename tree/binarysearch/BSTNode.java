package com.tree.binarysearch;

public class BSTNode {

	int value;
	BSTNode leftNode;
	BSTNode rightNode;

	public BSTNode(int value) {
		this.value = value;
	}

	public void setLeftNode(BSTNode leftNode) {
		this.leftNode = leftNode;
	}

	public BSTNode getLeftNode() {
		return leftNode;
	}

	public void setRightNode(BSTNode rightNode) {
		this.rightNode = rightNode;
	}

	public BSTNode getRightNode() {
		return rightNode;
	}

	public int getData() {
		return value;
	}

	public void setData(int value) {
		this.value = value;
	}
}
