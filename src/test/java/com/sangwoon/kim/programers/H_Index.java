package com.sangwoon.kim.programers;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class H_Index {

	Solution solution = new Solution();

	@Test
	void solution() {
		//이 과학자가 발표한 논문의 수는 5편이고, 그중 3편의 논문은 3회 이상 인용되었습니다. 그리고 나머지 2편의 논문은 3회 이하 인용되었기 때문에 이 과학자의 H-Index는 3입니다.
		Assertions.assertThat(solution.solution(new int[]{3, 0, 6, 1, 5})).isEqualTo(3);
	}

	class Solution {
		public int solution(int[] citations) {
			int answer = 0;
			Arrays.sort(citations);

			for (int i = 0; i < citations.length; i++) {
				//0 1 3 5 6
				int h = citations.length - i;
				if (citations[i] <= h) {
					answer = Math.max(answer, citations[i]);
				}
			}

			return answer;
		}
	}

}
