package com.sangwoon.kim.programers;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;
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

			for (int i : scoville) {
				queue.offer(i);
			}

			//1, 2, 3, 9, 10, 12
			while (!queue.isEmpty() && queue.peek() < k) {
				int a = queue.poll();//1 3
				if (queue.isEmpty()) {
					return -1;
				}
				int b = queue.poll();//2 5
				int mixed = a + (b * 2);//5 13
				queue.offer(mixed);
				answer++;
			}

			if (queue.peek() < k) answer = -1;

			return answer;
		}
	}
}
