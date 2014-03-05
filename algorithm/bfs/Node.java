package com.algorithm.bfs;

import java.util.LinkedList;
import java.util.List;

public class Node {

	public String data; // data element
	public boolean visited = false; // flag to track the already visited node
	public List<Node> adjacentNodes = new LinkedList<Node>(); // adjacency list

	public Node(String data) {
		this.data = data;
	}

	public void addAdjacentNode(final Node node) {
		// add adjacent node
		adjacentNodes.add(node);
		// add itself
		node.adjacentNodes.add(this);
	}

	@Override
	public String toString() {
		return this.data;
	}

}