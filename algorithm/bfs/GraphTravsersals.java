package com.algorithm.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class GraphTravsersals {

	private List<Node> nodes = new ArrayList<Node>();

	public void breadthFirstTraversal(Node rootNode) {
		Queue<Node> q = new LinkedList<Node>();
		q.add(rootNode);
		rootNode.visited = true;
		System.out.println("*****BFS******");
		while (!q.isEmpty()) {
			Node n = (Node) q.poll();
			System.out.print(n.data + " ");
			for (Node adj : n.adjacentNodes) {
				if (!adj.visited) {
					adj.visited = true;
					q.add(adj);
				}
			}
		}
	}

	/**
	 * Depth First Search ALgo
	 * 
	 * @param rootNode
	 */
	public void depthFirstSearch(Node rootNode) {
		// DFS uses Stack data structure
		Stack<Node> stack = new Stack<Node>();
		stack.push(rootNode);
		rootNode.visited = true;
		System.out.println("\n*****DFS******");
		while (!stack.isEmpty()) {
			Node node = (Node) stack.peek();
			traverse(stack, node);
		}
	}

	public void traverse(Stack<Node> stack, Node node) {
		System.out.print(node.data + " ");
		List<Node> adjacentNodes = node.adjacentNodes;
		if (adjacentNodes != null) {
			for (Node adj : adjacentNodes) {
				if (!adj.visited) {
					adj.visited = true;
					stack.push(adj);
					traverse(stack, adj);
				} else if (!stack.isEmpty()) {
					stack.pop();
				}
			}
		}
	}

	/**
	 * Main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Node n1 = new Node("A");
		Node n2 = new Node("B");
		Node n3 = new Node("C");
		Node n4 = new Node("D");
		Node n5 = new Node("E");
		Node n6 = new Node("F");
		Node n7 = new Node("G");
		Node n8 = new Node("H");

		GraphTravsersals g = new GraphTravsersals();
		g.nodes.add(n1);
		g.nodes.add(n2);
		g.nodes.add(n3);
		g.nodes.add(n4);
		g.nodes.add(n5);
		g.nodes.add(n6);
		g.nodes.add(n7);
		g.nodes.add(n8);

		// n1
		n1.addAdjacentNode(n3);
		n1.addAdjacentNode(n4);
		n1.addAdjacentNode(n5);

		// n2
		n2.addAdjacentNode(n5);

		// n3
		n3.addAdjacentNode(n4);
		n3.addAdjacentNode(n6);

		// n6
		n6.addAdjacentNode(n5);
		n6.addAdjacentNode(n2);

		g.breadthFirstTraversal(n1);
		// g.depthFirstSearch(n1);

	}
}