package com.algorithm.dfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class Graph {
	private static Map<Node, List<Node>> graph = new LinkedHashMap<Node, List<Node>>();
	private static Stack<Node> nodeStack = new Stack<Node>();
	private static Queue<Node> nodeQueue = new ArrayDeque<Node>();
	private static List<Node> visitedNodes = new LinkedList<Node>();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Node n1 = new Node("A", 1);
		Node n2 = new Node("B", 2);
		Node n3 = new Node("C", 3);
		Node n4 = new Node("D", 4);
		Node n5 = new Node("E", 5);
		Node n6 = new Node("F", 6);
		Node n7 = new Node("G", 7);
		Node n8 = new Node("H", 8);

		// Connecting from Node A
		connectNode(n1, n2);
		connectNode(n1, n7);
		connectNode(n1, n4);
		// Connecting from Node B
		connectNode(n2, n5);
		connectNode(n2, n6);
		connectNode(n2, n1);
		// Connecting from Node C
		connectNode(n3, n6);
		connectNode(n3, n8);
		// Connecting from Node D
		connectNode(n4, n1);
		connectNode(n4, n6);
		// Connecting from Node E
		connectNode(n5, n7);
		connectNode(n5, n2);
		// Connecting from Node F
		connectNode(n6, n2);
		connectNode(n6, n3);
		connectNode(n6, n4);
		// Connecting from Node G
		connectNode(n7, n5);
		connectNode(n7, n1);
		// Connecting from Node H
		connectNode(n8, n3);
		// Do Depth First Search
		 depthFirstSearch(n1);
		// Do Breadth First Search
//		breadthFirstSearch(n1);
		// Prints the Result
		printGraph();
	}

	private static void printGraph() {
		System.out.println("GRAPH :" + graph);
		System.out.println("RESULT :" + visitedNodes);
		System.out.println("STACK :" + nodeStack);
		System.out.println("STACK :" + nodeQueue);

	}

	private static void connectNode(Node n1, Node n2) {
		if (graph.containsKey(n1)) {
			graph.get(n1).add(n2);
		} else {
			List<Node> nodeList = new ArrayList<Node>();
			nodeList.add(n2);
			graph.put(n1, nodeList);
		}
	}

	private static void depthFirstSearch(Node rootNode) {
		nodeStack.push(rootNode);
		visitedNodes.add(rootNode);
		traverse(rootNode);
	}

	private static void traverse(Node node) {
		List<Node> list = graph.get(node);
		if (list != null) {
			for (Node n : list) {
				if (!visitedNodes.contains(n)) {
					visitedNodes.add(n);
					nodeStack.push(n);
					traverse(n);
				} else {
					continue;
				}
			}
		}
	}

	private static void breadthFirstSearch(Node rootNode) {
		traverseBFS(rootNode);

	}

	private static void traverseBFS(Node rootNode) {
		// Queue<Node> q = new ArrayDeque<Node>();
		nodeQueue.add(rootNode);
		while (!nodeQueue.isEmpty()) {
			Node u = nodeQueue.remove();
			List<Node> adj_u = graph.get(u);
			if (adj_u != null) {
				for (Node v : adj_u) {
					nodeQueue.add(v);
				}
			}
		}

		// visitedNodes.add(rootNode);
		// nodeQueue.add(rootNode);
		// while (!nodeQueue.isEmpty()) {
		// Node node = nodeQueue.remove();
		// List<Node> list = graph.get(node);
		// if (list != null) {
		// for (Node n : list) {
		// if (!nodeQueue.contains(n)) {
		// nodeQueue.add(n);
		// }
		// if (!visitedNodes.contains(n)) {
		// visitedNodes.add(n);
		// }
		// }
		// }
		// }
	}
}

class Node {
	String node;
	int distance;
	public boolean visited;

	public Node(String node, int distance) {
		this.node = node;
		this.distance = distance;
	}

	@Override
	public String toString() {
		return "(" + node + "," + distance + ")";
	}

	@Override
	public boolean equals(Object other) {
		if (other == null)
			return false;
		if (other == this)
			return true;
		if (!(other instanceof Node))
			return false;
		if (other instanceof Node) {
			Node otherNode = (Node) other;
			if (otherNode.node == ((Node) other).node)
				return true;
			else
				return false;
		}
		return false;

	}

	@Override
	public int hashCode() {
		return this.node.length() + 31;
	}
}