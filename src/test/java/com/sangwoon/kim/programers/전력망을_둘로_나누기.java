package com.sangwoon.kim.programers;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

public class 전력망을_둘로_나누기 {

	@Test
	void solution() {
		Solution solution1 = new Solution();
		Solution solution2 = new Solution();
		Solution solution3 = new Solution();

//		n	wires	result
//9	[[1,3],[2,3],[3,4],[4,5],[4,6],[4,7],[7,8],[7,9]]	3
//4	[[1,2],[2,3],[3,4]]	0
//7	[[1,2],[2,7],[3,7],[3,4],[4,5],[6,7]]	1
		assertThat(solution1.solution(9, new int[][]{{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}})).isEqualTo(3);
		assertThat(solution2.solution(4, new int[][]{{1, 2}, {2, 3}, {3, 4}})).isEqualTo(0);
		assertThat(solution3.solution(7, new int[][]{{1, 2}, {2, 7}, {3, 7}, {3, 4}, {4, 5}, {6, 7}})).isEqualTo(1);
	}

	class Solution {

		int[][] map;
		int length;
		int answer = Integer.MAX_VALUE;


		public int solution(int n, int[][] wires) {
			map = new int[n + 1][n + 1];
			length = n;
			for (int i = 0; i < wires.length; i++) {
				int a = wires[i][0];
				int b = wires[i][1];

				//네트워크 구성
				map[a][b] = 1;
				map[b][a] = 1;
			}

			for (int i = 0; i < wires.length; i++) {
				int a = wires[i][0];
				int b = wires[i][1];

				//네트워크 끊기
				map[a][b] = 0;
				map[b][a] = 0;

				answer = Math.min(answer, BFS(a));

				map[a][b] = 1;
				map[b][a] = 1;

			}


			return answer;
		}

		private int BFS(int start) {
			boolean[] visited = new boolean[length + 1];

			Queue<Integer> queue = new LinkedList<>();
			queue.offer(start);

			int count = 1;
			visited[start] = true;

			while (!queue.isEmpty()) {
				int point = queue.poll();
				for (int i = 1; i <= length; i++) {
					if (map[point][i] == 1 && !visited[i]) {
						queue.offer(i);
						visited[i] = true;
						count++;
					}
				}
			}

			return Math.abs(length - count - count);
		}

	}


}
