package com.sangwoon.kim.programers;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class 퍼즐_게임_챌린지 {

	@Test
	void solution() {
		//diffs	times	limit	result
		//[1, 5, 3]	[2, 4, 7]	30	3
		//[1, 4, 4, 2]	[6, 3, 8, 2]	59	2
		//[1, 328, 467, 209, 54]	[2, 7, 1, 4, 3]	1723	294
		//[1, 99999, 100000, 99995]	[9999, 9001, 9999, 9001]	3456789012	39354
		Solution solution = new Solution();
		Assertions.assertThat(solution.solution(new int[]{1, 5, 3}, new int[]{2, 4, 7}, 30)).isEqualTo(3);
		Assertions.assertThat(solution.solution(new int[]{1, 4, 4, 2}, new int[]{6, 3, 8, 2}, 59)).isEqualTo(2);
		Assertions.assertThat(solution.solution(new int[]{1, 328, 467, 209, 54}, new int[]{2, 7, 1, 4, 3}, 1723)).isEqualTo(294);
		Assertions.assertThat(solution.solution(new int[]{1, 99999, 100000, 99995}, new int[]{9999, 9001, 9999, 9001}, 3456789012L)).isEqualTo(39354);
	}

	class Solution {
		public int solution(int[] diffs, int[] times, long limit) {
			int answer = 0;

			int left = 1;
			int right = Arrays.stream(diffs).max().getAsInt();

			while (left <= right) {
				int mid = (left + right) / 2;
				long total = 0;

				if (validate(diffs, times, limit, mid, total)) {
					right = mid - 1;
					answer = mid;
				} else {
					left = mid + 1;
				}

			}

			return answer;
		}

		private boolean validate(int[] diffs, int[] times, long limit, int mid, long total) {
			for (int j = 0; j < diffs.length; j++) {
				int diff = diffs[j];
				int time_cur = times[j];

				//내 레벨이 난이도 보다 높을 때
				if (diff <= mid) {
					total += time_cur;
				} else if (diff > mid) {
					//(이전꺼 time_cur  + 현재 time_cur ) * (diff - level) + 현재 time_cur
					if (j > 0) {
						total += (time_cur + times[j - 1]) * (diff - mid) + time_cur;
					}
				}
			}

			if (total <= limit) {
				return true;
			}

			return false;
		}
	}



//	class Solution {
//		public int solution(int[] diffs, int[] times, long limit) {
//			int answer = Integer.MAX_VALUE;
//
//			int maxLevel = Arrays.stream(diffs).max().getAsInt();
//
//			//3: 2, 16, 7
//			for (int i = 1; i <= maxLevel; i++) {
//				int level = i;
//				long total = 0;
//				for (int j = 0; j < diffs.length; j++) {
//					int diff = diffs[j];
//					int time_cur = times[j];
//
//					//내 레벨이 난이도 보다 높을 때
//					if (diff <= level) {
//						total += time_cur;
//					} else if (diff > level) {
//						//(이전꺼 time_cur  + 현재 time_cur ) * (diff - level) + 현재 time_cur
//						if (j > 0) {
//							total += (time_cur + times[j - 1]) * (diff - level) + time_cur;
//						}
//					}
//				}
//
//				if (total <= limit) {
//					answer = Math.min(answer, level);
//				}
//			}
//
//			return answer;
//		}
//	}
//
}
