package com.sangwoon.kim.programers;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

public class 전력망을_둘로_나누기 {

	@Test
	void solution() {
		Solution solution = new Solution();

//		n	wires	result
//9	[[1,3],[2,3],[3,4],[4,5],[4,6],[4,7],[7,8],[7,9]]	3
//4	[[1,2],[2,3],[3,4]]	0
//7	[[1,2],[2,7],[3,7],[3,4],[4,5],[6,7]]	1
		assertThat(solution.solution(9, new int[][]{{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}})).isEqualTo(3);
		assertThat(solution.solution(4, new int[][]{{1, 2}, {2, 3}, {3, 4}})).isEqualTo(0);
		assertThat(solution.solution(7, new int[][]{{1, 2}, {2, 7}, {3, 7}, {3, 4}, {4, 5}, {6, 7}})).isEqualTo(1);
	}

	class Solution {

		int[][] map;

		public int solution(int n, int[][] wires) {
			int answer = Integer.MAX_VALUE;
			map = new int[n + 1][n + 1];

			//네트워크 구성
			for (int i = 0; i < wires.length; i++) {
				int a = wires[i][0];
				int b = wires[i][1];

				map[a][b] = 1;
				map[b][a] = 1;
			}

			for (int i = 0; i < wires.length; i++) {
				int a = wires[i][0];
				int b = wires[i][1];

				//연결 끊어 보기
				map[a][b] = 0;
				map[b][a] = 0;

				answer = Math.min(BFS(a, n), answer);

				//연결 복구
				map[a][b] = 1;
				map[b][a] = 1;
			}

			return answer;
		}

		private int BFS(int start, int n) {
			Queue<Integer> queue = new LinkedList<>();
			queue.offer(start);
			boolean[] visited = new boolean[n + 1];
			visited[start] = true;
			int count = 1;

			while (!queue.isEmpty()) {
				int point = queue.poll();

				for (int i = 1; i <= n; i++) {
					if (map[point][i] == 1 && !visited[i]) {
						visited[i] = true;
						queue.offer(i);
						count++;
					}
				}
			}

			return Math.abs(n - count - count);

		}
	}


}
