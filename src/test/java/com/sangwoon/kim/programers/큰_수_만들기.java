package com.sangwoon.kim.programers;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

public class 큰_수_만들기 {

	@Test
	void solution() {
		//number	k	return
		//"1924"	2	"94"
		//"1231234"	3	"3234"
		//"4177252841"	4	"775841"
		Solution solution = new Solution();

		Assertions.assertThat(solution.solution("1924", 2)).isEqualTo("94");
		Assertions.assertThat(solution.solution("1231234", 3)).isEqualTo("3234");
		Assertions.assertThat(solution.solution("4177252841", 4)).isEqualTo("775841");

	}

	class Solution {
		public String solution(String number, int k) {
			String answer = "";

			Stack<Integer> stack = new Stack<>();

			for (int i = 0; i < number.length(); i++) {
				int value = number.charAt(i) - 48;

				while (!stack.isEmpty() && value > stack.peek() && k > 0) {
					stack.pop();
					k--;
				}
				stack.push(value);
			}

			while (k > 0) {
				stack.pop();
				k--;
			}

			StringBuilder sb = new StringBuilder();
			for (int value : stack) {
				sb.append(value);
			}
			return sb.toString();
		}
	}

}
