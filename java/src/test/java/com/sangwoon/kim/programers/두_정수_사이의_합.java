package com.sangwoon.kim.programers;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class 두_정수_사이의_합 {

	@Test
	public void solution() throws Exception {
		//a	b	return
		//3	5	12
		//3	3	3
		//5	3	12

		Solution solution = new Solution();

		Assertions.assertThat(solution.solution(3, 5)).isEqualTo(12);
		Assertions.assertThat(solution.solution(3, 3)).isEqualTo(3);
		Assertions.assertThat(solution.solution(5, 3)).isEqualTo(12);

	}

	class Solution {
		public long solution(int a, int b) {
			return ((long) (a + b) * (Math.abs(a - b) + 1)) / 2;
		}
	}

}
