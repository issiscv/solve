package com.sangwoon.kim.programers;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

public class 주식가격 {

	Solution solution = new Solution();

	@Test
	void solution() throws Exception {
		//prices	return
		//[1, 2, 3, 2, 3]	[4, 3, 1, 1, 0]
		Assertions.assertThat(solution.solution(new int[]{1, 2, 3, 2, 3})).isEqualTo(new int[]{4, 3, 1, 1, 0});
	}

	class Solution {
		public int[] solution(int[] prices) {
			int[] answer = new int[prices.length];

			//stack 에는 떨어지지 않는 가격의 id 만 넣는다.
			Stack<Integer> stack = new Stack<>();

			for (int i = 0; i < prices.length; i++) {

				while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
					int idx = stack.pop();
					answer[idx] = i - idx;
				}

				stack.push(i);//0 1 2
			}

			while (!stack.isEmpty()) {
				int idx = stack.pop();
				answer[idx] = prices.length - idx - 1;
			}

			return answer;
		}
	}

}
