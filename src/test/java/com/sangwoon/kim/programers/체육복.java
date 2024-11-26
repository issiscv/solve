package com.sangwoon.kim.programers;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class 체육복 {

	@Test
	void solution() {
		Solution solution1 = new Solution();
		Solution solution2 = new Solution();
		Solution solution3 = new Solution();

//		n	lost	reserve	return
//5	[2, 4]	[1, 3, 5]	5
//5	[2, 4]	[3]	4
//3	[3]	[1]	2
		Assertions.assertThat(solution1.solution(5, new int[]{2, 4}, new int[]{1, 3, 5})).isEqualTo(5);
		Assertions.assertThat(solution2.solution(5, new int[]{2, 4}, new int[]{3})).isEqualTo(4);
		Assertions.assertThat(solution3.solution(3, new int[]{3}, new int[]{1})).isEqualTo(2);

	}


	class Solution {

		int[] people;

		public int solution(int n, int[] lost, int[] reserve) {
			int answer = 0;

			people = new int[n + 1];

			for (int i = 1; i <= n; i++) {
				people[i] = 1;
			}

			for (int i = 0; i < reserve.length; i++) {
				people[reserve[i]]++;
			}

			for (int i = 0; i < lost.length; i++) {
				people[lost[i]]--;
			}

			for (int i = 1; i <= n; i++) {
				if (people[i] < 1) {
					if (i > 1 && people[i - 1] > 1) {
						people[i]++;
						people[i - 1]--;
					} else if (i < n && people[i + 1] > 1) {
						people[i]++;
						people[i + 1]--;
					}
				}
			}

			for (int i = 1; i <= n; i++) {
				int person = people[i];
				if (person >= 1) answer++;
			}

			return answer;
		}
	}

}
