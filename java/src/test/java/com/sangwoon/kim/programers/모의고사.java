package com.sangwoon.kim.programers;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class 모의고사 {

	Solution solution = new Solution();

	@Test
	void solution() throws Exception {
		Assertions.assertThat(solution.solution(new int[]{1, 2, 3, 4, 5})).isEqualTo(new int[]{1});
		Assertions.assertThat(solution.solution(new int[]{1, 3, 2, 4, 2})).isEqualTo(new int[]{1, 2, 3});
	}

	class Solution {
		public int[] solution(int[] answers) {
			List<Integer> answer = new ArrayList<>();

			int[] one = new int[]{1, 2, 3, 4, 5};
			int[] two = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
			int[] three = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

			Map<Integer, Integer> map = new HashMap<>();
			map.put(1, 0);
			map.put(2, 0);
			map.put(3, 0);

			for (int i = 0; i < answers.length; i++) {
				int value = answers[i];

				//5
				//0 1 2 3 4
				if (one[i % one.length] == value) {
					map.put(1, map.get(1) + 1);
				}
				if (two[i % two.length] == value) {
					map.put(2, map.get(2) + 1);
				}
				if (three[i % three.length] == value) {
					map.put(3, map.get(3) + 1);
				}

			}

			int max = Integer.MIN_VALUE;
			for (int i : map.keySet()) {
				max = Math.max(max, map.get(i));
			}

			for (int i : map.keySet()) {
				if (map.get(i) >= max) {
					answer.add(i);
				}
			}

			Collections.sort(answer);

			return answer.stream().mapToInt(i -> i).toArray();
		}
	}

}
