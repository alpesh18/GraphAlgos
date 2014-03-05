package com.algorithm.kruskal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class KruskalAlgo {

	private static Set<Integer> vertices = new HashSet<Integer>();
	private static List<KEdge> edges = new ArrayList<KEdge>();
	static {

		vertices.add(1);
		vertices.add(2);
		vertices.add(3);
		vertices.add(4);
		vertices.add(5);
		vertices.add(6);

		edges.add(new KEdge(1, 2, 5));
		edges.add(new KEdge(1, 3, 4));
		edges.add(new KEdge(2, 4, 10));
		edges.add(new KEdge(3, 5, 20));
		edges.add(new KEdge(2, 3, 3));
		edges.add(new KEdge(4, 6, 12));
		edges.add(new KEdge(5, 6, 15));
	}

	private void performKruskalAlgo() {
		HashMap<Integer, Set<Integer>> forest = new HashMap<Integer, Set<Integer>>();
		for (Integer vertex : vertices) {
			// Each set stores the known vertices reachable from this vertex
			// initialize with it self.
			Set<Integer> vs = new HashSet<Integer>();
			vs.add(vertex);
			forest.put(vertex, vs);
		}

		// sort your edges, you should use existing functionality where
		// possible, saves testing needed
		// here edges is your Stack, pop until minimum spanning tree is found.
		Collections.sort(edges);
		ArrayList<KEdge> minSpanTree = new ArrayList<KEdge>();
		while (true) // while you haven't visited all the vertices at least once
		{
			KEdge edge = edges.remove(0);// pop

			Set<Integer> visited1 = forest.get(edge.v1);
			Set<Integer> visited2 = forest.get(edge.v2);
			if (visited1.equals(visited2))
				continue;
			minSpanTree.add(edge);
			visited1.addAll(visited2);
			for (Integer i : visited1) {
				forest.put(i, visited1);
			}
			if (visited1.size() == vertices.size())
				break;
		}
		System.out.println("Min Spanning Tree : " + minSpanTree);
	}

	public static void main(String[] args) {
		KruskalAlgo krusk = new KruskalAlgo();
		krusk.performKruskalAlgo();
	}

}
