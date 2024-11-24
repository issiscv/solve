package com.sangwoon.kim.programers;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class 피로도 {

	@Test
	void solution() {
		//k	dungeons	result
		//80	[[80,20],[50,40],[30,10]]	3
		Solution solution = new Solution();
		Assertions.assertThat(solution.solution(80, new int[][]{{80, 20}, {50, 40}, {30, 10}})).isEqualTo(3);
	}

	class Solution {

		boolean[] visited;
		int answer = Integer.MIN_VALUE;

		public int solution(int k, int[][] dungeons) {
			visited = new boolean[dungeons.length];
			DFS(0, k, dungeons);
			return answer;
		}

		private void DFS(int v, int ch, int[][] dungeons) {
			answer = Math.max(answer, v);

			for (int i = 0; i < dungeons.length; i++) {
				int required = dungeons[i][0];
				int cost = dungeons[i][1];

				if (!visited[i] && ch - required >= 0) {
					visited[i] = true;
					DFS(v + 1, ch - cost, dungeons);
					visited[i] = false;
				}

			}

		}

	}

}
