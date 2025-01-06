package com.sangwoon.kim.programers;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class n진수_게임 {

	@Test
	void solution() {
		Solution solution = new Solution();
		Assertions.assertThat(solution.solution(2, 4, 2, 1)).isEqualTo("0111");
		Assertions.assertThat(solution.solution(16, 16, 2, 1)).isEqualTo("02468ACE11111111");
		Assertions.assertThat(solution.solution(16, 16, 2, 2)).isEqualTo("13579BDF01234567");
	}

	class Solution {
		//t 미리구할 숫자의 개쉬
		//m 몇명
		//난 몇 번째
		public String solution(int n, int t, int m, int p) {

			List<String> list = new ArrayList<>();
			int num = 0;
			int idx = 0;

			while (list.size() < t) {
				String str = Integer.toString(num, n);

				for (int i = 0; i < str.length(); i++) {
					if (idx % m == p - 1 && list.size() < t) {
						list.add(String.valueOf(str.charAt(i)).toUpperCase());
					}
					idx++;//현재 몇번째 인지
				}
				num++;//숫자 증가
			}

			StringBuilder sb = new StringBuilder();

			for (String value : list) {
				sb.append(value);
			}

			return sb.toString();
		}
	}

}
