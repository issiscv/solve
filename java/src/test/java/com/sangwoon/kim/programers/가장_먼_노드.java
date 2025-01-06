package com.sangwoon.kim.programers;

import org.junit.jupiter.api.Test;

import java.util.*;

public class 가장_먼_노드 {

	@Test
	public void solution() throws Exception {
		//n	vertex	return
		//6	[[3, 6], [4, 3], [3, 2], [1, 3], [1, 2], [2, 4], [5, 2]]	3
		Solution solution = new Solution();
		int[][] edge = {
				{3, 6},
				{4, 3},
				{3, 2},
				{1, 3},
				{1, 2},
				{2, 4},
				{5, 2}
		};

		solution.solution(6, edge);
	}

	class Solution {
		public int solution(int n, int[][] edge) {
			int answer = 0;

			List<List<Integer>> list = new ArrayList<>();

			for (int i = 0; i <= n; i++) {
				list.add(new ArrayList<>());
			}

			for (int i = 0; i < edge.length; i++) {
				int v1 = edge[i][0];
				int v2 = edge[i][1];

				list.get(v1).add(v2);
				list.get(v2).add(v1);
			}


			return BFS(list);
		}

		private int BFS(List<List<Integer>> list) {
			boolean[][] visited = new boolean[list.size()][list.size()];
			visited[1][1] = true;

			int[] min = new int[list.size()];
			Arrays.fill(min, Integer.MAX_VALUE);
			min[1] = 0;
			min[0] = -1;

			Queue<Integer> queue = new LinkedList<>();
			for (int i = 0; i < list.get(1).size(); i++) {
				queue.offer(list.get(1).get(i));
			}

			int tmp = 1;
			while (!queue.isEmpty()) {
				int size = queue.size();

				for (int i = 0; i < size; i++) {
					int vertex = queue.poll();
					min[vertex] = Math.min(tmp, min[vertex]);
					for (int j = 0; j < list.get(vertex).size(); j++) {
						if (!visited[vertex][list.get(vertex).get(j)]) {
							visited[vertex][list.get(vertex).get(j)] = true;
							queue.offer(list.get(vertex).get(j));
						}
					}
				}
				tmp++;
			}

			int max = Arrays.stream(min).max().getAsInt();
			int count = 0;
			for (int i = 2; i < min.length; i++) {
				if (min[i] == max) count++;
			}

			return count;
		}
	}

}
