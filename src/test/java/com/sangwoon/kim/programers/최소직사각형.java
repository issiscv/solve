package com.sangwoon.kim.programers;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class 최소직사각형 {

	Solution solution = new Solution();

	@Test
	void solution() {
		//[[60, 50], [30, 70], [60, 30], [80, 40]]	4000
		//[[10, 7], [12, 3], [8, 15], [14, 7], [5, 15]]	120
		//[[14, 4], [19, 6], [6, 16], [18, 7], [7, 11]]	133
		Assertions.assertThat(solution.solution(new int[][]{{60, 50}, {30, 70}, {60, 30}, {80, 40}})).isEqualTo(4000);
		Assertions.assertThat(solution.solution(new int[][]{{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}})).isEqualTo(120);
		Assertions.assertThat(solution.solution(new int[][]{{14, 4}, {19, 6}, {6, 16}, {18, 7}, {7, 11}})).isEqualTo(133);
	}

	class Solution {
		public int solution(int[][] sizes) {
			int answer = 0;
			int maxW = Integer.MIN_VALUE;
			int maxH = Integer.MIN_VALUE;

			//주어진 가로 세로 중 회전이 가능하기 때문에 큰건 가로로, 작은건 세로로 배치해도 됨
			//가로중 제일 큰 것, 세로중 제일 큰 것(가로 세로 두 값 중 작은 값 중에서 제일 큰 것)
			for (int i = 0; i < sizes.length; i++) {
				int w = sizes[i][0];
				int h = sizes[i][1];

				int max = Math.max(w, h);
				int min = Math.min(w, h);

				maxW = Math.max(maxW, max);
				maxH = Math.max(maxH, min);
			}

			return maxW * maxH;
		}
	}

}
