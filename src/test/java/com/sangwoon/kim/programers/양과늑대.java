package com.sangwoon.kim.programers;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class 양과늑대 {

	@Test
	void solution() {
		int[] info1 = {0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1};
		int[][] edges1 = {
				{0, 1}, {1, 2}, {1, 4}, {0, 8}, {8, 7}, {9, 10},
				{9, 11}, {4, 3}, {6, 5}, {4, 6}, {8, 9}
		};

		int[] info2 = {0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0};
		int[][] edges2 = {
				{0, 1}, {0, 2}, {1, 3}, {1, 4}, {2, 5}, {2, 6},
				{3, 7}, {4, 8}, {6, 9}, {9, 10}
		};

		Solution solution = new Solution();

		System.out.println(solution.solution(info1, edges1));
		System.out.println(solution.solution(info2, edges2));
	}

	class Solution {
		int maxSheep = 0;

		public int solution(int[] info, int[][] edges) {
			List<List<Integer>> graph = new ArrayList<>();
			for (int i = 0; i < info.length; i++) {
				graph.add(new ArrayList<>());
			}
			for (int[] edge : edges) {
				graph.get(edge[0]).add(edge[1]);
			}

			List<Integer> nextNodes = new ArrayList<>();
			nextNodes.add(0);
			DFS(0, 0, 0, nextNodes, info, graph);

			return maxSheep;
		}

		private void DFS(int node, int sheep, int wolf, List<Integer> nextNodes, int[] info, List<List<Integer>> graph) {

			if (info[node] == 0) sheep++;
			else wolf++;

			if (wolf >= sheep) return;
			maxSheep = Math.max(maxSheep, sheep);

			List<Integer> newNextNodes = new ArrayList<>(nextNodes);
			newNextNodes.remove(Integer.valueOf(node));
			newNextNodes.addAll(graph.get(node));

			for (int newNextNode : newNextNodes) {
				DFS(newNextNode, sheep, wolf, newNextNodes, info, graph);
			}

		}

	}
}
