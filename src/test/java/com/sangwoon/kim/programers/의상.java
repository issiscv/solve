package com.sangwoon.kim.programers;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class 의상 {

	Solution solution = new Solution();

	@Test
	void solution() throws Exception {
//		[["yellow_hat", "headgear"], ["blue_sunglasses", "eyewear"], ["green_turban", "headgear"]]
//		[["crow_mask", "face"], ["blue_sunglasses", "face"], ["smoky_makeup", "face"]]
		String[][] clothes1 = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
		String[][] clothes2 = {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};

		Assertions.assertThat(solution.solution(clothes1)).isEqualTo(5);
		Assertions.assertThat(solution.solution(clothes2)).isEqualTo(3);
	}

	/**
	 * 각 종류별로 (의상 개수 + 1)을 계산합니다.
	 * 모든 종류의 (의상 개수 + 1)을 곱해줍니다.
	 * 마지막으로 모든 종류에서 아무것도 선택하지 않는 경우를 제외하기 위해 결과에서 1을 뺍니다.
	 * 이 6가지 경우는 다음과 같습니다:
	 *
	 * yellow_hat, blue_sunglasses
	 * yellow_hat, 아무것도 선택하지 않음
	 * green_turban, blue_sunglasses
	 * green_turban, 아무것도 선택하지 않음
	 * 아무것도 선택하지 않음, blue_sunglasses
	 * 아무것도 선택하지 않음, 아무것도 선택하지 않음
	 */
	class Solution {
		public int solution(String[][] clothes) {
			int answer = 1;

			Map<String, Integer> map = new HashMap<>();

			for (int i = 0; i < clothes.length; i++) {
				map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
			}

			for (int value : map.values()) {
				answer *= (value + 1);
			}

			return answer - 1;
		}
	}

}
