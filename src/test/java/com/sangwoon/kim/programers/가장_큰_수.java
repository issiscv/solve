package com.sangwoon.kim.programers;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class 가장_큰_수 {

	Solution solution = new Solution();

	@Test
	void solution() {
		Assertions.assertThat(solution.solution(new int[]{6, 10, 2})).isEqualTo("6210");
		Assertions.assertThat(solution.solution(new int[]{3, 30, 34, 5, 9})).isEqualTo("9534330");
	}

	class Solution {
		public String solution(int[] numbers) {
			String answer = "";

			String[] arr = new String[numbers.length];

			for (int i = 0; i < numbers.length; i++) {
				arr[i] = String.valueOf(numbers[i]);
			}

			//6 10 2
			//o1: 610, o2: 106
			Arrays.sort(arr, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

			if (arr[0].equals("0")) return "0";

			for (int i = 0; i < arr.length; i++) {
				answer += arr[i];
			}

			return answer;
		}
	}

}
