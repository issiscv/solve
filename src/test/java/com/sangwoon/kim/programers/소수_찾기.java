package com.sangwoon.kim.programers;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class 소수_찾기 {


	@Test
	public void soltuin() throws Exception {
		Solution solutionA = new Solution();
		Solution solutionB = new Solution();

		Assertions.assertThat(solutionA.solution("17")).isEqualTo(3);
		Assertions.assertThat(solutionB.solution("011")).isEqualTo(2);
	}

	class Solution {

		boolean[] visited;
		int length;
		Set<Integer> set = new HashSet<>();

		public int solution(String numbers) {
			length = numbers.length();
			visited = new boolean[length];
			int answer = 0;

			for (int i = 0; i < length; i++) {
				DFS(i, "", numbers);
			}

			for (int value : set) {
				if (isPrime(value)) answer++;
			}

			return answer;
		}

		private boolean isPrime(int value) {
			if (value <= 1) return false;


			for (int i = 2; i < value; i++) {
				if (value % i == 0) {
					return false;
				}
			}

			return true;
		}

		private void DFS(int v, String ch, String numbers) {
			if (v == length) {
				set.add(Integer.parseInt(ch));
			} else {
				for (int i = 0; i < length; i++) {
					if (!visited[i]) {
						visited[i] = true;
						DFS(v + 1, ch + numbers.charAt(i), numbers);
						visited[i] = false;
					}
				}
			}
		}

	}

}
