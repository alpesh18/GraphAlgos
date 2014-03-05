package com.algorithm.bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class BreadthFirstSearch {

	/**
	 * Enum NodeColour
	 * 
	 * @author Alpesh
	 * 
	 */
	public enum NodeColour {
		WHITE, GRAY, BLACK
	}

	/**
	 * Static Node class
	 * 
	 * @author Alpesh
	 * 
	 */
	public static class Node {
		int data;
		int distance;
		Node predecessor;
		NodeColour colour;

		public Node(int data) {
			this.data = data;
		}

		public String toString() {
			return "(" + data + ",d=" + distance + ")";
		}
	}

	private Map<Node, List<Node>> nodes;

	public BreadthFirstSearch() {
		nodes = new HashMap<Node, List<Node>>();
	}

	public void addEdge(Node n1, Node n2) {
		if (nodes.containsKey(n1)) {
			List<Node> list = nodes.get(n1);
			list.add(n2);
		} else {
			ArrayList<Node> list = new ArrayList<Node>();
			list.add(n2);
			nodes.put(n1, list);
		}
	}

	public void bfs(Node s) {
		Set<Node> keys = nodes.keySet();
		for (Node u : keys) {
			if (u != s) {
				// Initially mark color of all the adjacent node of the
				// corresponding vertex as white
				u.colour = NodeColour.WHITE;
				u.distance = Integer.MAX_VALUE;
				u.predecessor = null;
			}
		}
		// Mark the root node as Gray
		s.colour = NodeColour.GRAY;
		s.distance = 0;
		s.predecessor = null;
		Queue<Node> q = new ArrayDeque<Node>();
		q.add(s); // enqueue root node

		// Iterate over the queue
		while (!q.isEmpty()) {
			Node u = q.remove();
			List<Node> adj_u = nodes.get(u);
			if (adj_u != null) {
				for (Node v : adj_u) {
					if (v.colour == NodeColour.WHITE) {
						v.colour = NodeColour.GRAY;
						v.distance = u.distance + 1;
						v.predecessor = u;
						q.add(v);
					}
				}
			}
			u.colour = NodeColour.BLACK;
			System.out.print(u + " ");
		}
	}

	public static void main(String[] args) {
		BreadthFirstSearch graph = new BreadthFirstSearch();
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n6 = new Node(6);
		Node n7 = new Node(7);
		Node n8 = new Node(8);

		graph.addEdge(n1, n2);

		graph.addEdge(n2, n1);
		graph.addEdge(n2, n3);

		graph.addEdge(n3, n4);
		graph.addEdge(n3, n2);

		graph.addEdge(n4, n3);
		graph.addEdge(n4, n5);
		graph.addEdge(n4, n6);

		graph.addEdge(n5, n4);
		graph.addEdge(n5, n6);
		graph.addEdge(n5, n7);

		graph.addEdge(n6, n4);
		graph.addEdge(n6, n5);
		graph.addEdge(n6, n7);
		graph.addEdge(n6, n8);

		graph.addEdge(n7, n5);
		graph.addEdge(n7, n6);
		graph.addEdge(n7, n8);

		graph.addEdge(n8, n6);
		graph.addEdge(n8, n7);

		graph.bfs(n1);

	}
}
