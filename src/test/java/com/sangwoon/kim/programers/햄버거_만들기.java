package com.sangwoon.kim.programers;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

public class 햄버거_만들기 {

	@Test
	void solution() {
		//ingredient	result
		//[2, 1, 1, 2, 3, 1, 2, 3, 1]	2
		//[1, 3, 2, 1, 2, 1, 3, 1, 2]	0

		Solution solution = new Solution();
		Assertions.assertThat(solution.solution(new int[]{2, 1, 1, 2, 3, 1, 2, 3, 1})).isEqualTo(2);
		Assertions.assertThat(solution.solution(new int[]{1, 3, 2, 1, 2, 1, 3, 1, 2})).isEqualTo(0);

	}

	class Solution {
		public int solution(int[] ingredient) {
			int answer = 0;
			Stack<Integer> stack = new Stack<>();
			for (int i = 0; i < ingredient.length; i++) {
				stack.push(ingredient[i]);

				int size = stack.size();
				if (size >= 4) {
					if (stack.get(size - 4) == 1 && stack.get(size - 3) == 2 && stack.get(size - 2) == 3 && stack.get(size - 1) == 1) {
						stack.pop();
						stack.pop();
						stack.pop();
						stack.pop();
						answer++;
					}
				}
			}

			return answer;
		}
	}

}
