package com.sangwoon.kim.programers;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class NQueen {

	@Test
	void solution() {

		Solution solution = new Solution();
		int solution1 = solution.solution(4);
		Assertions.assertThat(solution1).isEqualTo(2);
	}

	class Solution {
		int answer = 0;

		public int solution(int n) {
			DFS(0, new int[n], n);
			return answer;
		}

		private void DFS(int L, int[] arr, int n) {
			if (L == n) {
				answer++;
				return;
			}
			for (int i = 0; i < n; i++) {
				arr[L] = i;
				if (check(arr, L)) {
					DFS(L + 1, arr, n);
				}
			}
		}

		private boolean check(int[] arr, int row) {
			for (int i = 0; i < row; i++) {
				if (arr[row] == arr[i]) {
					return false;
				}

				if (Math.abs(arr[i] - arr[row]) == Math.abs(i - row)) {
					return false;
				}
			}
			return true;
		}

	}
}
