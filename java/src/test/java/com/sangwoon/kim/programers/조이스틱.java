package com.sangwoon.kim.programers;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class 조이스틱 {

	@Test
	void solution() {
		Solution solution = new Solution();

		Assertions.assertThat(solution.solution("JEROEN")).isEqualTo(56);
		Assertions.assertThat(solution.solution("JAN")).isEqualTo(23);
	}

	class Solution {
		public int solution(String name) {
			int answer = 0;
			int move = name.length() - 1;

			for (int i = 0; i < name.length(); i++) {
				char c = name.charAt(i);
				answer += Math.min(c - 'A', 'Z' - c + 1);
			}

			for (int i = 0; i < name.length(); i++) {
				int next = i + 1;

				while (next < name.length() && name.charAt(next) == 'A') {
					next++;
				}

				move = Math.min(i + name.length() - next + Math.min(i, name.length() - next), move);
			}

			return answer += move;
		}
	}


}
