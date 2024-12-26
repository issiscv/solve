package com.sangwoon.kim.programers;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class 석유_시추 {

	class Solution {

		int row;
		int col;
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		int[][] land;
		int max;

		public int solution(int[][] land) {
			this.land = land;
			row = land.length;
			col = land[0].length;
			boolean[][] visited = new boolean[row][col];
			int[] res = new int[col];

			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					Set<Integer> set = new HashSet<>();
					if (land[i][j] == 1 && !visited[i][j]) {
						int bfs = BFS(i, j, visited, set);
						for (int col : set) {
							res[col] += bfs;
						}
					}
				}
			}

			return Arrays.stream(res).max().getAsInt();
		}

		private int BFS(int startRow, int startCol, boolean[][] visited, Set<Integer> set) {
			Queue<int[]> queue = new LinkedList<>();
			queue.offer(new int[]{startRow, startCol});
			visited[startRow][startCol] = true;
			int count = 1;
			set.add(startCol);
			while (!queue.isEmpty()) {
				int[] p = queue.poll();
				int px = p[0];
				int py = p[1];
				for (int j = 0; j < 4; j++) {
					int nx = px + dx[j];
					int ny = py + dy[j];
					if (nx >= 0 && nx < row && ny >= 0 && ny < col && land[nx][ny] == 1 && !visited[nx][ny]) {
						count++;
						visited[nx][ny] = true;
						queue.offer(new int[]{nx, ny});
						set.add(ny);
					}
				}
			}

			return count;
		}
	}

	@Test
	void solution() {


//		[[0, 0, 0, 1, 1, 1, 0, 0], [0, 0, 0, 0, 1, 1, 0, 0], [1, 1, 0, 0, 0, 1, 1, 0], [1, 1, 1, 0, 0, 0, 0, 0], [1, 1, 1, 0, 0, 0, 1, 1]]	9
		Solution solution = new Solution();
		Assertions.assertThat(solution.solution(new int[][]
				{
						{0, 0, 0, 1, 1, 1, 0, 0},
						{0, 0, 0, 0, 1, 1, 0, 0},
						{1, 1, 0, 0, 0, 1, 1, 0},
						{1, 1, 1, 0, 0, 0, 0, 0},
						{1, 1, 1, 0, 0, 0, 1, 1}
				})).isEqualTo(9);

		Assertions.assertThat(solution.solution(new int[][]{
				{1, 0, 1, 0, 1, 1},
				{1, 0, 1, 0, 0, 0},
				{1, 0, 1, 0, 0, 1},
				{1, 0, 0, 1, 0, 0},
				{1, 0, 0, 1, 0, 1},
				{1, 0, 0, 0, 0, 0},
				{1, 1, 1, 1, 1, 1}
		})).isEqualTo(16);
	}

}
