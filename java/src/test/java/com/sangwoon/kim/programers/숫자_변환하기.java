package com.sangwoon.kim.programers;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class 숫자_변환하기 {

	@Test
	void solution() {
		//x	y	n	result
		//10	40	5	2
		//10	40	30	1
		//2	5	4	-1
		Solution solution = new Solution();
		Assertions.assertThat(solution.solution(10, 40, 5)).isEqualTo(2);
		Assertions.assertThat(solution.solution(10, 40, 30)).isEqualTo(1);
		Assertions.assertThat(solution.solution(2, 5, 4)).isEqualTo(-1);

	}

	class Solution {
		public int solution(int x, int y, int n) {
			int answer = 0;

			int[] dp = new int[y + 1];
			for (int i = 0; i <= y; i++) {
				dp[i] = Integer.MAX_VALUE;
			}

			dp[x] = 0;

			for (int i = x; i <= y; i++) {
				if (dp[i] == Integer.MAX_VALUE) {
					continue;
				}

				if (i * 2 <= y) {
					dp[i * 2] = Math.min(dp[i] + 1, dp[i * 2]);
				}

				if (i * 3 <= y) {
					dp[i * 3] = Math.min(dp[i] + 1, dp[i * 3]);
				}

				if (i + n <= y) {
					dp[i + n] = Math.min(dp[i] + 1, dp[i + n]);
				}
			}

			return dp[y] == Integer.MAX_VALUE ? -1 : dp[y];
		}
	}

}
