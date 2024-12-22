package com.sangwoon.kim.inflearn.graph;

import java.util.ArrayList;
import java.util.List;

public class AdjacencyList {

	public int solution(int n, int[][] arr) {
		int answer = 0;

		List<List<Integer>> graph = new ArrayList<>();
		boolean[] visited = new boolean[n + 1];
		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}

		for (int[] info : arr) {
			int a = info[0];
			int b = info[1];
			graph.get(a).add(b);
		}
		visited[1] = true;

		DFS(1, "1", n, visited, graph);

		return answer;
	}

	private void DFS(int start, String ch, int e, boolean[] visited, List<List<Integer>> graph) {

		if (start == e) {
			System.out.println(ch);
			return;
		}

		for (int nextNode : graph.get(start)) {
			if (!visited[nextNode]) {
				visited[nextNode] = true;
				DFS(nextNode, ch + " " + nextNode, e, visited, graph);
				visited[nextNode] = false;
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

		AdjacencyList adjacencyList = new AdjacencyList();
		adjacencyList.solution(n, arr);
	}

}
