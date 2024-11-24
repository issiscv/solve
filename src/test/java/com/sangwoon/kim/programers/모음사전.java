package com.sangwoon.kim.programers;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 모음사전 {

	@Test
	void solution() {
//		word	result
//		"AAAAE"	6
//		"AAAE"	10
//		"I"	1563
//		"EIO"	1189
		Solution solution1 = new Solution();
		Solution solution2 = new Solution();
		Solution solution3 = new Solution();
		Solution solution4 = new Solution();

		Assertions.assertThat(solution1.solution("AAAAE")).isEqualTo(6);
		Assertions.assertThat(solution2.solution("AAAE")).isEqualTo(10);
		Assertions.assertThat(solution3.solution("I")).isEqualTo(1563);
		Assertions.assertThat(solution4.solution("EIO")).isEqualTo(1189);
	}

	class Solution {

		String[] moeum = new String[]{"A", "E", "I", "O", "U"};
		List<String> list = new ArrayList<>();

		public int solution(String word) {
			for (int i = 0; i < moeum.length; i++) {
				DFS(moeum[i]);
			}

			Collections.sort(list);

			return list.indexOf(word) + 1;
		}


		private void DFS(String ch) {
			//종료 조건은
			if (ch.length() > moeum.length) return;
			list.add(ch);
			for (int i = 0; i < moeum.length; i++) {
				DFS(ch + moeum[i]);
			}
		}

	}
}
