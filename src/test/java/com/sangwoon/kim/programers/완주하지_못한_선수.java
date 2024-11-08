package com.sangwoon.kim.programers;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class 완주하지_못한_선수 {

	Solution solution = new Solution();

	@Test
	void solution() throws Exception {
		Assertions.assertThat(solution.solution(new String[]{"leo", "kiki", "eden"}, new String[]{"eden", "kiki"})).isEqualTo("leo");
		Assertions.assertThat(solution.solution(new String[]{"marina", "josipa", "nikola", "vinko", "filipa"}, new String[]{"josipa", "filipa", "marina", "nikola"})).isEqualTo("vinko");
		Assertions.assertThat(solution.solution(new String[]{"mislav", "stanko", "mislav", "ana"}, new String[]{"stanko", "ana", "mislav"})).isEqualTo("mislav");
	}

	class Solution {
		public String solution(String[] participant, String[] completion) {
			String answer = "";

			Map<String, Integer> map = new HashMap<>();

			for (String s : participant) {
				map.put(s, map.getOrDefault(s, 0) + 1);
			}

			for (String s : completion) {
				map.put(s, map.get(s) - 1);
				if (map.get(s) == 0) {
					map.remove(s);
				}
			}

			for (String s : map.keySet()) {
				answer = s;
			}

			return answer;
		}
	}

}
