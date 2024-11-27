package com.sangwoon.kim.programers;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class 구명보트 {

	@Test
	void solution() {
		//people	limit	return
		//[70, 50, 80, 50]	100	3
		//[70, 80, 50]	100	3

		Solution solution = new Solution();

		Assertions.assertThat(solution.solution(new int[]{70, 50, 80, 50}, 100)).isEqualTo(3);
		Assertions.assertThat(solution.solution(new int[]{70, 80, 80}, 100)).isEqualTo(3);
	}

	class Solution {
		public int solution(int[] people, int limit) {
			int answer = 0;

			Arrays.sort(people);

			int left = 0;
			int right = people.length - 1;

			while (left <= right) {

				if (people[left] + people[right] <= limit) {
					left++;
				}

				right--;
				answer++;
			}

			return answer;
		}
	}

}
