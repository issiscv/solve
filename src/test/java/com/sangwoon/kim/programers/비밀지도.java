package com.sangwoon.kim.programers;

import org.junit.jupiter.api.Test;

public class 비밀지도 {

	@Test
	void solution() {
		Solution solution = new Solution();
		solution.solution(5, new int[]{9, 20, 28, 18, 11}, new int[]{30, 1, 21, 17, 28});
	}

	class Solution {
		public String[] solution(int n, int[] arr1, int[] arr2) {
			String[] answer = new String[n];

			for (int i = 0; i < n; i++) {
				String bin = Integer.toBinaryString(arr1[i] | arr2[i]);
				bin = String.format("%" + n + "s", bin)
						.replace(' ', '0')
						.replace('0', ' ')
						.replace('1', '#');
				answer[i] = bin;
			}

			return answer;
		}
	}

}
