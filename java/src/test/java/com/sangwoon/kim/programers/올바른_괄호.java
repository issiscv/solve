package com.sangwoon.kim.programers;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

public class 올바른_괄호 {

	Solution solution = new Solution();
	@Test
	void solution() throws Exception {
		//"()()"	true
		//"(())()"	true
		//")()("	false
		//"(()("	false
		Assertions.assertThat(solution.solution("()()")).isTrue();
		Assertions.assertThat(solution.solution("(())()")).isTrue();
		Assertions.assertThat(solution.solution(")()(")).isFalse();
		Assertions.assertThat(solution.solution("(()(")).isFalse();
	}

	class Solution {
		boolean solution(String s) {
			boolean answer = true;

			Stack<Character> stack = new Stack<>();

			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);

				if (stack.isEmpty() && c == ')') {
					return false;
				}

				if (stack.isEmpty()) {
					stack.push(c);
				} else {
					if (stack.peek() == '(' && c == ')') {
						stack.pop();
					} else {
						stack.push(c);
					}
				}
			}

			return stack.isEmpty();
		}
	}

}
