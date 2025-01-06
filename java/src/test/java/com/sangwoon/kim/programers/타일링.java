package com.sangwoon.kim.programers;

import org.junit.jupiter.api.Test;

public class 타일링 {

	@Test
	void solution() {
		Solution solution = new Solution();
		int solution1 = solution.solution(4);
		int solution2 = solution.solution(6);
		int solution3 = solution.solution(8);
		System.out.println(solution1);
		System.out.println(solution2);
		System.out.println(solution3);
	}

	class Solution {
		public int solution(int n) {
			int div = 1000000007;
			if (n % 2 != 0) return 0;
			long[] dp = new long[n + 1];
			dp[0] = 1;

			if (n >= 2) dp[2] = 3;

			for (int i = 4; i <= n; i += 2) {
				dp[i] = (dp[i - 2] * 3) % div;
				for (int j = 0; j < i - 2; j += 2) {
					dp[i] = (dp[i] + ((dp[j] * 2) % div)) % div;
				}
			}

			return (int) dp[n];
		}
	}

}
