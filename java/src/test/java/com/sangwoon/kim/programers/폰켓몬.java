package com.sangwoon.kim.programers;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.*;

public class 폰켓몬 {
	Solution1 solution1 = new Solution1();
	Solution1 solution2 = new Solution1();

	@Test
	void solution1() {
		assertThat(solution1.solution(new int[]{3, 1, 2, 3})).isEqualTo(2);
		assertThat(solution1.solution(new int[]{3, 3, 3, 2, 2, 4})).isEqualTo(3);
		assertThat(solution1.solution(new int[]{3, 3, 3, 2, 2, 2})).isEqualTo(2);
	}

	@Test
	void solution2() {
		assertThat(solution2.solution(new int[]{3, 1, 2, 3})).isEqualTo(2);
		assertThat(solution2.solution(new int[]{3, 3, 3, 2, 2, 4})).isEqualTo(3);
		assertThat(solution2.solution(new int[]{3, 3, 3, 2, 2, 2})).isEqualTo(2);
	}

	class Solution1 {
		public int solution(int[] nums) {
			Set<Integer> set = new HashSet<>();

			for (int i = 0; i < nums.length; i++) {
				set.add(nums[i]);
			}

			return Math.min(set.size(), nums.length / 2);
		}
	}

}
