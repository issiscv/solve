package com.sangwoon.kim.inflearn.graph;

public class AdjacencyMatrix {

	public void solution(int n, int[][] arr) {
		int[][] matrix = new int[n + 1][n + 1];

		for (int[] info : arr) {
			int a = info[0];
			int b = info[1];
			matrix[a][b] = 1;
		}

		boolean[] visited = new boolean[n + 1];
		visited[1] = true;

		DFS(1, n, "1", visited, matrix);

	}

	private void DFS(int start, int e, String ch, boolean[] visited, int[][] matrix) {

		if (start == e) {
			System.out.println(ch);
			return;
		}

		for (int i = 1; i < matrix[start].length; i++) {
			if (matrix[start][i] == 1 && !visited[i]) {
				visited[i] = true;
				DFS(i, e, ch + " " + i, visited, matrix);
				visited[i] = false;
			}
		}
	}

	public static void main(String[] args) {
		int n = 5;
		int[][] arr = {
				{1, 2},
				{1, 3},
				{1, 4},
				{2, 1},
				{2, 3},
				{2, 5},
				{3, 4},
				{4, 2},
				{4, 5}
		};

		AdjacencyMatrix adjacencyList = new AdjacencyMatrix();
		adjacencyList.solution(n, arr);
	}

}
