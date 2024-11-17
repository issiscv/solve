package com.sangwoon.kim.programers;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class K번째수 {

	Solution solution = new Solution();

	@Test
	void solution() {

//		array	commands	return
//[1, 5, 2, 6, 3, 7, 4]	[[2, 5, 3], [4, 4, 1], [1, 7, 3]]	[5, 6, 3]
		Assertions
				.assertThat(solution.solution(new int[]{1, 5, 2, 6, 3, 7, 4}, new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}}))
				.isEqualTo(new int[]{5, 6, 3});
	}

	class Solution {
		public int[] solution(int[] array, int[][] commands) {
			int[] answer = new int[commands.length];

			for (int l = 0; l < commands.length; l++) {
				int[] command = commands[l];
				int i = command[0];
				int j = command[1];
				int k = command[2];

				int[] copyArray = Arrays.copyOfRange(array, i - 1, j);
				Arrays.sort(copyArray);
				answer[l] = copyArray[k-1];
			}

			return answer;
		}
	}

}
