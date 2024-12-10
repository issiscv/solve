package com.sangwoon.kim.programers;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 네트워크 {

	@Test
	void solution() {
		Solution solution = new Solution();
		//n	computers	return
		//3	[[1, 1, 0], [1, 1, 0], [0, 0, 1]]	2
		//3	[[1, 1, 0], [1, 1, 1], [0, 1, 1]]	1

		int[][] arr1 = {
				{1, 1, 0},
				{1, 1, 0},
				{0, 0, 1}
		};
		int[][] arr2 = {
				{1, 1, 0},
				{1, 1, 1},
				{0, 1, 1}
		};

		;
		Assertions.assertThat(solution.solution(3, arr1)).isEqualTo(2);
		Assertions.assertThat(solution.solution(3, arr2)).isEqualTo(1);
		;
	}

	class Solution {
		public int solution(int n, int[][] computers) {
			int answer = 0;

			List<List<Integer>> list = new ArrayList<>();
			for (int i = 0; i <= n; i++) {
				list.add(new ArrayList<>());
			}

			for (int i = 1; i <= n; i++) {
				for (int j = i + 1; j <= n; j++) {
					if (computers[i - 1][j - 1] == 1) {
						list.get(i).add(j);
						list.get(j).add(i);
					}
				}
			}

			boolean[] visited = new boolean[n + 1];

			for (int i = 1; i <= n; i++) {
				if (!visited[i]) {
					BFS(i, visited, list);
					answer++;
				}
			}
			return answer;
		}
		private void BFS(int i, boolean[] visited, List<List<Integer>> list) {
			Queue<Integer> queue = new LinkedList<>();
			queue.offer(i);
			visited[i] = true;
			while (!queue.isEmpty()) {
				int size = queue.size();

				for (int j = 0; j < size; j++) {
					int current = queue.poll();
					List<Integer> nextList = list.get(current);
					for (int k = 0; k < nextList.size(); k++) {
						int next = nextList.get(k);
						if (!visited[next]) {
							queue.offer(next);
							visited[next] = true;
						}
					}
				}
			}
		}
	}

}
