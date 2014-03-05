package com.algorithm.dfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BFS {
	private Node rootNode;

	public void breadthFirstSearch() {
		// BFS uses Queue data structure
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(this.rootNode);
		printNode(this.rootNode);
		rootNode.visited = true;
		while (!queue.isEmpty()) {
			Node node = (Node) queue.remove();
			Node child = null;
			while ((child = getUnvisitedChildNode(node)) != null) {
				child.visited = true;
				printNode(child);
				queue.add(child);
			}
		}
		// Clear visited property of nodes
		clearNodes();
	}

	public void dfs() {
		// DFS uses Stack data structure
		Stack<Node> stack = new Stack<Node>();
		stack.push(this.rootNode);
		rootNode.visited = true;
		printNode(rootNode);
		while (!stack.isEmpty()) {
			Node node = (Node) stack.peek();
			Node child = getUnvisitedChildNode(node);
			if (child != null) {
				child.visited = true;
				printNode(child);
				stack.push(child);
			} else {
				stack.pop();
			}
		}
		// Clear visited property of nodes
		clearNodes();
	}

	private Node getUnvisitedChildNode(Node node) {
		// TODO Auto-generated method stub
		return null;
	}

	private void printNode(Node rootNode2) {
		// TODO Auto-generated method stub

	}

	private void clearNodes() {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {

		BFS bfs = new BFS();
		bfs.breadthFirstSearch();
	}
}
