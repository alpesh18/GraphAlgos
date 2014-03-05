package com.algorithm.kruskal;

/**
 * Representing an Edge connecting two vertices
 * 
 * @author Alpesh
 * 
 */
public class KEdge implements Comparable<KEdge> {
	int v1, v2, wt;

	public KEdge(int v1, int v2, int wt) {
		this.v1 = v1;
		this.v2 = v2;
		this.wt = wt;
	}

	@Override
	public int compareTo(KEdge o) {
		KEdge e1 = (KEdge) o;
		if (e1.wt == this.wt)
			return 0;
		return e1.wt < this.wt ? 1 : -1;
	}

	@Override
	public String toString() {
		return String.format("Vertex1:%d \t Vertex2:%d \t Cost:%d\n", v1, v2,
				wt);
	}
}