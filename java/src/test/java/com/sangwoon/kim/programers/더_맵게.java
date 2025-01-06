package com.sangwoon.kim.programers;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;
import java.util.Queue;

public class 더_맵게 {

	Solution solution = new Solution();

	@Test
	void solution() throws Exception {
		//scoville	K	return
		//[1, 2, 3, 9, 10, 12]	7	2
		Assertions.assertThat(solution.solution(new int[]{1, 2, 3, 9, 10, 12}, 7)).isEqualTo(2);
	}

	class Solution {
		public int solution(int[] scoville, int k) {
			int answer = 0;

			Queue<Integer> queue = new PriorityQueue<>();

			for (int i = 0; i < scoville.length; i++) {
				queue.offer(scoville[i]);
			}

			//가장 맵지 않은 + (2번째로 맵지 않은 * 2)
			while (!queue.isEmpty() && queue.peek() < k) {
				int a = queue.poll();
				if (queue.isEmpty()) {
					return -1;
				}
				int b = queue.poll();

				int value = a + (2 * b);
				queue.offer(value);
				answer++;
			}

			if (queue.peek() < k)
				return -1;

			return answer;
		}
	}
}
