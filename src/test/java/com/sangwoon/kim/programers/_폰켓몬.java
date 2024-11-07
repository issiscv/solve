package com.sangwoon.kim.programers;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.*;

public class _폰켓몬 {
	Solution solution = new Solution();

	@Test
	void solution() {
		assertThat(solution.solution(new int[]{3, 1, 2, 3})).isEqualTo(2);
		assertThat(solution.solution(new int[]{3, 3, 3, 2, 2, 4})).isEqualTo(3);
		assertThat(solution.solution(new int[]{3, 3, 3, 2, 2, 2})).isEqualTo(2);
	}

	class Solution {
		public int solution(int[] nums) {
			Map<Integer, Integer> map = new HashMap<>();

			for (int i = 0; i < nums.length; i++) {
				map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
			}

			return Math.min(map.size(), nums.length / 2);
		}
	}

}
