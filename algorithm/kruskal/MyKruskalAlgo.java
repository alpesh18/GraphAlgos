package com.algorithm.kruskal;

/*
 Kruskal's algorithm finds a minimum spanning tree for a connected weighted graph.
 The program below uses a hard-coded example.
 You can change this to match your problem by changing the edges in the graph.
 The program uses 3 classes.
 The Kruskal class contains the main method.
 The Edge class represents an edge.
 The KruskalEdges class contains the edges determined by the Kruskal algorithm.
 */

import java.util.TreeSet;
import java.util.Vector;
import java.util.HashSet;

class Edge implements Comparable<Edge> {
	String vertexA, vertexB;
	int weight;

	public Edge(String vertexA, String vertexB, int weight) {
		this.vertexA = vertexA;
		this.vertexB = vertexB;
		this.weight = weight;
	}

	public String getVertexA() {
		return vertexA;
	}
	
	//SCJ626ZNND

	public String getVertexB() {
		return vertexB;
	}

	public int getWeight() {
		return weight;
	}

	@Override
	public String toString() {
		return "(" + vertexA + ", " + vertexB + ") : Weight = " + weight;
	}

	public int compareTo(Edge edge) {
		// == is not compared so that duplicate values are not eliminated.
		return (this.weight < edge.weight) ? -1 : 1;
	}
}

class KruskalEdges {
	Vector<HashSet<String>> vertexGroups = new Vector<HashSet<String>>();
	TreeSet<Edge> kruskalEdges = new TreeSet<Edge>();

	public TreeSet<Edge> getEdges() {
		return kruskalEdges;
	}

	HashSet<String> getVertexGroup(String vertex) {
		for (HashSet<String> vertexGroup : vertexGroups) {
			if (vertexGroup.contains(vertex)) {
				return vertexGroup;
			}
		}
		return null;
	}

	/**
	 * The edge to be inserted has 2 vertices - A and B We maintain a vector
	 * that contains groups of vertices. We first check if either A or B exists
	 * in any group If neither A nor B exists in any group We create a new group
	 * containing both the vertices. If one of the vertices exists in a group
	 * and the other does not, we add the vertex that does not exist to the group
	 * of the other vertex. If both vertices exist in different groups We merge
	 * the two groups into one. All of the above scenarios mean that the edge is
	 * a valid Kruskal edge. In that scenario, we will add the edge to the
	 * Kruskal edges. However, if both vertices exist in the same group We do not
	 * consider the edge as a valid Kruskal edge
	 */
	public void insertEdge(Edge edge) {
		String vertexA = edge.getVertexA();
		String vertexB = edge.getVertexB();

		HashSet<String> vertexGroupA = getVertexGroup(vertexA);
		HashSet<String> vertexGroupB = getVertexGroup(vertexB);

		if (vertexGroupA == null) {
			kruskalEdges.add(edge);
			if (vertexGroupB == null) {
				HashSet<String> htNewVertexGroup = new HashSet<String>();
				htNewVertexGroup.add(vertexA);
				htNewVertexGroup.add(vertexB);
				vertexGroups.add(htNewVertexGroup);
			} else {
				vertexGroupB.add(vertexA);
			}
		} else {
			if (vertexGroupB == null) {
				vertexGroupA.add(vertexB);
				kruskalEdges.add(edge);
			} else if (vertexGroupA != vertexGroupB) {
				vertexGroupA.addAll(vertexGroupB);
				vertexGroups.remove(vertexGroupB);
				kruskalEdges.add(edge);
			}
		}
	}
}

public class MyKruskalAlgo {
	public static void main(String[] args) {
		// TreeSet is used to sort the edges before passing to the algorithm
		TreeSet<Edge> edges = new TreeSet<Edge>();

		// Sample problem - replace these values with your problem set
		edges.add(new Edge("0", "1", 2));
		edges.add(new Edge("0", "3", 1));
		edges.add(new Edge("1", "2", 3));
		edges.add(new Edge("2", "3", 5));
		edges.add(new Edge("2", "4", 7));
		edges.add(new Edge("3", "4", 6));
		edges.add(new Edge("4", "5", 4));

		System.out.println("Graph");
		KruskalEdges vv = new KruskalEdges();

		for (Edge edge : edges) {
			System.out.println(edge);
			vv.insertEdge(edge);
		}

		System.out.println("Kruskal algorithm");
		int total = 0;
		for (Edge edge : vv.getEdges()) {
			System.out.println(edge);
			total += edge.getWeight();
		}
		System.out.println("Total weight is " + total);
	}
}