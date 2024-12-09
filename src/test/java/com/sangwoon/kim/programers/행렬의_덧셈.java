package com.sangwoon.kim.programers;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class 행렬의_덧셈 {

	@Test
	public void solution() throws Exception {

		//arr1	arr2	return
		//[[1,2],[2,3]]	[[3,4],[5,6]]	[[4,6],[7,9]]
		//[[1],[2]]	[[3],[4]]	[[4],[6]]

		Solution solution = new Solution();

		Assertions.assertThat(solution.solution(new int[][]{{1, 2}, {2, 3}}, new int[][]{{3, 4}, {5, 6}})).isEqualTo(new int[][]{{4, 6}, {7, 9}});

	}

	class Solution {
		//1, 2  3, 4
		//2, 3  5, 6
		public int[][] solution(int[][] arr1, int[][] arr2) {
			int row = arr1.length;
			int col = arr1[0].length;

			int[][] arr = new int[row][col];

			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					arr[i][j] = arr1[i][j] + arr2[i][j];
				}
			}

			return arr;
		}
	}

}
