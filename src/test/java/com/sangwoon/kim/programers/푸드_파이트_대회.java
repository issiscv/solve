package com.sangwoon.kim.programers;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class 푸드_파이트_대회 {

	class Solution {
		public String solution(int[] food) {
			int[] arr = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
			for (int i = 1; i < food.length; i++) {
				arr[i] += (food[i] / 2);
			}

			String A = "";
			for (int i = 1; i <= 9; i++) {
				int count = arr[i];
				for (int j = 0; j < count; j++) {
					A += i;
				}
			}
			String B = new StringBuffer(A).reverse().toString();

			StringBuilder sb = new StringBuilder();
			sb.append(A);
			sb.append("0");
			sb.append(B);


			return sb.toString();
		}
	}

	@Test
	void solution() {
		//food	result
		//[1, 3, 4, 6]	"1223330333221"
		//[1, 7, 1, 2]	"111303111"

		Solution solution = new Solution();
		String solution1 = solution.solution(new int[]{1, 3, 4, 6});
		Assertions.assertThat(solution1).isEqualTo("1223330333221");
	}

}
