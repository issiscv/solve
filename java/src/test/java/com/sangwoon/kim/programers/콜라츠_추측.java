package com.sangwoon.kim.programers;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class 콜라츠_추측 {

	@Test
	void solution() {

		//n	result
		//6	8
		//16	4
		//626331	-1
		Solution solution = new Solution();
		Assertions.assertThat(solution.solution(6)).isEqualTo(8);
		Assertions.assertThat(solution.solution(16)).isEqualTo(4);
		Assertions.assertThat(solution.solution(626331)).isEqualTo(-1);

	}

	class Solution {
		public int solution(int num) {
			if (num == 1) return 0;
			return DFS(0, num);
		}

		private int DFS(int L, long num) {
			if (L > 500) return -1;
			if (num == 1) return L;
			if (num % 2 == 0) return DFS(L + 1, num / 2);
			else return DFS(L + 1, num * 3 + 1);
		}

	}

}
