package com.sangwoon.kim.programers;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 같은_숫자는_싫어 {

	@Test
	void solution() throws Exception {
		int[] solution = new Solution().solution(new int[]{1, 1, 3, 3, 0, 1, 1});
		Assertions.assertThat(solution).isEqualTo(new int[]{1, 3, 0, 1});
		Assertions.assertThat(new Solution().solution(new int[]{4, 4, 4, 3, 3})).isEqualTo(new int[]{4, 3});
	}

	public class Solution {
		public int[] solution(int []arr) {;
			Stack<Integer> stack = new Stack<>();

			for (int i = 0; i < arr.length; i++) {
				if (stack.isEmpty() || stack.peek() != arr[i]) {
					stack.push(arr[i]);
				}
			}

			return stack.stream().mapToInt(Integer::intValue).toArray();
		}
	}

}
