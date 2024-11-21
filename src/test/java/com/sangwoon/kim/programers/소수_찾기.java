package com.sangwoon.kim.programers;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class 소수_찾기 {



	@Test
	public void soltuin() throws Exception {
		//numbers	return
		//"17"	3
		//"011"	2
		Solution solutionA = new Solution();
		Solution solutionB = new Solution();
		Assertions.assertThat(solutionA.solution("17")).isEqualTo(3);
		Assertions.assertThat(solutionB.solution("011")).isEqualTo(2);
	}

	class Solution {
		int length;
		boolean[] visited;
		Set<Integer> set = new HashSet<>();

		public int solution(String numbers) {
			length = numbers.length();
			visited = new boolean[length];

			//input index, 더해진 값(context), input
			for (int i = 0; i < length; i++) {
				DFS(i, "", numbers);
			}

			int count = 0;
			for (int value : set) {
				if (isPrime(value)) {
					count++;
				}
			}

			return count;
		}

		private boolean isPrime(int value) {
			//1 과 자기 자신으로만 나눠줘여함
			if (value <= 1) return false;

			boolean prime = true;

			for (int i = 2; i < Math.sqrt(value); i++) {//제곱근을 초과하는 값에서 약수를 찾는다면, 그 값의 짝은 제곱근 이하에 이미 확인된 상태입니다.
				if (value % i == 0) {
					prime = false;
				}
			}

			return prime;
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
