package com.algorithm.greedy;

public class MinimumSpanningTree {

	public static void main(String[] args) {
		int[][] matrix = new int[10][];

		for (int i = 0; i < matrix.length; i++) {
			matrix[i] = new int[i + 1];
		}

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < i; j++) {
				matrix[i][j] = (int) (Math.random() * 100);
			}
		}

		System.out.println("Graph is >>");
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print(matrix[i][j] + ",");
			}
			System.out.println();
		}
		System.out.println();
		Graph graph = new Graph(matrix);
		System.out.println("The Total Cost is : " + graph.performPrim(0));
	}
}